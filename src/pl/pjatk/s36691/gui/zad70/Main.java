package pl.pjatk.s36691.gui.zad70;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
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
    public void start(Stage primaryStage) throws Exception {
        Rectangle r = new Rectangle(100, 100);
        r.setFill(Color.DARKGREEN);

        ScaleTransition st = new ScaleTransition(Duration.millis(2000), r);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(3);
        st.setToY(3);
        st.setCycleCount(ScaleTransition.INDEFINITE);
        st.setAutoReverse(true);
        st.play();

        StackPane root = new StackPane(r);
        root.setBackground(Background.fill(Color.LAWNGREEN));

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Scaling Rectangle");
        primaryStage.show();
    }
}
