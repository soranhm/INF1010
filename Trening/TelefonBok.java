import java.util.HashMap;
import java.util.Scanner;

class TelefonBok {
  public static void main(String[] args) {

    String sok;
    Scanner tastatur = new Scanner(System.in);

    // lager en Hashmap
    HashMap<String,Integer> telefonBok = new HashMap<>();

    // putter inn i Hashmap
    telefonBok.put("Arne".toLowerCase(), 22334455);
    telefonBok.put("Lisa", 95959595);
    telefonBok.put("Jonas", 97959795);
    telefonBok.put("Peder", 12345678);

    System.out.println("Sok ettter navn: ");
    sok = tastatur.nextLine().toLowerCase();

    //if(telefonBok.get(sok) != null )
    if (telefonBok.containsKey(sok)) {
      System.out.println(sok + "telefon: " + telefonBok.get(sok));
    }
    else {
      System.out.println("Navnet finnes ikke i telefonboken!");
    }

  }
}
