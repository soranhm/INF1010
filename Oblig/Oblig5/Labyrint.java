import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Labyrint {
    public Rute[][] rute;
    private int kol;
    private int rad;
    public Liste<String> list;


    public Labyrint(int kol,int rad, Rute[][] rute){
      this.rad = rad;
      this.kol = kol;
      this.rute = rute;
    }

    public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
    Scanner innFil = new Scanner(fil);
    String[] ord = innFil.nextLine().split(" ");
    int rad = Integer.parseInt(ord[0]);
    int kol = Integer.parseInt(ord[1]);
    Rute[][] nyR = new Rute[rad][kol];
    int x = 0;

    while(innFil.hasNext()){
        String linje =  innFil.nextLine();
        char[] ks = linje.toCharArray();

        for (int y = 0; y < ks.length ;y++ ) { // setter tegnene til objekter
          if(ks[y] == '#'){
            nyR[x][y] = new SortRute(x,y);
          }

          else if(ks[y] == '.') {
            if(x == 0 || y == 0 || y == kol-1 || x == rad-1){
              nyR[x][y] = new Aapning(x,y);
            }
            else{
              nyR[x][y] = new HvitRute(x,y);
            }
          }
        }
        x++; // oker rad
    }

    Labyrint lab = new Labyrint(kol,rad,nyR);

    for(int i = 0; i < nyR.length; i++) { // setter nord,sor,vest og ost pekere
        for(int j = 0; j < nyR[0].length; j++) {
          if(i >= 1){
            lab.rute[i][j].nord = lab.rute[i-1][j];
          }
          if (i < rad-1) {
            lab.rute[i][j].sor = lab.rute[i+1][j];
          }
          if(j >= 1){
            lab.rute[i][j].vest = lab.rute[i][j-1];
          }
          if (j < kol-1) {
            lab.rute[i][j].ost = lab.rute[i][j+1];
          }
          lab.rute[i][j].setLab(lab);
        }
    }
    System.out.println(lab); // skriver ut labyrinten
    return lab;
    }

    public Liste<String> finnUtveiFra(int rad, int kol){
      list = new Koe<String>();
      rute[rad-1][kol-1].finnUtvei();
      for(int i = 0; i<rute.length; i++){
          for(int j = 0; j<rute[0].length; j++){
              rute[i][j].tatt = false;
          }
      }
      return list;
    }

    @Override
    public String toString(){
    String string = "";
    for(int x=0; x<rute.length; x++){
        for(int y=0; y<rute[0].length; y++){
            string += rute[x][y].tilTegn();
        }
        string += "\n";
    }
    return string;
    }
}
