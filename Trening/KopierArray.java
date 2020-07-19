import java.util.Arrays;

class KopierArray {
  public static void main(String[] args) {
      String[] stringArray = {"INF1000","INF1500","INF1080"};
      String[] nyArray = new String[3];

      for (int i = 0; i < nyArray.length; i++) {
        System.out.println("stringArray["+i+"] = "+stringArray[i]);
        nyArray[i] = stringArray[i] ;
      }
      for (int i = 0; i < nyArray.length; i++) {
        System.out.println("nyArray["+i+"] = "+nyArray[i]);
      }
  }
}
