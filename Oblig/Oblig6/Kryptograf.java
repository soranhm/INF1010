import krypto.*;

class Kryptograf implements Runnable{
  private Monitor m1;// mottar mld
  private Monitor m2;// sender videre krypt mld
  private Melding k;

  public Kryptograf(Monitor m1,Monitor m2){
    this.m1 = m1;
    this.m2 = m2;
  }

  public void run(){
    k = m1.hent();                                                         // henter melding
    while (k != null) {
      String dekryptertMld = Kryptografi.dekrypter(k.getMelding());
      m2.sett(new Melding(dekryptertMld,k.getSekvensnummer(), k.getId()));// setter krypt mld
      k = m1.hent();                                                      // henter neste mld til ingen igjen
    }
    m1.ferdigK();
    m2.ferdigP();
  }
}
