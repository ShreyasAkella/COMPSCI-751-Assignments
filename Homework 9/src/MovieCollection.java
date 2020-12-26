
/*
 * A class that stores a number of movies in an array
 * If there are n movies, they are stored in the range [0, n-1]
 * Everything else will be null
 */

public class MovieCollection {
	private static final int DEFAULT_SIZE = 10;
	
	Movie[] movies;
	int spotsFilled;
	
	public MovieCollection() {
		this(DEFAULT_SIZE);
	}
	
	/**
	 * create an empty collection of movies of a certain size
	 * @param size the size that the collection can hold
	 * @throws IllegalArgumentException if size is negative
	 */
	public MovieCollection(int size) {
		//TODO implement the constructor according to the javadoc
		if (size <0) throw new IllegalArgumentException("size cannot be negative");
		 movies = new Movie[size];
		 spotsFilled = 0;
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
		return false; // THE RUNTIME FOR THIS METHOD IS O(movies.length) + CONSTANTS, SINCE THERE'S A FOR LOOP
		
	}
	
	/**
	 * This method does the same thing as addMovieSlow, but it should do so in a “faster” way.
	 *  It can do this by utilizing the fact that operations at a specific index are constant time: O(1).
	 *  And the fact that the used indices are always on the left side of the Movies Index.
	 * @param movie. Must not be null. otherwise throw an IllegalArgumentException
	 * @return true if a movie was added, false if it was full already
	 * @throws IllegalArgumentException for a null movie
	 */
	public boolean addMovie(Movie movie) {
		//TODO implement adding in a faster way
		//don't scan through the whole array
		//just go to where you need to add
		if(movie==null)
			throw new IllegalArgumentException();
		if(spotsFilled >=movies.length)
			return false;
		movies[spotsFilled]=movie;
		spotsFilled++;
		return true;
	}
	
	/**
	 * checks the movie collection to see if a movie is inside it. 
	 * @param movie to be found
	 * @return true if it the movie is inside. Returns false if not, or if movie is null
	 */
	public boolean findMovie(Movie movie) {
		//TODO implement finding a certain movie
		// Use .equals() to decide if it is the same movie
		for(int i = 0; i < spotsFilled; i++) {
			if(movies[i].equals(movie)) {
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
	 * This method does the same thing as removeMovieSlow but does so in a 'faster' way.
	 * This faster remove function utilizes the fact that the movies array does not have to be sorted at all times.
	 * and the fact that shifting the array whole array over 1 index is very time consuming.
	 * @param movie. Must not be null. Otherwise throw an IllegalArgumentException
	 * @return false if the movie is not in the array, true if it was found and subsequently removed.
	 */
	public boolean removeMovie(Movie movie) {
		//TODO implement removing in a faster way
		// find the element to remove
		// then pick an element to copy over the one you are removing
		// think about which one you can easily move without breaking anything
		int n = spotsFilled;
		for(int i=0; i<n; i++) {
			if(movies[i].equals(movie)) {
				movies[i]=movies[spotsFilled-1];
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
	 * Sorts the collection based on Year made, from oldest to newest.
	 * Among movies with the same year, sorts alphabetically by title
	 * (You may want to use the compareTo method written in the Movie Class).
	 * You should use Selection Sort here.
	 * If you use insertion sort again, you will lose points
	 */
	public void sortByYearTitle() {
		// use the Movie compareTo method to help
		int n = spotsFilled;
		int minIndex;
		Movie temp;
		for(int i=0; i<n-1; i++) {
			minIndex = i;
			for(int j = i+1; j<n; j++) {
				if(movies[j].compareTo(movies[minIndex]) != 1) {
					minIndex = j;
				}
				
			}
			temp = movies[minIndex];
			movies[minIndex] = movies[i];
			movies[i] = temp;
		}
		
	}
	
	/**
	 * Return the first n Movies in a new array
	 * @param n the number of Movies to return
	 * @return the array of the first n movies
	 * @throws IllegalArgumentException if n is not valid
	 */
	public Movie[] getFirstMovies(int n) {
		//TODO return a new array with the first n movies
		if(n<0 || n>movies.length) throw new IllegalArgumentException("n is invalid");
		Movie[] newCopy = new Movie[spotsFilled + 1];
		System.arraycopy(movies, 0, newCopy, 0, spotsFilled);
			return newCopy;
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
	

	

	

}
