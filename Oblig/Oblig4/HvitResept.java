class HvitResept extends Resept{
  public HvitResept(Legemiddel middel,Lege lege,int pasientID,int reit){
    super(middel,lege,pasientID,reit);
  }

  public String farge(){
    return "hvit";
  }

  public double prisAaBetale(){
    return middel.hentPris();
  }

}
