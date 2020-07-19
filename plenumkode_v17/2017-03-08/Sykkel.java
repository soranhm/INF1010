public class Sykkel implements Kjoretoy {
    String eier;

    public Sykkel(String eier) {
        this.eier = eier;
    }

    @Override
    public String hentId() {
        return eier;
    }

    @Override
    public String toString() {
        return "Sykkel. Eier: " + eier;
    }
}