import java.util.Scanner;

class StringArray {
  public static void main(String[] args) {
    String[] array = new String[5];
    Scanner tastatur = new Scanner(System.in);
    int lengdePaArray  = array.length;
    int teller = 0;
    System.out.println("Skriv in fem ord: ");
    while (teller<lengdePaArray) {
      array[teller] = tastatur.nextLine();
      teller++;
    }
    teller = 0;
    System.out.println("Utskrift fra array:");
    while (teller<lengdePaArray) {
      System.out.println("array["+teller+"] = " + array[teller]);
      teller++;
    }
  }
}
