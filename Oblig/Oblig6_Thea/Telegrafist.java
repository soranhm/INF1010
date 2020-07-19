import krypto.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Telegrafist implements Runnable {
    private Kanal kmeld;
    private int sekvensnummer = 1;
    private int id;
    private Monitor m;

    public Telegrafist(Kanal kmeld, Monitor m){ //kmeld, array med meldingene
        this.m = m;
        this.kmeld = kmeld;
    }

    public void run(){
        id = kmeld.hentId();
        String s = kmeld.lytt();
        while(s!= null){

            Melding mmm = new Melding(s, sekvensnummer, id);
            m.sett(mmm);
            s = kmeld.lytt();
            sekvensnummer++;
        }
        m.ferdigP();
    }
}
