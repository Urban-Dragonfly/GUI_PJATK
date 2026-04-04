package pl.pjatk.s36691.gui.zad25;

public class Ubranie implements Comparable<Ubranie> {

    private String nazwa;
    private String kolor;
    private String wzor;
    private String material;
    private Rozmiar rozmiar;
    private double cena;

    public Ubranie(String nazwa, String kolor, String wzor, String material, Rozmiar rozmiar, double cena) {
        this.nazwa = nazwa;
        this.kolor = kolor;
        this.wzor = wzor;
        this.material = material;
        this.rozmiar = rozmiar;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public int compareTo(Ubranie o) {
        return Integer.compare(rozmiar.ordinal(),  o.rozmiar.ordinal());
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa
                + ", Kolor: " + kolor
                + ", Wzór: " + wzor
                + ", Materiał: " + material
                + ", Rozmiar: " + rozmiar
                + ", Cena: " + cena;
    }
}
