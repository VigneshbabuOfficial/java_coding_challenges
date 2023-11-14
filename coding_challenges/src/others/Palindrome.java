package others;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	public static void main(String[] args) {
		int number = 546;
		if (isPalindrome(number))
			System.out.println(number + " is a Palindrome.");
		else
			System.out.println(number + " is not a Palindrome.");
		getPalindrome(1, 1000);
	}

	private static void getPalindrome(int start, int end) {
		List<Integer> palindromeList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			if (isPalindrome(i))
				palindromeList.add(i);
		}
		System.out.println(palindromeList);
	}

	private static boolean isPalindrome(int number) {
		int quotient = 0;
		int remainder = 0;
		int sum = 0;
		int tempNum = number;
		do {
			quotient = tempNum / 10;
			remainder = tempNum % 10;
			sum = (sum * 10) + remainder;
			tempNum = quotient;
		} while (quotient > 0);
		return sum == number;
	}
}
