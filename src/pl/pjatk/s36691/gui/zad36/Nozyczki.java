package pl.pjatk.s36691.gui.zad36;

public class Nozyczki implements Przybor {
    private double dlugoscOstrza;
    private String kolor;
    private boolean ostre;

    public Nozyczki(double dlugoscOstrza, String kolor, boolean ostre) {
        this.dlugoscOstrza = dlugoscOstrza;
        this.kolor = kolor;
        this.ostre = ostre;
    }

    public void tnij() {
        System.out.println("ciach!");
    }

    @Override
    public String toString() {
        return "kolor: " + kolor + ", długość ostrza: " + dlugoscOstrza + ", ostre: " + ostre;
    }

    @Override
    public String getNazwa() {
        return "Nożyczki";
    }
}
