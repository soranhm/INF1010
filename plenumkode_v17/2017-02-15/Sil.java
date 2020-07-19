public class Sil {

    public HarAlder[] objekter;

    public Sil() {
        objekter = new HarAlder[5];
    }

    public void settInn(HarAlder objekt) {
        // Case a
        for (int i=0; i<objekter.length; i++) {
            if (objekter[i] == null) {
                objekter[i] = objekt;
                return;
            }
        }

        // case b
        int yngsteIndeks = 0;
        for (int i=0; i<objekter.length; i++) {
            if (objekter[i].hentAlder() < objekter[yngsteIndeks].hentAlder()) {
                yngsteIndeks = i;
            }
        }

        if (objekter[yngsteIndeks].hentAlder() < objekt.hentAlder()) {
            objekter[yngsteIndeks] = objekt;
        }
    }

    public String toString() {
        String resultat = "Innhold:\n";
        for (HarAlder o : objekter) {
            resultat += "    " + o + "\n";
        }
        return resultat;
    }

}