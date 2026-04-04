package pl.pjatk.s36691.gui.zad20;

import java.util.Arrays;
import java.util.Comparator;
import pl.pjatk.s36691.gui.zad19.Tree;

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

        Arrays.sort(trees, Comparator.comparingInt(Tree::getHeight).reversed());
        System.out.println(" === Drzewa posortowane ze względu na wysokość ===");
        Arrays.stream(trees).forEach(System.out::println);

    }
}
