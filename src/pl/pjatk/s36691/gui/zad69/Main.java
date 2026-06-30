package pl.pjatk.s36691.gui.zad69;

import javafx.animation.FillTransition;
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

        FillTransition ft = new FillTransition(Duration.millis(4000), e, Color.NAVY, Color.CRIMSON);
        ft.setCycleCount(FillTransition.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        StackPane root = new StackPane(e);
        root.setBackground(Background.fill(Color.POWDERBLUE));
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Filling Ellipse");
        primaryStage.show();
    }
}
