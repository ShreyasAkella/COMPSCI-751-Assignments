import java.util.Arrays;

/*
 * A class that stores a number of movies in an array
 * If there are n movies, they are stored in the range [0, n-1]
 * Everything else will be null
 */

public class MovieCollection {
	
	Movie[] movies;
	int spotsFilled;
	

	
	/**
	 * create a collection of movies based on an array
	 * @param movies the movies that make up the collection
	 */
	public MovieCollection(Movie[] movies) {
		if (movies == null)
			throw new IllegalArgumentException("null collection");
		this.movies = Arrays.copyOf(movies, movies.length);
		int count = 0;
		for(int i=0; i<movies.length; i++)
			if(movies[i] != null)
				count++;
		spotsFilled = count;
	}
	
	
	
	
	/**
	 * Given method. Loops through the array until it finds a null Movie spot. puts the new movie there and
	 * increments spotsFilled by one. 
	 * @param movie. Must not be null, or an IllegalArgumentException Occurs.
	 * @return true if a movie was added, false if it was full already
	 * @throws IllegalArgumentException for a null movie
	 */
	public boolean addMovieSlow(Movie movie) {
		if(movie==null)
			throw new IllegalArgumentException("movies cannot be null");
		for(int i = 0; i<movies.length; i++) {
			if(movies[i]==null) {
				movies[i]=movie;
				spotsFilled++;
				return true;
			}
				
		}
		return false;
		
	}
	
	
	/**
	 * This method is given. It goes through the whole array until it finds the movie. 
	 * If it finds the movie, it takes all the movies to the right of the one to remove, 
	 * and shifts them to the left by one index.
	 * If there is more than one movie in the array that is equal to the argument
	 * this method only removes the first one found.
	 * It does this so we aren't leaving "holes" in the data array.
	 * @param movie. Must not be null. Otherwise throw an IllegalArgumentException
	 * @return false if the movie is not in the array, true if it was found and subsequently removed.
	 */
	public boolean removeMovieSlow(Movie movie) {
		if(movie==null)
			throw new IllegalArgumentException("movies cannot be null");
		
		for(int i= 0; i<spotsFilled;i++) {
			if(movie.equals(movies[i])) {
				for(int j=i+1; j<spotsFilled; j++) {
					movies[j-1]=movies[j];
				}
				spotsFilled--;
				return true;
			}
				
		}
		return false;
	}
	

	
	
	/**
	 * Sorts the collection based on rating, from highest to lowest. 
	 * You should use Insertion Sort here.
	 */
	public void sortByRating() {
		int n = spotsFilled; 
        for (int i = 1; i < n; ++i) { 
            Movie current = movies[i]; 
            int j = i - 1; 
  
            while (j >= 0 && movies[j].getRating() < current.getRating()) { 
                movies[j + 1] = movies[j]; 
                j = j - 1; 
            } 
            movies[j + 1] = current; 
        } 
		
	}
	
	
	/**
	 * MovieCollection’s toString should call each movie’s toString method on a different line. 
	 */
	public String toString() {
		String output = "";
		for(int i=0; i<spotsFilled; i++) {
			output = output + movies[i].toString() + "\n";
		}
		
		return output;
		
	}
	
	public int getCapacity() {
		return movies.length;
	}
	
	public boolean isEmpty() {
		return spotsFilled == 0;
	}
	
	/**
	 * return the nth movie in the collection
	 * @param n the index to look at
	 * @return nth movie
	 * @throws IllegalArgumentException if n is a bad index
	 */
	public Movie getNth(int n) {
		if (n<0 || n >= spotsFilled)
			throw new IllegalArgumentException("n out of bounds");
		return movies[n];
	}
	
	/**
	 * This method makes a deep Copy of this MovieCollection object and returns it. 
	 * Remember that that means that changes to the original collection should not affect the new one.
	 * @return a deep copy of this movieCollection
	 */
	public MovieCollection duplicateCollection() {
		//TODO create a new MovieCollection
		// make a deep copy of the state of this MovieCollection
		// return it
		  MovieCollection carbonCopy;
          Movie[] copyDeep= new Movie[spotsFilled];
          int i = 0;
			while(i < spotsFilled) {
	        	   copyDeep[i]=new Movie(movies[i].getTitle(), movies[i].getReleaseYear(),movies[i].getRating());
	           }
			carbonCopy= new MovieCollection(copyDeep);
		   return carbonCopy;
	}
	


}
