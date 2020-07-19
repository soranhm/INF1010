import java.util.Scanner;

class Differanse {
  public static void main(String[] args) {
    // Lager scanner som leser inn fra tastatur
    Scanner tastatur = new Scanner(System.in);

    // Velger variablenen
    String lest;
    int x;
    int y;
    int z;

    System.out.println("Oppgi verdien til x: ");
    lest = tastatur.nextLine(); // Oppdaterer verdien til lest
    x = Integer.parseInt(lest); // gjor om til int

    System.out.println("Oppgi verdien til y: ");
    lest = tastatur.nextLine(); // Oppdaterer verdien til lest
    y = Integer.parseInt(lest); // gjor om til int


    System.out.println("Differasen mellom x og y er :" + (x-y) );
    // tar absoluttverdien til tallet hvis den er negativ
    z = x - y;
    if (z<0) {
      z = z*-1;
      System.out.println("Absoluttverdien av differansen er : " + z);
    }


  }
}
