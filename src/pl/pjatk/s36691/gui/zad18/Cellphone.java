package pl.pjatk.s36691.gui.zad18;

public class Cellphone extends Phone implements SMSable{

    private boolean hasSIM;

    public Cellphone(String name, String producerName, float price, boolean hasSIM) {
        super(name, producerName, price);
        this.hasSIM = hasSIM;
    }

    public boolean hasSIM() {
        return hasSIM;
    }

    @Override
    public String call() {
        if (hasSIM) {
            return super.call();
        } else {
            return "Calling: INOP";
        }
    }

    @Override
    public String sms() {
        if (hasSIM) {
            return SMSable.super.sms();
        } else {
            return "SMS: INOP";
        }
    }

    @Override
    public String toString() {
        return "Komórka, " + super.toString() +
                "\n" + call() +
                "\n" + sms();
    }
}
