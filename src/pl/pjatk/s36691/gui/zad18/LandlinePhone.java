package pl.pjatk.s36691.gui.zad18;

public class LandlinePhone extends Phone implements Callable{

    public LandlinePhone(String name, String producerName, float price) {
        super(name, producerName, price);
    }

    @Override
    public String toString() {
        return "Telefon stacjonarny, " + super.toString() + "\n"
                + this.call();
    }
}
