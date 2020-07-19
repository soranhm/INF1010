class Spiller {
  private String navn;
  private ArrayList<Kort> hand;

  public Spiller(String n){
    navn = n;
  }
  
  public String toString() {
    String string = navn + "\nKort: ";
    for (Kort k : hand) {
        string += k + " ";
    }
    return string;
  }
}
