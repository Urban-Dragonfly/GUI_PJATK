package pl.pjatk.s36691.gui.zad09;

public class Cat extends Animal {

    public Cat(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
