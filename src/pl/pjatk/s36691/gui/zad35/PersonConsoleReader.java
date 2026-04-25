package pl.pjatk.s36691.gui.zad35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonConsoleReader {
    private Scanner scanner = new Scanner(System.in);

    public List<Person> readPeople() {
        List<Person> people = new ArrayList<>();

        while (true) {
            people.add(readPerson());

            System.out.println("Czy dodać kolejną osobę? (T/N)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("t")) {
                break;
            }
        }

        return people;
    }

    private Person readPerson() {
        System.out.println("Podaj imię:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj PESEL:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj adres:");
        String adres = scanner.nextLine();

        return new Person(imie, nazwisko, pesel, adres);
    }

}
