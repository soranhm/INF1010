//FIFO
public class Koe<T> extends Stabel<T> {
  /*
  settInn(T element) skal sette inn element på den ene siden av listen,
  og fjern() skal ta ut et element fra den andre siden av listen.
  */
  @Override
  public void settInn(T elem) {
    antall++;
    if( foran == null){
      foran = new Node(elem);
    }
    else{
      Node tmp = foran;
      while ( tmp.neste != null){
        tmp = tmp.neste;
      }
      tmp.neste = new Node(elem);
    }
  }
  
}
