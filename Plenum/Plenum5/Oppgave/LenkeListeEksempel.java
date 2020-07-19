public class LenkelisteEksempel {
    public static void main(String[] args) {
        Lenkeliste<String> lenkeliste = new Lenkeliste<String>();
        lenkeliste.settInn("hei");
        lenkeliste.settInn("på");
        lenkeliste.settInn("deg");

        lenkeliste.skrivUt2();
        lenkeliste.inneholder("hei");
        lenkeliste.inneholder("hallo");
    }
}
