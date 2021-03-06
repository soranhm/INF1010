import krypto.*;

class Oblig6 {
    private static final int antallTelegrafister = 3;
    private static final int antallKryptografer = 20;
    private static final int antallOperasjonsledere = 1;

    public static void main(String[] args) {
        int i = 0;
        Monitor m = new Monitor(antallTelegrafister, antallKryptografer);
        Monitor m2 = new Monitor(antallKryptografer, antallOperasjonsledere);
        Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);//antallTelegrafister = maxKanaler
        krypto.Kanal[] kanaler = ops.hentKanalArray();
        while(i<antallTelegrafister) {
            new Thread(new Telegrafist(kanaler[i], m)).start();
            i++;
        }
        i=0;

        while(i<antallKryptografer){
            new Thread(new Kryptograf(m, m2)).start();
            i++;
        }

        new Thread(new Operasjonsleder(m2)).start();

        while(m2.alleP() && m2.alleK()){ // endelig løøke som terminerer når ting er ferdig
        }
    }
}
