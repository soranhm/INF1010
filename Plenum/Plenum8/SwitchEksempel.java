class SwitchEksempel{
  public static void main(String[] args) {
    int a = 0;

    switch(a){
      case 0:
        System.out.println("A er null");
        System.out.println("og det er et spesielt tall");
        break;
      case 1:
        System.out.println("A er en");
        break;
      default:
        System.out.println("Feil");
        break;
    }

    System.out.println("----");
    
    if(a == 0) System.out.println("A er null");
    else if(a == 1) System.out.println("A er en");
    else System.out.println("Feil");
  }
}
