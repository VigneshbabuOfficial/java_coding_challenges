package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {

		// ------------- FEB-13,2024 ----------------
		// REF :
		// https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
		miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));

		// REF : https://www.hackerrank.com/challenges/staircase/problem
		staircase(6);

		// ------------- FEB-27,2024 ----------------
		// REF :
		// https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
		kangarooJump();

		// ------------- FEB-28,2024 ----------------
		// Subarray Division -

		// ------------- MAR-04,2024 ----------------
		// Climbing Leader Board :
		// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
		System.out.println("----- Climbing Leader Board *** begins ------- ");
		climbingLeaderboard();
		// status : DONE but some test cases shows execution timeout exceeded
		System.out.println("----- Climbing Leader Board *** ends ------- ");

		// ------------- MAR-05,2024 ----------------
		// Extra Long Factorial :
		// https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
		System.out.println("----- Extra Long Factorial *** begins ------- ");
		extraLongFactorials();
		// status : DONE
		System.out.println("----- Extra Long Factorial *** ends ------- ");

		// ------------- MAR-06,2024 ----------------
		// Camel Case :
		// https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true
		System.out.println("----- Camel Case *** begins ------- ");
		camelcase();
		// status : SUCCESS
		System.out.println("----- Camel Case *** ends ------- ");

		// ------------- APR-01,2024 ----------------
		// sub array division :
		// https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true
		System.out.println("----- sub array division *** begins ------- ");
		subArrayDivision();
		// status : SUCCESS
		System.out.println("----- sub array division *** ends ------- ");

		// ------------- APR-03,2024 ----------------
		// sock merchant - sales by match :
		// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true
		System.out.println("----- sock merchant - sales by match *** begins ------- ");
		sockMerchant();
		// status : SUCCESS
		System.out.println("----- sock merchant - sales by match *** ends ------- ");

		// ------------- APR-20,2024 ----------------
		// Bill Division :
		// https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
		// Difficulty : EASY
		// status : SUCCESS
		System.out.println("----- Bill Division *** begins ------- ");
		bonAppetit();
		System.out.println("----- Bill Division *** ends ------- ");

		// chat-gpt solved problem
		// Between Two Sets :
		// https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
		// Difficulty : EASY
		// status : SUCCESS
		System.out.println("----- Between Two Sets *** begins ------- ");
		getTotalX();
		System.out.println("----- Between Two Sets *** ends ------- ");

		// ------------- APR-25,2024 ----------------
		// Electronics Shop :
		// https://www.hackerrank.com/challenges/electronics-shop/problem?isFullScreen=true
		// Difficulty : EASY
		// status : SUCCESS
		System.out.println("----- Electronics Shop *** begins ------- ");
		getMoneySpent();
		System.out.println("----- Electronics Shop *** ends ------- ");

		// ------------- APR-30,2024 ----------------
		// Picking Numbers :
		// https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
		// Difficulty : EASY
		// status : SUCCESS
		// DONE BY CHAT-GPT
		System.out.println("----- Picking Numbers *** begins ------- ");
		pickingNumbers();
		System.out.println("----- Picking Numbers *** ends ------- ");

		// ------------- MAY-02,2024 ----------------
		// The Hurdle Race :
		// https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=true
		// Difficulty : EASY
		// status : SUCCESS
		System.out.println("----- The Hurdle Race *** begins ------- ");
		hurdleRace();
		System.out.println("----- The Hurdle Race *** ends ------- ");
	}

	private static void hurdleRace() {
		hurdleRace(1, Arrays.asList(1,2,3,3,2));
		hurdleRace(4, Arrays.asList(1,6,3,5,2));
		hurdleRace(7, Arrays.asList(2,5,4,5,2));
	}

	public static int hurdleRace(int k, List<Integer> height) {
		int maxHeight = height.stream().mapToInt(Integer::intValue).max().getAsInt();
		int requiredDose = Math.max(0, maxHeight-k); 
		System.out.println(" requiredDose = "+requiredDose);
		return requiredDose;
	}

	private static void pickingNumbers() {
//		pickingNumbers();

	}

	public static int pickingNumbers(List<Integer> a) {
		// Create a frequency map to count the occurrence of each unique number
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : a) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		int maxLength = 0;
		// Iterate through the frequency map
		for (int num : frequencyMap.keySet()) {
			int currentLength = frequencyMap.get(num); // Frequency of the current number
			int nextLength = frequencyMap.getOrDefault(num + 1, 0); // Frequency of the next number (num + 1)
			int totalLength = currentLength + nextLength; // Total length of subarray
			// Update maxLength if the totalLength is greater
			if (totalLength > maxLength) {
				maxLength = totalLength;
			}
		}
		return maxLength;
	}

	private static void getMoneySpent() {
		int[] keyboards = { 3, 1 };
		int[] drives = { 5, 2, 8 };
		int budget = 10;
		getMoneySpent(keyboards, drives, budget);
	}

	private static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int maxCost = -1;
		for (int keyboard : keyboards) {
			for (int drive : drives) {
				int totalCost = keyboard + drive;
				if (totalCost <= budget && totalCost > maxCost) {
					maxCost = totalCost;
				}
			}
		}
		System.out.println("maxCost = " + maxCost);
		return maxCost;
	}

	private static void getTotalX() {
		getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96));
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		int lcmA = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			lcmA = lcm(lcmA, a.get(i));
		}

		int gcdB = b.get(0);
		for (int i = 1; i < b.size(); i++) {
			gcdB = gcd(gcdB, b.get(i));
		}

		int count = 0;
		for (int i = lcmA, j = 2; i <= gcdB; i = lcmA * j, j++) {
			if (gcdB % i == 0) {
				count++;
			}
		}
		System.out.println(count);
		return count;

	}

	private static void bonAppetit() {
		List<Integer> billItems = Arrays.asList(3, 10, 2, 9);
		int billAnnaNoNeedToPay = 1; // 0 based index
		int annaCharged = 12;
		bonAppetit(billItems, billAnnaNoNeedToPay, annaCharged);
		bonAppetit(billItems, billAnnaNoNeedToPay, 7);
	}

	public static void bonAppetit(List<Integer> bill, int k, int b) {
		int sum = bill.stream().filter(bi -> bill.indexOf(bi) != k).mapToInt(Integer::intValue).sum();
		int shareAmount = sum / 2;
		String annaOverCharged = b == shareAmount ? "Bon Appetit" : b - shareAmount + "";
		System.out.println("bill = " + bill + ", k = " + k + ", b = " + b + ", sum = " + sum + ", shareAmount = "
				+ shareAmount + ", annaOverCharged = " + annaOverCharged);
		// 2/7 test cases failed for the above solution

		// chat-gpt solution
		int n = bill.size();
		// Step 2: Calculate Shared Cost
		int sharedCost = 0;
		for (int i = 0; i < n; i++) {
			if (i != k) {
				sharedCost += bill.get(i);
			}
		}
		// Step 3: Calculate Actual and Charged Amounts
		int b_actual = sharedCost / 2;
		// Step 4: Check if Charged Amount is Correct
		if (b == b_actual) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - b_actual);
		}
	}

	private static void sockMerchant() {
		sockMerchant(Arrays.asList(1, 2, 1, 2, 1, 3, 2));
		sockMerchant(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
	}

	public static int sockMerchant(List<Integer> ar) {
		Map<Integer, Long> countMap = ar.stream()
				.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

		int pairsCount = 0;
		for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
			pairsCount += (entry.getValue() / 2);
		}
		System.out.println(" numbers = " + ar + " countMap = " + countMap + ", pairsCount = " + pairsCount);
		return pairsCount;
	}

	private static void subArrayDivision() {
		birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2);
		birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2);
		birthday(Arrays.asList(1, 1, 1, 1, 1, 1), 3, 2);
		birthday(Arrays.asList(4), 4, 1);
	}

	private static void birthday(List<Integer> s, int d, int m) {

		int sum = 0;
		int result = 0;
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < m && i + j < s.size(); j++) {
				sum += s.get(i + j);
			}
			if (sum == d) {
				result++;
			}
			sum = 0;
		}
		System.out.println("subArrayDivision" + " s = " + s + ", d = " + d + ", m = " + m + ", result is = " + result);
	}

	private static void miniMaxSum() {
		miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
	}

	private static void camelcase() {
		camelcase("saveChangesInTheEditor");
	}

	public static int camelcase(String s) {
		// A - Z = 65 - 90
		// a - z = 97 - 122

		int asciiVal = 0;
		Character ch = null;
		List<String> wordList = new ArrayList<>();
		StringBuilder sb = new StringBuilder("");

		for (int index = 0; index < s.length(); index++) {

			ch = s.charAt(index);
			asciiVal = (int) ch;

			if (asciiVal >= 65 && asciiVal <= 90) {
				// System.out.println("CAPS");
				wordList.add(sb.toString());
				sb.setLength(0);
				sb.append(ch);
			} else if (asciiVal >= 97 && asciiVal <= 122) {
				// System.out.println("LOWER");
				sb.append(ch);
			}
		}
		wordList.add(sb.toString());

		System.out.println(s + " has " + wordList.size() + " words. And the words are " + wordList);

		return wordList.size();
	}

	private static void extraLongFactorials() {

		extraLongFactorials(25);
	}

	private static void extraLongFactorials(int n) {
		BigInteger factorial = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}

		System.out.println("factorial of " + n + " is " + factorial);
	}

	private static void climbingLeaderboard() {

		climbingLeaderboard(Arrays.asList(100, 90, 90, 80, 75, 60), Arrays.asList(50, 65, 77, 90, 102));
		climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120));

	}

	// optimized code by JAVA15
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		List<Integer> sortedRanked = new ArrayList<>(ranked);
		sortedRanked.sort(Collections.reverseOrder());

		SortedMap<Integer, Integer> ranks = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
		int rank = 1;
		for (int i = 0; i < sortedRanked.size(); i++) {
			int num = sortedRanked.get(i);
			if (!ranks.containsKey(num)) {
				ranks.put(num, rank++);
			}
		}

		List<Integer> newRankList = new ArrayList<>();

		for (int num : player) {
			if (ranks.containsKey(num)) {
				newRankList.add(ranks.get(num));
			} else {
				int val = ranks.entrySet().stream().filter(entry -> num > entry.getKey()).findFirst()
						.map(Map.Entry::getValue).orElse(ranks.size() + 1);
				newRankList.add(val);
			}
		}

		System.out.println("ranked = " + ranked);
		System.out.println("player = " + player);
		System.out.println("ranks = " + ranks);
		System.out.println("newRankList = " + newRankList);
		return newRankList;
	}

	public static List<Integer> climbingLeaderboard_1(List<Integer> ranked, List<Integer> player) {

		List<Integer> sortedNumbers = new ArrayList<>(ranked);
		// Sort the list in descending order
		sortedNumbers.sort(Comparator.reverseOrder());

		// Create a map to store ranks
		SortedMap<Integer, Integer> ranks = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});

		int rankNum = 1;

		for (Integer num : sortedNumbers) {
			if (!ranks.containsKey(num))
				ranks.put(num, rankNum++);
		}

		// since .getLast() function is found from JAVA 21 commented
		// Integer lastNum = sortedNumbers.getLast();
		Integer lastNum = ranks.lastKey();

		List<Integer> newRankList = new ArrayList<>();

		for (int palyerIndex = 0; palyerIndex < player.size(); palyerIndex++) {

			Integer num = player.get(palyerIndex);

			if (ranks.containsKey(num)) {
				newRankList.add(ranks.get(num));
			} else {
				for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
					Integer key = entry.getKey();
					Integer val = entry.getValue();
					if (num > key) {
						newRankList.add(val);
						break;
					} else if (num < lastNum) {
						newRankList.add(ranks.size() + 1);
						break;
					}
				}
			}
		}

		System.out.println(" ranked = " + ranked);
		System.out.println(" player = " + player);
		System.out.println(" ranks = " + ranks);
		System.out.println(" newRankList = " + newRankList);
		return newRankList;
	}

	private static void kangarooJump() {
		kangaroo(0, 3, 4, 2);
		kangaroo(0, 2, 5, 3);
		kangaroo(2, 5, 3, 6);
		kangaroo(1, 2, 8, 4);
		kangaroo(0, 3, 0, 4);
	}

	public static String kangaroo(int x1, int v1, int x2, int v2) {
		String result = null;

		if (v1 <= v2) {
			result = "NO";
			// Kangaroo 1 is not able to catch up or Kangaroo 2 is moving faster
			System.out.println("x1 = " + x1 + " v1 = " + v1 + " x2 = " + x2 + " v2 = " + v2 + " result = " + result);
			return result;
		}

		// Calculate the number of jumps required for Kangaroo 1 to catch up with
		// Kangaroo 2
		int jumps = (x2 - x1) / (v1 - v2);
		// Check if both kangaroos will be at the same position after the same number of
		// jumps
		if (x1 + jumps * v1 == x2 + jumps * v2) {
			result = "YES"; // Kangaroo 1 can catch up with Kangaroo 2
		} else {
			result = "NO"; // Kangaroo 1 cannot catch up with Kangaroo 2
		}
		System.out.println("x1 = " + x1 + " v1 = " + v1 + " x2 = " + x2 + " v2 = " + v2 + " result = " + result);
		return result;

	}

	public static void staircase(int n) {
		for (int rowIndex = 1; rowIndex <= n; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= n - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int printIndex = 1; printIndex <= rowIndex; printIndex++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void miniMaxSum(List<Integer> arr) {

		int maxSum = arr.stream().sorted().skip(1).mapToInt(Integer::intValue).sum();
		int minSum = arr.stream().sorted((a, b) -> b.compareTo(a)).skip(1).mapToInt(Integer::intValue).sum();

		System.out.println("miniMaxSum = " + minSum + " " + maxSum);

		// another way of solution
		int sum = arr.stream().mapToInt(Integer::intValue).sum();
		List<Integer> numList = arr.stream().sorted().toList();

		int minSum_1 = sum - numList.get(4);
		int maxSum_1 = sum - numList.get(0);
		System.out.println("miniMaxSum = " + minSum_1 + " " + maxSum_1);

		int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
		int min = arr.stream().mapToInt(Integer::intValue).min().getAsInt();
		int max = arr.stream().mapToInt(Integer::intValue).max().getAsInt();

		int minSum_2 = totalSum - max;
		int maxSum_2 = totalSum - min;

		System.out.println(minSum_2 + " " + maxSum_2);
	}

}
