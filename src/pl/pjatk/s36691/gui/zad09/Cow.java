package pl.pjatk.s36691.gui.zad09;

public class Cow extends Animal {

    public Cow(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Moo");
    }
}
