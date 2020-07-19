public class Lege implements Comparable<Lege>{

  protected String navn;
  Koe<Resept> rest;

  public Lege(String navn){
    this.navn = navn;
    rest = new Koe<Resept>();

  }
  public String hentNavn() {
    return navn;
  }
  public int compareTo(Lege annenLege) {
    return navn.compareTo(annenLege.hentNavn());
  }

  public void leggTilResept(Resept resept) {
    rest.settInn(resept);
  }
  public Koe<Resept> hentReseptliste() {
      return rest;
    }

  public String toString(){
    return " ,Lege: "+ navn;
  }
}
