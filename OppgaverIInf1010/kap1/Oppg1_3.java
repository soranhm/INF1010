class Oppg1_3 {
  public static void main(String[] args) {
    Kvadrat kvadrat = new Kvadrat(2.2);
    Sirkel sirkel = new Sirkel(2.2);

    kvadrat.omkrets();
    kvadrat.areal();
    sirkel.omkrets();
    sirkel.areal();
    kvadrat.skrivUt();
    sirkel.skrivUt();
  }
}
