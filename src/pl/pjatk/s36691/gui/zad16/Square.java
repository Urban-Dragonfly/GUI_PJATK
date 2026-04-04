package pl.pjatk.s36691.gui.zad16;

public class Square implements Comparable<Square> {
    private int length;
    private int number;
    static int counter = 0;

    public Square(int length) {
        this.length = length;
        this.number = ++counter;
    }

    public int getArea() {
        return length * length;
    }

    @Override
    public String toString() {
        return "(" + number + "): " + getArea();
    }

    @Override
    public int compareTo(Square other) {
        int result = Integer.compare(length, other.length);
        result = result == 0 ? Integer.compare(number, other.number) : result;
        return result;
    }
}