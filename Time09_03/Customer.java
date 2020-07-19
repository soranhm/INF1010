/* Based on the example in Chapter 1 in "Refactoring Improving the
 * Design of Existing Code" by Martin Fowler (with Kent Beck, John
 * Brant, William Opdyke, and Don Roberts), Addison-Wesley, 1999 */

/* Note: This is _not_ an example of good code design, but an example
 * used to illustrate how to improve the code design. */

/* The sample program is very simple. It is a program to calculate and
 * print a statement of a customer's charges at a video store. The
 * program is told which movies a customer rented and for how long. It
 * then calculates the charges, which depend on how long the movie is
 * rented, and identifies the type of movie. There are three kinds of
 * movies: regular, children's and new releases. In addition to
 * calculating charges, the statement also computes frequent renter
 * points, which vary depending on whether the film is a new
 * release. */

/* Note: The main program with user input etc is not shown, as it is
 * out of scope for this example. */

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
	    double thisAmount = 0;

	    //determine amounts for each line
	    int code = rent.getMovie().getPriceCode();
	    if (code == Movie.REGULAR) {
		      thisAmount += 2;
		      if (rent.getDaysRented() > 2)
		        thisAmount += (rent.getDaysRented() - 2) * 1.5;
	    } else if (code == Movie.NEW_RELEASE) {
		      thisAmount += rent.getDaysRented() * 3;
	    } else if (code == Movie.CHILDRENS) {
		      thisAmount += 1.5;
		      if (rent.getDaysRented() > 3)
		        thisAmount += (rent.getDaysRented() - 3) * 1.5;
	    }

	    // add frequent renter points
	    frequentRenterPoints++;
	    // add bonus for a two day new release rental
	    if (code == Movie.NEW_RELEASE &&  rent.getDaysRented() > 1) frequentRenterPoints++;

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
