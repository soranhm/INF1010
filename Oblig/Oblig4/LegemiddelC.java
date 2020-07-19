public class LegemiddelC extends Legemiddel{
  private String type;

  public LegemiddelC(String navn, double pris, double virkestoff){
    super(navn,pris,virkestoff);
    type = "c";
  }

  public String hentType(){return type;}

  public String toString(){
    String s = String.format("Legemiddle: %s, Type: %s, Pris: %.2f, Virkestoff: %.2f",hentNavn(),hentType(),hentPris(),hentVirkestoff());
    return s;
 }
}
