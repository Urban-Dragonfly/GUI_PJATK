package pl.pjatk.s36691.gui.zad13;

public class Main{
    public static void main(String[] args) {
        Dog burek = new Dog("Burek");
        Pet[] pets = {burek,
                () -> System.out.println("Scratching post, wet food and water"),
                new Bunny("Bugs")
        };

        for(Pet p : pets){
            p.conditions();
            System.out.println(p.commonProblem());
        }
    }
    }
