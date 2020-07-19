import krypto.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Telegrafist implements Runnable{
  private Kanal kl;
  private Monitor m;
  private int skvnr;
  private int id;


  public Telegrafist(Kanal kl,Monitor m){
    this.kl = kl;
    this.m = m;
  }

  public void run(){
    id = kl.hentId();
    String s = kl.lytt();                       // horer paa forste mld
    while(s != null) {                          // hvis ikke null
        Melding mld = new Melding(s,skvnr,id);  // lager ny Melding
        m.sett(mld);
        s = kl.lytt();                         // horer paa andre mld til faar null
        skvnr++;
    }
    m.ferdigP();
  }

}
