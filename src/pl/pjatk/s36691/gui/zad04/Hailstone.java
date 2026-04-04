package pl.pjatk.s36691.gui.zad04;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer> {

    private final int start;

    public Hailstone(int start) {
        this.start = start;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HailstoneIterator();
    }

    private class HailstoneIterator implements Iterator<Integer> {

        private int number = Hailstone.this.start;
        private boolean first = true;
        private boolean last = false;

        @Override
        public boolean hasNext() {
            return !last;
        }

        @Override
        public Integer next() {
            if (first) {
                first = false;
                last = number == 1;
                return number;
            }
            if (number % 2 == 0) {
                number =  number / 2;
                last = number == 1;
                return number;
            }  else {
                return number =  3 * number + 1;
            }
        }
    }
}
