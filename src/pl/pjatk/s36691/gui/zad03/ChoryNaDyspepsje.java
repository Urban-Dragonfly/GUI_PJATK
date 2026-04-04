package pl.pjatk.s36691.gui.zad03;

public class ChoryNaDyspepsje extends Pacjent {

    public ChoryNaDyspepsje(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "dyspepsja";
    }

    @Override
    public String leczenie() {
        return "węgiel";
    }
}
