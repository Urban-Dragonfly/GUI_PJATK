package pl.pjatk.s36691.gui.zad36;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Piornik implements Serializable {
    private String wlasciciel;
    private List<Przybor> przybory;

    public Piornik(String wlasciciel) {
        this.wlasciciel = wlasciciel;
        this.przybory = new ArrayList<>();
    }

    public void dodaj(Przybor przybor) {
        this.przybory.add(przybor);
    }

    public void pokazZawartosc() {
        System.out.println(toString());
        for (Przybor przybor : przybory) {
            System.out.println(przybor.getNazwa() + ", " + przybor);
        }
    }

    @Override
    public String toString() {
        return "Piórnik, właściciel: " + wlasciciel;
    }

}
