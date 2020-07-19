import java.util.Scanner;

class IO {
    private static Scanner inn = new Scanner(System.in);
    public static int intFraBruker(String melding) {
        boolean suksess = false;
        int tallet = 0;
        while (!suksess) {
            System.out.print(melding);
            String linje = inn.nextLine();
            try {
                tallet = Integer.parseInt(linje);
                return tallet;
            } catch (NumberFormatException e) {
                System.out.printf("'%s' er ikke et heltall, din løk!\n",
                                  linje);
            }
        }
        return tallet;
    }

    public static int intFraBrukerFomTom(String melding, int fom, int tom) {
        boolean suksess = false;
        int tallet = 0;
        while (!suksess) {
            tallet = intFraBruker(melding);
            if (tallet < fom || tom < tallet) {
                System.out.printf("%d ligger ikke i intervallet [%d, %d]!\n",
                                  tallet, fom, tom);
            } else {
                suksess = true;
            }
        }
        return tallet;
    }


    public static String ikketomStringFraBruker(String melding) {
        boolean suksess = false;
        String linjen = null;
        while (!suksess) {
            System.out.print(melding);
            linjen = inn.nextLine();
            if (linjen.equals("")) {
                System.out.println("Oppgi minst ett tegn!");
            } else {
                suksess = true;
            }
        }
        return linjen;
    }
}
