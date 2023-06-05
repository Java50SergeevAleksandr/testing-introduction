package telran.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysInt {
	
	public static int getRandomInt() {
		Random gen = new Random();
		return gen.nextInt();
	}
	
	public static int[] addNumber(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;
		return res;
	}

	public static int[] insertNumber(int[] array, int index, int number) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	public static int[] removeNumber(int[] array, int index) {
		// returns array with no number at the given index
		int[] res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, res.length - index);
		return res;
	}

	public static int[] insertNumberSorted(int[] arraySorted, int number) {
		// takes sorted array and number to insert
		// returns sorted array with the given number at a proper position
		// apply the standard method of the class Arrays int binarySearch(int[]
		// arraySorted, int key)
		int[] res = new int[arraySorted.length + 1];
		int index = Arrays.binarySearch(arraySorted, number);

		if (index < 0) {
			index = -(index + 1);
		}

		res = insertNumber(arraySorted, index, number);
		return res;
	}

	public static int searchNumber(int[] array, int number) {
		// searching for the given number in the given array
		// returns index value for the number if exists otherwise false
		int index = 0;
		while (index < array.length && array[index] != number) {
			index++;
		}
		return index < array.length ? index : -1;
	}

	public static int binarySearchPart(int[] array, int number) {
		// searching for the given number in the given array that should be sorted
		// returns index value for the number if exists otherwise -1
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && array[middle] != number) {
			if (number < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left <= right ? middle : -1;
	}

	public static void quickSort(int[] array) {
		Arrays.sort(array);
	}

	public static void bubbleSort(int[] array) {
		int length = array.length;
		boolean flSorted = false;
		do {
			flSorted = true;
			length--;
			for (int i = 0; i < length; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flSorted = false;
				}
			}
		} while (!flSorted);
	}

	private static void swap(int[] array, int i, int j) {
		// ONLY for interview task of swapping with no additional variable
		// array[i] = array[i] + array[j];
		// array[j] = array[i] - array[j];
		// array[i] = array[i] - array[j];
		//
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// ==============HW===============//
	public static int binarySearch(int[] array, int number) {
		// searching for the given number in the given array that should be sorted
		// returns index value for the number if exists otherwise -1   

		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;

		while (left <= right && (array[middle] != number || middle != 0 && array[middle - 1] == number)) {
			if (number > array[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}

			middle = (left + right) / 2;
		}
		return left <= right ? middle : -(getEntryPoint(left, array.length) + 1);
	}

	private static int getEntryPoint(int left, int length) {
		return left == (length - 1) ? length : left;
	}

}