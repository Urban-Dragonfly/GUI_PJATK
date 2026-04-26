package pl.pjatk.s36691.gui.zad36;

public class Gumka implements Przybor {
    private String kolor;
    private String ksztalt;

    public Gumka(String kolor, String ksztalt) {
        this.kolor = kolor;
        this.ksztalt = ksztalt;
    }

    public void zmazuj() {
        System.out.println("scrub scrub!");
    }
    @Override
    public String toString() {
        return "kolor: " + kolor + ", kształt: " + ksztalt;
    }
    @Override
    public String getNazwa() {
        return "Gumka";
    }
}
