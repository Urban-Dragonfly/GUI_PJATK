package pl.pjatk.s36691.gui.zad52;

import javax.swing.*;
import java.awt.*;

public class Interfejs extends JFrame {

    private JTextField displayField;
    private JLabel currentInput;

    private double valueA;
    private double valueB;
    private Operator operator;
    private boolean startNewNumber = true;

    public Interfejs() {
        setTitle("Kalkulator");

        JPanel displayPanel = getDisplayPanel();

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 5,5));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] labels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", "C", "=", "/"
        };

        for (String label : labels) {
            JButton button = createButton(label);
            button.addActionListener(_ -> handleButton(label));
            buttonsPanel.add(button);
        }

        add(displayPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel getDisplayPanel() {
        displayField = new JTextField(12);
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Consolas", Font.BOLD, 36));

        currentInput = new JLabel(" ");
        currentInput.setHorizontalAlignment(JLabel.RIGHT);
        currentInput.setFont(new Font("Consolas", Font.PLAIN, 16));
        currentInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        displayPanel.add(displayField, BorderLayout.CENTER);
        displayPanel.add(currentInput, BorderLayout.NORTH);
        return displayPanel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(64, 64));
        button.setFont(new Font("Consolas", Font.BOLD, 20));
        return button;
    }

    private void handleButton(String label) {
        if (label.matches("\\d")) {
            handleDigit(label);
        } else if (label.equals("C")) {
            handleClear();
        } else if (label.equals("=")) {
            handleEquals();
        } else {
            handleOperator(label);
        }
    }

    private void handleDigit(String digit) {
        if (startNewNumber) {
            displayField.setText("");

            if (currentInput.getText().endsWith("=")) {
                currentInput.setText(" ");
            }

            startNewNumber = false;
        }
        displayField.setText(displayField.getText() + digit);
        currentInput.setText(currentInput.getText() + digit);
    }

    private void handleClear() {
        displayField.setText("");
        currentInput.setText(" ");
        startNewNumber = true;
    }

    private void handleEquals() {
        if (operator == null) return;
        if (displayField.getText().isEmpty()) return;
        if (currentInput.getText().endsWith("=")) return;

        currentInput.setText(currentInput.getText() + "=");

        valueB = Double.parseDouble(displayField.getText());

        Double result = operator.oblicz(valueA, valueB);
        displayField.setText(String.valueOf(result));

        startNewNumber = true;
    }

    private void handleOperator(String label) {
        if (displayField.getText().isEmpty()) return;

        String currentInputText = currentInput.getText();
        String currentDisplayText = displayField.getText();

        if (currentInputText.endsWith("=")) {
            currentInputText = currentDisplayText;
        }

        currentInput.setText(currentInputText + label);
        valueA = Double.parseDouble(currentDisplayText);
        displayField.setText("");

        switch (label) {
            case "+" -> operator = Operator.DODAWANIE;
            case "-" -> operator = Operator.ODEJMOWANIE;
            case "*" -> operator = Operator.MNOZENIE;
            case "/" -> operator = Operator.DZIELENIE;
        }

        startNewNumber = true;
    }
}
