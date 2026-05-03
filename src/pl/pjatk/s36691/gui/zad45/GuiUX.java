package pl.pjatk.s36691.gui.zad45;

import javax.swing.*;
import java.awt.*;

public class GuiUX extends JFrame {

    private final JPanel panel;

    public GuiUX() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        panel = new JPanel();
        add(panel);
        setAlwaysOnTop(true);
    }

    private void addComponents() {
        panel.add(new JButton("Button1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("B3"));
        panel.add(new JButton("Larger button 4"));
        panel.add(new JButton("Largest button number 5"));
    }

    public void updateLayout(int choice) {
        panel.removeAll();
        switch (choice) {
            case 1 -> {
                panel.setLayout(new BorderLayout());
                panel.add(new JButton("Button1"), BorderLayout.NORTH);
                panel.add(new JButton("Button 2"), BorderLayout.SOUTH);
                panel.add(new JButton("B3"), BorderLayout.CENTER);
                panel.add(new JButton("Larger button 4"), BorderLayout.WEST);
                panel.add(new JButton("Largest button number 5"), BorderLayout.EAST);
            }
            case 2 -> {
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                addComponents();
            }
            case 3 -> {
                panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                addComponents();
            }
            case 4 -> {
                panel.setLayout(new FlowLayout());
                addComponents();
            }
            case 5 -> {
                panel.setLayout(new GridLayout(1,0));
                addComponents();
            }
            case 6 -> {
                panel.setLayout(new GridLayout(0,1));
                addComponents();
            }
            case 7 -> {
                panel.setLayout(new GridLayout(3,2));
                addComponents();
            }
        }
        panel.revalidate();
        panel.repaint();
    }
}
