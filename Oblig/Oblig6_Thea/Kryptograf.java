import krypto.*;

public class Kryptograf implements Runnable{
    private Monitor m;
    private Monitor mm;
    private Melding k ;

    public Kryptograf(Monitor m, Monitor mm){
        this.mm = mm;
        this.m = m;
    }

    public void run(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        k = m.hent();
        while(k != null){
            String dekryptertMld = Kryptografi.dekrypter(k.getMelding());
            mm.sett(new Melding(dekryptertMld, k.getSekvensnummer(), k.getId()));
            k = m.hent();
        }
        m.ferdigK();
        mm.ferdigP();
    }
}
