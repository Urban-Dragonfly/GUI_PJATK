package pl.pjatk.s36691.gui.zad29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");

        Samochod skoda1 = new Samochod("WA00001", Samochod.Marka.SKODA);
        Samochod skoda2 = new Samochod("SC36010", Samochod.Marka.SKODA);
        Samochod mazda1 = new Samochod("WA01234", Samochod.Marka.MAZDA);
        Samochod mazda2 = new Samochod("DW01ASD", Samochod.Marka.MAZDA);
        Samochod bmw = new Samochod("WA12690", Samochod.Marka.BMW);
        Samochod volvo = new Samochod("KR60606", Samochod.Marka.VOLVO);

        /*
         * Jan Kowalski-> SKODA WA00001, BMW WA12690
         * Adam Nowak-> MAZDA DW01ASD
         * Bartosz Krawczyk-> VOLVO KR60606, MAZDA WA01234, SKODA SC36010
         * Kierownik Heniek-> [Brak samochodów]
         *
         * Samochody, których numery rejestracyjne zaczynają się na WA:
         * SKODA WA00001
         * BMW WA12690
         * MAZDA WA01234
         * */
        Map<Osoba, List<Samochod>> mapaSamochodow = new HashMap<>();
        dodajDoMapy(mapaSamochodow, kowalski, skoda1);
        dodajDoMapy(mapaSamochodow, kowalski, bmw);
        dodajDoMapy(mapaSamochodow, nowak, mazda2);
        dodajDoMapy(mapaSamochodow, krawczyk, volvo);
        dodajDoMapy(mapaSamochodow, krawczyk, mazda1);
        dodajDoMapy(mapaSamochodow, krawczyk, skoda2);
        dodajDoMapy(mapaSamochodow, heniek);

       for (Map.Entry<Osoba, List<Samochod>> mapEntry : mapaSamochodow.entrySet()) {
           if (mapEntry.getValue().isEmpty()) {
               System.out.println(mapEntry.getKey() +"-> [Brak samochodów]");
               continue;
           }
           System.out.println(mapEntry.getKey() + "-> "
                   + mapEntry.getValue().stream()
                   .map(Samochod::toString)
                   .collect(Collectors.joining(", ")));
       }

        System.out.println("======");
        for (Map.Entry<Osoba, List<Samochod>> mapEntry : mapaSamochodow.entrySet()) {
            int iloscpojazdow = mapEntry.getValue().size();
            String pojazdOdmiana = "";
            if (iloscpojazdow > 1 && iloscpojazdow < 5) {
                pojazdOdmiana += "y";
            }
            if (iloscpojazdow >= 5 || iloscpojazdow == 0) {
                pojazdOdmiana += "ów";
            }
            System.out.println(mapEntry.getKey() + " posiada " + iloscpojazdow + " pojazd" + pojazdOdmiana );
            // np: Jan Kowalski posiada 3 pojazdy
        }

        System.out.println("======");
        System.out.println("Samochody, których numery rejestracyjne zaczynają się na WA:");
        for (Map.Entry<Osoba, List<Samochod>> mapEntry : mapaSamochodow.entrySet()) {
            mapEntry.getValue().forEach(samochod -> {
                if (samochod.getRejestracja().startsWith("WA")) {
                    System.out.println(samochod);
                }
            });
        }
        System.out.println(mapaSamochodow.get(nowak).get(0));
        // MAZDA DW01ASD
    }

    public static void dodajDoMapy(Map<Osoba, List<Samochod>> mS, Osoba wlasciciel, Samochod samochod) {
        mS.putIfAbsent(wlasciciel, new ArrayList<>());
        mS.get(wlasciciel).add(samochod);
    }
    public static void dodajDoMapy(Map<Osoba, List<Samochod>> mS, Osoba wlasciciel){
        mS.putIfAbsent(wlasciciel, new ArrayList<>());
    }
}
