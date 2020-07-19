class Spiller {
    private String navn;
    private Kortbunke haand;

    Spiller(String navn, Kortbunke haand) {
        this.navn = navn;
        this.haand = haand;
    }

    public String hentNavn() {
        return navn;
    }

    /*
    public Kortbunke hentHaand() {
        return haand;
    }
    */

    public int kortPaaHaanden() {
        return haand.antallKort();
    }

    public void delUt(Kort kort) {
        haand.leggTil(kort);
    }

    public Kort velgKort() {
        return haand.velgKort();
    }

    public void fjernKort(Kort kort) {
        haand.fjernKort(kort);
    }
}
