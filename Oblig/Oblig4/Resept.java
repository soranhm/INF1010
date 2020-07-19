abstract class Resept{

  protected Legemiddel middel;
  protected Lege lege;
  protected int pasientID;
  protected int reit;
  protected int reseptId;
  static int teller;

  public Resept(Legemiddel middel,Lege lege,int pasientID,int reit){
    this.middel = middel;
    this.lege = lege;
    this.pasientID = pasientID;
    this.reit = reit;
    reseptId = teller;
    teller++;
  }

  public int hentId() { return reseptId; }
  public Legemiddel hentLegemiddel() { return middel; }
  public Lege hentLege() { return lege; }
  public int hentPasientId() { return pasientID; }
  public int hentReit() { return reit; }

  /**
  * Bruker resepten én gang. Returner false om resepten er
  * oppbrukt, ellers returnerer den true.
  * @return      om resepten kunne brukes
  */
  public boolean bruk() {
    reit--;
    return (reit >= 0);
  }

  /**
  * Returnerer reseptens farge. Enten "blå" eller "hvit".
  * @return      reseptens farge
  */
  abstract public String farge();

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  abstract public double prisAaBetale();

  @Override
  public String toString(){
    return "Farge: " + farge() + lege
           + " ,Middel: " + middel.hentNavn();
   }
}
