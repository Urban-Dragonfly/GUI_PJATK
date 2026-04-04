package pl.pjatk.s36691.gui.zad11;

public abstract class Figura {
    private String kolor;

    public Figura(String kolor){
        this.kolor = kolor;
    }

    public abstract double pole();
    public abstract double obwod();

    @Override
    public String toString(){
        return kolor + " " + this.getClass().getSimpleName().toLowerCase()
                + ", pole: " + Math.round(pole() * 100)/100.0
                + ", obwod: " + ((obwod() == -1) ? "za malo danych" : Math.round(obwod() *100)/100.0);
    }
}
