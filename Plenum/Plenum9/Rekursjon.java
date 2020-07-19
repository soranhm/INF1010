public class Rekursjon {
  public static int sum(int n){
    if (n == 1) return 1;
    else {
      System.out.println("Regner ut sum av tall opp til " + n);
      int tmp = n + sum(n-1);
      System.out.println("Sum("+ n + ") = "+tmp);
      return tmp;
    }
  }

  public static void skrivOppTilTi(int start){
      if (start <= 10){
        System.out.println(start);
        skrivOppTilTi(start+1);
      }
  }

  public static void skrivOppTilTiInnryk(int start,String prefiks){
      if (start <= 10){
        System.out.println(prefiks + start);
        skrivOppTilTiInnryk(start+1, prefiks + " ");
      }
  }

  public static void skrivOppTilN(int start,int slutt,String prefiks){
      if (start <= slutt){
        System.out.println(prefiks + start);
        skrivOppTilN(start+1,slutt, prefiks + " ");
      }
  }

  public static void skrivNedTilN(int start,int slutt,String prefiks){
      if (start <= slutt){
        System.out.println(prefiks + start);
        skrivNedTilN(start+1,slutt, prefiks + " ");
        System.out.println(prefiks + start);
      }
  }

  public static void main(String[] args){
    System.out.println(sum(4));
    //skrivOppTilTi(1);
    //skrivOppTilTiInnryk(1, "");
    //skrivOppTilN(1,15,"");
    //skrivNedTilN(1,15,"");
  }
}
