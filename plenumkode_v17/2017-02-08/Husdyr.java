public class Husdyr {
    protected String navn;
    private int alder;

    public Husdyr() {
        System.out.println("Kalt");
    }

    public Husdyr(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String hentDetaljer() {
        return this.navn + " er " + this.alder + " år";
    }

    @Override
    public String toString() {
        return hentDetaljer();
    }

    public void oppdaterAlder() {
        this.alder++;
    }

    public void oppdaterAlder(int nyAlder) {
        this.alder = nyAlder;
    }
}