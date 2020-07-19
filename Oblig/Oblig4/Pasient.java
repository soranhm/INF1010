
public class Pasient {

  private String navn;
  private long fodselsnummer;
  private String gate;
  private int post;
  private int id = 0;
  static int teller = 0;
  private Stabel<Resept> rpt;

  public Pasient(String navn,long fodselsnummer,String gate, int post){
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;
    this.gate = gate;
    this.post = post;
    id = teller;
    teller++;
    rpt = new Stabel<Resept>();
  }

  public int hentId() { return id;}
  public String hentNavn() { return navn;}
  public long hentFodselsnummer() { return fodselsnummer;}
  public String hentGateadresse() { return gate;}
  public int hentPostnummer() { return post;}

  public void leggTilResept(Resept resept) {
    rpt.settInn(resept);
    }

  public Stabel<Resept> hentReseptliste() { return rpt;}

  public String toString(){
    return hentNavn() + "(" + hentFodselsnummer() + ")" ;

  }
}
