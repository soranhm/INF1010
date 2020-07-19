import java.util.Scanner;

class Handletur {
  public static void main(String[] args) {
    Scanner tastatur = new Scanner(System.in);

    System.out.println("Hvor mange brød vil du ha?");
    int brod = Integer.parseInt(tastatur.nextLine());

    System.out.println("Hvor mange melk vil du ha?");
    int melk = Integer.parseInt(tastatur.nextLine());

    System.out.println("Hvor mange ost vil du ha?");
    int ost = Integer.parseInt(tastatur.nextLine());

    System.out.println("Hvor mange youghurt vil du ha?");
    int youghurt = Integer.parseInt(tastatur.nextLine());

    System.out.println("Du skal betale: "+(brod*20+melk*15+ost*40+youghurt*12)+" kr");
  }
}
