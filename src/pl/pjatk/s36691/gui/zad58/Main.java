package pl.pjatk.s36691.gui.zad58;

import pl.pjatk.s36691.gui.zad58.util.FontLoader;
import pl.pjatk.s36691.gui.zad58.view.MemoryCatsFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Font arcadeFont = FontLoader.loadFont(
                    "/pl/pjatk/s36691/gui/zad58/assets/font/arcade.TTF"
            );

            new MemoryCatsFrame(arcadeFont);
        });
    }
}
