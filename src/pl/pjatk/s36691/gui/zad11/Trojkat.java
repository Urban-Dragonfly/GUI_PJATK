package pl.pjatk.s36691.gui.zad11;

public class Trojkat extends Figura {
    private double a;
    private double h;

    public Trojkat(String kolor, double a, double h) {
        super(kolor);
        this.a = a;
        this.h = h;
    }


    @Override
    public double pole() {
        return a * h / 2;
    }

    @Override
    public double obwod() {
        return -1;
    }
}
