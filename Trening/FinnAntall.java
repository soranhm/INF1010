class FinnAntall {
  public static void main(String[] args) {
    String[] stasjoner = {"blindern", "Bislett", "Forskningsparken",
    "JERNBANETORGET", "toyen", "Jernbanetorget","forskningsparken"};
    antallForekomster("toyen",stasjoner);
    antallForekomster("Jernbanetorget", stasjoner);
  }
    static void antallForekomster(String tekst, String [] array) {
      int antallForekomst = 0;
      for (int i = 0; i < array.length; i++) {
        if (array[i].equalsIgnoreCase(tekst)){
          antallForekomst++;
        }
      }
      System.out.println(tekst + " forekommer " + antallForekomst + " ganger");
    }
}
