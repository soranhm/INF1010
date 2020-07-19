class Plenum {
  public static void main(String[] args) {
    Katt pus = new Katt("Pus",1);
    System.out.println(pus.getInfo());

    Hund bjarte = new Hund("Bjarte",2);
    System.out.println(bjarte.getInfo());
    bjarte.bjeff();

  }
}
