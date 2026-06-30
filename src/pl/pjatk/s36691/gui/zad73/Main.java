package pl.pjatk.s36691.gui.zad73;

import javafx.animation.*;
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
    public void start(Stage primaryStage) throws Exception {
        Rectangle r = new Rectangle(100, 100);
        r.setFill(Color.DODGERBLUE);

        ScaleTransition st = new ScaleTransition(Duration.millis(2000), r);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(3);
        st.setToY(3);
        st.setCycleCount(ScaleTransition.INDEFINITE);
        st.setAutoReverse(true);

        TranslateTransition tt = new TranslateTransition(Duration.millis(4000), r);
        tt.setFromX(-200);
        tt.setToX(200);
        tt.setFromY(-200);
        tt.setToY(200);
        tt.setCycleCount(Animation.INDEFINITE);
        tt.setAutoReverse(true);

        RotateTransition rt = new RotateTransition(Duration.seconds(4), r);
        rt.setByAngle(360);
        rt.setCycleCount(RotateTransition.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);

        ParallelTransition pt = new ParallelTransition(st, tt, rt);
        pt.play();

        StackPane root = new StackPane();
        root.getChildren().add(r);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
