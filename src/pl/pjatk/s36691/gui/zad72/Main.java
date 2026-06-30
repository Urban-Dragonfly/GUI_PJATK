package pl.pjatk.s36691.gui.zad72;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle(100, 100);
        r.setStroke(Color.DARKGRAY);
        r.setStrokeWidth(5);
        r.setFill(Color.BISQUE);

        RotateTransition rt = new RotateTransition(Duration.seconds(4), r);
        rt.setByAngle(360);
        rt.setCycleCount(RotateTransition.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

        StackPane root = new StackPane(r);
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotating Rectangle");
        primaryStage.show();
    }
}
