import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class ComparatorEksempel {
    public static void main(String[] args) {
        List<String> minListe = new ArrayList<String>();
        minListe.add("Josefine");
        minListe.add("Roger");
        minListe.add("Tore");
        minListe.add("Stine");
        minListe.add("Cato");

        // Vi bruker anonym klasse i stedet for den navngitte klassen
        // "MinKomparator" som er skrevet nederst i filen.
        Collections.sort(minListe, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        //Lambda-uttrykk for den spesielt interesserte
        //Collections.sort(minListe, (a, b) -> a.length() - b.length());

        for(String s : minListe) {
            System.out.println(s);
        }
    }
}

/*class MinKomparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}*/