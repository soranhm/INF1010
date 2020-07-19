class USBKabel{
  double meterLengde;

  private USBKabel(double meterLengde){
    this.meterLengde = meterLengde;
  }

  public static USBKabel fraMeter(double meterLengde){
    return new USBKabel(meterLengde);
  }

  public static USBKabel fraFot(double fotLengde){
    return new USBKabel(fotLengde*0.3048);
  }

  public double getMeterLengde(){return meterLengde;}

  public double getFotLengde(){return meterLengde/0.3048;}

}

class FabrikkTest{
  public static void main(String[] args) {
    USBKabel kort = USBKabel.fraMeter(1);
    USBKabel middels = USBKabel.fraFot(6);
    System.out.println(kort.getMeterLengde());
    System.out.println(middels.getMeterLengde());
  }
}
