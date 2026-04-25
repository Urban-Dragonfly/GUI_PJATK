package pl.pjatk.s36691.gui.zad33;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Animal("Słoń", 6000, 320, 40),
                new Animal("Żyrafa", 1200, 500, 60),
                new Animal("Lew", 190, 120, 80),
                new Animal("Tygrys", 220, 110, 65),
                new Animal("Koń", 500, 170, 88),
                new Animal("Niedźwiedź", 350, 150, 50),
                new Animal("Wilk", 45, 85, 60),
                new Animal("Pies", 30, 60, 45),
                new Animal("Królik", 2, 25, 40),
                new Animal("Struś", 140, 250, 70)
        );

        List<String> forEachAnimalsOver1m = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getHeight() > 100) {
                forEachAnimalsOver1m.add(animal.getName());
            }
        }
        System.out.println(forEachAnimalsOver1m);

        System.out.println();

        List<String> streamAnimalsOver1m = animals.stream()
                .filter(animal -> animal.getHeight() > 100)
                .map(Animal::getName)
                .toList();
        System.out.println(streamAnimalsOver1m);
    }
}
