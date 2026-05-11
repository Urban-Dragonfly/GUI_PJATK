package pl.pjatk.s36691.gui.zad49;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Countdown");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,20, 20));
        add(panel);

        JButton countdownButton = new JButton("Start Countdown");

        JTextField countdownField = new JTextField("");
        countdownField.setHorizontalAlignment(JTextField.TRAILING);
        countdownField.setPreferredSize(new Dimension(128, 24));

        countdownButton.putClientProperty("countdownField", countdownField);
        countdownButton.addActionListener(new MyActionListener());

        panel.add(countdownButton);
        panel.add(countdownField);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
