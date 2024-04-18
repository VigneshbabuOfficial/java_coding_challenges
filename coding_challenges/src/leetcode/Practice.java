package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {

		// ------------- FEB-14,2024 ----------------
		// check valid pairs
		// REF : https://leetcode.com/problems/valid-parentheses/description/
		// status : SOLVED
		isValidParenthesis("()");
		isValidParenthesis("()[]{}");
		isValidParenthesis("([])");
		isValidParenthesis("([}])");

		// ------------- FEB-15,2024 ----------------
		// Remove Duplicates from Sorted Array
		// REF : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
		// status : throwing error in the output couldn't find the reason
		removeDuplicates();

		// Remove Element
		// REF : https://leetcode.com/problems/remove-element/description/
		// status :
		removeElement();

		// ------------- FEB-28,2024 ----------------
		// REF :
		// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
		findTheIndexOfTheFirstOccurrenceInAString();
		// status : DONE

		// SEARCH INSERT POSITION :
		// https://leetcode.com/problems/search-insert-position/description/
		searchInsertPosition();
		// status : DONE

		// ------------- MAR-04,2024 ----------------
		// Add Two Numbers : https://leetcode.com/problems/add-two-numbers/description/
		addTwoNumbers();
		// status : NOT DONE. As its output is ListNode

		// ------------- MAR-05,2024 ----------------
		// Longest substring without repeating characters :
		// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
		System.out.println("----- Longest substring without repeating characters *** begins ------- ");
		lengthOfLongestSubstring();
		// status : pending
		System.out.println("----- Longest substring without repeating characters *** ends ------- ");

		// ------------- APR-18,2024 ----------------
		// Difficulty : EASY
		// Length of Last Word :
		// https://leetcode.com/problems/length-of-last-word/description/
		System.out.println("----- Length of Last Word *** begins ------- ");
		lengthOfLastWord();
		// status : Accepted & Success
		System.out.println("----- Length of Last Word *** ends ------- ");

		// Difficulty : MEDIUM
		// Zigzag Conversion :
		// https://leetcode.com/problems/zigzag-conversion/description/
		System.out.println("----- Zigzag Conversion *** begins ------- ");
		printZigZagPattern(5);
		// status : Pending
		System.out.println("----- Zigzag Conversion *** ends ------- ");

	}

	public static void printZigZagPattern(int n) {

		for (int i = 1; i <= n; i++) {

		}
	}

	private static void lengthOfLastWord() {
		lengthOfLastWord("Hello World");
	}

	public static int lengthOfLastWord(String s) {
		String[] wordArr = Arrays.stream(s.split(" ")).filter(str -> str.trim().length() > 0).toArray(String[]::new);
		int lengthOfLastword = wordArr[wordArr.length - 1].length();
		System.out.println(" lengthOfLastWord = " + lengthOfLastword);
		return lengthOfLastword;
	}

	private static void lengthOfLongestSubstring() {
//		System.out.println("abcd1233444".startsWith("abcd"));
		lengthOfLongestSubstring("abcabcbb");

	}

	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();
		int maxLen = 0;
		int left = 0;
		int right = 0;

		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				maxLen = Math.max(maxLen, set.size());
				right++;
			} else {
				set.remove(s.charAt(left));
				left++;
			}
		}

		System.out.println(" string = " + s + " set = " + set + ", max length = " + maxLen);

		return maxLen;
	}

	private static void addTwoNumbers() {
		addTwoNumbers(Arrays.asList(2, 4, 3), Arrays.asList(5, 6, 4));
		addTwoNumbers(Arrays.asList(0), Arrays.asList(0));
		addTwoNumbers(Arrays.asList(9, 9, 9, 9, 9, 9, 9), Arrays.asList(9, 9, 9, 9));
	}

	private static void addTwoNumbers(List<Integer> list_1, List<Integer> list_2) {

		List<Integer> list_3 = new ArrayList<>();

		int quotient = 0;

		for (int i = 0; i < list_1.size(); i++) {
			int sum = quotient + list_1.get(i) + (i < list_2.size() ? list_2.get(i) : 0);
			if (sum >= 10) {
				list_3.add(sum % 10);
				quotient = sum / 10;
			} else {
				list_3.add(sum);
				quotient = 0;
			}
		}
		System.out.println(" list_1 = " + list_1);
		System.out.println(" list_2 = " + list_2);
		System.out.println(" list_3 = " + list_3);
	}

	private static void searchInsertPosition() {
		System.out.println(" -------- searchInsertPosition -------- ");
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 4));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 6));
		System.out.println(searchInsert(nums, 9));
	}

	public static int searchInsert(int[] nums, int target) {
		for (int index = 0; index < nums.length; index++) {

			if (nums[index] >= target)
				return index;

			if (index == nums.length - 1 && target > nums[index])
				return index + 1;

		}
		return 0;
	}

	private static void findTheIndexOfTheFirstOccurrenceInAString() {
		System.out.println(" -------- findTheIndexOfTheFirstOccurrenceInAString -------- ");
		System.out.println(strStr("sadbutsad", "sad"));
		System.out.println(strStr("leetcode", "leeto"));
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("a", "a"));
	}

	public static int strStr(String haystack, String needle) {

		int strLength = haystack.length();

		for (int index = 0; index < strLength; index++) {
			if (haystack.substring(index, strLength).startsWith(needle)) {
				return index;
			}
		}
		return -1;
	}

	private static void removeElement() {

		int[] nums = { 3, 2, 2, 1, 5, 8, 3 };
		int val = 3;
		final int count = (int) Arrays.stream(nums).filter(e -> e != val).count();
		System.out.println(count);
	}

	private static void removeDuplicates() {
		int[] nums = { 1, 2, 3, 2, 3 };
		final List<Integer> uniqueList = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
		System.out.println(uniqueList);
	}

	private static boolean isValidParenthesis(String s) {

		Map<String, Long> charsCountMap = Stream.of(s.split(""))
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

		System.out.println("input = " + s);
//		System.out.println("charsCountMap = " + charsCountMap);

		// validating pairs count
		boolean isValidPairs = isValidPairs(charsCountMap, "(", ")") && isValidPairs(charsCountMap, "{", "}")
				&& isValidPairs(charsCountMap, "[", "]");
		System.out.println("validating pairs count = " + (isValidPairs ? "OK" : "NOT OK"));

		// validating order of the pairs
		Map<Character, Character> mappings = new HashMap<>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (mappings.containsKey(c)) {
				char topElement = stack.isEmpty() ? '#' : stack.pop();
				if (topElement != mappings.get(c))
					return false;
			} else
				stack.push(c);
		}

		return isValidPairs;

	}

	private static boolean isValidPairs(Map<String, Long> pairsMap, String opening, String closing) {
		return pairsMap.getOrDefault(opening, 0L).equals(pairsMap.getOrDefault(closing, 0L));
	}

}
