public class Bil implements HarAlder {
    private String navn;
    private int alder;

    public Bil(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public int hentAlder() {
        return alder;
    }
}