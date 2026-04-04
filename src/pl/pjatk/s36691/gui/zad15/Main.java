package pl.pjatk.s36691.gui.zad15;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        int[] hundred = new int[100];

        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = (int)(Math.random() * 100 + 1);
        }

        wydrukuj(hundred,value -> value % 2 == 0);

    }

    private static void wydrukuj(int[] tab, Filtr filtr) {
        for (int j : tab) {
            if (filtr.filtruj(j)) {
                System.out.println(j);
            }
        }
    }
}
