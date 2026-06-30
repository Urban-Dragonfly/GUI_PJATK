package pl.pjatk.s36691.gui.zad66;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField firstDigit = new TextField();
        firstDigit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        allowOnlyDigits(firstDigit);

        TextField secondDigit = new TextField();
        secondDigit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        allowOnlyDigits(secondDigit);

        Button result = new Button();
        result.setText("=");
        result.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        result.setOnAction(e -> {
            if (firstDigit.getText().isEmpty() || secondDigit.getText().isEmpty()) return;
            int first = Integer.parseInt(firstDigit.getText());
            int second = Integer.parseInt(secondDigit.getText());
            int sum = first + second;
            result.setText(String.valueOf(sum));
        });

        GridPane grid = new GridPane();
        grid.add(firstDigit, 0, 0);
        grid.add(secondDigit, 1, 0);
        grid.add(result, 0, 1, 2, 1);

        int[] percWidth = {50, 50};
        int[] percHeight = {50, 50};

        for (int i = 0; i < 2; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(percWidth[i]);
            grid.getColumnConstraints().add(columnConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(percHeight[i]);
            grid.getRowConstraints().add(rowConstraints);
        }

        grid.getStyleClass().add("grid");

        Scene scene = new Scene(grid, 300, 150);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void allowOnlyDigits(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getControlNewText();
            if (text.matches("\\d{0,3}")) {
                return change;
            }
            return null;
        };
        textField.setTextFormatter(new TextFormatter<>(filter));
    }
}
