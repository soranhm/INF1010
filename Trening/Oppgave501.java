public class Oppgave501 {
  public static void main(String[] args){

    Bil bilGeir = new Bil("Geir Kjetil", "ford");
    Bil bilSiri = new Bil("Siri", "volvo");
    Bil bilSoran = new Bil("Soran Hussein", "ferrari");

    bilGeir.infoOmBil();
    bilSiri.infoOmBil();
    bilSoran.infoOmBil();
  }
}

class Bil {

  private String eier;
  private String merke;

  public Bil(String e, String m){
    eier = e;
    merke = m;
  }

  public void infoOmBil() {
    System.out.println("Eier: " + eier + ", kjorer " + merke);
  }

}
