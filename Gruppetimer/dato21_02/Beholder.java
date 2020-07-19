public class Beholder<E extends Comparable<E>>{
  private E e1;
  private E e2;

  Beholder(E e1,E e2){
    this.e1 = e1;
    this.e2 = e2;
  }

  public void skrivUtSortert(){
    if (e1.compareTo(e2)< 0){
      System.out.println(e1 + "\n" + e2);
    }
    else if (e1.compareTo(e2)> 0){
      System.out.println(e1 + "\n" + e2);
    }
    else{
      System.out.println("Lik: " + e1);
    }
  }

}
