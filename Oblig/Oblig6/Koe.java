//FIFO
public class Koe<T> extends Stabel<T> {
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
