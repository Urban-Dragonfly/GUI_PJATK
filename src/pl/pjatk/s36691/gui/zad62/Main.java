package pl.pjatk.s36691.gui.zad62;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage ) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("view/login-view.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Logowanie");
        stage.show();

    }
}
