class Test2 {
  public static void main(String[] args){
    /*
    LinkedList<Person> ll = new LinkedList<>();
    ll.settInn(new Person("A",12));
    ll.settInn(new Person("B",12));
    ll.settInn(new Person("C",12));
    ll.settInn(new Person("D",12));
    */
    LinkedList<String> ll = new LinkedList<>();
    ll.settInn("A");
    ll.settInn("B");
    ll.settInn("C");
    ll.settInn("D");

    ll. skrivUt();
    System.out.println();
    // Snu rekkefolgen
    LinkedList<String> l2 = new LinkedList<>();
    while(!ll.erTom()){
      l2.settInn(ll.taUt());
    }
    l2.skrivUt();

  }
}
