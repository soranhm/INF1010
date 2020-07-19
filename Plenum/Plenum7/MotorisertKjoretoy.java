public abstract class MotorisertKjoretoy implements Kjoretoy{
  private String regNr;

  public MotorisertKjoretoy(String regNr){
    this.regNr = regNr;
  }
  public String hentId(){return regNr;}

  @Override
  public String toString(){
    return "Registreringsnummer: " + regNr;
  }
}
