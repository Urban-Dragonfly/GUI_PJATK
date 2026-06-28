package pl.pjatk.s36691.gui.zad63;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/player-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("view/player-view.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Audio Deck");
        primaryStage.show();
    }
}
