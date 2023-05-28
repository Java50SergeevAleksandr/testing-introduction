import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTests {

	@Test
	void compareTo() {
		String str = "Hello";		
		assertEquals(0, str.compareTo("Hello"));
		assertEquals(1, str.compareTo("Hell"));
		assertEquals(-2, str.compareTo("Hello!!"));
		assertEquals(4, str.compareTo("Dello"));
		assertEquals(-1, str.compareTo("Hellp"));
	}

	@Test
	void compareToIgnoreCase() {
		String str = "Hello";		
		assertEquals(0, str.compareToIgnoreCase("hello"));		
		assertEquals(1, str.compareToIgnoreCase("Hell"));
		assertEquals(-2, str.compareToIgnoreCase("hello!!"));
		assertEquals(4, str.compareToIgnoreCase("Dello"));
		assertEquals(-1, str.compareToIgnoreCase("HellP"));
	}
	
	@Test
	void concat() {
		String str = "Hello";
		assertEquals("Hello", str.concat(""));
		assertEquals("Hello!", str.concat("!"));
		assertEquals("Hello there!", str.concat(" ").concat("there!"));
	}
	
	@Test
	void startsWith() {
		String str = "Hello";
		assertTrue(str.startsWith("He"));
		assertFalse(str.startsWith("Me"));
		assertFalse(str.startsWith(" "));
		assertTrue(str.startsWith(""));
		assertTrue(str.startsWith("Hello"));
	}
	
	@Test
	void endWith() {
		String str = "Hello";
		assertTrue(str.endsWith("lo"));
		assertFalse(str.startsWith("Me"));
		assertFalse(str.startsWith(" "));
		assertTrue(str.startsWith(""));
		assertTrue(str.startsWith("Hello"));
	}
	
	@Test
	void equalsIgnoreCase() {
		String str = "Hello";
		assertTrue(str.equalsIgnoreCase("helLO"));
		assertFalse(str.startsWith("Hello!"));
		assertFalse(str.startsWith("Helo "));	
		assertTrue(str.startsWith(""));
		assertTrue(str.startsWith("Hello"));
	}
	
	@Test
	void indexOfString() {
		String str = "Hello";
		assertEquals(-1, str.indexOf(" "));
		assertEquals(3, str.indexOf("lo"));		
	}
	
	@Test
	void indexOfInt() {
		String str = "Hello";
		assertEquals(2, str.indexOf(108)); // "l"
		assertEquals(-1, str.indexOf(76));// "L"			
	}
	
}
