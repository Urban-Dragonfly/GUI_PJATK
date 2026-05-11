package pl.pjatk.s36691.gui.zad50;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        JButton leftButton = new JButton("Warsaw");
        JButton rightButton = new JButton("Change title...");
        JTextField textField = new JTextField(20);

        leftButton.addActionListener((e) -> textField.setText(e.getActionCommand()));

        textField.addActionListener((e) -> leftButton.setText(e.getActionCommand()));

        rightButton.putClientProperty("textField", textField);
        rightButton.putClientProperty("frame", this);
        rightButton.addActionListener(new RightButtonActionListener());

        panel.add(leftButton);
        panel.add(rightButton);
        panel.add(textField);
        add(panel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
