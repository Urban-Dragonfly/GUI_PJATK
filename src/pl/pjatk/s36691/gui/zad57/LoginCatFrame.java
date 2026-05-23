package pl.pjatk.s36691.gui.zad57;

import javax.swing.*;
import java.awt.*;

public class LoginCatFrame extends JFrame {


    public LoginCatFrame() {
        setTitle("Login Cat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel credentialsPanel = new JPanel(new GridLayout(2, 1));

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        credentialsPanel.add(loginPanel);
        credentialsPanel.add(passwordPanel);
        add(credentialsPanel, BorderLayout.PAGE_START);

        JPanel catTextAreaPanel = new JPanel(new GridLayout(1, 2));
        JLabel catImageLabel = new JLabel(new ImageIcon("src/pl/pjatk/s36691/gui/zad57/LoginCat.png"));
        catTextAreaPanel.add(catImageLabel);
        JTextArea catTextArea = new JTextArea();
        catTextArea.setEditable(false);
        catTextAreaPanel.add(new JScrollPane(catTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        add(catTextAreaPanel, BorderLayout.CENTER);

        JButton loginButton = new JButton("Show Login and Password");
        loginButton.addActionListener(_ -> {
           String login = loginField.getText();
           String password = new String(passwordField.getPassword());
           catTextArea.setText(String.format("Login: %s \nPassword: %s",login,password));
        });
        add(loginButton, BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
