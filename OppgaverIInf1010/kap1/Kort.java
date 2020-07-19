class Kort {
  private String farge;
  private int tall;

  public Kort(String f,int t){
    farge = f;
    tall = t;
  }

  public String toString() {
    return new String(farge);
  }

  public int getTall(){
    return tall
  }
}
