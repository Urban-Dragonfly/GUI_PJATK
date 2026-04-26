package pl.pjatk.s36691.gui.zad36;

public class Pioro implements Przybor {

    private String kolorAtramentu;
    private String typStalowki;
    private boolean czyNabojPelny;

    public Pioro(String kolorAtramentu, String typStalowki, boolean czyNabojPelny) {
        this.kolorAtramentu = kolorAtramentu;
        this.typStalowki = typStalowki;
        this.czyNabojPelny = czyNabojPelny;
    }

    public void pisz() {
        System.out.println("abc");
    }

    public void wymienNaboj() {
        czyNabojPelny = true;
    }

    @Override
    public String toString() {
        return "kolor atramentu: " + kolorAtramentu + ", typ stalowki: " + typStalowki + ", nabój pełny: " + czyNabojPelny;
    }

    @Override
    public String getNazwa() {
        return "Pióro";
    }
}
