public class Hund extends Husdyr {
    public Hund(String navn, int alder) {
        super(navn, alder);
    }

    @Override
    public String hentDetaljer() {
        return "Hunden " + super.hentDetaljer();
    }

    @Override
    public void lagLyd() {
        System.out.println("Voff voff sa " + navn);
    }

    @Override
    public int hentAlder() {
        return super.hentAlder()*7;
    }
}