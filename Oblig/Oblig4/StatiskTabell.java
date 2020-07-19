import java.util.Iterator;

public class StatiskTabell<T> implements Tabell<T>{
    T[] tabell ;
    private int l ;
    private int teller = 0;
    private T rangeStart;
    private T rangeEnd;

    @SuppressWarnings("unchecked")
    public StatiskTabell(int l) {
      this.l = l;
      tabell = (T[]) new Object[l];
    }

    public int storrelse(){
      return teller;
    }

    public boolean erTom() {
      return (tabell[0] == null);
    }

    public void settInn(T element) {
      if(tabell.length == teller) throw new FullTabellUnntak(teller);
      for (int i = 0 ; i < tabell.length; i++) {
        if (tabell[i] == null) {
          tabell[i] = element;
          teller++;
          break;
        }
      }
    }

    public T hentFraPlass(int plass) {
      if(plass > teller || plass < 0){
        throw new UgyldigPlassUnntak(l,teller);
      }
      return tabell[plass];
    }

    //iterer
    public Iterator<T> iterator(){
      return new MinIterator();
    }

    private class MinIterator implements Iterator<T>{

      private int gjeldendeTall;

        public T next() {
            int returVerdi = gjeldendeTall;
            gjeldendeTall++;
            return tabell[returVerdi];
        }

        public boolean hasNext() {
          return this.gjeldendeTall < teller;
        }

        public void remove() {
        }
      }

}
