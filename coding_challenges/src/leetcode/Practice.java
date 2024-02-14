package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {

		// ------------- FEB-14,2024 ----------------
		// check valid pairs
		// REF : https://leetcode.com/problems/valid-parentheses/description/
		isValidParenthesis("()");
		isValidParenthesis("()[]{}");
		isValidParenthesis("([])");
		isValidParenthesis("([}])");


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
