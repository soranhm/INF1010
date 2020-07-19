import java.util.Scanner;

class SkattRuritania {
  public static void main(String[] args) {
    Scanner tastatur = new Scanner(System.in);

    double inntekt;

    System.out.println("Skriv inn inntekten din:");
    inntekt = Double.parseDouble(tastatur.nextLine());

    if (inntekt < 10000) {
      System.out.println("Du betaler: " + (inntekt/100 * 10) +"kr i skatt ");
    }

    else {
      System.out.println("Du betaler: "+(1000+(inntekt-10000)/100 *30)+" kr i skatt");
    }
  }
}
