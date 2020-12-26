import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class TestClass extends TestCase {

	MovieCollection coll;
	MovieCollection copy;
	
	Movie cars2 = new Movie("Cars 2", 2011,6.1);
	Movie TGGNew = new Movie("The Great Gatsby", 2013,7.2);
	Movie TGGOld = new Movie("The Great Gatsby", 1974,6.4);
	Movie parasite = new Movie("Parasite",2019,9.3);
	
	public void setUp() {
		coll = new MovieCollection(new Movie[] {null, null, null, null});
		
	}
	
	//test that the copy has the same movies
	//(must have at least copied the array reference)
	public void test01() {
		coll.addMovieSlow(cars2);
		coll.addMovieSlow(TGGNew);
		coll.addMovieSlow(TGGOld);
		coll.addMovieSlow(parasite);
		copy = coll.duplicateCollection();
		assertEquals(cars2, copy.getNth(0));
		assertEquals(TGGNew, copy.getNth(1));
		assertEquals(TGGOld, copy.getNth(2));
		assertEquals(parasite, copy.getNth(3));
		
		assertFalse(coll == copy);
	}
	
	
	//test that changing coll doesn't change the copy
	//(must have at least made a shallow copy)
	public void test02() {
		coll.addMovieSlow(TGGNew);
		copy = coll.duplicateCollection();
		coll.removeMovieSlow(TGGNew);
		assertEquals(TGGNew, copy.getNth(0));
	}
	
	//test that changing movies in coll doesn't change movies in copy
	//(must have made a deep copy)
	public void test03() {
		coll.addMovieSlow(TGGNew);
		copy = coll.duplicateCollection();
		assertEquals(coll.getNth(0), copy.getNth(0));
		coll.getNth(0).setRating(0);
		assertNotEquals(coll.getNth(0), copy.getNth(0));
	}
}
