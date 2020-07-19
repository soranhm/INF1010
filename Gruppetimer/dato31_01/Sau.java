class Sau extends Dyr {

  private boolean harUll;
  Sau(String navn, int vekt, boolean harUll) {
    super(navn,vekt); // gjor dette forst !
    this.harUll = harUll;
  }

  public void klippSau(){
    if(harUll){
      System.out.println("Vi klipper "+ navn);
    }
    else{
      System.out.println(navn + " har ikke ull");
    }
    harUll = false;
  }

  public void lagLyd(){
    System.out.println(navn + ": \"baaa\"");
  }

  public String toString(){
    return navn;
  }
}
