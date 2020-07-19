// Bruker dette til aa lagre meldinger og sende videre
class Melding implements Comparable<Melding>{

    private int id;
    private int sekvensnummer;
    private String melding;

    public Melding(String melding, int sekvensnummer, int id){
        this.melding = melding;
        this.sekvensnummer = sekvensnummer;
        this.id = id;
    }

    public String getMelding(){
        return melding;
    }
    public int getId(){
        return id;
    }
    public int getSekvensnummer(){
        return sekvensnummer;
    }

    public int compareTo(Melding m){
        if(this.sekvensnummer < m.getSekvensnummer()){
            return -1;
        }
        else if(this.sekvensnummer == m.getSekvensnummer()){
            return 0;
        }
        else{
            return +1;
        }
    }
}
