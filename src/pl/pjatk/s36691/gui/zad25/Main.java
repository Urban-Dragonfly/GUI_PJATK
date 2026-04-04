package pl.pjatk.s36691.gui.zad25;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Ubranie[] ubrania = {
                new Ubranie("Sweter", "czerwony", "romby", "wełna", Rozmiar.M, 129.99),
                new Ubranie("Koszulka", "bialy", "bez wzoru", "bawełna", Rozmiar.S, 49.99),
                new Ubranie("Bluza", "czarny", "napis", "poliester", Rozmiar.L, 159.99),
                new Ubranie("Spodnie", "niebieski", "bez wzoru", "jeans", Rozmiar.XL, 199.99),
                new Ubranie("Kurtka", "zielony", "pikowana", "nylon", Rozmiar.L, 299.99),
                new Ubranie("Sukienka", "fioletowy", "kwiaty", "wiskoza", Rozmiar.XS, 179.99),
                new Ubranie("Koszula", "błękitny", "kratka", "len", Rozmiar.M, 139.99),
                new Ubranie("Plaszcz", "beżowy", "bez wzoru", "wełna", Rozmiar.XL, 399.99)
        };

        System.out.println("Nieposegregowane ubrania:");
        for (Ubranie u : ubrania) {
            System.out.println(u);
        }
        System.out.println();
        System.out.println("Ubrania posegregowane po rozmiarze:");
        Arrays.sort(ubrania);
        for (Ubranie u : ubrania) {
            System.out.println(u);
        }
        System.out.println();
        System.out.println("Ubrania posegregowane po cenie:");
        Arrays.sort(ubrania, Comparator.comparingDouble(Ubranie::getCena));
        for (Ubranie u : ubrania) {
            System.out.println(u);
        }
    }
}
