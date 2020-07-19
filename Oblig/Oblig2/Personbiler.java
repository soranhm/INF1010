class Personbiler extends Fossilbiler {
  private int seter;

  Personbiler(String skilt,double utslipp,int seter) {
    super(skilt,utslipp);
    this.seter = seter;
  }

  public int hentSeter() {
    return seter;
  }

  public String hentNavn(){
    return (char)27 + "[31mPersonbiler" + (char)27 + "[0m";
  }
}
