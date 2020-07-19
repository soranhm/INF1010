import java.util.Iterator;
import java.util.NoSuchElementException;

// Superklassen/ Stabel, brukte den som super pga har basic settInn() og fjern()
// LIFO
public class Stabel<T> implements Liste<T> {
  protected Node foran = null;
  protected int antall = 0;

  public int storrelse(){
    return antall;
  }

  public boolean erTom(){
    return foran == null;
  }

  public void settInn(T element){
    antall++;                         //oker antallet nar setter in
    Node nyNode = new Node(element);  //lager ny node og setter inn elementet
    nyNode.neste = foran;             //nyNode sin neste peker paa det foran peker paa( ellers mister forrige nodene)
    foran = nyNode;                   //2 peker pa null , her oppdaterers node
  }

  // fjerner siste jeg setter inn
  public T fjern(){
    if(foran ==null) return null;
    T p = foran.data;
    foran = foran.neste;
    antall--;
    return p;
  }

  protected class Node {
      T data;
      Node neste;

      public Node(T data){
          this.data = data;
      }
  }

  //Iterator delen
  /*
  iterer gjennom og husker plassering paa elementene
  */
  public Iterator<T> iterator(){
		return new MinIterator();
	}

  private class MinIterator implements Iterator<T>{
    Node current = foran;

    public T next() throws NoSuchElementException{
      if(!hasNext()) throw new NoSuchElementException();
      T tmp = current.data;
      current = current.neste;
      return tmp;
    }

    public boolean hasNext(){
        return current != null;
    }
    public void remove(){
    }


  }

}
