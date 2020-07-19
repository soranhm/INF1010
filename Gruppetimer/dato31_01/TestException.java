import java.util.Scanner;

class TestException {
  public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int i = Integer.parseInt(sc.nextLine());

  String[] array = new String[3];
  array[0] = "Hallo";
  array[1] = "Hei";
  array[2] = "hade";

  if(testIndex(array,i)){
    System.out.println(array[Integer.parseInt(i)]);

  }
  else {
    System.out.println("Indexen funket ikke");

  }
  }
/*
  public static boolean testIndex(String[] a, int index){
    try{
      String temp = a[index];
    }
    catch(ArrayIndexOutOfBoundsException e){
      return false;
    }
    return true;

  }
  */
  public static boolean testIndex(String[] a, String index){
    try{
      int i = Integer.parseInt(index);
      String tmp =a[i];
    }
    catch(ArrayIndexOutOfBoundsException e){
      return false;
    }
    catch(NumberFormatException e){
      return false;
    }
    return true;

  }
}
