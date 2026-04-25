package pl.pjatk.s36691.gui.zad33;

public class Animal {
    private String name;
    private int weight;
    private int height;
    private int topSpeed;

    public Animal(String name, int weight, int height, int topSpeed) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.topSpeed = topSpeed;
    }

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", Waga: " + weight + "kg, Wysokość: " + (double)height/100 + "m, Prędkość: " + topSpeed + "km/h";
    }
}
