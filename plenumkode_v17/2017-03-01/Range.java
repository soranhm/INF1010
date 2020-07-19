import java.util.Iterator;

class Range implements Iterable<Integer> {
    private int rangeStart;
    private int rangeEnd;

    Range(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    Range(int rangeEnd) {
        this(0, rangeEnd);
    }

    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        private int gjeldendeTall;

        public RangeIterator() {
            this.gjeldendeTall = rangeStart;
        }

        public Integer next() {
            int returVerdi = gjeldendeTall;
            gjeldendeTall++;
            return returVerdi;
        }

        public boolean hasNext() {
            return this.gjeldendeTall < rangeEnd;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}