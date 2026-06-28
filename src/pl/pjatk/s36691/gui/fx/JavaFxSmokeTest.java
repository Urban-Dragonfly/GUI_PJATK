package pl.pjatk.s36691.gui.fx;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFxSmokeTest extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX dziala. Zmien main.class na klase z konkretnego zadania.");
        StackPane root = new StackPane(label);
        root.setPadding(new Insets(24));

        stage.setTitle("JavaFX smoke test");
        stage.setScene(new Scene(root, 520, 160));
        stage.show();

        PauseTransition closeDelay = new PauseTransition(Duration.seconds(2));
        closeDelay.setOnFinished(event -> stage.close());
        closeDelay.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
