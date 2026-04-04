package pl.pjatk.s36691.gui.zad14;

public class SweterWelniany implements Pranie {
    private String kolor;
    private String wzor;

    public SweterWelniany(String color, String patter) {
        this.kolor = color;
        this.wzor = patter;
    }

    @Override
    public String toString() {
        return "Sweter welniany, " + kolor
                + " wzór: " + wzor;
    }

    @Override
    public int jakaTemperatura() {
        return 30;
    }

    @Override
    public String nazwaCyklu() {
        return "wool";
    }
}
