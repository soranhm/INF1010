package oppgav2p9;

public class Test {
    public static void main(String[] args){
    	varebil v = new varebil("DF452", "Volvo","OLE", 5000);
    	personbil p = new personbil("KR4654","volvo", "ole", 1500);
    	buss busss = new buss("KD456","volvo","ole",4);
    	
    	p.skrivUt();
    	System.out.println("");
    	busss.skrivUt();
    	System.out.println("");
    	v.skrivUt();
    }
    
    
    
}

