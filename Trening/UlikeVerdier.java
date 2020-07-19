import java.util.Scanner;

class UlikeVerdier {
  public static void main(String[] args) {
    Scanner tastatur = new Scanner(System.in);

    System.out.println("Velg i:");
    int i = Integer.parseInt(tastatur.nextLine());
    System.out.println("Velg j:");
    int j = Integer.parseInt(tastatur.nextLine());

    if (i != j) {
      System.out.println("i og j har ulike verdier");
    }

    else {
      System.out.println("i og j har ikke like verider");
    }
  }
}
