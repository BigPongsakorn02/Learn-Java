import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingShapes extends Application {
    private double rectX = 200; // Initial X position of rectangle
    private double circleY = 100; // Initial Y position of circle
    private double triangleY = 200; // Initial Y position of triangle
    private final double WIDTH = 400;
    private final double HEIGHT = 400;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> draw(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Moving Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Update positions
        rectX += 2;
        circleY += 1;
        triangleY -= 1;

        if (rectX > WIDTH) rectX = -50;
        if (circleY > HEIGHT) circleY = -50;
        if (triangleY < -50) triangleY = HEIGHT;

        // Draw rectangle
        gc.setFill(Color.RED);
        gc.fillRect(rectX, 150, 50, 30);

        // Draw circle
        gc.setFill(Color.BLUE);
        gc.fillOval(150, circleY, 40, 40);

        // Draw triangle
        gc.setFill(Color.GREEN);
        double[] xPoints = {250, 270, 230};
        double[] yPoints = {triangleY, triangleY + 40, triangleY + 40};
        gc.fillPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        launch(args);
    }
}



