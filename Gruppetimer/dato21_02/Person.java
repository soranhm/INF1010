class Person implements Comparable<Person>{
  private int alder;
  private String navn;
  Person(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
    }

  public String getNavn(){
      return navn;
    }
  public String toString(){

      return navn + "," +alder;
    }

    public int getAlder(){
      return alder;
    }
  public int compareTo(Person p){

    if(navn.compareTo(p.getNavn()) == 0){
      return alder - p.getAlder();
    }

    return navn.compareTo(p.getNavn());
    }


}
