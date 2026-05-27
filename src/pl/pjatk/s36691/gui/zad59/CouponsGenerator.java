package pl.pjatk.s36691.gui.zad59;

public class CouponsGenerator {

    private final int minNumber;
    private final int maxNumber;
    private final int couponLength;
    private final int couponsCount;
    private int[][] coupons;

    public CouponsGenerator(int couponLength, int couponsCount, int maxNumber) {
        this.couponLength = couponLength;
        this.couponsCount = couponsCount;
        this.minNumber = 1;
        this.maxNumber = maxNumber;
        if (couponLength > maxNumber - minNumber + 1) {
            throw new IllegalArgumentException("Coupon length cannot be greater than available numbers range.");
        }
        generateCoupons();
    }

    public void generateCoupons() {
        int[][] coupons = new int[couponsCount][];
        for (int i = 0; i < couponsCount; i++) {
            coupons[i] = generateCoupon();
        }
        this.coupons = coupons;
    }

    private int[] generateCoupon() {
        int[] numbers = new int[couponLength];
        for (int i = 0; i < numbers.length; i++) {
            int number = generateRandomNumber();
            if (contains(numbers, i, number)) {
                i--;
                continue;
            }
            numbers[i] = number;
        }
        return numbers;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * (maxNumber - minNumber + 1)) + minNumber;
    }

    private boolean contains(int[] numbers, int usedLength, int number) {
        for (int i = 0; i < usedLength; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    public int[][] getCoupons() {
        return coupons;
    }
}
