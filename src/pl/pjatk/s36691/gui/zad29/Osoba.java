package pl.pjatk.s36691.gui.zad29;

import java.util.Objects;

public class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    //getters and setters
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko);
    }

    @Override
    public String toString() {
        return getImie() + " " + getNazwisko();
    }
}
