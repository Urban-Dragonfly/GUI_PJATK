package pl.pjatk.s36691.gui.zad71;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle r = new Rectangle(100, 100);
        r.setFill(Color.CHOCOLATE);

        Pane root = new Pane();
        root.getChildren().add(r);
        root.setStyle("-fx-background-color: lightblue");

        TranslateTransition tt = new TranslateTransition(Duration.millis(4000), r);
        tt.setFromX(0);
        tt.setToX(300);
        tt.setFromY(0);
        tt.setToY(300);
        tt.setCycleCount(Animation.INDEFINITE);
        tt.setAutoReverse(true);
        tt.play();


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Transitioning Rectangle");
        primaryStage.show();
    }
}
