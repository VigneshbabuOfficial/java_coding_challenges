package others;

import java.util.Collections;
import java.util.List;

public class LargestAmong3Numbers {
	public static void main(String[] args) {
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
