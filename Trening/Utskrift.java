class Utskrift {
  public static void main(String[] args) {
    String enTekst = "Skriver ut en teskt";
    int tall1 = 2;
    int tall2 = 5;

    utskrift(enTekst); utskrift(tall1); utskrift(tall1,tall2);
  }
    // A) skriver ut teskten i terminal
    public static void utskrift(String tekst) {
      System.out.println("Tekst: " + tekst);
    }

    public static void utskrift(int tall) { // Tar forste tallet
      System.out.println("Tall: " + tall);
    }

    public static void utskrift(int tall1, int tall2) {
      System.out.println("Sum av tallene: "+(tall1+tall2));
    }

}
