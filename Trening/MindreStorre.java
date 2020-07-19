import java.util.Scanner;

class MindreStorre {
  public static void main(String[] args) {
    Scanner tastatur = new Scanner(System.in);

    System.out.println("Tast inn et tall:");
    int a = Integer.parseInt(tastatur.nextLine());

    if (a>10 && a<20) {
      System.out.println("Tallet er mellom 10 og 20");
    }
    else if (a<10) {
      System.out.println("Tallet er under 10");
    }
    else {
      System.out.println("Tallet er over 20");
    }
  }
}
