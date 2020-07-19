public class ForsteArbeider extends Arbeider{

	private Scanner forrige;
	private OrdBuffer neste;

	public ForsteArbeider(int traadnummer, Scanner forrige, OrdBuffer neste){
		super(traadnummer);
		this.forrige = forrige;
		this.neste = neste;
	}

	public void run(){
		minste = forrige.nextLine();

		while(forrige.hasNextLine()){
			String nesteOrd = forrige.nextLine();
			String storste = lagreMinste(nesteOrd);
			neste.settInn(storste);
		}

		neste.settInn(null);
		skrivMinste();
	}

}
