package pl.pjatk.s36691.gui.zad09;

public abstract class Animal {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public abstract void makeSound();

}
