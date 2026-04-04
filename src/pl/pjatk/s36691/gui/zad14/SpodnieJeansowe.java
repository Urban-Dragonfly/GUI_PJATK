package pl.pjatk.s36691.gui.zad14;

public class SpodnieJeansowe implements Pranie {
    private int szerokoscTalii;
    private int dlugoscNogawki;

    public SpodnieJeansowe(int waist, int length) {
        this.szerokoscTalii = waist;
        this.dlugoscNogawki = length;
    }

    @Override
    public String toString() {
        return "Spodnie, szerokość w pasie: " + szerokoscTalii
                + ", długość nogawki: " + dlugoscNogawki;
    }

    @Override
    public int jakaTemperatura() {
        return 60;
    }

    @Override
    public String nazwaCyklu() {
        return "jeans";
    }
}
