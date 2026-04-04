package pl.pjatk.s36691.gui.zad23;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumUpTo(23));
    }

    public static long sumUpTo(long a) {
        if (a < 1) throw new IllegalArgumentException("n must be > 0");
        if (a == 1) return 1;
        return a + sumUpTo(a - 1);
    }
}
