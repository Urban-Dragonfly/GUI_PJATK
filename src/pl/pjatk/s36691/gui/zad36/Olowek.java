package pl.pjatk.s36691.gui.zad36;

public class Olowek implements Przybor{
    private String twardosc;
    private double dlugosc;
    private boolean zatemperowany;

    public Olowek(String twardosc, double dlugosc, boolean zatemperowany) {
        this.twardosc = twardosc;
        this.dlugosc = dlugosc;
        this.zatemperowany = zatemperowany;
    }

    public void rysuj() {
        if (zatemperowany) {
            System.out.println("~~~~~~");
            zatemperowany = false;
        } else {
            System.out.println("Najpierw zatemperuj");
        }
    }

    public void temperuj() {
        zatemperowany = true;
    }

    @Override
    public String toString() {
        return "twardość: " + twardosc + ", długość: " + dlugosc + ", zatemperowany: " + zatemperowany;
    }

    @Override
    public String getNazwa() {
        return "Ołówek";
    }
}
