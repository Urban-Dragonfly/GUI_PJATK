package pl.pjatk.s36691.gui.zad65;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();

        TextArea textArea = new TextArea();

        textArea.setPrefSize(500, 500);
        textArea.setEditable(true);
        textArea.setWrapText(true);
        textArea.requestFocus();

        root.getChildren().add(textArea);
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Editor");
        primaryStage.show();

    }

}
