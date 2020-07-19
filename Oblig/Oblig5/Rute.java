abstract class Rute{

  protected int rad; protected int kol;
  protected Labyrint lab;
  protected SortRute sr;
  protected HvitRute hr;
  protected Aapning ap;
  protected Rute nord; protected Rute sor; protected Rute ost; protected Rute vest;
  protected boolean tatt = false;


  public Rute(int rad, int kol){
    this.kol = kol+1;
    this.rad = rad+1;
  }

  public void setLab(Labyrint lab){this.lab = lab;}

  public void gaa(int rad,int kol,String vei){
      if(tatt == true) return;
      tatt = true;

      if(this instanceof Aapning){
        lab.list.settInn(vei);
        return;
      }

      if(this instanceof SortRute){ System.out.println("starter pa svart rute");return ;}

      String vei1;

      if(nord instanceof HvitRute){
        vei1 = vei;
        vei += "-->" + "("+nord.kol+","+nord.rad+")";
        nord.gaa(rad-1, kol, vei);
        vei = vei1;
      }

      if(sor instanceof HvitRute){
        vei1 = vei;
        vei += "-->" + "("+sor.kol+","+sor.rad+")";
        sor.gaa(rad+1, kol, vei);
        vei = vei1;
      }

      if(vest instanceof HvitRute){
        vei1 = vei;
        vei += "-->" + "("+vest.kol+","+vest.rad+")";
        vest.gaa(rad, kol-1,vei);
        vei = vei1;
      }

      if(ost instanceof HvitRute){
        vei1 = vei;
        vei += "-->" + "("+ost.kol+","+ost.rad+")";
        ost.gaa(rad, kol+1, vei);
        vei = vei1;
      }
  }

  public void finnUtvei(){ gaa(rad,kol,"("+kol+","+rad+")");}

  abstract char tilTegn();

}
