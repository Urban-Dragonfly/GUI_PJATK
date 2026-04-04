package pl.pjatk.s36691.gui.zad08;

public abstract class Person {
    String name;
    String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String toString(){
        return "Name: " + name + ", Surname: " + surname;
    }

    public abstract void greet(Person p);
}
