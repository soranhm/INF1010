public class Oppgave1{

  public static int sum(int n){
    if (n == 1) return 1;
    else {
      System.out.println(n);
      return sum(n-1);
    }
  }

  public static void main(String[] args){
    System.out.println(sum(10));
  }
}
