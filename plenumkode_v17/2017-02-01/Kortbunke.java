import java.util.ArrayList;
import java.util.Random;

class Kortbunke {
    private ArrayList<Kort> bunken;
    private Random random;

    Kortbunke() {
        bunken = new ArrayList<Kort>();
        random = new Random();
    }

    public boolean erTom() {
        return bunken.isEmpty();
    }

    public int antallKort() {
        return bunken.size();
    }

    public Kort hentKort(int indeks) {
        return bunken.get(indeks);
    }

    public Kort hentOeverste() {
        return bunken.get(0);
    }

    public void fjernKort(Kort kort) {
        bunken.remove(kort);
    }

    public Kort fjernOeverste() {
        return bunken.remove(0);
    }

    public void leggTil(Kort kort) {
        bunken.add(kort);
    }

    public void leggTilOeverst(Kort kort) {
        bunken.add(0, kort);
    }

    public static Kortbunke helKortstokk() {
        Kortbunke kortstokken = new Kortbunke();
        for (char farge : Kort.farger) {
            for (int verdi = 1; verdi < 14; verdi++) {
                kortstokken.leggTil(new Kort(farge, verdi));
            }
        }
        return kortstokken;
    }

    public void stokk() {
        ArrayList<Kort> gamlebunken = bunken;
        bunken = new ArrayList<Kort>();
        while (!gamlebunken.isEmpty()) {
            int kortIgjen = gamlebunken.size();
            int indeksKortSomTrekkes = random.nextInt(kortIgjen);
            Kort trukketKort = gamlebunken.remove(indeksKortSomTrekkes);
            bunken.add(trukketKort);
        }
    }

    public Kort velgKort() {
        int teller = 0;
        String melding = String.format("[%2d] %s\n", teller++, "PASS");
        for (Kort kort : bunken) {
            melding += String.format("[%2d] %s\n", teller++, kort);
        }
        melding += "Velg et kort: ";
        int nummer = IO.intFraBrukerFomTom(melding, 0, antallKort());
        if (nummer == 0) {
            // intet kort valgt
            return null;
        }
        return hentKort(nummer - 1);
    }
}
