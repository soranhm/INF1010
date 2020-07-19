// Klasse KoSystem
import java.util.ArrayList;

public class KoSystem{

    ArrayList<KoLapp> koLapper = new ArrayList<>();
    int teller = 0;

    /**
     * Lager et nytt objekt av KoLapp, printer ut
     * informasjon om den og legger den til i listen
     * over koLapper.
     */
    public void trekkKoLapp(){
        teller ++;
        KoLapp nyLapp = new KoLapp(teller);
        koLapper.add(nyLapp);

        System.out.print("Du har fatt tildelt billettnr ");
        System.out.println(nyLapp.getNummer() + ".");
        System.out.println("Det staar "+(koLapper.size()-1) +" foran deg.\n");
    }

    /**
     * Henter ut, printer ut informasjon og fjerner den
     * forste kolappen i lista. Gir feilmelding dersom
     * ingen kunder staar i ko.
     */
    public void betjenKunde(){
        if(koLapper.isEmpty()){
            System.out.println("ingen er i ko");
        } else {
            KoLapp betjenes = koLapper.remove(0);
            System.out.print("Kunde med billettnr: ");
            System.out.println(betjenes.getNummer() + " er betjent.\n");
        }

    }

    /**
     * Returnerer antall kunder som er i ko.
     */
    public int antKunder(){
        return koLapper.size();
    }

    /**
     * Printer alle kunder i ko
     */
    public void printKunderIKo(){
        System.out.println("Disse er i ko: ");

        // printer ved hjelp av en for-each-løkke
        for(KoLapp koLapp : koLapper){
            System.out.print("nr." + koLapp.getNummer() + ", ");
        }
        System.out.println("\n\n");
    }
}
