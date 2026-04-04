package pl.pjatk.s36691.gui.zad18;

public abstract class Device {
    private String name;
    private String producerName;
    private float price;

    public Device(String name, String producerName, float price) {
        this.name = name;
        this.producerName = producerName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + " Marka: " + producerName + ", Cena: " + price;
    }

}
