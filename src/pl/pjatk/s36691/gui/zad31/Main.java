package pl.pjatk.s36691.gui.zad31;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("src/pl/pjatk/s36691/gui/zad31/info.txt"))) {
            String text = br.readAllAsString();
            String[] words = text.split("[,.\\s]+");
            int count = 0;
            for (String word : words) {
                if (word.length() > 8) {
                    System.out.println(word);
                    count++;
                }
            }
            System.out.println("Ilość słów powyżej ośmiu liter: " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
