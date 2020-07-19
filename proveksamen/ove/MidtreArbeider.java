public class MidtreArbeider extends Arbeider{

	private OrdBuffer forrige;
	private OrdBuffer neste;

	public MidtreArbeider(int traadnummer, OrdBuffer forrige, OrdBuffer neste){
		super(traadnummer);
		this.forrige = forrige;
		this.neste = neste;
	}

	public void run(){
		minste = forrige.hentUt();

		String nesteOrd = forrige.hentUt();
		while(nesteOrd != null){
			String storste = lagreMinste(nesteOrd);
			neste.settInn(storste);
		}

		neste.settInn(null);
		skrivMinste();
	}

}
