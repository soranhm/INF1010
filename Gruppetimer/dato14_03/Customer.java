/* The customer class represents the customer of the store. Like the
 * other classes it has data and accessors. Customer also has the
 * method that produces a statement. */

import java.util.*;

class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
	this.name = name;
    }

    public void addRental(Rental arg) {
	rentals.add(arg);
    }

    public String getName() {
	     return name;
    }

    public String statement() {
    	double totalAmount = 0;
    	int frequentRenterPoints = 0;
    	String result = "Rental Record for " + getName() + "\n";
    	for (Rental rent: rentals) {
          Movie m = rent.getMovie();
          int days = rent.getDaysRented();
    	    double thisAmount = m.calcRentalCost(days);

    	    // add frequent renter points
          // add bonus for a two day new release rental
    	    frequentRenterPoints++;
    	    if (m instanceof NewMovie && days > 1) frequentRenterPoints++;

    	    // show figures for this rental
    	    result += "\t" + rent.getMovie().getTitle() + "\t" +
      		thisAmount + "\n";
      	  totalAmount += thisAmount;

      	}
      	// add footer lines
      	result += "Amount owed is " + totalAmount + "\n";
      	result += "You earned " + frequentRenterPoints +
      	    " frequent renter points";
      	return result;
      }


}
