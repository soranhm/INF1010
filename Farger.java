class Farger{
  public static void main(String[] args) {
    /*
    For quick reference:
    30 black
    31 red
    32 green
    33 yellow
    34 blue
    35 magenta
    36 cyan
    37 white
    40 black background
    41 red background
    42 green background
    43 yellow background
    44 blue background
    45 magenta background
    46 cyan background
    47 white background
    1 make bright (usually just bold)
    21 stop bright (normalizes boldness)
    4 underline
    24 stop underline
    0 clear all formatting
    */
    System.out.println((char)27 + "[30mThis text would show up blue" + (char)27 + "[0m");
    System.out.println((char)27 + "[31mThis text would show up red" + (char)27 + "[0m");
    System.out.println((char)27 + "[32mThis text would show up green" + (char)27 + "[0m");
    System.out.println((char)27 + "[33mThis text would show up yellow" + (char)27 + "[0m");
    System.out.println((char)27 + "[34mThis text would show up purpel" + (char)27 + "[0m");
    System.out.println((char)27 + "[35mThis text would show up pink" + (char)27 + "[0m");
    System.out.println((char)27 + "[36mThis text would show up cyan" + (char)27 + "[0m");
    System.out.println((char)27 + "[37mThis text would show up white" + (char)27 + "[0m");
    System.out.println((char)27 + "[40mThis text would show up blue background" + (char)27 + "[0m");
    System.out.println((char)27 + "[41mThis text would show up red background" + (char)27 + "[0m");
    System.out.println((char)27 + "[42mThis text would show up green background" + (char)27 + "[0m");
    System.out.println((char)27 + "[43mThis text would show up yellow background" + (char)27 + "[0m");
    System.out.println((char)27 + "[44mThis text would show up purpel background" + (char)27 + "[0m");
    System.out.println((char)27 + "[45mThis text would show up pink background" + (char)27 + "[0m");
    System.out.println((char)27 + "[46mThis text would show up cyan background" + (char)27 + "[0m");
    System.out.println((char)27 + "[47mThis text would show up white background" + (char)27 + "[0m");
    System.out.println((char)27 + "[1mThis text would show up Bold" + (char)27 + "[0m");
    System.out.println((char)27 + "[4mThis text would show up underline" + (char)27 + "[0m");




  }
}
