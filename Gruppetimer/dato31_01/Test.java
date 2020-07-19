class Test {
  public static void main(String[] args){

    //Dyr d = new Dyr("ole", 500)// funker ikke pga dyr er abstract
    Sau s = new Sau("Sau1", 200, true);
    Ku k = new Ku("Ku1", 500);
    /*
    Sau[] fjos = new Sau[4];
    Ku[] fjos = new Ku[4];
    */
    // lager array for begge
    Dyr[] fjos = new Dyr[3];
    fjos[0]= k;
    fjos[1]= s;
    fjos[2] = new Ku("Ku10000",1000);

    for(Dyr d: fjos) {
      if (d instanceof Sau) {
        ((Sau)d).klippSau();
      }
    }

    for(Dyr d: fjos) {
      d.lagLyd();
      System.out.println(d);
    }

  }
}
