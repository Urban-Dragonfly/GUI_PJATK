package pl.pjatk.s36691.gui.zad16;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Square[] squares = new Square[5];

        for (int i = 0; i < 5; i++) {
            squares[i] = new Square((int) (Math.random() * 10) + 1);
        }

        System.out.println(Arrays.toString(squares));

        Collections.sort(Arrays.asList(squares));

        System.out.println(Arrays.toString(squares));
    }
}
