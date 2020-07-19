public abstract class Husdyr implements HarAlder {
    protected String navn;
    private int alder;
    private int id;
    private static int teller = 0;

    public Husdyr() {
        System.out.println("Kalt");
        id = teller;
        teller++;
    }

    public Husdyr(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
        id = teller;
        teller++;
    }

    public int hentAlder(){
      return alder;
    }

    public String hentNavn(){
      return navn;
    }

    public String hentDetaljer() {
        return this.id + ": " + this.navn + " er " + this.alder + " år";
    }

    @Override
    public String toString() {
        return hentDetaljer();
    }


    public boolean equals(Husdyr annet) {
      return getClass().equals(annet.getClass())
      && alder == annet.hentAlder()
      && navn.equals(annet.hentNavn());
    }

    public void oppdaterAlder() {
        this.alder++;
    }

    public void oppdaterAlder(int nyAlder) {
        this.alder = nyAlder;
    }

    public abstract void lagLyd();

}
