import java.util.Iterator;
interface ListReader<E> extends Iterator<E>{
  E next();
  E previous();
  boolean hasNext();
  boolean hasPrevious();
}
