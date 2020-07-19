import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vei <T extends Kjoretoy> implements Iterable<T>{
    private Plass foran;
    private Plass sist;

    public Vei(){
        foran = new Plass(null);
        sist = new Plass(null);
        foran.neste = sist;
        sist.forrige = foran;
    }

    public void kjorInnPaaVei(T kjoretoy) {
        Plass ny = new Plass(kjoretoy);
        ny.neste = sist;
        ny.forrige = sist.forrige;

        sist.forrige.neste = ny;
        sist.forrige = ny;
    }

    private class Plass {
        T kjoretoy;
        Plass neste;
        Plass forrige;

        public Plass(T data){
            kjoretoy = data;
        }
    }

    public boolean avkjorsel(String id) {
        Plass gjeldende = foran.neste;

        while(gjeldende != sist) {
            if (gjeldende.kjoretoy.hentId().equals(id)) {
                Plass foer = gjeldende.forrige;
                Plass etter = gjeldende.neste;

                foer.neste = etter;
                etter.forrige = foer;

                return true;
            }
            gjeldende = gjeldende.neste;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator(){
        return new VeiIterator();
    }

    private class VeiIterator implements Iterator<T> {
        private Plass posisjon;

        public VeiIterator(){
            posisjon = foran;
        }

        @Override
        public boolean hasNext(){
            return posisjon.neste != sist;
        }

        @Override
        public T next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            posisjon = posisjon.neste;
            return posisjon.kjoretoy;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    }


}