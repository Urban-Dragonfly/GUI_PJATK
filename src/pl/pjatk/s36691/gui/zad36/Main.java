package pl.pjatk.s36691.gui.zad36;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Piornik piornik = new Piornik("Janek Bronek");

        piornik.dodaj(new Dlugopis("niebieski", "Bic", 0.5));
        piornik.dodaj(new Dlugopis("czarny", "Parker", 0.7));
        piornik.dodaj(new Pioro("granatowy", "cienka", true));
        piornik.dodaj(new Olowek("HB", 17.5, true));
        piornik.dodaj(new Olowek("2B", 12.0, false));
        piornik.dodaj(new Nozyczki(8.5, "czerwony", true));
        piornik.dodaj(new Gumka("biały", "prostokąt"));

        piornik.pokazZawartosc();

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/pl/pjatk/s36691/gui/zad36/piornik.ser"))) {

            oos.writeObject(piornik);
            System.out.println("Zapisano do pliku piornik.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Odczyt z pliku piornik.ser:");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/pl/pjatk/s36691/gui/zad36/piornik.ser"))) {

            Piornik odczytanyPiornik = (Piornik) ois.readObject();
            odczytanyPiornik.pokazZawartosc();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
