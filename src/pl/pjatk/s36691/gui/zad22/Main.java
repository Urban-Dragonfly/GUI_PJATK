package pl.pjatk.s36691.gui.zad22;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        System.out.println(silnia(BigInteger.valueOf(23)));
    }

    public static BigInteger silnia(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("n should be >= 0");
        if  (n.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.ONE;
        return n.multiply(silnia(n.subtract(BigInteger.ONE)));
    }
}
