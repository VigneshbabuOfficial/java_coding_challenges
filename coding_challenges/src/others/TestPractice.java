package others;

import java.util.Arrays;
import java.util.List;

public class TestPractice {

	public static void main(String[] args) {
		// print fibonacci upto 100
		System.out.println("------------------ FIBONACCI NUMBERS ------------------- ");
//		printFibonacci(100);
		// print prime numbers
		System.out.println("------------------ PRIME NUMBERS ------------------- ");
//		printPrimeNumbers(1000);
		System.out.println("------------------ ARMSTRONG NUMBERS ------------------- ");
//		printArmstrongNumber(1000);

		// Arrays.asList features
		Integer[] numArr = new Integer[] { 1, 2, 3, 4, 5 };
		// feature 1: we cant add / remove elements from the List
		List<Integer> numList = Arrays.asList(numArr);
//		numList.add(7);
//		 Exception in thread "main" java.lang.UnsupportedOperationException

		// feature 2: List instance will get same effect if the source is modified
		System.out.println(" numList.get(1) = " + numList.get(1)); // numList.get(1) = 2
		numArr[1] = 2000;
		System.out.println(" numList.get(1) = " + numList.get(1)); // numList.get(1) = 2000

		// feature 3: its mutable so we can update the List elements
		numList.set(2, 9999);
		System.out.println(" numList.get(2) = " + numList.get(2)); // numList.get(2) = 9999

		// feature 4: null is allowed to add in the List
		numList.set(3, null);
		System.out.println(" numList.get(3) = " + numList.get(3)); // numList.get(3) = null

		System.out.println("----------- FEATURES OF LIST.OF ---------------- ");
		Integer[] numArr1 = new Integer[] { 1, 2, 3, 4, 5 };
		// feature 1: we cant add / remove elements from the List
		List<Integer> numList1 = List.of(numArr1);
		// numList1.add(7);
		// Exception in thread "main" java.lang.UnsupportedOperationException

		// feature 2: List instance won't get effect if the source is modified
		System.out.println(" numList1.get(1) = " + numList1.get(1)); // numList1.get(1) = 2
		numArr1[1] = 2000;
		System.out.println(" numList1.get(1) = " + numList1.get(1)); // numList1.get(1) = 2000

		// feature 3: its immutable so we can't update the List elements
		// numList1.set(2, 9999);
		System.out.println(" numList1.get(2) = " + numList1.get(2)); // numList.get(2) = 9999
		// Exception in thread "main" java.lang.UnsupportedOperationException

		// feature 4: List.of doesn't allow null value
		Integer[] numArr2 = new Integer[] { 1, null, 3, 4, 5 };
		List<Integer> numList2 = List.of(numArr2);
		// Exception in thread "main" java.lang.UnsupportedOperationException
	}

	private static void printArmstrongNumber(final int limit) {

	}

	private static void printPrimeNumbers(final int limit) {
		boolean isPrime = false;
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
				isPrime = false;
			}
		}
	}

	private static void printFibonacci(final int limit) {
		StringBuilder result = new StringBuilder("0, 1");
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		for (int i = 1; i <= limit; i++) {
			if (i > 1) {
				n3 = n1 + n2;
				if (n3 > limit)
					break;
				result.append(", " + n3);
				n1 = n2;
				n2 = n3;

			}
		}
		System.out.println("Fibonacci - result = " + result.toString());
	}

}
