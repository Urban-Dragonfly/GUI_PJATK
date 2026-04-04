package pl.pjatk.s36691.gui.zad18;

public class GameConsole extends Device implements Internetable, Playable {

    private boolean hasWiFi;

    public GameConsole(String name, String producerName, float price, boolean hasWiFi) {
        super(name, producerName, price);
        this.hasWiFi = hasWiFi;
    }

    @Override
    public String internet() {
        if (hasWiFi) {
            return Internetable.super.internet();
        } else {
            return "Internet: INOP";
        }
    }

    @Override
    public String toString() {
        return "Konsola, " + super.toString() +
                "\n" + play() +
                "\n" + internet();

    }

}
