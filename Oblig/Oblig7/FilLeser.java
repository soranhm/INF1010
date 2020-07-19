import java.io.File;
import java.io.FileNotFoundException;

public class FilLeser{


    public static Labyrint lesFil(String filnavn){

        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }
        return l;
    }
}
