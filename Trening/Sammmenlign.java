import java.util.Scanner;

class Sammmenlign {
  public static void main(String[] args) {
    // Lager scanner som leser inn fra tastatur
    Scanner tastatur = new Scanner(System.in);

    // Velger variablenen
    String lest;
    int a;
    int b;

    System.out.println("Oppgi verdien til a: ");
    lest = tastatur.nextLine(); // Oppdaterer verdien til lest
    a = Integer.parseInt(lest); // gjor om til int

    System.out.println("Oppgi verdien til b: ");
    lest = tastatur.nextLine(); // Oppdaterer verdien til lest
    b = Integer.parseInt(lest); // gjor om til int

    if (a>b) {
      System.out.println("a er større enn b");
    }

    else if (a==b) {
      System.out.println("a er lik b");

    }

    else {
      System.out.println("a er ikk større enn b");

    }

  }
}
