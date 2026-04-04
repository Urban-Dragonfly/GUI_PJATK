package pl.pjatk.s36691.gui.zad18;

public class Smartphone extends Cellphone implements Playable, Internetable {

    private boolean hasWiFi;

    public Smartphone(String name, String producerName, float price, boolean hasSIM, boolean hasWiFi) {
        super(name, producerName, price, hasSIM);
        this.hasWiFi = hasWiFi;
    }

    @Override
    public String internet() {
        if (hasWiFi || super.hasSIM()) {
            return Internetable.super.internet();
        } else {
            return "Internet: INOP";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + play() +
                "\n" + internet();
    }

}
