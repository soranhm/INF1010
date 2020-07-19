import krypto.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

class Operasjonsleder implements Runnable{

    private Monitor mm;
    private Melding o;
    //Stabel<String> opmelding = new Stabel<String>();
    OrdnetLenkeliste<Melding> mel1 = new OrdnetLenkeliste<Melding>();
    OrdnetLenkeliste<Melding> mel2 = new OrdnetLenkeliste<Melding>();
    OrdnetLenkeliste<Melding> mel3 = new OrdnetLenkeliste<Melding>();

    public Operasjonsleder(Monitor mm){
        this.mm = mm;
    }

    public void run(){
        /*try{
            Thread.sleep(20000);
        }
        catch(InterruptedException e){}*/
        settInn();
        skrivTilFil();

        System.out.println("ferdig i run");
        mm.ferdigK();
    }

    public void settInn(){
        o = mm.hent();
        while(o != null){
            if(o.getId() == 1){
                mel1.settInn(o);
                //mel1.settInn(new Melding(o.getMelding(), o.getSekvensnummer(), o.getId()));
            }
            else if(o.getId() == 2){
                mel2.settInn(o);
                //mel2.settInn(new Melding(o.getMelding(), o.getSekvensnummer(), o.getId()));
            }
            else{
                mel3.settInn(o);
                //mel3.settInn(new Melding(o.getMelding(), o.getSekvensnummer(), o.getId()));
            }
            o = mm.hent();
        }
    }


    public void skrivTilFil(){
        File utfil = new File("TekstOblig6");
        PrintWriter skrivTil = null;
        try{
            skrivTil = new PrintWriter(utfil, "utf-8");
        }
        catch(IOException ioe){
            System.out.println("noe feil skjedde");
        }
        for(Melding s : mel1){
            skrivTil.println(s.getMelding());
            skrivTil.println("\n" + "\n");
        }
        for(Melding s : mel2){
            skrivTil.println(s.getMelding());
            skrivTil.println("\n" + "\n");

        }
        for(Melding s : mel3){
            skrivTil.println(s.getMelding());
            skrivTil.println("\n" + "\n");
        }
        skrivTil.close();
    }

}
//Når alle telegrafistene og kryptografene er ferdige, skal operasjonslederen skrive meldingene til fil,
//med én fil for hver kanal. Hver melding skal være adskilt av to linjeskift. Pass på at meldingene kommer i riktig rekkefølge!
