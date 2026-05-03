package pl.pjatk.s36691.gui.zad45;

import javax.swing.*;

public class Main {
    public static void main() {
        SwingUtilities.invokeLater(() -> {
            GuiUX guiUX = new GuiUX();
            new Thread(() -> new ConsoleUX(guiUX).start()).start();
        });
    }
}
