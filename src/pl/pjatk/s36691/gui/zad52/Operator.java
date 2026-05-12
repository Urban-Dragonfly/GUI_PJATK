package pl.pjatk.s36691.gui.zad52;

public enum Operator {

    DODAWANIE((a, b) -> a + b),
    ODEJMOWANIE((a, b) -> a - b),
    MNOZENIE((a, b) -> a * b),
    DZIELENIE((a, b) -> a / b);

    private final Kalkulator kalkulator;

    Operator(Kalkulator kalkulator) {
        this.kalkulator = kalkulator;
    }

    public double oblicz(double val1, double val2) {
        return kalkulator.operacja(val1, val2);
    }
}