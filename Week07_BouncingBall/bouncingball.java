import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class bouncingball extends Application {

    private double x = 100;
    private double y = 200;
    private double velocityX = 150;
    private double velocityY = 120;
    private double angle = 0;
    private double rotationSpeed = 180;
    private double scale = 1;
    private double scaleSpeed = 0.5;
    private boolean growing = true;

    private Image shuriken;
    private Canvas canvas;
    private double canvasWidth = 600, canvasHeight = 400;

    @Override
    public void start(Stage stage) {
        // Load image (handle null case if resource not found)
        try {
            shuriken = new Image(getClass().getResource("/shuriken.png").toExternalForm());
        } catch (Exception e) {
            System.err.println("❌ Could not load image: /shuriken.png");
            return;
        }

        canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);

        // Resize handling
        scene.widthProperty().addListener((obs, oldVal, newVal) ->
                updateWindowSize(newVal.doubleValue(), canvasHeight));
        scene.heightProperty().addListener((obs, oldVal, newVal) ->
                updateWindowSize(canvasWidth, newVal.doubleValue()));

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
                update(deltaTime);
                draw(gc);
            }
        };

        timer.start();
        stage.setTitle("Bouncing Shuriken with Resize Handling");
        stage.setScene(scene);
        stage.show();
    }

    private void update(double deltaTime) {
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;

        if (x - 50 < 0 || x + 50 > canvasWidth) {
            velocityX *= -1;
            x = Math.max(50, Math.min(x, canvasWidth - 50));
        }
        if (y - 50 < 0 || y + 50 > canvasHeight) {
            velocityY *= -1;
            y = Math.max(50, Math.min(y, canvasHeight - 50));
        }

        angle += rotationSpeed * deltaTime;
        angle %= 360;

        if (growing) {
            scale += scaleSpeed * deltaTime;
            if (scale >= 1.0) growing = false;
        } else {
            scale -= scaleSpeed * deltaTime;
            if (scale <= 0.2) growing = true;
        }
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        gc.save();
        gc.translate(x, y);
        gc.rotate(angle);
        gc.scale(scale, scale);
        gc.drawImage(shuriken, -50, -50, 100, 100);
        gc.restore();
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
