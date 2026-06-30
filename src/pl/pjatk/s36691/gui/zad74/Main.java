package pl.pjatk.s36691.gui.zad74;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();
        Button button = new Button("Wylicz");

        button.setOnAction(e -> {
            if (textField.getText().isBlank()) return;

            double x;
            try {
                x = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.pow(x, 3)));
                button.setText("Wyliczono");
            } catch (NumberFormatException ex) {
                System.out.println("Podano niepoprawne wyrażenie liczbowe.");
            }
        });

        BorderPane root = new BorderPane();
        root.setTop(textField);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        root.setCenter(stackPane);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setTitle("Potegowanie");
        primaryStage.show();

    }
}
