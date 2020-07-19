abstract class Legemiddel{
  protected String navn;
  protected double pris;
  protected double virkestoff;
  protected int id = 0;
  static int teller;

  public Legemiddel(String navn, double pris, double virkestoff){
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    id = teller;
    teller++;
  }
  public int hentId() { return id; }
  public String hentNavn() { return navn; }
  public double hentPris() { return pris;   }
  public double hentVirkestoff() { return virkestoff; }
}
