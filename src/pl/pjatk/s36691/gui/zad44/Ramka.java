package pl.pjatk.s36691.gui.zad44;

import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {

    public Ramka() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Przekątne");

        add(new JPanel(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
               g.drawLine(getWidth() - 1, 0, 0, getHeight() - 1);
           }
        });

        setVisible(true);

    }
}
