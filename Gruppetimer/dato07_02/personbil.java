package oppgav2p9;

public class personbil extends kjoretoy{
	personbil(String reg, String merke, String eier, int plass){
		super(reg,merke,eier);
		sitteplasser = plass;
		avgift = 3000;
	}
	private int sitteplasser;
	private int avgift;
	
    public void skrivUt(){
	 System.out.println("Type: personbil");
	 super.skrivUt();
	 System.out.println("plass:" +sitteplasser);
	 System.out.println("Avgift:" +avgift);
 }


}
