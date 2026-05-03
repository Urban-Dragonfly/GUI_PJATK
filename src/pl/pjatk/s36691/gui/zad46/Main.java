package pl.pjatk.s36691.gui.zad46;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main() {
        Point center = new Point(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());

        SwingUtilities.invokeLater(() -> {
            new Frame1(center);
            new Frame2(center);
        });
    }
}
