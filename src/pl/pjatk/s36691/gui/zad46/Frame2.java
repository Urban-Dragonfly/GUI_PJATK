package pl.pjatk.s36691.gui.zad46;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JFrame {

    public Frame2(Point center) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(center.x + center.x / 2 - 200, center.y - 200);
        setTitle("Button added in panel layer");

        JPanel panel = new JPanel();
        add(panel);
        panel.add(new JButton("Button"));

        setVisible(true);
    }
}
