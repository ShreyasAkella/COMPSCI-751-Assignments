import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class TestClass extends TestCase {

	MovieCollection test1 = new MovieCollection();
	MovieCollection test2 = new MovieCollection();
	MovieCollection blank = new MovieCollection();
	
	
	Movie cars2 = new Movie("Cars 2", 2011,6.1);
	
	Movie TGGNew = new Movie("The Great Gatsby", 2013,7.2);
	Movie TGGOld = new Movie("The Great Gatsby", 1974,6.4);
	
	Movie parasite = new Movie("Parasite",2019,9.3);
	
	Movie[] test1DT = {new Movie("Star Wars", 1977,8.8),new Movie("Frozen 2", 2019,7.6),new Movie("Parasite",2019,9.3),null,null,null,null,null,null,null};
	
	Movie[] test1R = {new Movie("Frozen 2", 2019,7.6),new Movie("Star Wars", 1977,8.8),new Movie("Parasite",2019,9.3),null,null,null,null,null,null,null};
	

	Movie[] t2 = {TGGOld,TGGNew,null,null,null,null,null,null,null,null};
	
	Movie[] tt2 = {TGGNew, TGGOld,null,null,null,null,null,null,null,null};
	
	Movie[] emptyArr = {null,null,null,null,null,null,null,null,null,null};
	
	
	Movie[] SWF = { new Movie("Star Wars", 1977,8.8),new Movie("Frozen 2", 2019,7.6),null,null,null,null,null,null,null,null};
	
	public void setUp() {
		test1.addMovie(new Movie("Parasite",2019,9.3));
		test1.addMovie(new Movie("Frozen 2", 2019,7.6));
		test1.addMovie(new Movie("Star Wars", 1977,8.8));
		
		test2.addMovie(TGGNew);
		test2.addMovie(TGGOld);
		
	}
	
	//testing movies constructor
	public void test01() {
		boolean caught = false;
		try {
			new MovieCollection(-1);
		}catch (IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
		MovieCollection movies1 = new MovieCollection(1);
		assertEquals(1, movies1.getCapacity());
		MovieCollection movies2 = new MovieCollection();
		assertEquals(10, movies2.getCapacity());
		MovieCollection movies3 = new MovieCollection(1000);
		assertEquals(1000, movies3.getCapacity());
		assertTrue(movies3.isEmpty());
		MovieCollection movies4 = new MovieCollection(0);
		assertEquals(0, movies4.getCapacity());
		assertTrue(movies4.isEmpty());
		
		
	}
	
	
	//testing adding and finding
	public void test02() {
		MovieCollection movies = new MovieCollection(4);
		assertFalse(movies.findMovie(parasite));
		assertFalse(movies.findMovie(null));
		
		assertTrue(movies.addMovie(TGGNew));
		assertTrue(movies.addMovie(TGGOld));
		assertTrue(movies.addMovie(cars2));
		assertTrue(movies.addMovie(parasite));
		assertTrue(movies.findMovie(TGGNew));
		assertTrue(movies.findMovie(TGGOld));
		assertTrue(movies.findMovie(cars2));
		assertTrue(movies.findMovie(parasite));
		
		Movie blank = new Movie("Blank", 1950, 5);
		assertFalse(movies.addMovie(blank));
		assertFalse(movies.findMovie(blank));
	}
	
	public void test03() {
		MovieCollection movies = new MovieCollection(4);
		boolean caught = false;
		try {
			movies.addMovie(null);
		}
		catch(IllegalArgumentException ex) {
			caught = true;
		}
		assertTrue(caught);
	}
	
	public void test04() {
		MovieCollection movies = new MovieCollection(2);
		movies.addMovie(cars2);
		assertTrue(movies.findMovie(new Movie("Cars 2", 2011,6.1)));
	}
	
	//testing removing
	public void test05() {
		assertTrue(test1.removeMovie(parasite));
		
		assertFalse(test1.findMovie(parasite));
		
		assertFalse(test1.removeMovie(parasite));
		
		
		assertFalse(test1.removeMovie(cars2));
		
		assertTrue(test1.removeMovie(new Movie("Frozen 2", 2019,7.6)));
		
		boolean caught = false;
		try {
			test1.removeMovie(null);
		}catch (IllegalArgumentException e) {
			caught = true;
		}
		assertTrue(caught);
		
	}	
	
	//testing sort by Year and Title
	public void test06() {
		
		test1.sortByYearTitle();
		assertArrayEquals(test1DT,test1.movies);
		
		
		test2.sortByYearTitle();
		
		assertArrayEquals(t2,test2.movies);
		
		blank.sortByYearTitle();
		
		MovieCollection one = new MovieCollection(1);
		one.addMovie(cars2);
		one.sortByYearTitle();
		
		MovieCollection zero = new MovieCollection(0);
		zero.sortByYearTitle();
		
		MovieCollection five = new MovieCollection(5);
		five.addMovie(cars2);
		five.addMovie(cars2);
		five.addMovie(cars2);
		five.addMovie(cars2);
		five.addMovie(cars2);
		five.sortByYearTitle();
	}

	
	//testing getFirstMovies
	public void test07() {
		test1.sortByRating();
		assertEquals(parasite,test1.getFirstMovies(1)[0]);

		test2.sortByRating();
		assertEquals(TGGNew,test2.getFirstMovies(1)[0]);
		
		test2.addMovie(parasite);
		test2.sortByRating();
		assertEquals(parasite,test2.getFirstMovies(1)[0]);
		
		parasite.setRating(3.0);
		test2.sortByRating();
		assertEquals(TGGNew,test2.getFirstMovies(1)[0]);
		
	}
	
	//testing encapsulation of getFirstMovies
	public void test08() {
		test1.sortByRating();
		Movie[] first = test1.getFirstMovies(1);
		first[0] = null;
		assertTrue(test1.findMovie(parasite));
		first = test1.getFirstMovies(1);
		assertEquals(parasite,test1.getFirstMovies(1)[0]);
	}

	public void test09() {
		test1.sortByYearTitle();
		assertEquals(0, test1.getFirstMovies(0).length);
		assertEquals(1, test1.getFirstMovies(1).length);
		assertEquals(test1DT[0], test1.getFirstMovies(1)[0]);
		
		assertEquals(test1DT[0], test1.getFirstMovies(3)[0]);
		assertEquals(test1DT[1], test1.getFirstMovies(3)[1]);
		assertEquals(test1DT[2], test1.getFirstMovies(3)[2]);
		
	}
	
	public void test10() {
		test1.sortByYearTitle();
		boolean caught = false;
		try {
			test1.getFirstMovies(-1);
		}
		catch (IllegalArgumentException ex) {
			caught = true;
		}
		assertTrue(caught);
		
		caught = false;
		try {
			test1.getFirstMovies(4);
		}
		catch (IllegalArgumentException ex) {
			caught = true;
		}
		assertTrue(caught);
	}
	
	public void test11() {
		MovieCollection longer = new MovieCollection(11);
		longer.addMovie(new Movie("a", 2000, 0));
		longer.addMovie(new Movie("b", 2010, 10));
		longer.addMovie(new Movie("c", 2005, 5));
		longer.addMovie(new Movie("d", 2004, 3));
		longer.addMovie(new Movie("e", 2006, 7));
		longer.addMovie(new Movie("f", 2004, 4));
		longer.addMovie(new Movie("g", 2001, 1));
		longer.addMovie(new Movie("h", 2002, 2));
		longer.addMovie(new Movie("i", 2005, 6));
		longer.addMovie(new Movie("j", 2008, 9));
		longer.addMovie(new Movie("c", 2008, 8));
		longer.sortByYearTitle();
		Movie[] sorted = longer.getFirstMovies(11);
		for (int i=0; i<11; i++)
			assertEquals(i, Math.round(sorted[i].getRating()));
	}
}
