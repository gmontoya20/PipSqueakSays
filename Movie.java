import java.util.ArrayList;
import java.util.Scanner;
public class Movie{

    public static ArrayList<Movie> movieList = new ArrayList<Movie>();

    String title;
    double avgRating = 0;
    int yearReleased;
    String summary;
    String producer;
    ArrayList<Review> reviews;
    
    public Movie(String title, int yearReleased, String summary, String producer){
	this.title = title;
	this.yearReleased = yearReleased;
	this.summary = summary;
	this.producer = producer;
	reviews = new ArrayList<Review>();
}

    public void addReview(double rating, String theReview){
	Review newReview = new Review(rating, theReview);
	reviews.add(newReview);
	updateAvgRating();
	
}
    public void printReviews(){
	for(int i = 0; i < reviews.size(); i++){
	    System.out.println(reviews.get(i).theReview);
	}
    }
 
    
    public void updateAvgRating(){
	double total = 0;
	for(int i = 0; i < reviews.size(); i++){
	   total += reviews.get(i).rating;
	}
	
	avgRating= (total / reviews.size());
	
    }
    
    public static void createMovieList(){
	Movie aladdin = new Movie("Aladdin", 1992, "A street rat finds a lamp and love.", "Walt Disney Pictures");
	Movie moana = new Movie("Moana", 2016, "A young girl goes on a journey to save her island.", "Walt Disney Animation Studios");
	Movie lion = new Movie("The Lion King", 1994, "A young lion Simba, heir of his father, must overcome his wicked uncle before he gets the throne.", "Walt Disney Animation Studios");
	Movie mermaid = new Movie("The Little Mermaid", 1989, "A mermaid princess makes a bargain with an evil sea witch to meet a human prince on land.", "Walt Disney Animation Studios");
	Movie white = new Movie("Snow White", 1937, "Exiled into the dangerous forest by her wicked stepmother, a princess finds a cabin of dwarf miners.", "Walt Disney Animation Studios");
	Movie bambi = new Movie("Bambi", 1942, "After losing his mother, a young buck learns the way of the forrest.", "Walt Disney Animation Studios");
	Movie cindy = new Movie("Cinderella", 1950, "Forced into servitude by her stepmother and two stepsisters, a young woman wishes for more in life.", "Walt Disney Animation Studios");
	Movie zoo = new Movie("Zootopia", 2016, "A furry bunny cop proves to the world that appearances aren't everything.", "Walt Disney Animation Studios");
	Movie pinno = new Movie("Pinocchio", 1940, "A little wooden puppet comes to life and wonders what it would be like to be a real boy.", "Walt Disney Animation Studios");
	Movie poca = new Movie("Pocahontas", 1995, "An English soldier and the daughter of an Algonquin chief share a romance while trouble stirs between colonists and tribe.", "Walt Disney Animation Studios");
      
	movieList.add(aladdin);
	movieList.add(moana);
	movieList.add(lion);
	movieList.add(mermaid);
	movieList.add(white);
	movieList.add(bambi);
	movieList.add(cindy);
	movieList.add(zoo);
	movieList.add(pinno);
	movieList.add(poca);

	aladdin.addReview(8.8, "Beautiful! I loved it");
	moana.addReview(9.3, "So creative and beautiful!");
	lion.addReview(9.4, "I cried so hard");
	mermaid.addReview(7.2, "Cute story with funny characters");
	white.addReview(7.3, "A classic!");
	bambi.addReview(8.2, "A wonderful film with a sad plot!");
	cindy.addReview(6.5, "Not what women should aspire to");
	zoo.addReview(9.6, "Loved the way society was represented!");
	pinno.addReview(7.7, "Beautiful artwork!");
	poca.addReview(8.3, "Not historically accurate, but good!");

	
    }
    
    /*public static void addMovie(takes in movie stuff){
      creates a movie object
      movieList.add(movie thing);
      create a for loop that checks if movie already exists
     }*/

    /* three call methods for arraylist order */
    
    //method that adds authomatically adds our reviews
 
   
}
