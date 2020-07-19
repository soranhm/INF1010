import java.util.Scanner;

class Produkt {
  public static void main(String[] args) {
    // A) produktet mellom x og y
    // lager Scanner som leser inn fra tastatur
    Scanner tastatur = new Scanner(System.in);
    // lager variablenen
    int x;
    int y;

    System.out.println("Oppgi verdien til x: ");
    x = Integer.parseInt(tastatur.nextLine());

    System.out.println("Oppgi verdien til y: ");
    y = Integer.parseInt(tastatur.nextLine());

    System.out.println("produktet av x(" +x+ ") og y(" +y+") er: "+ (x+y));

    // B) sjekker om differeansen er negativ eller postiv
    int z = x-y;
    if (z > 0) {
      System.out.println("Differansen mellom tallene er positiv");
    }
    else if (z == 0) {
      System.out.println("Differansen mellom tallene er 0");

    }
    else {
      System.out.println("Differansen mellom tallene er negativ");
    }

  }
}
