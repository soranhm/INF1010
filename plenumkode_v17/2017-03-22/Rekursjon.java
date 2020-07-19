public class Rekursjon {
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            //System.out.println("Regner ut sum av tall opp til " + n);
            int tmp = n+sum(n-1);
            //System.out.println("sum("+ n + ") = " + tmp);
            return tmp;
        }
    }

    public static void skrivOppTilTi(int start, int slutt, String prefiks) {
        if (start <= slutt) {
            System.out.println(prefiks + start);
            skrivOppTilTi(start+1, slutt, prefiks + " ");
            System.out.println(prefiks + start);
        }
    }

    public static void main(String[] args) {
        skrivOppTilTi(1, 15, " ");
    }


}