package pl.pjatk.s36691.gui.zad08;

public class Main {
    public static void main(String[] args) {

        Person[] people = {
                new Student("Kalaria", "Kot", 23),
                new Student("Ciuciema", "Kot", 42),
                new CabinCrew("Michal", "K.", 555)
        };

        for (Person person : people) {
            person.greet(person);
        }
    }
}
