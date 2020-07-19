class Lastebiler extends Fossilbiler {
  private double nyttevekt;

  Lastebiler(String skilt,double utslipp,double nyttevekt){
    super(skilt,utslipp);
    this.nyttevekt = nyttevekt;
  }

  public double hentNyttevekt() {
    return nyttevekt;
  }

  public String hentNavn(){
    return (char)27 + "[31mLastebiler" + (char)27 + "[0m";
  }
}
