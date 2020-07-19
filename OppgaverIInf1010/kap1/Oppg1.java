class Oppg1 {
  public static void main(String[] args) {
    Person soran = new Person("Soran");
    Hus hus1 = new Hus();

    soran.setHus(hus1);
    hus1.setEier(soran);
    soran.skrivUt();
  }
}
