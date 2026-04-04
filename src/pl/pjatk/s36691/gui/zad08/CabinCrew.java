package pl.pjatk.s36691.gui.zad08;

public class CabinCrew extends Person{

    int staffNumber;

    public CabinCrew(String name, String surname, int staffNumber){
        super(name, surname);
        this.staffNumber = staffNumber;
    }

    public void greet(Person p){
        System.out.println("Hello " + p.name);
    }
}
