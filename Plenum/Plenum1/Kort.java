class Kort {
    private char farge;
    private int verdi;
    public static final char[] farger = {'S', 'H', 'K', 'R'};

    Kort(char farge, int verdi) {
        this.farge = farge;
        this.verdi = verdi;
    }

    public char hentFarge() {
        return farge;
    }

    public int hentVerdi() {
        return verdi;
    }

    public String toString() {
        return String.format("%c %2d", farge, verdi);
    }
}
