package pl.pjatk.s36691.gui.zad17;

public class Square implements Comparable<Square>, Figure {
    private int length;
    private int number;
    static int counter = 0;

    public Square(int length) {
        if(length > max){
            throw new TooBigSquareException("Maximum length is " + max);
        }
        this.length = length;
        this.number = ++counter;
    }

    @Override
    public int getArea() {
        return length * length;
    }

    @Override
    public int getPerimeter() {
        return length * 4;
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