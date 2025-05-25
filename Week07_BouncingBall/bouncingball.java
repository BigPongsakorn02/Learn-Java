import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bouncingball extends Application {

    abstract class MoveableObject {
        double x, y, vx, vy, size;
        Color color;
        boolean shouldRotate;
        double angle = 0;

        MoveableObject(double x, double y, double vx, double vy, double size, Color color, boolean shouldRotate) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.size = size;
            this.color = color;
            this.shouldRotate = shouldRotate;
        }

        void update(double dt, double width, double height) {
            x += vx * dt;
            y += vy * dt;
            if (x < 0 || x + size > width) {
                vx *= -1;
                x = Math.max(0, Math.min(x, width - size));
            }
            if (y < 0 || y + size > height) {
                vy *= -1;
                y = Math.max(0, Math.min(y, height - size));
            }
            if (shouldRotate) {
                angle += 180 * dt;
                if (angle > 360) angle -= 360;
            }
        }

        abstract void draw(GraphicsContext gc);
        abstract boolean contains(double mx, double my);
    }

    class CircleObject extends MoveableObject {
        CircleObject(double x, double y, double vx, double vy, double size, Color color) {
            super(x, y, vx, vy, size, color, false);
        }

        void draw(GraphicsContext gc) {
            gc.setFill(color);
            gc.fillOval(x, y, size, size);
        }

        boolean contains(double mx, double my) {
            double dx = mx - (x + size / 2);
            double dy = my - (y + size / 2);
            return dx * dx + dy * dy <= (size / 2) * (size / 2);
        }
    }

    class RectangleObject extends MoveableObject {
        RectangleObject(double x, double y, double vx, double vy, double size, Color color) {
            super(x, y, vx, vy, size, color, true);
        }

        void draw(GraphicsContext gc) {
            gc.save();
            gc.translate(x + size / 2, y + size / 2);
            gc.rotate(angle);
            gc.setFill(color);
            gc.fillRect(-size / 2, -size / 2, size, size);
            gc.restore();
        }

        boolean contains(double mx, double my) {
            return mx >= x && mx <= x + size && my >= y && my <= y + size;
        }
    }

    class TriangleObject extends MoveableObject {
        TriangleObject(double x, double y, double vx, double vy, double size, Color color) {
            super(x, y, vx, vy, size, color, false);
        }

        void draw(GraphicsContext gc) {
            gc.setFill(color);
            double[] xPoints = {x + size / 2, x, x + size};
            double[] yPoints = {y, y + size, y + size};
            gc.fillPolygon(xPoints, yPoints, 3);
        }

        boolean contains(double mx, double my) {
            return mx >= x && mx <= x + size && my >= y && my <= y + size;
        }
    }

    class ImageObject extends MoveableObject {
        Image image;

        ImageObject(double x, double y, double vx, double vy, double size, Image image) {
            super(x, y, vx, vy, size, null, true);
            this.image = image;
        }

        void draw(GraphicsContext gc) {
            gc.save();
            gc.translate(x + size / 2, y + size / 2);
            gc.rotate(angle);
            gc.drawImage(image, -size / 2, -size / 2, size, size);
            gc.restore();
        }

        boolean contains(double mx, double my) {
            return mx >= x && mx <= x + size && my >= y && my <= y + size;
        }
    }

    private final List<MoveableObject> objects = new ArrayList<>();
    private final Random random = new Random();
    private Image shuriken;
    private Canvas canvas;
    private double canvasWidth = 800, canvasHeight = 600;

    @Override
    public void start(Stage stage) {
        try {
            shuriken = new Image(getClass().getResource("/shuriken.png").toExternalForm());
        } catch (Exception e) {
            System.err.println("Could not load image: /shuriken.png");
        }

        canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        scene.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                double size = 20 + random.nextDouble() * 40;
                double vx = -100 + random.nextDouble() * 200;
                double vy = -100 + random.nextDouble() * 200;
                Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
                int type = random.nextInt(4);
                switch (type) {
                    case 0:
                        objects.add(new CircleObject(e.getX(), e.getY(), vx, vy, size, color));
                        break;
                    case 1:
                        objects.add(new RectangleObject(e.getX(), e.getY(), vx, vy, size, color));
                        break;
                    case 2:
                        objects.add(new TriangleObject(e.getX(), e.getY(), vx, vy, size, color));
                        break;
                    case 3:
                        if (shuriken != null)
                            objects.add(new ImageObject(e.getX(), e.getY(), vx, vy, size, shuriken));
                        break;
                }

            } else if (e.getButton() == MouseButton.SECONDARY) {
                Iterator<MoveableObject> it = objects.iterator();
                while (it.hasNext() && objects.size() > 1) {
                    MoveableObject obj = it.next();
                    if (obj.contains(e.getX(), e.getY())) {
                        it.remove();
                        break;
                    }
                }
            }
        });

        scene.widthProperty().addListener((obs, oldVal, newVal) -> updateWindowSize(newVal.doubleValue(), canvasHeight));
        scene.heightProperty().addListener((obs, oldVal, newVal) -> updateWindowSize(canvasWidth, newVal.doubleValue()));

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now;
                    return;
                }
                double deltaTime = (now - lastUpdate) / 1e9;
                lastUpdate = now;

                gc.clearRect(0, 0, canvasWidth, canvasHeight);
                for (MoveableObject obj : objects) {
                    obj.update(deltaTime, canvasWidth, canvasHeight);
                    obj.draw(gc);
                }
            }
        };

        timer.start();
        stage.setTitle("Bouncing Objects Project");
        stage.setScene(scene);
        stage.show();

        // Add one initial object
        objects.add(new CircleObject(100, 100, 150, 120, 40, Color.RED));
    }

    private void updateWindowSize(double newWidth, double newHeight) {
        canvasWidth = newWidth;
        canvasHeight = newHeight;
        canvas.setWidth(newWidth);
        canvas.setHeight(newHeight);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
