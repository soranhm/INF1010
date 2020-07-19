import java.util.ArrayList;

abstract class Rute{

protected Labyrint lab;
protected HvitRute hr;
protected SortRute sr;
protected Aapning aa;
protected int rad;
protected int kol;
protected Rute nord;
protected Rute syd;
protected Rute vest;
protected Rute oest;


public Rute( int rad, int kol){
    this.rad = rad;
    this.kol = kol;
}

public void setLab(Labyrint lab){
    this.lab = lab;
}

public boolean gaatt = false;

public void gaa(int rad, int kol, String vei){
    //System.out.println("er her: " + lab.rute[rad][kol]);
    //System.out.println("Ruten har tegn " + lab.rute[rad][kol].tilTegn());

    if(gaatt == true) return;
    gaatt = true;
        if(this instanceof Aapning){
            lab.list.settInn(vei);
        }
        String vei1;
        if(this instanceof SortRute) return;
        if(nord instanceof HvitRute) {
            //nord.gaatt = true;
            vei1 = vei;
            vei += "->" + "("+nord.rad+","+nord.kol+")";
            nord.gaa(rad-1, kol, vei);
            vei = vei1;
            //nord.this.gaatt = false;

        }
        if(syd instanceof HvitRute) {
            //syd.gaatt = true;
            vei1 = vei;
            vei += "->" + "("+syd.rad+","+syd.kol+")";
            //System.out.println("er her: " + lab.rute[rad][kol]);
            syd.gaa(rad+1, kol, vei);
            vei = vei1;
            //this.gaatt = false;
        }
        if(vest instanceof HvitRute) {
            //System.out.println("RUten til vest var " + vest);
            //vest.gaatt = true;
            vei1 = vei;
            vei += "->" + "("+vest.rad+","+vest.kol+")";
            //System.out.println("er her: " + lab.rute[rad][kol]);
            vest.gaa(rad, kol-1,vei);
            vei = vei1;
            //this.gaatt = false;
        }

        if(oest instanceof HvitRute) {
            //oest.gaatt = true;
            vei1 = vei;
            vei += "->" + "("+oest.rad+","+oest.kol+")";
            //System.out.println("er her: " + lab.rute[rad][kol]);
            oest.gaa(rad, kol+1, vei);
            vei = vei1;
            //this.gaatt = false;
        }


}

public void finnUtvei(){
    gaa(rad,kol, "("+rad+","+kol+")");
}

abstract char tilTegn();

}
