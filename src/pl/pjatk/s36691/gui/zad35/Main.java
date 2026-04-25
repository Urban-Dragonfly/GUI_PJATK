package pl.pjatk.s36691.gui.zad35;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonConsoleReader reader = new PersonConsoleReader();

        List<Person> people = reader.readPeople();

        PersonFileManager fm = new PersonFileManager();
        fm.saveAsText(people);
        fm.saveAsBinary(people);
        fm.saveAsSerialized(people);

        List<Person> peopleFromTxt = fm.readFromText();
        peopleFromTxt.forEach(System.out::println);
        System.out.println();

        List<Person> peopleFromBin = fm.readFromBinary();
        peopleFromBin.forEach(System.out::println);
        System.out.println();

        List<Person> peopleFromSer = fm.readFromSerialized();
        peopleFromSer.forEach(System.out::println);
    }
}
