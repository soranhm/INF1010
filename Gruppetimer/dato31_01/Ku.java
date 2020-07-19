class Ku extends Dyr {

  Ku(String navn,int vekt) {
    super(navn,vekt);

  }

  public void lagLyd(){
    System.out.println(navn + ": \"moooo\"");
  }
    
  public String toString(){
    return navn;
  }
}
