package pl.pjatk.s36691.gui.zad62.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.pjatk.s36691.gui.zad62.service.LoginService;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private final LoginService loginService = new LoginService();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean loginOk = loginService.login(username, password);

        if (loginOk) {
            messageLabel.setText("Zalogowano poprawnie");
        } else {
            messageLabel.setText("Błędny login lub hasło");
        }
    }
}
