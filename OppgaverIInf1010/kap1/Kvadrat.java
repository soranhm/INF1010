class Kvadrat {
  private double sidelengde;
  private double omkrets;
  private double areal;

  public Kvadrat(double s){
    sidelengde = s;
  }

  public void omkrets(){
    omkrets = 4*sidelengde;
  }

  public void areal(){
    areal = sidelengde*sidelengde;
  }

  public void skrivUt(){
    System.out.println("Kvadrat");
    System.out.println("Omkretsen er: "+omkrets);
    System.out.println("arelaet er: "+areal);
  }
}
