package telran.arrays.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import telran.arrays.ArraysInt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class ArraysTests {

	private static int N_ELEMENTS = 1000000;
	private static int N_RUNS = 1000000;

	@Test
	void initialTest() {
		int[] ar1 = { 1, 2, 3 };
		int[] ar2 = { 1, 2, 3 };
		int[] ar2_3 = ar2;
		assertFalse(ar1 == ar2);
		assertTrue(ar2 == ar2_3);
		assertArrayEquals(ar1, ar2);
		ar2_3[0] = 10;
		ar1[0] = 10;
		assertArrayEquals(ar1, ar2);

	}

	@Test
	void copyOfIntTest() {
		int[] ar1 = { 10, 5, 15 };
		int[] expected1 = { 10, 5, 15 };
		int[] expected2 = { 10, 5 };
		int[] expected3 = { 10, 5, 15, 0, 0 };
		assertArrayEquals(expected1, Arrays.copyOf(ar1, 3));
		assertArrayEquals(expected2, Arrays.copyOf(ar1, 2));
		assertArrayEquals(expected3, Arrays.copyOf(ar1, 5));
	}

	@Test
	void addNumberTest() {
		int[] ar1 = { 10, 5, 15 };
		int number = 20;
		int[] expected = { 10, 5, 15, number };
		assertArrayEquals(expected, ArraysInt.addNumber(ar1, number));
	}

	@Test
	void arraycopyTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int[] dest = { 10, 20, 30, 40, 50, 60, 70 };
		int[] expected = { 10, 20, 30, 40, 1, 2, 3 };
		System.arraycopy(src, 0, dest, 4, 3);
		assertArrayEquals(expected, dest);
	}

	@Test
	void insertNumberTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int number = 20;
		int index = 3;
		int[] expected1 = { 1, 2, 3, 20, 4, 5, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.insertNumber(src, index, number));
		number = 30;
		index = 0;
		int[] expected2 = { 30, 1, 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.insertNumber(src, index, number));
		number = 40;
		index = 7;
		int[] expected3 = { 1, 2, 3, 4, 5, 6, 7, 40 };
		assertArrayEquals(expected3, ArraysInt.insertNumber(src, index, number));
	}

	@Test
	void removeNumberTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int index = 3;
		int[] expected1 = { 1, 2, 3, 5, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.removeNumber(src, index));

		index = 0;
		int[] expected2 = { 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.removeNumber(src, index));

		index = 6;
		int[] expected3 = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected3, ArraysInt.removeNumber(src, index));

		int[] src2 = { 1 };
		index = 0;
		int expected4 = 0;
		assertEquals(expected4, ArraysInt.removeNumber(src2, index).length);
	}

	@Test
	void binarySearchTest() {

		int[] src = { 1, 2, 3, 4, 5 };
		int key = 1;
		int expected1 = 0;
		assertEquals(expected1, Arrays.binarySearch(src, key));

		key = 5;
		int expected2 = 4;
		assertEquals(expected2, Arrays.binarySearch(src, key));

		key = 10;
		int expected3 = -src.length - 1;
		assertEquals(expected3, Arrays.binarySearch(src, key));

		key = 0;
		int expected4 = -1;
		assertEquals(expected4, Arrays.binarySearch(src, key));

		int[] src2 = { 1, 2, 4, 5 };
		key = 3;
		int expected5 = -3;
		assertEquals(expected5, Arrays.binarySearch(src2, key));
	}

	@Test
	void insertSortedTest() {

		int[] src = { 1, 2, 3, 4, 5 };
		int number = 10;
		int[] expected1 = { 1, 2, 3, 4, 5, 10 };
		assertArrayEquals(expected1, ArraysInt.insertNumberSorted(src, number));

		number = 2;
		int[] expected2 = { 1, 2, 2, 3, 4, 5 };
		assertArrayEquals(expected2, ArraysInt.insertNumberSorted(src, number));

		number = 0;
		int[] expected3 = { 0, 1, 2, 3, 4, 5 };
		assertArrayEquals(expected3, ArraysInt.insertNumberSorted(src, number));

		int[] src2 = { 3, 4, 5, 9, 10 };
		number = 7;
		int[] expected4 = { 3, 4, 5, 7, 9, 10 };
		assertArrayEquals(expected4, ArraysInt.insertNumberSorted(src2, number));

	}

	@Test
	void maxIntTest() {
		assertEquals(Integer.MAX_VALUE, getIntMax());
	}

	private int getIntMax() {
		int res = 1;
		while (res > 0) {
			res++;
		}

		return res - 1;
	}

	@Test
	@Timeout(3)
	void maxLongTest() {
		assertEquals(Long.MAX_VALUE, getLongMax());
	}

	private long getLongMax() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}

		return res - 1;
	}

	@Test
	void myBinarySearchTest() {

		int[] src = { 1, 2, 3, 4, 5 };
		int key = 1;
		int expected1 = 0;
		assertEquals(expected1, ArraysInt.binarySearch(src, key));

		key = 5;
		int expected2 = 4;
		assertEquals(expected2, ArraysInt.binarySearch(src, key));

		key = 10;
		int expected3 = -src.length - 1;
		assertEquals(expected3, ArraysInt.binarySearch(src, key));

		key = 0;
		int expected4 = -1;
		assertEquals(expected4, ArraysInt.binarySearch(src, key));

		int[] src2 = { 1, 2, 4, 5 };
		key = 3;
		int expected5 = -3;
		assertEquals(expected5, ArraysInt.binarySearch(src2, key));
	}

	@Test
	void binarySearchRepeatedNumbersTest() {

		int[] src = { 1, 2, 3, 4, 4, 4, 4, 5, 6 };
		int key = 4;
		int expected1 = 3;
		assertEquals(expected1, ArraysInt.binarySearch(src, key));

	}

	@Test
	void muchRepeatedTest() {
		int[] array = new int[N_ELEMENTS];
		for (int i = 0; i < N_RUNS; i++) {
			assertEquals(0, ArraysInt.binarySearch(array, 0));
		}
	}

	@Test
	void sortingSpeedBubbleSortTest() {
		int[] array = new int[100000];
		for (int i = 0; i < array.length; i++) {
			array[i] = ArraysInt.getRandomInt();
		}

		int[] res = Arrays.copyOf(array, array.length);

		ArraysInt.bubbleSort(array);
		Arrays.sort(res);

		assertArrayEquals(res, array);

	}

	@Test
	void sortingSpeedQuickSortTest() {
		int[] array = new int[100000];

		for (int i = 0; i < array.length; i++) {
			array[i] = ArraysInt.getRandomInt();
		}

		int[] res = Arrays.copyOf(array, array.length);

		ArraysInt.quickSort(array);
		Arrays.sort(res);

		assertArrayEquals(res, array);

	}

}