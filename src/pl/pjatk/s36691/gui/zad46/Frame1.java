package pl.pjatk.s36691.gui.zad46;

import javax.swing.*;
import java.awt.*;

public class Frame1 extends JFrame {

    public Frame1(Point center) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(center.x / 2 - 200, center.y - 200);
        setTitle("Button added in frame layer");

        add(new JButton("Button"));

        setVisible(true);
    }
}
