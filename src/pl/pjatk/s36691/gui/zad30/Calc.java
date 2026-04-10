package pl.pjatk.s36691.gui.zad30;

import java.util.HashMap;
import java.util.Map;

public class Calc {
    private Map<String, Operacja> operations;

    public Calc() {
        operations = new HashMap<>();
        operations.put("+", (x, y) -> x + y);
        operations.put("-", (x, y) -> x - y);
        operations.put("*", (x, y) -> x * y);
        operations.put("/", (x, y) -> x / y);
    }

    public String doCalc(String dzialanie) {
        try {
            String[] elements = dzialanie.split(" ");
            double x = Double.parseDouble(elements[0]);
            double y = Double.parseDouble(elements[2]);
            return Double.toString(operations.get(elements[1]).oblicz(x, y));
        } catch (Exception e) {
            return "Podaj prawidłowe działanie arytmetyczne";
        }
    }
}
