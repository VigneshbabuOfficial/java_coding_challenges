package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class RunnableClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

public class InterviewPractice {

	public static void main(String[] args) {

//		printPatterns();

		System.out.println("--------------findHighestOccurenceOfAword-----------------");
		findHighestOccurenceOfAword();
		System.out.println("-------------------------------");
		// findLeastWordOccurence

		System.out.println("--------------findLongestWordInParagraph-----------------");
		findLongestWordInParagraph();
		System.out.println("-------------------------------");

		System.out.println("--------------findMostRepeatingLetter-----------------");
		findMostRepeatingLetter();
		System.out.println("-------------------------------");

		System.out.println("--------------findNonRepeatingLetter-----------------");
		findNonRepeatingLetter();
		System.out.println("-------------------------------");

		concurrentModificationExceptionMethod();

		testMethod();

		System.out.println("--------------armstrongNumber-----------------");
		armstrongNumber();
		System.out.println("-------------------------------");

		System.out.println("-------------- STRING OPS -----------------");
		stringOperation();
		System.out.println("-------------------------------");

		System.out.println("-------------- THREAD OPS -----------------");
		threadOperation();
		System.out.println("-------------------------------");

//		automorphicNumber();
//		getFactorial();
//		fibonacci();
//		findGCD();
//		findLargest();
//		palidrome();
//		primeNumber();
//		
//		longest substring without repeating character
//
//		smallest substring without repeating character

		// [{]{]() - valid or not

		// ask chatgpt for more frequently asked problems
	}

	private static void threadOperation() {

		try {
			RunnableClass rc = new RunnableClass();
			Thread t1 = new Thread(rc);
			Thread t2 = new Thread(rc);
			t1.start();
			t2.start();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		Runnable r = () -> System.out.println("TASK");
		Future<?> submit = es.submit(r);
		try {
			submit.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// OUTPUT : TASK
		
		Callable<String> task = () -> {
		    return "Task result";
		};
		
		Future<String> future = es.submit(task);
		
		try {
		    String result = future.get();  // Get the result of the Callable
		    System.out.println("Task result: " + result);
		} catch (InterruptedException | ExecutionException e) {
		    e.printStackTrace();
		}

		// OUTPUT : Task result: Task result
		es.shutdown();
	}

	private static void printPatterns() {

		System.out.println("--------------printRightTriangleStarPattern-----------------");
		printRightTriangleStarPattern(5);
		printRightTriangleStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printLeftTriangleStarPattern-----------------");
		printLeftTriangleStarPattern(5);
		printLeftTriangleStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printUpperPyramidStarPattern-----------------");
		printUpperPyramidStarPattern(5);
		printUpperPyramidStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDownwardRightTriangleStarPattern-----------------");
		printDownwardRightTriangleStarPattern(5);
		printDownwardRightTriangleStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------prinDownwardtLeftTriangleStarPattern-----------------");
		prinDownwardLeftTriangleStarPattern(5);
		prinDownwardLeftTriangleStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDownwardPyramidStarPattern-----------------");
		printDownwardPyramidStarPattern(5);
		printDownwardPyramidStarPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDiamondPattern-----------------");
		printDiamondPattern(5);
		printDiamondPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------print2DownwardTriangles-----------------");
		print2DownwardTriangles(5);
		print2DownwardTriangles(8);
		System.out.println("-------------------------------");

		System.out.println("--------------print2UpwardTriangles-----------------");
		print2UpwardTriangles(5);
		print2UpwardTriangles(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printRightPyramid-----------------");
		printRightPyramid(5);
		printRightPyramid(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printLeftPyramid-----------------");
		printLeftPyramid(5);
		printLeftPyramid(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printSandGlassPattern-----------------");
		printSandGlassPattern(5);
		printSandGlassPattern(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printUpwardTriangleBorder-----------------");
		printUpwardTriangleBorder(5);
		printUpwardTriangleBorder(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDownwardTriangleBorder-----------------");
		printDownwardTriangleBorder(5);
		printDownwardTriangleBorder(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDiamondPatternBorder-----------------");
		printDiamondPatternBorder(5);
		printDiamondPatternBorder(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printRightTriangleWithNumbersPattern_1-----------------");
		printRightTriangleWithNumbersPattern_1(5);
		printRightTriangleWithNumbersPattern_1(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printRightTriangleWithNumbersPattern_2-----------------");
		printRightTriangleWithNumbersPattern_2(5);
		printRightTriangleWithNumbersPattern_2(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printRightTriangleWithNumbersPattern_3-----------------");
		printRightTriangleWithNumbersPattern_3(5);
		printRightTriangleWithNumbersPattern_3(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printUpperPyramidWithNumberPattern_4-----------------");
		printUpperPyramidWithNumberPattern_4(5);
		printUpperPyramidWithNumberPattern_4(8);
		System.out.println("-------------------------------");

		System.out.println("--------------printDownwardPyramidWithNumberPattern_5-----------------");
		printDownwardPyramidWithNumberPattern_5(5);
		printDownwardPyramidWithNumberPattern_5(8);
		System.out.println("-------------------------------");

	}

	private static void stringOperation() {

		String s1 = "sachin";
		s1.concat("Tendulkar");
		System.out.println("s1  >> " + s1);
		String s2 = s1.concat("Tendulkar");
		System.out.println("s2  >> " + s2);
		System.out.println("s1==s2  >> " + s1 == s2);
		String s3 = s1 + "Tendulkar";
		System.out.println("s3  >> " + s3);
		System.out.println("s1==s3  >> " + s1 == s3);

	}

	private static void armstrongNumber() {
		armstrongNumber(153);
		armstrongNumberWithLimit(10000);
	}

	private static void armstrongNumberWithLimit(int limit) {

		List<Integer> armstrongNumList = new ArrayList<>();

		for (int num = 1; num <= limit; num++) {
			if (checkIfArmstrong(num)) {
				armstrongNumList.add(num);
			}
		}
		System.out.println(armstrongNumList);
	}

	private static void armstrongNumber(int num) {

		// find armstrong or not
		if (checkIfArmstrong(num)) {
			System.out.println(num + " is an Armstrong number");
		} else {
			System.out.println(num + " is not an Armstrong number");
		}

	}

	private static boolean checkIfArmstrong(int num) {

		// find digits count
		int digitsCount = countDigits(num);

		int sum = 0;
		int quotient = num;
		int lastDigitVal = 0;

		while (quotient > 0) {
			lastDigitVal = quotient % 10;
			quotient = quotient / 10;
			sum += Math.pow(lastDigitVal, digitsCount);
		}

		return sum == num;
	}

	private static int countDigits(int num) {

		int count = 0;

		while (num > 0) {
			num /= 10;
			count++;
		}

		return count;
	}

	private static void findNonRepeatingLetter() {

		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");
		System.out.println(Arrays.toString(wordArr));

		Map<String, Long> lettersCountMap = Arrays.stream(wordArr).flatMap(e -> e.chars().mapToObj(c -> (char) c))
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(" lettersCountMap = " + lettersCountMap);

		List<String> nonRepeatLetts = lettersCountMap.entrySet().stream().filter(c -> c.getValue().equals(1L))
				.map(Map.Entry::getKey).toList();
		System.out.println(" nonRepeatLetts = " + nonRepeatLetts);

	}

	private static void findMostRepeatingLetter() {

		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");
		System.out.println(Arrays.toString(wordArr));

		Map<String, Long> lettersCountMap = Arrays.stream(wordArr).flatMap(e -> e.chars().mapToObj(c -> (char) c))
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(" lettersCountMap = " + lettersCountMap);

		Entry<String, Long> maxLetter = lettersCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(" maxLetter = " + maxLetter);
	}

	private static void findLongestWordInParagraph() {

		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");
		System.out.println(Arrays.toString(wordArr));

		Map<String, Integer> wordLenMap = Arrays.stream(wordArr).distinct()
				.collect(Collectors.toMap(String::valueOf, String::length));
		System.out.println(" wordLenMap = " + wordLenMap);

		Entry<String, Integer> maxLenWord = wordLenMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(" maxLenWord = " + maxLenWord);

	}

	private static void testMethod() {
		// TODO Auto-generated method stub

		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);

		Iterator<Integer> itr = al.iterator();
		while (itr.hasNext()) {
			if (itr.next() == 2) {
				// will not throw Exception
				itr.remove();
			}
		}

		System.out.println(al);

		itr = al.iterator();
		while (itr.hasNext()) {
			if (itr.next() == 3) {
				// will throw Exception on
				// next call of next() method
//				al.remove(3);
			}
		}
	}

	private static void concurrentModificationExceptionMethod() {

		List<String> colors = new ArrayList<>() {
			{
				add("RED");
				add("WHITE");
				add("GREEN");
				add("BLUE");
			}
		};

		// ConcurrentModificationException occurs
		for (String color : colors) {
			System.out.println(color);
			if ("WHITE".equals(color)) {
				// colors.remove(color); ==>> ConcurrentModificationException occurs
				System.out.println(color + " is removed");
			}
		}

		// METHOD 1 : using Iterator
		Iterator<String> colorItr = colors.iterator();
		while (colorItr.hasNext()) {
			String val = colorItr.next();
			System.out.println(val);
			if ("WHITE".equals(val)) {
				colorItr.remove();
				System.out.println(val + " is removed");
			}
		}

		colors.add("WHITE");
		System.out.println("BEFORE = " + colors);

		// METHOD 2 : removeIf method
		colors.removeIf(c -> "WHITE".equals(c));
		System.out.println("AFTER = " + colors);
	}

	private static void findHighestOccurenceOfAword() {

		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");
		System.out.println(Arrays.toString(wordArr));

		// word with occurrence count
		Map<String, Long> wordCount = Arrays.stream(wordArr)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

		Long maxCount = wordCount.values().stream().max(Long::compareTo).get();
		List<String> maxCountWordList = wordCount.entrySet().stream().filter(e -> e.getValue().equals(maxCount))
				.map(Map.Entry::getKey).toList();

		System.out.println(" wordCount = " + wordCount);
		System.out.println(" maxCount = " + maxCount);
		System.out.println(" maxCountWordList = " + maxCountWordList);

		Entry<String, Long> secondMax = wordCount.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).distinct().skip(1).findFirst().get();
		System.out.println(" secondMax = " + secondMax);
		Long secondMaxVal = wordCount.values().stream().filter(Predicate.not(e -> e.equals(maxCount)))
				.max(Long::compareTo).get();
		System.out.println(" secondMaxVal = " + secondMaxVal);
	}

	private static void printDownwardPyramidWithNumberPattern_5(int r) {
		int left_num = r;
		int right_num = 1;
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			for (int numIndex = 1; numIndex <= (r - rowIndex) * 2 + 1; numIndex++) {
				if (left_num >= 1)
					System.out.print(left_num--);
				else
					System.out.print(++right_num);
			}
			left_num = r - rowIndex;
			right_num = 1;
			System.out.println();
		}
	}

	private static void printUpperPyramidWithNumberPattern_4(int r) {
		int left_num = 1;
		int right_num = 1;
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			left_num = rowIndex;
			right_num = 1;
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int numIndex = 1; numIndex <= rowIndex * 2 - 1; numIndex++) {
				if (left_num >= 1)
					System.out.print(left_num--);
				else
					System.out.print(++right_num);
			}
			System.out.println();
		}
	}

	private static void printRightTriangleWithNumbersPattern_3(int r) {
		int printNum = 0;
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			printNum = rowIndex;
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(printNum-- + " ");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleWithNumbersPattern_2(int r) {
		int printNum = 1;
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(printNum++ + " ");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleWithNumbersPattern_1(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(numIndex + " ");
			}
			System.out.println();
		}
	}

	private static void printDiamondPatternBorder(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (rowIndex == 1 || starIndex == 1 || starIndex == rowIndex)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= r; starIndex++) {
				if (rowIndex == r || starIndex == rowIndex || starIndex == r)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printDownwardTriangleBorder(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= r; starIndex++) {
				if (rowIndex == 1 || rowIndex == r || starIndex == rowIndex || starIndex == r)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printUpwardTriangleBorder(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (rowIndex == 1 || rowIndex == r || starIndex == 1 || starIndex == rowIndex)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printSandGlassPattern(int r) {

		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= r; starIndex++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printLeftPyramid(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= r; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightPyramid(int r) {

		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = rowIndex; starIndex <= r; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2UpwardTriangles(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}

			for (int spaceIndex = 1; spaceIndex <= ((r * 2) - (rowIndex * 2)); spaceIndex++) {
				System.out.print(" ");
			}

			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2DownwardTriangles(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print("*");
			}
			for (int spaceIdx = 0; spaceIdx < (rowIndex - 1) * 2; spaceIdx++) {
				System.out.print(" ");
			}
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDiamondPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = r; spaceIndex >= rowIndex; spaceIndex--) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			System.out.print(" ");
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printDownwardPyramidStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void prinDownwardLeftTriangleStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightTriangleStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = r; starIndex >= rowIndex; starIndex--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printUpperPyramidStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printLeftTriangleStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= r - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleStarPattern(int r) {
		for (int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
