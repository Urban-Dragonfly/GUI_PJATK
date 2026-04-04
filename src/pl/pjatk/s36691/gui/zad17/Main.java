package pl.pjatk.s36691.gui.zad17;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Square[] squares = new Square[5];

        for (int i = 0, j = 1; i < squares.length; i++, j++) {
            try {
                System.out.println("Randomizing square attempt: " + j);
                squares[i] = new Square((int) (Math.random() * 10) + 1);
                System.out.println("Successfully generated square: " + squares[i]);
            } catch (TooBigSquareException e) {
                System.out.println("Failed to generate square: " + e.getMessage());
                i--;
            }
        }

        System.out.println(Arrays.toString(squares));

        Collections.sort(Arrays.asList(squares));

        System.out.println(Arrays.toString(squares));
    }
}
