import java.util.Scanner;
import java.util.random;

public class Stringcheck
{
public class void main(Strings[] args)
{
	Scanner stdIn = new Scanner (system.in);
	char response;
	int numberEntry;
	
	
	system.out.print ln("Enter an integer");
	numberEntry = std.nextInt();
	
	do {
		
		
		
		
	}while (response == "y"||"y") 
	
}

public static string (int numberEntry)
{
	char[] characterArray;
	int arraySize = numberEntry;
	char max = "a";
	char min = "z";
	String theRandomArray;
	int count = 0;
	
	for(int=0; i<arraySize; i++) {
		characterArray[i] = java.util.random.nextChar;
	}
	for(int=0; i<arraySize; i++) {
		if(characterArray[i] > max) {
			characterArray[0] = characterArray[i];
	}
	}
		theRandomArray = String.valueOf(characterArray);
	for(int=0; i<arraySize; i++) {
		if(str.charAt(i) == "a"||str.charAt(i) == "e"||str.charAt(i) =="i"||str.charAt(i) =="o"||str.charAt(i) =="u")
			count++;
	}
	system.out.print ln("The random character string is " + theRandomArray);
		

}
}














