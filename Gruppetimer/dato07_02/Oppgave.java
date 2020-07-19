package oppgav2p9;
import java.util.ArrayList;
import java.util.Scanner;

public class Oppgave {
	Oppgave(){
		meny();
	}
	private ArrayList<Kjoretoy> liste = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	private void nyttKjoretoy(){
		System.out.println("type kjoretoy (varebil/buss/personbil):" );
		String s = sc.nextLine();
		System.out.println("Merke:" );
		String merke = sc.nextLine();
		System.out.println("Navn:" );
		String regnr = sc.nextLine();
		if(s.equalsIgnoreCase("varebil")){
			System.out.println("Vekt:" );
			int vekt = sc.nextLine();
			System.out.println("Avvgift:" );
			int avvgift = sc.nextLine();
		}
		else if(s.equalsIgnoreCase("buss")){
			System.out.println("sitteplasser:" );
			int sitteplasser = sc.nextLine();
			int avvgift = 0;
		}
		else if(s.equalsIgnoreCase("personbil"))
		System.out.println("sitteplasser:" );
		int sitteplasser = sc.nextLine();
		int avvgift = 3000;

	}
	private void avgfit(){

	}
	private void skrivUt(){
		for(Kjoretoy k: liste){
			System.out.println(k);
		}
	}

	private void meny(){

		while(true){
			System.out.println("1: NyttKjoretoy\n2: skriv ut\n3: avgift");
			System.out.println("exit:");

			switch(sc.nextLine()){
			case "1":
				nyttKjoretoy();
				break;
			case "2":
				skrivUt();
				break;
			case "3":
				avgift();
				break;
			case " exit": return;
		    default:

			}
		}

	}

}
