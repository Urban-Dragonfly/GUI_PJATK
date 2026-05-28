package pl.pjatk.s36691.gui.zad61;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageGetter imageGetter = new ImageGetter();

            if (imageGetter.isPicturesPresent()) {
                Image[] images = imageGetter.loadImages();
                new ImageViewerFrame(images);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Nie znaleziono obrazków w wybranym katalogu."
                );
            }
        });
    }
}
