class LinkedList<E> {

  private Node head;
  private int size = 0;
  //ertom     isEmpty
  public boolean erTom() {
    return head == null;
  }

  //tit       peek
  public E tit(){
    if (head == null) return null;
    return head.data;
  }

  //settInn   push
  public void settInn(E p){
    Node n = new Node(p);
    size++;

    n.neste = head;
    head = n;
  }

  //taUt      pop
  public E taUt() {
    if(head ==null) return null;

    E p = head.data;
    head = head.neste;
    size--;
    return p;
  }

  public void skrivUt(){
    // for(<D>,<T>)
    for (Node n = head; n != null; n= n.neste){
      System.out.println(n.data);
    }
  }

  class Node{
    Node neste;
    E data;

    Node(E p){
      data = p;
    }

  }

}
