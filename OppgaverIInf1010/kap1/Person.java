class Person {
  private String navn;
  private Hus  hus;

  public Person(String n) {
    navn = n;
    System.out.println("navnet er:"+n);
  }

  public void skrivUt(){
    System.out.println(navn);
  }

  public void setHus(Hus h){
    hus = h;
    System.out.println("huset er:"+h);

  }

}
