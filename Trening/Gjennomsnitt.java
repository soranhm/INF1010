import java.util.Scanner;

class Gjennomsnitt {
  public static void main(String[] args) {
    int[] tall = {1,4,2,7,9,10};
    double sum1 = 0;
    for (int i =0; i < tall.length;i++) {
      sum1 += tall[i];
    }
    System.out.println("Summen er: " +sum1);
    double gjennomsnitt = ((sum1)/tall.length);
    System.out.println("Gjennomssnittet er: "+ gjennomsnitt);

    int[] innlesteTall = new int[5];
    Scanner tastatur = new Scanner(System.in);
    System.out.println("Skriv in 5 tall: ");

    for (int i = 0; i < innlesteTall.length;i++) {
      innlesteTall[i] = tastatur.nextInt();
    }

    sum1 = 0;
    gjennomsnitt = 0;

    for (int i =0; i < innlesteTall.length;i++) {
      sum1 += innlesteTall[i];
    }
    System.out.println("summen er: " +sum1);
    gjennomsnitt = ((sum1)/innlesteTall.length);
    System.out.println("Gjennomssnittet er: "+ gjennomsnitt);

  }
}
