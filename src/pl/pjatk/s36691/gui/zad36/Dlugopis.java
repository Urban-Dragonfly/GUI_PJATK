package pl.pjatk.s36691.gui.zad36;

public class Dlugopis implements Przybor {

    private String kolorTuszu;
    private String producent;
    private double gruboscLinii;

    public Dlugopis(String kolorTuszu, String producent, double gruboscLinii) {
        this.kolorTuszu = kolorTuszu;
        this.producent = producent;
        this.gruboscLinii = gruboscLinii;
    }

    public void pisz() {
        System.out.println("abc");
    }

    @Override
    public String toString() {
        return "kolor tuszu: " + kolorTuszu + ", producent: " + producent + ", grubość linii: " + gruboscLinii;
    }

    @Override
    public String getNazwa() {
        return "Długopis";
    }
}
