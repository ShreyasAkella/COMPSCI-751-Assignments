import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.math.*;

/*
 * Maintains information about a game of spyfall
 * It uses a map to keep track of what role each player has
 * It uses another map to keep track of which roles exist for each possible location
 */

public class Spyfall {

	

	private final static String[] locationList = {"Ski Lodge","Bank","Beach"};
	private final Role spy = new Role();
	private Map<String, String[]> locationMap;
	private Map<Player,Role> playerMap;
	
	/**
	 * initialize both maps, and populate the locationMap with the corresponding String array of roles.
	 * mapping locations to the list of roles they have. 
	 */
	public Spyfall() {
		 playerMap = new HashMap<Player, Role>();
		 locationMap = generateLocationMap();
	}
	
	private static Map<String, String[]> generateLocationMap() {
		 String[] skiLodge = {"Ski Patrol", "Lift Technician", "Tourist", "Ski Instructor", "Owner"};
		 String[] bank = {"Teller", "Robber", "Customer", "Custodian", "Owner"};
		 String[] beach = {"Surfer", "Lifeguard", "Tourist", "Fisher", "Park Ranger"};
		 
		 //TODO create a hashmap of string to string array
		 //it should map each location to the array of roles for that location
		 //return the map after storing the associations
		 Map<String,String[]> map = new HashMap<String,String[]>();	 
		 map.put(locationList[0],skiLodge);	 
	     map.put(locationList[1],bank);
    	 map.put(locationList[2],beach);
	return map;
	}
	
	
	
	/**
	 * clears the playerMap to be ready to start a new game.
	 */
	public void resetGame() {
		//TODO call clear on the player map
		playerMap.clear();
	}
	
	/**
	 * checks to see if the given location is in the locationMap.
	 * @param location
	 * @return whether the location is in the locationMap
	 */
	public boolean containsLocation(String location) {
		//TODO return true iff a player with the given name is in the player map
		for (Map.Entry<String,String[]> entry : locationMap.entrySet()) {
		if(entry.getKey().equals(location))
			return true;				
		}
		return false;
	}
	
	/**
	 * checks to see if the given player is in the playerMap.
	 * @param player
	 * @return whether the player is in the playerMap
	 */
	public boolean containsPlayer(Player player) {
		//TODO return true iff a player with the given name is in the player map
		
		 // using for-each loop for iteration over playerMap.entrySet() 
		for (Map.Entry<Player,Role> entry : playerMap.entrySet()) {
			if(entry.getKey().equals(player))
				return true;
		}	
		return false;
	}
	
	/**
	 * let a player check what role they received
	 * @param name
	 * @return the role assigned to that player
	 */
	public Role getRole(Player player) {
		//TODO return the role for that player, or null if that player has no role
		// using for-each loop for iteration over playerMap.entrySet() 
		for (Map.Entry<Player,Role> entry : playerMap.entrySet()) {
			if(entry.getKey().equals(player))
				return entry.getValue();
		}		
		return null;
	}
	
	
	/**
	 * starts a new game of 'spyfall' with the players inside the players array. To start a game first
	 * assign a spy, and then assign normal roles.
	 * @param players
	 * @throws IllegalArgumentException if players is null or empty.
	 */
	public void startGame(ArrayList<Player> players) {
		if(players == null) {
			throw new IllegalArgumentException("players cannot be null");
		}
		if(players.isEmpty()) {
			throw new IllegalArgumentException("players cannot be empty");
		}
		assignSpy(players);
		
		assignNormalRoles(players);
	}
	
	
	/**
	 * randomly selects one of the players to become the spy. should use the PlayerMap to map that Player
	 * to the role of spy. This method should be called directly before assignNormalRoles is called.
	 * @param players
	 */
	public void assignSpy(ArrayList<Player> players) {
		//TODO choose a player randomly
		//assign that player the spy role in the player map
		Random rand = new Random(); 
		if(playerMap.size()==0) {
		 int sizeOf = players.size();
		 //random number generator
		int random = rand.nextInt(sizeOf);
	     playerMap.put(players.get(random), spy);
		}
	     
	}
	
	

	
	/**
	 * assigns roles to the rest of the players. this method should be called directly after assignSpy is called.
	 * That also means before this method is called, there is exactly one player (the spy) inside the playerMap.
	 * use a random number to get the name of a location, then use the locationMap to get the list of roles.
	 * use this list to give the remaining players each a different role.
	 * @param players
	 */
	public void assignNormalRoles(ArrayList<Player> players){
		//TODO randomly choose one of the locations from locationList
		//for the chosen location, get the corresponding array of roles from the location map
		//give each player a role from that array (in the player map)
		//UNLESS that player is already the spy
		//if there are as many non-spy players as roles (or fewer players) this should give each player a different role
		//if there are more, you can repeat roles		 
		 String[] roles = null; 
		 Random rand = new Random();
		 int length = locationList.length;
	     int random = rand.nextInt(length);
	     String location = locationList[random] ;    
	     for (Map.Entry<String,String[]> entry : locationMap.entrySet()) {
	    	 if(entry.getKey().equals(location))
	    		 roles=entry.getValue();
	     }
	     int index=0,player=0;
	     while( player<=players.size()-1) {
	    	 if(!containsPlayer(players.get(player))) {
		    		 Role role = new Role(location,roles[index]);
		    		 playerMap.put(players.get(player), role);
		    		 index++;
		    		 if(index == roles.length)
		    			 index=0;
	    	 }
	    	 player++;
	     
	     }    
	}
	
	
	
	/**
	 * checks if the player was the spy, and if they were, all the players who were not the spy win.
	 * if the guessed player was not the spy, the spy wins.
	 * (remember to addWin() to all the wining players)
	 * Then reset the game.
	 * @param player the player guessed
	 * @throws IllegalArgumentException if the player given was not in the playerMap.
	 * @return A String saying who won.
	 */
	public String checkIfSpy(Player player) {
		//TODO make sure the player map contains this player
		//check if the player has the spy role
		//if so, add a win for each non-spy in the map (use keySet)
		//	and return "The Non-Spies Win!"
		//if not, add a win for the spy (again use keySet - this operation is not efficient)
		//  return "The Spy Wins!"
		//either way, reset the game before returning
		int temp=0;
		for (Map.Entry<Player,Role> entry : playerMap.entrySet()) 
	    	 if(entry.getKey().equals(player)) 
	    		 temp= 1;	
		if(temp==0)
			throw new IllegalArgumentException();
	
		 
		
		for (Map.Entry<Player,Role> entry : playerMap.entrySet()) {
	    	 if(entry.getKey().equals(player)&&entry.getValue().equals(spy)) {
	    			 for(Player k : playerMap.keySet()) 
	    				 if(!k.equals(entry.getKey()))
	    					 k.addWin();		 	 
	         resetGame();
	         return "The Non-Spies Win!";
	    	 }    		 
	    	 }
		 	
		
		 for (Map.Entry<Player,Role> entry : playerMap.entrySet()) 
		    	if(entry.getValue().equals(spy)) {
		    			entry.getKey().addWin();
		    			resetGame();
		    			return "The Spy Wins!";
		    	}		 
	 return "The Spy Wins!";
	 
	}
		
	/**
	 * prints out all the players and their roles. 
	 */
	public String toString() {
		if(playerMap.isEmpty())
			return "The game has not started yet";
		
		else {
			String output = "";
			for (Player person : playerMap.keySet()) {
				output = output + person.toString() + " " + playerMap.get(person).toString()+ "\n";
		    }
			return output;
		}
	}	
}


