import java.util.NoSuchElementException;
class GameList<E> implements Maneuverable<E>{
/*
Dette er en del av et stort programm om sjakk, derfor
ikke fullfort!
*/
  private Node head;
  private Node tail;

  GameList(E[] eArray){
    for(E e: eArray) add(e);
  }

  public boolean isEmpty(){
    return head == null;
  }

  private void add(E e){
    Node n = new Node(e);
    if(isEmpty()) head = tail = n;
    else {
      tail.next = n;
      n.previous = tail;
      tail = n;
    }
  }

  public ListReader<E> listReader(){
    return new HiddenListReader();
  }

  private class HiddenListReader implements ListReader<E>{
    private Node showing = head;
    private boolean first = true;

    public boolean hasNext(){
      return !isEmpty() && showing.next != null;
    }
    public boolean hasPrevious(){
      return !isEmpty() && showing.previous != null;
    }
    public E next() throws NoSuchElementException{
      if(!hasNext()) throw new NoSuchElementException();
      if(first) first = false;
      else showing = showing.next;
      return showing.data;
    }

    public E previous() throws NoSuchElementException{
      if(!hasPrevious()) throw new NoSuchElementException();
      showing = showing.previous;
      return showing.data;
    }
  }

  private class Node{
    Node next;
    Node previous;
    E data;

    Node(E e){
      data = e;
    }
  }
}
