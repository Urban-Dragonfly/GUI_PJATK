package pl.pjatk.s36691.gui.zad02;

// Napisać program, który z pliku tab.txt (należy go uprzednio stworzyć) wczytuje do kolekcji
// liczby całkowite, które są rozdzielone dowolnymi białymi znakami. Wśród zapisanych wartości
// należy znaleźć wartość maksymalną oraz wszystkie indeksy kolekcji gdzie taka wartość
// występuje.
//      Program powinien wypisywać na konsoli:
//  • w pierwszym wierszu - wszystkie liczby, rozdzielone spacjami
//  • w drugim wierszu - wartość maksymalną,
//  • w trzecim wierszu - indeksy podktórymi w kolekcji znajduje się wartość maksymalna
// Przykład dla pliku zawierającego liczby:
//        1 5 5 3
//        -1 2 5 4
//  Otrzymamy na konsoli następujący wynik:
//        1 5 5 3 -1 2 5 4
//        5
//        1 2 6

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabIO
{
    public static void main(String[] args) {

        Path path = Path.of("src", "pl", "pjatk", "s36691", "gui", "zad02", "tab.txt");

        List<Integer> tabContent = new ArrayList<>();

        try (Scanner sc = new Scanner(path)){
            while (sc.hasNextInt()) {
                tabContent.add(sc.nextInt());
            }
        } catch (IOException e) {
            System.out.println("File not found");
            return;
        }

        if (tabContent.isEmpty()) {
            System.out.println("No numbers in file");
            return;
        }

        int biggestNumber = tabContent.get(0);
        List<Integer> biggestNumberIndices = new ArrayList<>();


        for (int i = 0; i < tabContent.size(); i++) {
            int number = tabContent.get(i);
            if (biggestNumber > number) continue;
            if (biggestNumber < number) {
                biggestNumber = number;
                biggestNumberIndices.clear();
            }
            biggestNumberIndices.add(i);
        }

        System.out.println(buildString(tabContent));
        System.out.println(biggestNumber);
        System.out.println(buildString(biggestNumberIndices));
    }

    public static String buildString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(number -> sb.append(number).append(" "));
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
