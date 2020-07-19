import java.util.Iterator;

public class Test2 {
	public static void main(String[] args){
    LL2<String> liste = new LL2<>();

    liste.addRec("3");
    liste.addRec("1");
    liste.addRec("15");
    liste.addRec("9");
    liste.addRec("1");
    liste.printAll();

  }
}
