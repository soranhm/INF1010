class NewMovie extends Movie{

  NewMovie(String title){
    super(title);
  }

  public double calcRentalCost(int days){
        double amount = 1.5;
        amount += days * 3;
    return amount;
  }
}
