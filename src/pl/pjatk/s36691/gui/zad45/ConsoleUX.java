package pl.pjatk.s36691.gui.zad45;

import javax.swing.*;
import java.util.Scanner;

public class ConsoleUX {

    private final Scanner scanner = new Scanner(System.in);
    private final GuiUX guiUX;

    public ConsoleUX(GuiUX guiUX) {
        this.guiUX = guiUX;
    }

    public void start() {
        System.out.println("*** Podstawowi zarządcy rozkładów graficznych ***\n");
        while (true) {
            printMenu();
            int input = getInput();
            if (input == 0) {
                System.exit(0);
            } else {
                SwingUtilities.invokeLater(() -> {
                    guiUX.setTitle(getTitleString(input));
                    guiUX.updateLayout(input);
                    if (!guiUX.isVisible()) guiUX.setVisible(true);
                });
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                Wybierz układ graficzny:
                1 - układ BorderLayout
                2 - układ FlowLayout z wyrównaniem do lewej
                3 - układ FlowLayout z wyrównaniem do prawej
                4 - układ FlowLayout
                5 - układ GridLayout– tylko jeden wiersz
                6 - układ GridLayout– tylko jedna kolumna
                7 - układ GridLayout– jako tabela 2 kolumny, 3 wiersze
                Q - zakończ program""");
    }

    private int getInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return 0;
            }
            if (input.matches("[1-7]")) {
                return Integer.parseInt(input);
            }
            System.out.println("Niepoprawny wybór, wybierz ponownie:");
        }
    }

    private String getTitleString (int input) {
        return switch (input) {
        case 1 -> "układ BorderLayout";
        case 2 -> "układ FlowLayout z wyrównaniem do lewej";
        case 3 -> "układ FlowLayout z wyrównaniem do prawej";
        case 4 -> "układ FlowLayout";
        case 5 -> "układ GridLayout - tylko jeden wiersz";
        case 6 -> "układ GridLayout - tylko jedna kolumna";
        case 7 -> "układ GridLayout - jako tabela 2 kolumny, 3 wiersze";
        default -> "";
        };
    }
}
