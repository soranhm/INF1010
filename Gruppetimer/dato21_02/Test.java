class Test{
  public static void main(String[] args){
    Person p1 = new Person("Martin",25);
    Person p2 = new Person("Martin",27);
    
    Beholder<Person> b = new Beholder<Person>(p1,p2);
    b.skrivUtSortert();

  }
}
