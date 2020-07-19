import java.util.ArrayList;

public class Permutasjon {
    public static void main(String[] args) {
        ArrayList<String> permutasjoner = permutasjon("bok");

        for(String ord : permutasjoner) {
            System.out.println(ord);
        }
    }

    public static ArrayList<String> permutasjon(String ord) {
        ArrayList<String> resultat = new ArrayList<String>();
        if(ord.length() == 0) {
            resultat.add(ord);
            return resultat;
        }

        for(int i = 0; i < ord.length(); i++) {
            String kortereOrd = ord.substring(0, i) + ord.substring(i+1);

            ArrayList<String> korterePermutasjoner = permutasjon(kortereOrd);

            for(String permutasjon : korterePermutasjoner) {
                resultat.add(ord.charAt(i) + permutasjon);
            }
        }
        return resultat;
    }
}