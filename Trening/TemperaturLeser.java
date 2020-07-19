import java.util.Scanner;
import java.io.File;

class TemperaturLeser {
  public static void main(String[] args) throws Exception {
    Scanner fil = new Scanner(new File("Temperatur.txt"));

    String[] temperatur = new String[12];

    for (int i = 0; i < temperatur.length; i++) {
      temperatur[i] = fil.nextLine();;
    }

    for (int j = 0; j < temperatur.length; j++) {
      System.out.println(temperatur[j]);
    }
  }
}
