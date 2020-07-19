import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class ComparatorEksempel {
  public static void main(String[] args) {
    String string1 = "stine";
    String string2 = "mathias";

    System.out.println(string2.compareTo(string1));

    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Emir");
    strings.add("Kalle Klovn");
    strings.add("Daniel");
    Collections.sort(strings);

    for(String s: strings) {
      System.out.println(s);
    }

    ArrayList<Hund> hunder = new ArrayList<Hund>();
    hunder.add(new Hund("Sally", 3));
    hunder.add(new Hund("Bjarte",8));
    hunder.add(new Hund("Bob", 5));
    Collections.sort(hunder);

    for(Hund hund: hunder){
      System.out.println(hund);
    }

    Hund[] hundArray = new Hund[3];
    hundArray[0] = new Hund("Sally", 3);
    hundArray[1] = new Hund("Bjarte",8);
    hundArray[2] = new Hund("Bob", 5);
    Arrays.sort(hundArray);

    for (int i = 0; i < hundArray.length; i++){
      System.out.println(hundArray[i]);
    }
    
  }
}
