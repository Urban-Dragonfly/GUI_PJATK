package pl.pjatk.s36691.gui.zad09;

public class Main {
    public static void main(String[] args) {

        Animal firstAnimal = new Cow("Milka", 23);
        Animal secondAnimal = new Cat("Garrfield", 13.5);

        firstAnimal.makeSound();
        secondAnimal.makeSound();
    }



}
