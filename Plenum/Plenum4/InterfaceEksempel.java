public class InterfaceEksempel {
  public static void main(String[] args) {
    Sil sil = new Sil();

    sil.settInn(new Hund("Passopp", 7));
    sil.settInn(new Hund("Pernille", 5));
    sil.settInn(new Hund("Fritjolf", 12));
    sil.settInn(new Katt("Mathias", 10));
    sil.settInn(new Katt("Mathias", 12));
    sil.settInn(new Katt("Geir", 3));

    sil.settInn(new Bil("Ford Mondeo",80));
    System.out.println(sil);
  }
}
