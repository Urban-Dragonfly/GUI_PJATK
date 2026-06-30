package pl.pjatk.s36691.gui.zad67;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load("https://www.pja.edu.pl/");

        StackPane root = new StackPane(view);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("PJA");
        primaryStage.show();
    }
}
