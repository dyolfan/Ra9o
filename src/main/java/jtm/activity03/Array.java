package jtm.activity03;

import java.util.Arrays;

public class Array {
	static int[] array;

	public static void arrayToInt(String[] args) {
		int[] arrayCopy = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			arrayCopy[i] = Integer.parseInt(args[i]);
		}
		array = arrayCopy;
	}

	public static void main(String[] args) {
		arrayToInt(args);
		printSortedArray();
	}

	public static void printSortedArray() {
		System.out.printf("Sorted array:%s", Arrays.toString(returnSortedArray()));
	}

	public static int[] returnSortedArray() {
		Arrays.sort(array);
		return array;
	}
}
