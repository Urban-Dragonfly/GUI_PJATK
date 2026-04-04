package pl.pjatk.s36691.gui.zad14;

public class Main {
    public static void main(String[] args) {
        Pranie[] koszNaPranie = {
                new SpodnieJeansowe(32, 90),
                new SpodnieJeansowe(36, 100),
                new SweterWelniany("czerwony", "romby")
        };

        for (Pranie ubranie : koszNaPranie) {
            System.out.println(ubranie);
            System.out.print("temperatura: " + ubranie.jakaTemperatura());
            System.out.println(", cykl: " + ubranie.nazwaCyklu());
            System.out.println("---");
        }
    }
}
