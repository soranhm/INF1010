class Fossilbiler extends Bil {

  protected double utslipp;

  Fossilbiler(String skilt,double utslipp) {
    super(skilt);
    this.utslipp = utslipp;
  }

  public double hentUtslipp() {
    return utslipp;
  }

}
