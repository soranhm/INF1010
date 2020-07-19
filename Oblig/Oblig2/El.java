class El extends Bil {

  private double batteri;

  El(String skilt,double batteri) {
    super(skilt);
    this.batteri = batteri;
  }

  public double hentBatteri() {
    return batteri;
  }

  public String hentNavn(){
    return (char)27 + "[31mEl" + (char)27 + "[0m";
  }
}
