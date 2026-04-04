package pl.pjatk.s36691.gui.zad11;

public class Prostokat extends Figura{
    private double a;
    private double b;

    public Prostokat(String kolor, double a, double b) {
        super(kolor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole() {
        return a * b;
    }

    @Override
    public double obwod() {
        return 2 * a + 2 * b;
    }

}
