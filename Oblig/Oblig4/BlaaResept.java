class BlaaResept extends Resept{
  public BlaaResept(Legemiddel middel,Lege lege,int pasientID,int reit){
    super(middel,lege,pasientID,reit);
  }

  public String farge(){
    return "blaa";
  }

  public double prisAaBetale(){
    return 0.25*middel.hentPris();
  }
}
