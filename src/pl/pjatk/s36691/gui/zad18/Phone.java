package pl.pjatk.s36691.gui.zad18;

public abstract class Phone extends Device implements Callable{

    public Phone(String name, String producerName, float price) {
        super(name, producerName, price);
    }

}
