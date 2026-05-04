package pl.pjatk.s36691.gui.zad47;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setTitle("Primitive Calculator");
        setResizable(false);
        add(new Calc());
        setVisible(true);
    }
}
