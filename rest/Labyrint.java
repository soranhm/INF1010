import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint{
private int kol;
private int rad;
public Rute[][] rute;
public static int antRuter = 0;

private Labyrint(int kol, int rad, Rute[][] rute){
    this.kol = kol;
    this.rad = rad;
    this.rute = rute;
}

public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
    Scanner innFil = new Scanner(fil);
    String[] ord = innFil.nextLine().split(" ");
    int rad = Integer.parseInt(ord[0]);
    int kol = Integer.parseInt(ord[1]);
    int r = 0;
    Rute[][] nyR = new Rute[rad][kol];
    //System.out.println("rad" + rad);
    //System.out.println("kol" + kol);

    while(innFil.hasNext()){
        String linje =  innFil.nextLine();
        char[] karSplit = linje.toCharArray();

        for(int k = 0; k < karSplit.length; k++){

            if(karSplit[k] == '#'){

                nyR[r][k] = new SortRute(r,k);

                //System.out.println(nyR[r][k].tilTegn());
            } else if(karSplit[k] == '.'){
                if(r == 0 || k == 0 || r == rad-1 || k == kol-1){
                    nyR[r][k] = new Aapning(r,k);
                    //System.out.print("-");
                }
                else{
                    nyR[r][k] = new HvitRute(r,k);
                    //System.out.print(".");
                }
            }
        }
        r++;
        //System.out.println();
    }
    Labyrint lab = new Labyrint(kol, rad, nyR);
    //System.out.println("    ");
    //System.out.println(lab);

    for(int i=0; i<nyR.length; i++){
        for(int j=0; j<nyR[0].length; j++){
            if(i >=1){
                lab.rute[i][j].nord = lab.rute[i-1][j];
            }
            if(i <  rad-1){
                lab.rute[i][j].syd = lab.rute[i+1][j];
            }
            if(j >= 1){
                lab.rute[i][j].vest = lab.rute[i][j-1];
            }
            if(j < kol-1){
                lab.rute[i][j].oest = lab.rute[i][j+1];
            }
            lab.rute[i][j].setLab(lab);
            }
        }
        System.out.println(lab);
    return lab;
}
Liste<String> list = new Koe<String>();

public Liste<String> finnUtveiFra(int rad, int kol){
    rute[rad][kol].finnUtvei();
    for(int i = 0; i<rute.length; i++){
        for(int j = 0; j<rute[0].length; j++){
            rute[i][j].gaatt = false;
        }
    }
    return list;
}

@Override
public String toString(){
    String string = "";
    for(int rad=0; rad<rute.length; rad++){
        for(int kol=0; kol<rute[0].length; kol++){
            string += rute[rad][kol].tilTegn();
        }
        string += "\n";
    }
    return string;
}
}
