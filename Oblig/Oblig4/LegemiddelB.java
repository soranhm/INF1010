public class LegemiddelB extends Legemiddel{
  private int styrke;
  private String type;

  public LegemiddelB(String navn, double pris, double virkestoff,int styrke){
    super(navn,pris,virkestoff);
    this.styrke = styrke;
    type = "b";
  }

  public int hentVanedannendeStyrke() { return styrke; }

  public String hentType(){return type;}

  public String toString(){
    String s = String.format("Legemiddle: %s, Type: %s, Pris: %.2f, Virkestoff: %.2f, Styrke: %d",hentNavn(),hentType(),hentPris(),hentVirkestoff(),hentVanedannendeStyrke());
    return s;
 }
}
