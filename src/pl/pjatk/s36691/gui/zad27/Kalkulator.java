package pl.pjatk.s36691.gui.zad27;

public enum Kalkulator {

    DODAWANIE((a, b) -> a + b),
    ODEJMOWANIE((a, b) -> a - b),
    MNOZENIE((a, b) -> a * b),
    DZIELENIE((a, b) -> a / b),
    RESZTA((a, b) -> a % b),
    POTEGA((a, b) -> Math.pow(a, b));

    private final Operator operator;

    Kalkulator(Operator operator) {
        this.operator = operator;
    }

    public double oblicz(double val1, double val2) {
        return operator.operacja(val1, val2);
    }

}
