class Hund implements Comparable<Hund> {
  private String navn;
  private int alder;

  public Hund(String navn, int alder){
  this.navn = navn;
  this.alder = alder;

  }
  public int hentAlder(){
    return alder;
  }

  @Override
  public String toString(){return navn + " " + alder + " aar"; }

  @Override
  public int compareTo(Hund annenHund){
    /*if(this.hentAlder() < annenHund.hentAlder()){
      return -1;
    }
    else if(this.hentAlder() > annenHund.hentAlder()){
      return 1;
    }
    else {
      return 0;
    }*/
    return this.hentAlder() - annenHund.hentAlder();
  }
}
