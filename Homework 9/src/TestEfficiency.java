import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class TestEfficiency extends TestCase {
	
	MovieCollection mediumCollection = new MovieCollection(10000);
	
	MovieCollection largeCollection = new MovieCollection(2000000);

	
	public void setUp() {
		
		for(int i = 0; i<1000000;i++) {
			largeCollection.addMovie(new Movie(""+i,2000,1));
		}
		
		for(int i = 0; i<10000;i++) {
			mediumCollection.addMovie(new Movie(""+i,2000,1));
		}
	}
	



	//testing adding lots of movies. this should finish within a few seconds.
	public void test01() {
		for(int i = 0; i<1000000;i++) {
			largeCollection.addMovie(new Movie(""+i,2000,1));
		}
		
	}
	

	
	//testing removing the first element repeatedly. this should finish within a few seconds
	//this is fast because we always remove the first movie
	public void test02() {
		for(int i = 0; i<1000000;i++) {
			largeCollection.removeMovie(largeCollection.getFirstMovies(1)[0]);
		}
		
	}
		
	//testing for your selection sort method. this should finish within a few seconds
	public void test03() {
		mediumCollection.sortByYearTitle();
	}
	
	//testing finding in a small collection. this should finish within a few seconds
	public void test04() {
		MovieCollection nearlyEmpty = new MovieCollection(1000000);
		Movie a = new Movie("a", 2000, 5);
		Movie b = new Movie("b", 2000, 5);
		nearlyEmpty.addMovie(a);
		for (int i=0; i<1000000; i++) {
			nearlyEmpty.findMovie(a);
			nearlyEmpty.findMovie(b);
		}
	}
	
	//testing getting the first 10 movies in a large collection. this should finish within a few seconds.
	public void test05() {
		for(int i=0; i<100000; i++)
			largeCollection.getFirstMovies(10);
	}
}
	