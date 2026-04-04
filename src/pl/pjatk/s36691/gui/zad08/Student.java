package pl.pjatk.s36691.gui.zad08;

public class Student extends Person{

    int indexNumber;

    public Student(String name, String surname, int indexNumber){
        super(name, surname);
        this.indexNumber = indexNumber;
    }

    public void greet(Person p){
        System.out.println("Hi " + p.name);
    }
}
