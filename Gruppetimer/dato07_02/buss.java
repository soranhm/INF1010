package oppgav2p9;

public class buss extends kjoretoy{
	buss(String reg, String merke, String eier, int plass){
		super(reg,merke, eier);
		sitteplasser = plass;
		avgift = 0;
	}
	private int sitteplasser;
	private int avgift;
 public void skrivUt(){
	 System.out.println("Type: buss");
	 super.skrivUt();
	 System.out.println("plass:" +sitteplasser);
	 System.out.println("Avgift:" +avgift);
 }
}
