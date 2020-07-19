class Sirkel {
  private double radius;
  private double omkrets;
  private double areal;

  public Sirkel(double r){
    radius = r;
  }

  public void omkrets(){
    omkrets = 2*Math.PI*radius;
  }

  public void areal(){
    areal = Math.PI*radius*radius;
  }

  public void skrivUt(){
    System.out.println("Sirkel");
    System.out.println("Omkretsen er: "+omkrets);
    System.out.println("arelaet er: "+areal);
  }
}
