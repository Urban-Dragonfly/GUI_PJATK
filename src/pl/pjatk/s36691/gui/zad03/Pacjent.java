package pl.pjatk.s36691.gui.zad03;

public abstract class Pacjent {

    private String name;

    public Pacjent(String name) {
        this.name = name;
    }

    public String nazwisko() {
        return name;
    }

    public abstract String choroba();
    public abstract String leczenie();
}
