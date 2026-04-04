package pl.pjatk.s36691.gui.zad12;

import java.util.Arrays;

public abstract class Spiewak {
    private String nazwisko;
    private int id;
    private static int idCount = 0;


    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        this.id = ++idCount;
    }

    public abstract String spiewaj();

    public String toString() {
        return "(" + id + ") " + nazwisko + ": " + spiewaj();
    }

    public int getId() {
        return id;
    }

    public static Spiewak najglosniej(Spiewak[] sp) {
        long biggestCount = -1;
        Spiewak winner = null;
        for (Spiewak s : sp) {
            long count = s.spiewaj().chars()
                    .filter(ch -> Character.isLetter(ch) && Character.isUpperCase(ch))
                    .count();
            if (count > biggestCount) {
                biggestCount = count;
                winner = s;
            }
        }
        return winner;
    }
}
