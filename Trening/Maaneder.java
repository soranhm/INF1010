import java.util.Scanner;

class Maaneder {
  public static void main(String[] args) {
    String[] maaneder = {"januar", "februar", "mars", "april", "mai", "juni",
    "juli", "august", "september", "oktober", "november", "desember"};

    Scanner tastatur = new Scanner(System.in);
    System.out.println("Tast inn maanedsnummer:");

    String linje = tastatur.nextLine();
    int tall = Integer.parseInt(linje);

    if (tall>0 && tall<13) {
      System.out.println(tall + " - " + maaneder[tall-1]);
    }
    else {
      System.out.println(tall + " er Ugyldig, velg et tall mellom 1-12!");
    }
  }
}
