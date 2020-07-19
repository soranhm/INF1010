/* NB: Veldig enkelt testprogram, men avslører likevel en del
 * potensielle feil. Illustrerer også noen av problemene med
 * statement-metoden i Customer. Testprogrammet bør egentlig lages mer
 * systematisk og med bruk av feks JUnit.*/

class TestProgram {
    public static void main(String[] args) {
	Customer c1 = new Customer("Arne");
	Customer c2 = new Customer("Berit");
	Customer c3 = new Customer("Cecilie");
	Customer c4 = new Customer("David");

	Movie m1 = new NewMovie("Star Wars");
	Movie m2 = new ChildrensMovie("Frozen");
	Movie m3 = new RegularMovie("AI");
	Movie m4 = new NewMovie("Snekker Andersen");
	Movie m5 = new ChildrensMovie("Cars");
	Movie m6 = new RegularMovie("The imitation game");

	c1.addRental(new Rental(m1, 4));
	c1.addRental(new Rental(m2, 2));
	c2.addRental(new Rental(m2, 3));
	c2.addRental(new Rental(m3, 2));
	c2.addRental(new Rental(m6, 1));
	c3.addRental(new Rental(m5, 2));
	c3.addRental(new Rental(m4, 1));
	c3.addRental(new Rental(m2, 1));
	c1.addRental(new Rental(m6, 4));
	c1.addRental(new Rental(m6, 4));
	c1.addRental(new Rental(m2, 4));

	// System.out.println(c1.statement());
	// System.out.println(c2.statement());
	// System.out.println(c3.statement());
	// System.out.println(c4.statement());

	if (!c1.statement().equals("Rental Record for Arne\n\tStar Wars\t12.0\n\tFrozen\t1.5\n\tThe imitation game\t5.0\n\tThe imitation game\t5.0\n\tFrozen\t3.0\nAmount owed is 26.5\nYou earned 6 frequent renter points")) {
	    System.out.println("ERROR: ");
	    System.out.println(c1.statement());
	    System.out.println("SHOULD BE");
	    System.out.println("Rental Record for Arne\n\tStar Wars\t12.0\n\tFrozen\t1.5\n\tThe imitation game\t5.0\n\tThe imitation game\t5.0\n\tFrozen\t3.0\nAmount owed is 26.5\nYou earned 6 frequent renter points");
	}


	if (!c2.statement().equals("Rental Record for Berit\n\tFrozen\t1.5\n\tAI\t2.0\n\tThe imitation game\t2.0\nAmount owed is 5.5\nYou earned 3 frequent renter points")) {
	    System.out.println("ERROR: ");
	    System.out.println(c2.statement());
	    System.out.println("SHOULD BE");
	    System.out.println("Rental Record for Berit\n\tFrozen\t1.5\n\tAI\t2.0\n\tThe imitation game\t2.0\nAmount owed is 5.5\nYou earned 3 frequent renter points");
	}

	if (!c3.statement().equals("Rental Record for Cecilie\n\tCars\t1.5\n\tSnekker Andersen\t3.0\n\tFrozen\t1.5\nAmount owed is 6.0\nYou earned 3 frequent renter points")) {
	    System.out.println("ERROR: ");
	    System.out.println(c3.statement());
	    System.out.println("SHOULD BE");
	    System.out.println("Rental Record for Cecilie\n\tCars\t1.5\n\tSnekker Andersen\t3.0\n\tFrozen\t1.5\nAmount owed is 6.0\nYou earned 3 frequent renter points");
	}



    }
}
