public class Hund extends Husdyr {
    public Hund(String navn, int alder) {
        super(navn, alder);
    }

    @Override
    public String hentDetaljer() {
        return "Hunden " + super.hentDetaljer();
    }

    public void bjeff() {
        System.out.println("Voff voff sa " + navn);
    }
}