public class MyClass {
	
	
	/**
	 * Look at (and run) the tests that start with "test" in "TestClass.java". 
	 * You will make changes in this file so that those tests pass.
	 * For the array methods, it will be easier to find the bugs using the debugger.
	 * 
	 */
	public static String str1() {
		return "this is the incorrect string";
	}
	public static String str2() {
		return "Helld Wirld";
	}
	public static String str3(){
		return "";
	}
	
	public static String constant1() {
		return "24";
	}
	public static boolean constant2() {
		return true;
	}
	public static char constant3() {
		return 'J';
	}
	
	
	
	/**
	 * @param size of new array
	 * @return an array of powers of 2 up to size.
	 * IE: if size = 4, completeArray = {1,2,4,8}.
	 */
	public static int[] arrayFiller(int size) {
		int[] completeArray = new int[size];
		int curNum=0;
		for(int i = 0; i<size; i++) {
			completeArray[i] = curNum;
			curNum = curNum*2;
		}
		
		return completeArray;
	}
	/**
	 * @param an array of int's
	 * @return sum of all the elements in the array.
	 */
	public static int arraySum(int[] arr) {
		int sum = 0;
		for(int i = 0; i<=arr.length; i++) {
			sum = arr[i];
		}
		return sum;
	}
	
	/**
	 * this method works as expected.
	 * using the Javadoc here, write at least 4 different tests in the "testDeVoweler" section of the Test_File.
	 * @param input: any string
	 * @param vowel: a char
	 * @return returns the input string, with all instances of the specified vowel removed. 
	 * If the char given is not a vowel, returns null.
	 * If the input itself is null, return null.
	 */
	public static String deVoweler(String input, char vowel) {
		if(input ==null)
			return null;
		
		switch(vowel) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				break;
			default:
				return null;
		}
		String vow=String.valueOf(vowel);  
		input = input.replace(vow, "");
		
		return input;
	}	
	
	/*
	 * This method returns an array that contains the sorted contents of arr
	 * It repeatedly finds the smallest char in arr, copies it to the new array, and then replaces
	 * that char in arr with a 0 to mark that it has been taken already. Therefore it skips over
	 * any 0 values that it sees.
	 * This algorithm has a bug! (Hint: 0 could be a valid value for a char!)
	 */
	public static char[] sorter(char[] arr) {
		char[] result = new char[arr.length];
		boolean anythingFound;
		int count = 0;
		do {
			int smallestIndex = -1;
			anythingFound = false;
			//Find the smallest remaining char, skipping already removed chars
			for(int i=0; i<arr.length; i++) {
				if (arr[i] == 0)
					continue;
				if (anythingFound == false || arr[i] < arr[smallestIndex]) {
					smallestIndex = i;
					anythingFound = true;
				}
			}
			if (anythingFound) {
				result[count++] = arr[smallestIndex];
				arr[smallestIndex] = 0;
			}
				
		} while (anythingFound);
		return result;
	}
	
}
