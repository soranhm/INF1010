/* Movie is just a simple data class. There are three kinds of movies:
 * regular, children's and new releases. */

 abstract  class Movie{

    protected String title;

    public Movie(String title) {
	     this.title = title;
    }

    public String getTitle() {
	     return title;
    }

    public abstract double calcRentalCost(int days);
}
