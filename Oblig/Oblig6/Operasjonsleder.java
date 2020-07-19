import krypto.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

class Operasjonsleder implements Runnable{

    private Monitor m;
    private Melding o;
    OrdnetLenkeliste<Melding> mel1 = new OrdnetLenkeliste<Melding>();
    OrdnetLenkeliste<Melding> mel2 = new OrdnetLenkeliste<Melding>();
    OrdnetLenkeliste<Melding> mel3 = new OrdnetLenkeliste<Melding>();

    public Operasjonsleder(Monitor m){
        this.m = m;
    }

    public void run(){
        try{
            Thread.sleep(20000);
        }
        catch(InterruptedException e){}
        settInn();
        skrivTilFil();

        System.out.println("ferdig i run");
        m.ferdigK();
    }

    public void settInn(){            // setter inn i riktig rekkefolge
        o = m.hent();
        while(o != null){
            if(o.getId() == 1){
                mel1.settInn(o);
            }
            else if(o.getId() == 2){
                mel2.settInn(o);
            }
            else{
                mel3.settInn(o);
            }
            o = m.hent();
        }
    }


    public void skrivTilFil(){
        File utfil = new File("UTFIL");
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
