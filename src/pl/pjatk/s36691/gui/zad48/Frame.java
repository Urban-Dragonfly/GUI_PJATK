package pl.pjatk.s36691.gui.zad48;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setTitle("Color Changing Button");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 170));
        panel.setBackground(new Color(50, 100, 50));

        JButton button = getJButton();

        panel.add(button);
        add(panel);
        setVisible(true);
    }

    private static JButton getJButton() {
        Color blue = new Color(0, 50, 100);
        Color red = new Color(160, 40, 40);

        JButton button = new JButton("CHANGE COLOR");
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(blue);
        button.setForeground(new Color(200, 200, 200));
        button.setPreferredSize(new Dimension(200, 100));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(button.getBackground().equals(blue) ? red : blue);
            }
        });
        return button;
    }
}
