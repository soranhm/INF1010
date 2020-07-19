abstract class Arbeider implements Runnable{

	protected int traadnummer = 0;
	protected String minste = null;

	public Arbeider(int traadnummer){
		this.traadnummer = traadnummer;
	}

	public void run(){

	}

	public String lagreMinste(String ord){
		String returverdi = minste;
		if(ord.compareTo(minste) <= 0){
			minste = ord;
		}
		else {
			returverdi = ord;
		}
		return returverdi;
	}

	public void skrivMinste(){
		System.out.println("Trådnummer: " + traadnummer + ", minste: " + minste);
	}
}
