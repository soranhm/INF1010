package oppgav2p9;

public class Kjoretoy {

	   Kjoretoy(String reg, String merke, String eier){
		   this.reg = reg;
		   this.merke = merke;
		   this.eier = eier;
	   }

       protected String reg;
       protected String merke;
       protected String eier;

       public void skrivUt(){
    	   System.out.println(("reg.nr:" + reg));
    	   System.out.println("Merke:" +merke);
    	   System.out.println("Eier:" +eier);
       }
}
