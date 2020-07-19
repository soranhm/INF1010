class Heltallsarray {
  public static void main(String[] args) {
    // A)-B) lag fem variabler med 0,1,2,3,4 og skriv de ut
    int tall1 = 0; int tall2 = 1; int tall3 = 2; int tall4 = 3; int tall5 = 4;
    System.out.println("Utskrift av variable:");
    System.out.println("tall1 = " + tall1);
    System.out.println("tall2 = " + tall2);
    System.out.println("tall3 = " + tall3);
    System.out.println("tall4 = " + tall4);
    System.out.println("tall5 = " + tall5);

    /* C)-E) lag arry som kan innholde 5 tall, legg verdiene inn ved hjelp av Lokker
    skriv utut ved hjelp av lokke*/
    int[] array = new int[5];
    System.out.println("Utskrift av array");

    for (int i= 0 ; i<=4; i++) {
      array[i] += i;                  // Lager array
    }

    for (int i= 0 ; i<=4; i++) {
      System.out.println("array["+ i+ "] = "+ array[i]);
    }
    System.out.println(array[0]);
  }
}
