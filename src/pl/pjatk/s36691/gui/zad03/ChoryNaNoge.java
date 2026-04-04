package pl.pjatk.s36691.gui.zad03;

public class ChoryNaNoge extends Pacjent {

    private String name;

    public ChoryNaNoge(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "noga";
    }

    @Override
    public String leczenie() {
        return "gips";
    }
}
