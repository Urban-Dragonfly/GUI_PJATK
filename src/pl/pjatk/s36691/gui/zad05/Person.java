package pl.pjatk.s36691.gui.zad05;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void  sayHelloTo(Person person) {
        System.out.println("Hello " + person.name);
    }

    public String getName() {
        return name;
    }


}
