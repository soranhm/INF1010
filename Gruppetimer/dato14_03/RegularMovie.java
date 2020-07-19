
class RegularMovie extends Movie{

  RegularMovie(String title){
    super(title);
  }

  public double calcRentalCost(int days){
        double amount = 2;
        if (days > 2) amount += (days - 2) * 1.5;
        return amount;
  }
}
