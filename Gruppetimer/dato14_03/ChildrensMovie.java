class ChildrensMovie extends Movie{

  ChildrensMovie(String title){
    super(title);
  }
  public double calcRentalCost(int days){
        double amount = 1.5;
        if (days > 3) amount += (days - 3) * 1.5;
    return amount;
  }

}
