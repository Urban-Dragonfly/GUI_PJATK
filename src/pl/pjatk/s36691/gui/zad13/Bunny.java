package pl.pjatk.s36691.gui.zad13;

public class Bunny implements Pet {
    private String name;

    public Bunny (String name) {
        this.name = name;
    }

    @Override
    public void conditions() {
        System.out.println("Carrots");
    }

    @Override
    public String commonProblem() {
        return "what's up doc?";
    }
}
