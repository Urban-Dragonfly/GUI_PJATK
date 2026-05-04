package pl.pjatk.s36691.gui.zad47;


import javax.swing.*;
import java.awt.*;

public class Calc extends JPanel {

    public Calc() {
        Font font = new Font("Segoe UI", Font.BOLD, 20);
        setBackground(new Color(64,32,64));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(true);

        JTextField aField = new JTextField("23");
        aField.setHorizontalAlignment(JTextField.CENTER);
        aField.setAlignmentX(Component.CENTER_ALIGNMENT);
        aField.setMaximumSize(new Dimension(150, 30));
        aField.setFont(font);

        JTextField bField = new JTextField("42");
        bField.setHorizontalAlignment(JTextField.CENTER);
        bField.setAlignmentX(Component.CENTER_ALIGNMENT);
        bField.setMaximumSize(new Dimension(150, 30));
        bField.setFont(font);

        JButton sum = new JButton("SUM");
        sum.setAlignmentX(Component.CENTER_ALIGNMENT);
        sum.setMaximumSize(new Dimension(300, 100));
        sum.setBackground(new Color(158, 68, 58));
        sum.setForeground(new Color(180, 180, 180));
        sum.setFont(font);

        add(Box.createVerticalStrut(100));
        add(aField);
        add(Box.createVerticalStrut(50));
        add(bField);
        add(Box.createVerticalStrut(75));
        add(sum);

        sum.addActionListener(_ -> {
            if (aField.getText().isEmpty() || bField.getText().isEmpty()) return;
            try {
                double aDouble = Double.parseDouble(aField.getText());
                double bDouble = Double.parseDouble(bField.getText());
                double result = aDouble + bDouble;

                sum.setText(result == (long) result ? String.valueOf((long) result) : String.valueOf(result));
            } catch (NumberFormatException ex) {
                sum.setText("ERROR");
            }
        });
    }

}
