class Husdyr {
  protected String navn;
  protected int alder;

  Husdyr(String navn, int alder){

    this.navn = navn;
    this.alder = alder;

  }

  public String getInfo(){
    return navn+ " er " + alder+ " år";
  }

  public void oppdaterAlder() {
    alder++;
  }
}
