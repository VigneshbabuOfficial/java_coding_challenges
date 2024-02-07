package others;

import java.util.Collections;
import java.util.List;

public class LargestAmong3Numbers {
	public static void main(String[] args) {
		
		findLargest();
		findLargestNum(12, 20, 5);
		findLargestNum(20, 12, 5);
		findLargestNum(5, 20, 12);
		findLargestNum(5, 5, 12);
		findLargestNum(5, 12, 5);
		findLargestNum(12, 5, 5);
		findLargestNum(5, 5, 5);
		System.out.println("-----------------");
		find2ndLargestNum(12, 20, 5);
		find2ndLargestNum(20, 12, 5);
		find2ndLargestNum(5, 20, 12);
		find2ndLargestNum(5, 5, 12);
		find2ndLargestNum(5, 12, 5);
		find2ndLargestNum(12, 5, 5);
		find2ndLargestNum(5, 5, 5);
	}
	
	private static void findLargest() {

		List<Integer> numList = List.of(8, 111, 45, 455, 500);

		// find largest number
		int largestNum = 0;
		for (int i = 1; i < numList.size(); i++) {
			if (numList.get(i) > largestNum)
				largestNum = numList.get(i);
		}
		System.out.println("1 - largest among " + numList + " is " + largestNum);

		// find second largest number
		largestNum = 0;
		int secLargestNum = 0;
		for (int i = 1; i < numList.size(); i++) {
			if (numList.get(i) > largestNum) {
				secLargestNum = largestNum;
				largestNum = numList.get(i);
			} else if (numList.get(i) > secLargestNum && numList.get(i) != largestNum)
				secLargestNum = numList.get(i);
		}
		System.out.println("1 - second largest among " + numList + " is " + secLargestNum);

		// finding largest number using stream API
		final Integer largest = numList.stream().max(Integer::compareTo).orElse(0);
		System.out.println("largest among " + numList + " is " + largest);

		// finding second largest number using stream API
		final int secLargest = numList.stream().sorted((a, b) -> b.compareTo(a)).skip(1).findFirst().get();
		System.out.println("second largest among " + numList + " is " + secLargest);

	}

	private static void find2ndLargestNum(final int num1, final int num2, final int num3) {

		// second largest among 3 nos
		// second largest among list
		List<Integer> numList = List.of(num1, num2, num3);
		int secondLargest = 0, largest = 0;
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) > largest) {
				secondLargest = largest;
				largest = numList.get(i);
			} else if (numList.get(i) > secondLargest && numList.get(i) != largest) {
				secondLargest = numList.get(i);
			}
		}

		System.out.println(
				"second largest among 3 numbers " + num1 + ", " + num2 + " & " + num3 + " is 2>" + secondLargest);
		System.out.println("-----------------");

		// largest among list
//		System.out.println("Largest among number List Collections.max(numList) = " + num1 + ", " + num2 + " & " + num3 + " is >"+ Collections.max(numList));
//		System.out.println("-----------------");
	}

	private static void findLargestNum(final int num1, final int num2, final int num3) {

		// largest among 3 nos or list
		List<Integer> numList = List.of(num1, num2, num3);
		int largest = 0;
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) > largest) {
				largest = numList.get(i);
			}
		}
		System.out.println("largest among 3 numbers " + num1 + ", " + num2 + " & " + num3 + " is >" + largest);
		System.out.println("-----------------");
	}
}
