package pl.pjatk.s36691.gui.zad30;

public class Main {
    public static void main(String[] args) {
        Calc c = new Calc();

        System.out.println(c.doCalc("2 + 3"));
        System.out.println(c.doCalc("10 - 4"));
        System.out.println(c.doCalc("6 * 7"));
        System.out.println(c.doCalc("8 / 2"));
        System.out.println(c.doCalc("2 @ 3"));
        System.out.println(c.doCalc("abc + 3"));
        System.out.println(c.doCalc("2 +"));

        String wynik = c.doCalc("2 * 3");
        System.out.println(wynik);
    }
}
