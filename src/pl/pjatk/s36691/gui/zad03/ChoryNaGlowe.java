package pl.pjatk.s36691.gui.zad03;

public class ChoryNaGlowe extends Pacjent {

    private String name;

    public ChoryNaGlowe(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "głowa";
    }

    @Override
    public String leczenie() {
        return "aspiryna";
    }
}
