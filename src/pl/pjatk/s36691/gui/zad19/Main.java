package pl.pjatk.s36691.gui.zad19;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Tree[] trees = {
                new Tree("Dąb", 15, 65),
                new Tree("Choinka", 2, 1),
                new Tree("Sosna", 27, 14),
                new Tree("Brzoza", 10, 3),
                new Tree("Modrzew", 17,12)
        };
        System.out.println(" === Drzewa przed sortowaniem ===");
        Arrays.stream(trees).forEach(System.out::println);
        System.out.println();

        Arrays.sort(trees);
        System.out.println(" === Drzewa posortowane ze względu na wiek ===");
        Arrays.stream(trees).forEach(System.out::println);

    }
}
