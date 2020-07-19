package oppgav2p9;

public class varebil extends kjoretoy {
	varebil(String reg, String merke, String eier, int vekt){
		super(reg,merke,eier);
		this.vekt=vekt;
		avgift = 4*vekt;
		
	}
	private int vekt;
	private int avgift;
	
    public void skrivUt(){
	 System.out.println("Type: varebil");
	 super.skrivUt();
	 System.out.println("max vekt:" +vekt);
	 System.out.println("Avgift:" +avgift);
 }

}
