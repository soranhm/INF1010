import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Oblig2 {
  public static void main(String[] args){
    ArrayList<Bil> bil = new ArrayList<Bil>();
    El el;
    Personbiler pb;
    Lastebiler lb;

    try{// starter try blokken
    //hvis brukeren oppgir 1 args
    if(args.length == 1) {
      String filNavn = args[0];
      Scanner fil = new Scanner(new File(filNavn));
      // lager en while lokke som kjorer for hvert linje i tekstfilen
      while(fil.hasNext()){
        String[] split = fil.nextLine().split(" ");
        String type = split[0];
        String skilt = split[1];
        // leser fra fil og setter inn i arraylist
        if(type.equalsIgnoreCase("EL")){
          Double batteri = Double.parseDouble(split[2]);
          el = new El(skilt,batteri);
          bil.add(el);
        }

        else if(type.equalsIgnoreCase("PERSONBIL")){
          Double utslipp = Double.parseDouble(split[2]);
          int seter = Integer.parseInt(split[3]);
          pb = new Personbiler(skilt,utslipp,seter);
          bil.add(pb);
        }

        else if(type.equalsIgnoreCase("LASTEBIL")){
          Double utslipp = Double.parseDouble(split[2]);
          Double nyttevekt = Double.parseDouble(split[3]);
          lb = new Lastebiler(skilt,utslipp,nyttevekt);
          bil.add(lb);
        }
      }
    }
    // Hvis brukeren oppgir 2 args
    else if(args.length == 2) {
      String filNavn = args[0];
      String typeTo = args[1];
      Scanner fil = new Scanner(new File(filNavn));
      // lager en while lokke som kjorer for hvert linje i tekstfilen
      while(fil.hasNext()){
        String[] split = fil.nextLine().split(" ");
        String type = split[0];
        String skilt = split[1];

          // hvis args 2 er lik el kjorer dette
          if(typeTo.equalsIgnoreCase("EL")){
            if(type.equalsIgnoreCase("EL")){
              Double batteri = Double.parseDouble(split[2]);
              el = new El(skilt,batteri);
              bil.add(el);
            }
          }
          // hvis args 2 er lik fossil kjorer dette
          else if (typeTo.equalsIgnoreCase("FOSSIL")){
             if(type.equalsIgnoreCase("PERSONBIL")){
               Double utslipp = Double.parseDouble(split[2]);
               int seter = Integer.parseInt(split[3]);
               pb = new Personbiler(skilt,utslipp,seter);
               bil.add(pb);
             }

             else if(type.equalsIgnoreCase("LASTEBIL")){
               Double utslipp = Double.parseDouble(split[2]);
               Double nyttevekt = Double.parseDouble(split[3]);
               lb = new Lastebiler(skilt,utslipp,nyttevekt);
               bil.add(lb);
             }
          }
          // hvis brukeren oppgir feil Bil
          else {
            System.out.println(((char)27) + "[31m"+((char)27)+"[4m" + typeTo
            + (char)27 + "[0m" + ": finnes ikke, skrive el eller fossil" );
            return;
          }
      }
    }
    // Hvis brukeren ikke oppgir noen args
    else{System.out.println(((char)27)+ "[36mOppgi tekstfil navnet etter filnavnet i argumentet"+ (char)27 + "[0m");}

  }//Slutter try blokken

    catch(FileNotFoundException e){
      System.out.println("Finner ikke filen: " + args[0]);
    }

    // Gaar gjnnom arraylisten
    for (Bil e: bil){

      if(e instanceof El){
        System.out.println("\n");
        System.out.println("Type motorvogn: "+ ((El)e).hentNavn());
        System.out.println("regnr:   " + e.hentSkilt());
        System.out.println("Batteri: " + ((El)e).hentBatteri());
      }
      else if(e instanceof Personbiler){
        System.out.println("\n");
        System.out.println("Type motorvogn: "+((Personbiler)e).hentNavn());
        System.out.println("regnr:   " + ((Personbiler)e).hentSkilt());
        System.out.println("Utslipp: " + ((Personbiler)e).hentUtslipp());
        System.out.println("seter:   " + ((Personbiler)e).hentSeter());
      }
      else if(e instanceof Lastebiler){
        System.out.println("\n");
        System.out.println("Type motorvogn: "+((Lastebiler)e).hentNavn());
        System.out.println("regnr:     " + ((Lastebiler)e).hentSkilt());
        System.out.println("Utslipp:   " + ((Lastebiler)e).hentUtslipp());
        System.out.println("nyttevekt: " + ((Lastebiler)e).hentNyttevekt());
      }
    }
  }
}
