class Test{
  public static void main(String[] args) {
    Lager l = new Lager(5);

    Arbeider a1 = new Arbeider(1);
    Arbeider a1 = new Arbeider(1);

    Eskemaker e1 = new Eskemaker(1,10);
    Eskemaker e2 = new Eskemaker(1,3);

    new Thread(a1.start());


  }
}
