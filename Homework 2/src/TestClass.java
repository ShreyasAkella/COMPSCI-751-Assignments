import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TestClass extends TestCase{
	
	public void setUp() {
	}
	
	
	public void testStrings() {
		assertTrue(true);
		assertEquals("this is the correct string", MyClass.str1());
		assertEquals("Hello World", MyClass.str2());
		assertEquals(" ", MyClass.str3());
	}
	
	
	public void testTypes() {
		assertEquals(24, MyClass.constant1());
		assertEquals("true", MyClass.constant2());
		assertEquals("J", MyClass.constant3());
	}
	
	public void testArrayFiller() {
		int[] testArray = MyClass.arrayFiller(0);
		int[] expected = new int[]{};
		assertArrayEquals(expected, testArray);
		
		testArray = MyClass.arrayFiller(4);
		expected = new int[]{1,2,4,8};
		assertArrayEquals(expected, testArray);
		
		testArray = MyClass.arrayFiller(6);
		expected = new int[]{1,2,4,8,16,32};
		assertArrayEquals(expected, testArray);
	}
	
	
	public void testArraySum() {
		int[] arrayToSum = new int[]{1,2,4,8};
		int expected = 15;
		int computedSum =MyClass.arraySum(arrayToSum);
		assertEquals(expected, computedSum);
		
		arrayToSum = new int[]{1,2,4,8,16,32,64,128};
		expected = 255;
		computedSum =MyClass.arraySum(arrayToSum);
		assertEquals(expected, computedSum);
	}
	
	//write at least 4 tests for the DeVoweler. 
	//these tests should pass!
	public void testDeVoweler() {
		
		//TODO Write a few tests for the deVoweler method.
		//cover at least these cases:
		//1. the string contains the vowel passed
		//2. the string is not empty, but does not contain the vowel passed
		//3. the string is empty
		//4. the character passed is not a vowel
		
	}
	
	
	public void testSorter() {
		char[] arrayToSort = new char[]{'a', 'b', 'c', 'd'};
		char[] expected = new char[]{'a', 'b', 'c', 'd'};
		assertArrayEquals(expected, MyClass.sorter(arrayToSort));
		
		arrayToSort = new char[]{};
		expected = new char[]{};
		assertArrayEquals(expected, MyClass.sorter(arrayToSort));
		
		arrayToSort = new char[]{'w', 'e', 'r', 's', 'b', 'd', 'a'};
		expected = new char[]{'a', 'b', 'd', 'e', 'r', 's', 'w'};
		assertArrayEquals(expected, MyClass.sorter(arrayToSort));
		
		arrayToSort = new char[]{'3', '2', '2', '0'};
		expected = new char[]{'0', '2', '2', '3'};
		assertArrayEquals(expected, MyClass.sorter(arrayToSort));
		
		//TODO write an assertion that SHOULD pass, but fails because of the bug
	}
	
}
