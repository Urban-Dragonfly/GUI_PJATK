package pl.pjatk.s36691.gui.zad64;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Hello world!");

        btn.setOnAction(e -> {
            if (btn.getText().equals("Hello world!")) {
                btn.setText("Hi");
            } else {
                btn.setText("Hello world!");
            }
        });

        btn.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-pref-width: 200px;" +
                "-fx-pref-height: 150px;" +
                "-fx-background-color: aqua;" +
                "-fx-text-fill: darkred;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-background-insets: 5;" +
                "-fx-border-color: darkblue;"
        );

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        root.setStyle("-fx-background-color: lightgray;");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
