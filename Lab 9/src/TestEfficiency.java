import junit.framework.TestCase;

public class TestEfficiency extends TestCase {
	
	MovieCollection mediumCollection;

	
	public void setUp() {
		Movie[] movies = new Movie[10000];
		for(int i = 0; i<10000;i++) {
			movies[i] = new Movie(""+i,2000,1);
		}
		mediumCollection = new MovieCollection(movies);
	}
	



	//testing duplicating the collection a bunch of times. This should finish within a few seconds.
	public void testEfficiency() {
		for(int i = 0; i<10000;i++) {
			mediumCollection.duplicateCollection();
		}
		
	}

}
	