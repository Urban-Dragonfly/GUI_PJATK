package pl.pjatk.s36691.gui.zad26;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz kolory do zmieszania:");
            Color.print();

            try {
                int n = sc.nextInt() - 1;
                int m = sc.nextInt() - 1;
                Color mixed = Color.mixColors(Color.values()[n], Color.values()[m]);
                System.out.println(mixed);
            } catch (InputMismatchException e) {
                System.out.println("Podaj liczby");
                sc.nextLine();
                continue;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException  e) {
                System.out.println("Sprawdź co mieszasz!");
                sc.nextLine();
                continue;
            }
            break;
        }
    }
}
