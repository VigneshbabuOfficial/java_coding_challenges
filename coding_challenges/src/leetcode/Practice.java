package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

			if (index == nums.length-1 && target > nums[index])
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
