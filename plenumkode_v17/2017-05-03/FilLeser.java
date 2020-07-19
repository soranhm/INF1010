/**
 * Denne klassen er en eksempelklasse for aa vise hvordan
 * vi kan kombinere eksisterende klasser med JavaFX. Klassen
 * i seg selv var ikke tema i plenumstimen.
 */

import java.util.*;
import java.io.*;

public class FilLeser {
    /**
     * @Param  filnavn som skal leses inn med ett tall per linje
     *
     * @Return En ArrayList der hver linje i inn-filen er et heltall
     */
    public static ArrayList<Integer> lesFil(String filnavn) {
        ArrayList<Integer> listen = new ArrayList<Integer>();

        try {
            Scanner scanner = new Scanner(new File(filnavn));

            while (scanner.hasNextLine()) {
                int tall = Integer.parseInt(scanner.nextLine());
                listen.add(tall);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Fant ikke fil " + filnavn);
        }
        return listen;
    }
}
