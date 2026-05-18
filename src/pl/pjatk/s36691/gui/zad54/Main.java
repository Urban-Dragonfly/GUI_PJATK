package pl.pjatk.s36691.gui.zad54;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("src/pl/pjatk/s36691/gui/zad54/text.txt");
        List<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        }   catch (IOException e) {
            System.out.println("File not found");
        }

        if (list.isEmpty()) {
            System.out.println("No lines in file");
            return;
        }

        SwingUtilities.invokeLater(() -> new MyJListFrame(list));
    }

}
