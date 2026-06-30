package pl.pjatk.s36691.gui.zad68;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Ellipse e = new Ellipse(120, 180);
        e.setFill(Color.DARKORCHID);

        FadeTransition ft = new FadeTransition();
        ft.setNode(e);
        ft.setDuration(Duration.seconds(4));
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setAutoReverse(true);
        ft.setCycleCount(FadeTransition.INDEFINITE);
        ft.play();

        StackPane root = new StackPane();
        root.setBackground(Background.fill(Color.DARKGOLDENROD));
        root.getChildren().add(e);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Fading Ellipse");
        primaryStage.show();
    }
}
