class Sannhetsverdier {
  public static void main(String[] args) {
    boolean b = false;
    int x = 0;
    System.out.println(b && x == 0);
    System.out.println(b || x == 0);
    System.out.println(!b && x == 0);
    System.out.println(!b || x == 0);
    System.out.println(b && x != 0);
    System.out.println(b || x != 0);
    System.out.println(!b && x != 0);
    System.out.println(!b || x != 0);
  }
}
