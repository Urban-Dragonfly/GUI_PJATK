package pl.pjatk.s36691.gui.zad29;

public class Samochod {
    public enum Marka {
        SKODA, MAZDA, BMW, VOLVO
    }
    private String rejestracja;
    private Marka marka;

    public Samochod(String rejestracja, Marka marka) {
        this.rejestracja = rejestracja;
        this.marka = marka;
    }

    public String getRejestracja() {
        return rejestracja;
    }

    @Override
    public String toString() {
        return marka + " " + rejestracja;
    }
}
