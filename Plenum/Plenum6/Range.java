import java.util.Iterator;

class Range implements Iterable<Integer> {
  private int rangStart;
  private int rangEnd;

  Range(int rangStart,int rangEnd){
    this.rangStart = rangStart;
    this.rangEnd = rangEnd;
  }

  Range(int rangEnd) {
    this(0 ,rangEnd);
  }

  public Iterator<Integer> iterator(){
    return new RangeIterator();
  }

  private class RangeIterator implements Iterator<Integer> {
    private int gjeldeneTall;

    public RangeIterator(){
      this.gjeldeneTall = rangStart;
    }

    public Integer next(){
      int returVerdi = gjeldeneTall;
      gjeldeneTall++;
      return returVerdi;
    }

    public boolean hasNext(){
        /*if(this.gjeldeneTall < rangEnd){return true;}
        else{return false;}*/
        return this.gjeldeneTall < rangEnd;
    }

    public void remove(){throw new UnsupportedOperationException();}

  }
}
