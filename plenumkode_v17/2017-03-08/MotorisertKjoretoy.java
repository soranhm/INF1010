public abstract class MotorisertKjoretoy implements Kjoretoy {
    private String regNr;

    public MotorisertKjoretoy(String regNr) {
        this.regNr = regNr;
    }

    @Override
    public String hentId() {
        return regNr;
    }

    @Override
    public String toString() {
        return "Registreringsnummer: " + regNr;
    }
}