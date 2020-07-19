import java.util.ArrayList;
import java.util.Iterator;

class RangeEksempel {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Emir");
    strings.add("Kalle Klovn");
    strings.add("Daniel");

    Iterator<String> iterator = strings.iterator();
    /*
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }*/

    for(String s: strings){ System.out.println(s);}

    Range minRange = new Range(0,10);
    Iterator<Integer> rangeIterator = minRange.iterator();

    /*while(rangeIterator.hasNext()){System.out.println(rangeIterator.next());}*/
    for (int i : new Range(0,10)){System.out.println(i);}
  }
}
