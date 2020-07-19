package gruke9;
import java.util.Iterator;

public class Test {
	public static void main(String[] args){
		LL<String> liste = new LL<>();
		
		liste.addSorted("b");
		liste.addSorted("g");
		liste.addSorted("3");
		liste.addSorted("w");
		liste.addSorted("j");
		System.out.println(liste.size());
		liste.print();
		
		for(String s:liste){
			System.out.println(s);
		}
		
//  annen skrivemåte:
//		Iterator<String> it = liste.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		
		
		//annet eksempel
		liste.addFirst("hei");
		liste.addFirst("hello");

		System.out.println(liste.size() + " " + liste.getFirst());
		System.out.println(liste.size() + " " + liste.removeFirst()); //denne printer ut den den fjerner
		System.out.println(liste.size() + " " + liste.getFirst());


	}

}
