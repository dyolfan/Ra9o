package jtm.extra01;

public class BasicMathFunctions {

	/**
	 * This program teaches you how to use basic math functions. It tells the
	 * story about teeth, candies and money. Fill the code inside TODO sections.
	 * don't touch other code.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// You can use main() method to test your implementation by
		// running it as a Java application
		// Note that Unit tests don't invoke this method
	}

	/**
	 * @return sum of two numbers
	 */
	public int addition(int aliceCandyCount, int maryCandyCount) {
		// #1: Alice had some candies and Mary also had some candies.
		// How many candies will Robert get if he will rob both girls?
		return aliceCandyCount + maryCandyCount;
	}

	/**
	 * @return subtraction of two numbers
	 */
	public int subtraction(int initialTeethCount, int cnockedTeethCount) {
		// #2 Robert had initialTeethCount teeth.
		// Mary's brother found out what Robert did and knocked out
		// cnockedTeethCount teeth.
		// How much teeth Robert will have left?
		return initialTeethCount - cnockedTeethCount;
	}

	/**
	 * @return multiplication of two numbers
	 */
	public int multiplication(int numberOfKnockedTeeth, int pricePerTooth) {
		// #3 Robert's parents caught Mary's brother and forced him to pay
		// pricePerTooth for each knocked Robert's tooth.
		// How much money will Robert earn?
		return numberOfKnockedTeeth * pricePerTooth;
	}

	/**
	 * @return division of two integer numbers
	 */
	public int division(int moneyForTeeth, int reduction) {
		// #4 Robert agreed to divide price per teeth by reduction
		// factor. How much money will Robert earn now?
		return moneyForTeeth / reduction;
	}

	/**
	 * @return remaining part of division of two integer numbers
	 */
	public int modulo(int income, int parts) {
		// #5 Robert is asked to pay equal share of income to his
		// brothers and himself. His brothers do not know, that not any amount
		// can be divided equally, therefore Robert can hold remaining part
		// to himself. How much will Robert hold to himself?
		return income % parts;
	}

	/**
	 * @return value increased by 1
	 */
	public int increment(int teethCount) {
		// #6 Doctors were able to fix one Robert's teeth.
		// Please increase number of Robert's teeth by one
		return ++teethCount;
	}

}
