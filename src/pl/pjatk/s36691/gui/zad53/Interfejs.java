package pl.pjatk.s36691.gui.zad53;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Interfejs extends JFrame {

    private JTextField displayField;
    private JLabel currentInput;
    private final Map<String, JButton> buttons = new HashMap<>();
    private final Color purple = new Color(100, 50,100);


    private long valueA;
    private long valueB;
    private int radix = 10;
    private Operator operator;
    private boolean startNewNumber = true;

    public Interfejs() {
        setTitle("Kalkulator");

        JPanel displayPanel = getDisplayPanel();

        JPanel buttonsPanel = new JPanel(new GridLayout(6, 4, 5,5));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] labels = {
                "0", "1", "2", "3",
                "4", "5", "6", "7",
                "8", "9", "A", "B",
                "C", "D", "E", "F",
                "+", "-", "*", "/",
                "", "", "=", "CC"
        };

        for (String label : labels) {
            JButton button = createButton(label);
            buttonsPanel.add(button);
            if (label.isEmpty()) {
                button.setVisible(false);
            } else {
                button.addActionListener(_ -> handleButton(label));
                buttons.put(label, button);
            }
        }

        updateDigitButtons();

        displayPanel.setBackground(purple);
        buttonsPanel.setBackground(purple);

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
        currentInput.setForeground(Color.LIGHT_GRAY);

        JPanel displayPanel = new JPanel(new GridLayout(3,1,0,0));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        displayPanel.add(currentInput);
        displayPanel.add(displayField);
        displayPanel.add(getRadioButtonsPanel());
        return displayPanel;
    }

    private JPanel getRadioButtonsPanel() {
        JPanel radioButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        radioButtonsPanel.setBackground(purple);

        String[] labels = {"Hex", "Dec", "Bin", "Oct"};
        ButtonGroup group = new ButtonGroup();

        for (String label : labels) {
            JRadioButton radioButton = new JRadioButton(label);
            radioButton.setFont(new Font("Consolas", Font.BOLD, 16));
            radioButton.setForeground(Color.LIGHT_GRAY);
            radioButton.setBackground(purple);
            radioButtonsPanel.add(radioButton);
            group.add(radioButton);
            radioButton.addActionListener(_ -> {
                handleRadio(label);
            });

            if (label.equals("Dec")) {
                radioButton.setSelected(true);
            }
        }

        return radioButtonsPanel;
    }

    private void handleRadio(String label) {
        String displayText = displayField.getText();

        if (displayText.isEmpty()) {
            setRadix(label);
            updateDigitButtons();
            return;
        }

        long displayValue = Long.parseLong(displayText, radix);

        setRadix(label);

        displayField.setText(Long.toString(displayValue, radix).toUpperCase());
        updateDigitButtons();
    }

    private void setRadix(String label) {
        switch (label) {
            case "Hex" -> radix = 16;
            case "Dec" -> radix = 10;
            case "Bin" -> radix = 2;
            case "Oct" -> radix = 8;
        }
    }

    private void updateDigitButtons() {
        for (String label : buttons.keySet()) {
            if (label.matches("[0-9A-F]")) {
                if (isDigitAllowed(label)) {
                    buttons.get(label).setEnabled(true);
                    buttons.get(label).setBackground(new Color(130, 70,50));
                    buttons.get(label).setForeground(Color.LIGHT_GRAY);
                } else {
                    buttons.get(label).setEnabled(false);
                    buttons.get(label).setBackground(new Color(90, 50,50));
                    buttons.get(label).setForeground(new Color(90, 50,50));
                }
            }
        }
    }

    private boolean isDigitAllowed(String digit) {
        try {
            Long.parseLong(digit, radix);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(64, 64));
        button.setFont(new Font("Consolas", Font.BOLD, 20));
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setForeground(Color.LIGHT_GRAY);
        button.setBackground(new Color(130, 70,50));
        return button;
    }

    private void handleButton(String label) {
        if (label.matches("[0-9A-F]")) {
            handleDigit(label);
        } else if (label.equals("CC")) {
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
    }

    private void handleClear() {
        displayField.setText("");
        currentInput.setText(" ");
        operator = null;
        startNewNumber = true;
    }

    private void handleEquals() {
        if (operator == null) return;
        if (displayField.getText().isEmpty()) return;
        if (currentInput.getText().endsWith("=")) return;

        valueB = Long.parseLong(displayField.getText(), radix);

        if (operator == Operator.DZIELENIE && valueB == 0) {
            JOptionPane.showMessageDialog(null, "Dzielenie przez zero nie jest dozwolone!");
            return;
        }

        currentInput.setText(currentInput.getText() + valueB + "=");

        long result = operator.oblicz(valueA, valueB);
        displayField.setText(Long.toString(result, radix).toUpperCase());

        startNewNumber = true;
    }

    private void handleOperator(String label) {
        if (displayField.getText().isEmpty()) return;

        String currentDisplayText = displayField.getText();

        valueA = Long.parseLong(currentDisplayText, radix);

        currentInput.setText(valueA + label);
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
