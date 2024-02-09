package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Feb082024 {

	public static void main(String[] args) {

		// palidrome number
		findPalidrome();

		// find longest common String
		findLongestCommonString();
	}

	private static void findLongestCommonString() {
		String[] strs = { "flower", "flow", "flight" };
		String commonStr = longestCommonPrefix(strs);
		System.out.println("the longest common string  is " + commonStr);
	}

	public static String longestCommonPrefix(String[] strs) {

		final String maxStr = Arrays.asList(strs).stream().max(Comparator.comparing(String::length)).get();
		char[] strToCheck = maxStr.toCharArray();

		StringBuilder longestCommonPrefix = new StringBuilder("");

		for (int i = 0; i < strToCheck.length; i++) {

			String chrToCheck = longestCommonPrefix.toString() + strToCheck[i];

			if (Arrays.asList(strs).stream().allMatch(strData -> strData.startsWith(chrToCheck))) {

				longestCommonPrefix.append(strToCheck[i]);

			}
		}

		return longestCommonPrefix.toString();
	}

	private static void findPalidrome() {
		int num = 121;
		System.out.println(isPalindrome(num) ? num + " is a palidrome " : num + " is not a palindrome");
	}

	public static boolean isPalindrome(int num) {
		int remainder = 0;
		int quotient = 0;
		int sum = 0;
		int temp = num;

		do {
			quotient = temp / 10;
			remainder = temp % 10;
			sum = (sum * 10) + remainder;
			temp = quotient;
		} while (quotient > 0);

		return sum == num;
	}

}
