package others;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {

		praciceArmstrongNumber();
		practiceAutomorphicNumber();
		getFactorial();
		fibonacci();
		findGCD();
		findLargest();
		palidrome();
		primeNumber();
		printPatterns();
		convertDates();

//	DONE	#1 find the highest word occurrence in a given paragraph
		findHighestOccurenceOfAword();

//	DONE	#2 find the least word occurrence in a given paragraph
		findLeastWordOccurence();

//	DONE	#3 find the longest words in a given paragraph
		findLongestWordInParagraph();

//	DONE	#4 finding the smallest words in a given paragraph
		findSmallestWordInParagraph();

//		  #5 find the most repeating letter in a word

//		  #6 find the least repeating letter in a word

//		  #7 longest substring without repeating character

//		  #8 smallest substring without repeating character

	}

	private static void findSmallestWordInParagraph() {
		
		System.out.println("------------ findSmallestWordInParagraph -------------------");
		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");

		Map<String, Integer> wordMap = Arrays.stream(wordArr).distinct()
				.collect(Collectors.toMap(String::valueOf, String::length));
		System.out.println(wordMap);
		
		
		Integer smallestWordLength = wordMap.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
		
		List<Entry<String, Integer>> smallestWordList = wordMap.entrySet().stream().filter(a -> a.getValue() == smallestWordLength).toList();
		System.out.println(" smallest word list = " + smallestWordList);
	}

	private static void findLeastWordOccurence() {
		System.out.println("------------ findLeastWordOccurence -------------------");
		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");

		Map<String, Long> wordMap = Arrays.stream(wordArr)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(wordMap);
		
		Long leastWordOccurenceCount = wordMap.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
		System.out.println(" least occured words count = " + leastWordOccurenceCount);
		
		List<String> leastOccurenceWordList = wordMap.entrySet().stream().filter(a -> a.getValue() == leastWordOccurenceCount).map(Map.Entry::getKey).toList();
		System.out.println(" least occured word list = " + leastOccurenceWordList);

	}

	private static void findLongestWordInParagraph() {
		System.out.println("------------ findLongestWordInParagraph -------------------");
		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");

		Map<String, Integer> wordLengthMap = Arrays.stream(wordArr).distinct()
				.collect(Collectors.toMap(String::valueOf, String::length));
		System.out.println(" words length = " + wordLengthMap);

		Integer longestWordLength = wordLengthMap.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(Map.Entry::getValue).orElse(null);
		System.out.println(" longest word length = " + longestWordLength);
		List<String> longestWordList = wordLengthMap.entrySet().stream().filter(a -> a.getValue() == longestWordLength)
				.map(Map.Entry::getKey).toList();
		System.out.println(" longest word list = " + longestWordList);
	}

	private static void findHighestOccurenceOfAword() {
		System.out.println("------------ fidingHighestOccurenceOfAword -------------------");
		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

		String[] wordArr = paragraph.split(" ");
		System.out.println(Arrays.toString(wordArr));

		Map<String, Long> wordMap = Arrays.stream(wordArr)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(wordMap);

		String commonWord = wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.orElse(null);
		System.out.println("most common word = " + commonWord);

		Long mostCommonWordCount = wordMap.entrySet().stream().max(Map.Entry.comparingByValue())
				.map(Map.Entry::getValue).orElse(0L);
		List<String> mostCommonWordList = wordMap.entrySet().stream().filter(a -> a.getValue() == mostCommonWordCount)
				.map(Map.Entry::getKey).distinct().toList();
		System.out.println("most common word count = " + mostCommonWordCount);
		System.out.println("most common word list = " + mostCommonWordList);

		String secondCommonWord = wordMap.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).skip(1).findFirst()
				.map(Map.Entry::getKey).orElse(null);
		System.out.println("second most common word = " + secondCommonWord);
		// another way
		String secondMostCommonWord = mostCommonWordList.stream().sorted().skip(1).findFirst().get();
		System.out.println("second most common word = " + secondMostCommonWord);

	}

	private static void convertDates() {
		System.out.println("------------ convertDates -------------------");
		String[] dates = { "17-Dec-80", "20-Feb-81", };
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (String inputDate : dates) {

			LocalDate date = LocalDate.parse(inputDate, inputFormatter);
			String formattedDate = date.format(outputFormatter);
			System.out.println(inputDate + " - " + formattedDate);
		}
	}

	private static void printPatterns() {

// @formatter:off
/*
		 
*
**
***
****
*****
		
*/
// @formatter:on
		printRightTriangleStarPattern(5);
		System.out.println("-------------------------------");
		printRightTriangleStarPattern(6);
		System.out.println("-------------------------------");

// @formatter:off
/*	
		  
 	*
   **
  ***
 ****
*****
		
*/
// @formatter:on
		printLeftTriangleStarPattern(5);
		System.out.println("-------------------------------");
		printLeftTriangleStarPattern(8);
		System.out.println("-------------------------------");

// @formatter:off
/*	
		
    * 
   * * 
  * * * 
 * * * * 
* * * * *
				
*/
// @formatter:on
		printUpperPyramidStarPattern(5);
		System.out.println("-------------------------------");
		printUpperPyramidStarPattern(8);
		System.out.println("-------------------------------");

// @formatter:off
/*	
			
* * * * * 
 * * * * 
  * * * 
   * * 
    * 
						
*/
// @formatter:on
		printDownwardPyramid(5);
		System.out.println("-------------------------------");
		printDownwardPyramid(8);

// @formatter:off
/*	

       * 
      * * 
     * * * 
    * * * * 
   * * * * * 
  * * * * * * 
 * * * * * * * 
* * * * * * * * 
 * * * * * * * 
  * * * * * * 
   * * * * * 
    * * * * 
     * * * 
      * * 
       *
								
*/
// @formatter:on		
		System.out.println("------------printDiamondPattern-------------------");
		printDiamondPattern(8);
		System.out.println("------------printDiamondPattern-------------------");
		printDiamondPattern(7);

// @formatter:off
		
/*

*****
****
***
**
*

*/
		
// @formatter:on
		System.out.println("------------ Downward - Right - Triangle-------------------");
		printDownwardRightTriangle(7);

// @formatter:off
/*

*****
 ****
  ***
   **
    *

*/
// @formatter:on
		System.out.println("------------ Downward - Left - Triangle-------------------");
		printDownwardLeftTriangle(7);

// @formatter:off
/*

**********
****  ****
***    ***
**      **
*        *

*/
// @formatter:on
		System.out.println("------------ 2 - Downward - Triangles -------------------");
		print2DownwardTriangles(7);

// @formatter:off
/*

*        *
**      **
***    ***
****  ****
**********

*/
// @formatter:on
		System.out.println("------------ 2 - Downward - Triangles -------------------");
		print2UpwardTriangles(7);

// @formatter:off
/*

*
**
***
****
*****
****
***
**
*

*/
// @formatter:on		
		System.out.println("------------ Right - Pyramid -------------------");
		printRightPyramid(5);

// @formatter:off
/*

    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *

*/
// @formatter:on		
		System.out.println("------------ Left - Pyramid / Left - Pascal - Triangle -------------------");
		printLeftPyramid(5);

// @formatter:off
/*

* * * * * 
 * * * * 
  * * * 
   * * 
    * 
    * 
   * * 
  * * * 
 * * * * 
* * * * * 

*/
// @formatter:on
		System.out.println("------------ Sand Glass Pattern -------------------");
		printSandGlassPattern(6);

// @formatter:off
 /*

    * 
   * * 
  *   * 
 *     * 
* * * * * 

 */
// @formatter:on
		System.out.println("------------ Triangle Border -------------------");
		printTriangleBorder(6);

// @formatter:off
 /*

* * * * * 
 *     * 
  *   * 
   * * 
    * 

*/
// @formatter:on
		System.out.println("------------ Downward Triangle Border -------------------");
		printDownwardTriangleBorder(6);

// @formatter:off
/*

    * 
   * * 
  *   * 
 *     * 
*       * 
 *     * 
  *   * 
   * * 
    * 

*/
// @formatter:on
		System.out.println("------------ Diamond pattern Border -------------------");
		printDiamondPatternBorder(6);

// @formatter:off
/*

1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 

*/
// @formatter:on
		System.out.println("------------ Right Triangle With Numbers Pattern - 1 -------------------");
		printRightTriangleWithNumbersPattern_1(15);

// @formatter:off
/*

1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
16 17 18 19 20 21 
22 23 24 25 26 27 28

*/
// @formatter:on
		System.out.println("------------ Right Triangle With Numbers Pattern - 2 -------------------");
		printRightTriangleWithNumbersPattern_2(15);

// @formatter:off
/*

1 
2 1 
3 2 1 
4 3 2 1 
5 4 3 2 1

*/
// @formatter:on
		System.out.println("------------ Right Triangle With Numbers Pattern - 3 -------------------");
		printRightTriangleWithNumbersPattern_3(15);

// @formatter:off
/*

    1
   212
  32123
 4321234
543212345
 4321234
  32123
   212
    1

*/
// @formatter:on
		System.out.println("------------ Diamond With Numbers -------------------");
		printDiamondWithNumbers(8);

// @formatter:off
/*

1 
2 1 
3 2 1 
4 3 2 1 
5 4 3 2 1

*/
// @formatter:on
		System.out.println("--- Right Triangle With Numbers Pattern - 1 - reverse ------");
		printRightTriangleWithNumberPattern_1_reverse(6);

		// diff a++ vs ++a
		System.out.println("------------ diff a++  vs  ++a -------------------");
		diff();

	}

	private static void printRightTriangleWithNumberPattern_1_reverse(int limit) {
		int num;
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			num = rowIndex;
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(" " + num--);
			}
			System.out.println();
		}
	}

	private static void diff() {
		int a = 10;
		for (int i = 1; i <= 3; i++) {
			System.out.println(a++);
		}
		System.out.println(" final a = " + a);

		int b = 10;
		for (int i = 1; i <= 3; i++) {
			System.out.println(++b);
		}
		System.out.println(" final b = " + b);
	}

	private static void printDiamondWithNumbers(int limit) {

		int numIndex_1, numIndex_2;

		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			numIndex_1 = rowIndex;
			numIndex_2 = 1;
			for (int starIndex = 1; starIndex <= ((rowIndex * 2) - 1); starIndex++) {
//				System.out.print("*");
				if (starIndex % rowIndex == 0) {
					System.out.print("1");
				} else if (starIndex <= rowIndex)
					System.out.print(numIndex_1--);
				else
					System.out.print(++numIndex_2);
			}
			System.out.println();
		}

		for (int rowIndex = limit - 1; rowIndex >= 1; rowIndex--) {
			for (int spaceIndex = rowIndex; spaceIndex < limit; spaceIndex++) {
				System.out.print(" ");
			}
			numIndex_1 = rowIndex;
			numIndex_2 = 1;
			for (int starIndex = 1; starIndex <= ((rowIndex * 2) - 1); starIndex++) {
//				System.out.print("*");
				if (starIndex % rowIndex == 0) {
					System.out.print("1");
				} else if (starIndex <= rowIndex)
					System.out.print(numIndex_1--);
				else
					System.out.print(++numIndex_2);
			}
			System.out.println();
		}

	}

	private static void printRightTriangleWithNumbersPattern_3(int limit) {
		int num;
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			num = rowIndex;
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(" " + num--);
			}
			System.out.println();
		}
	}

	private static void printRightTriangleWithNumbersPattern_2(int limit) {
		int num = 1;
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(" " + num++);
			}
			System.out.println();
		}
	}

	private static void printRightTriangleWithNumbersPattern_1(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(" " + numIndex);
			}
			System.out.println();
		}
	}

	private static void printDiamondPatternBorder(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (starIndex == 1 || starIndex == rowIndex)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= limit - 1; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {

				if (starIndex == 1 || starIndex == limit - rowIndex)
					System.out.print(" *");
				else
					System.out.print("  ");

//				System.out.print(" *");
			}
			System.out.println();
		}

	}

	private static void printDownwardTriangleBorder(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				if (starIndex == 1 || starIndex == limit - rowIndex || rowIndex == 1)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printTriangleBorder(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (starIndex == 1 || starIndex == rowIndex || rowIndex == limit)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printSandGlassPattern(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= limit; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printLeftPyramid(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex < limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightPyramid(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= limit - 1; rowIndex++) {
			for (int starIndex = rowIndex; starIndex <= limit - 1; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2UpwardTriangles(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			for (int spaceIndex = 1; spaceIndex <= (limit - rowIndex) * 2; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print2DownwardTriangles(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				System.out.print("*");
			}
			for (int spaceIndex = 0; spaceIndex < (rowIndex - 1) * 2; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardLeftTriangle(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightTriangle(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = rowIndex; starIndex <= limit; starIndex++)
				System.out.print("*");
			System.out.println();
		}
	}

	private static void printDiamondPattern(int limit) {

		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}

		for (int rowIndex = 1; rowIndex <= limit - 1; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= limit - rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}

	}

	private static void printDownwardPyramid(int limit) {
		for (int rowIndex = limit; rowIndex >= 1; rowIndex--) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printUpperPyramidStarPattern(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printLeftTriangleStarPattern(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= limit - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleStarPattern(int limit) {
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int colIndex = 1; colIndex <= rowIndex; colIndex++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	private static void primeNumber() {
		int num = 9;
		boolean isPrimeNum = checkIfPrimeNumber(num);
		System.out.println(isPrimeNum ? num + " is a prime number" : num + " is not a prime number");

		int limit = 100;
		List<Integer> primeNumList = new ArrayList<>();
		for (int i = 2; i <= limit; i++) {
			if (checkIfPrimeNumber(i)) {
				primeNumList.add(i);
			}
		}
		System.out.println("Prime numbers between 1 and " + limit + " is " + primeNumList);
	}

	private static boolean checkIfPrimeNumber(int num) {

		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static void palidrome() {
		int num = 121;

		boolean isPalidrome = checkIfPalindrome(num);
		if (isPalidrome) {
			System.out.println(num + " is a palindrome number");
		} else {
			System.out.println(num + " is not a palindrome number");
		}

		int limit = 1000;
		List<Integer> numList = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (checkIfPalindrome(i))
				numList.add(i);
		}
		System.out.println("Palidrome numbers between 1 to " + limit + " is " + numList);
	}

	private static boolean checkIfPalindrome(int num) {

		int remainder = 0;
		int quotient = 0;
		int sum = 0;
		int temp = num;
		do {
			remainder = temp % 10;
			quotient = temp / 10;
			temp = quotient;
			sum = (sum * 10) + remainder;
//			System.out.println(sum);
		} while (quotient > 0);

		return sum == num;
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

	private static void findGCD() {

		int num1 = 8;
		int num2 = 100;
		int gcd = 0;

		for (int i = 1; i <= num1 && i <= num2; i++) {
			if (num1 % i == 0 && num2 % i == 0)
				gcd = i;
		}

		System.out.println("GCD for " + num1 + " and " + num2 + " is " + gcd);
	}

	private static void fibonacci() {

		@SuppressWarnings("serial")
		List<Integer> fibonacciSeries = new ArrayList<>() {
			{
				add(0);
				add(1);
			}
		};

		int limit = 10;

		for (int i = 1; i <= limit; i++) {
			fibonacciSeries.add(fibonacciSeries.get(i - 1) + fibonacciSeries.get(i));
		}
		System.out.println(fibonacciSeries);
	}

	private static void getFactorial() {

		int num = 10;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		System.out.println("Factorial of " + num + " is " + fact);
	}

	private static void practiceAutomorphicNumber() {

		int num = 4;
		boolean isAutomorphic = checkIfAutomorphic(num);
		if (isAutomorphic)
			System.out.println(num + " is Automorphic number");
		else
			System.out.println(num + " is not an Automorphic number");

		int limit = 1000;
		List<Integer> automorphicNumbs = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (checkIfAutomorphic(i)) {
				automorphicNumbs.add(i);
			}
		}

		System.out.println("Automorphic numbers between 1 to " + limit + " is " + automorphicNumbs);
	}

	private static boolean checkIfAutomorphic(int num) {

		String squareVal = Integer.valueOf(num * num).toString();

		return squareVal.endsWith(num + "");
	}

	private static void praciceArmstrongNumber() {

		int num = 407;
		boolean isArmstrongNum = checkIfArmstrong(num);
		System.out.println(num + " Armstrong number status is " + isArmstrongNum);

		int limit = 1000;
		List<Integer> armstrongNumbs = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (checkIfArmstrong(i))
				armstrongNumbs.add(i);
		}

		System.out.println("Armstrong numbers between 1 to " + limit + " is " + armstrongNumbs);
	}

	private static boolean checkIfArmstrong(final int num) {

		int digitCount = countDigits(num);
		int digitsSum = 0;
		int remainDigits = num;
		int lastDigitVal = num;
		while (remainDigits > 0) {
			lastDigitVal = remainDigits % 10;
			remainDigits = remainDigits / 10;
			digitsSum += Math.pow(lastDigitVal, digitCount);
		}

		return num == digitsSum;
	}

	private static int countDigits(int num) {

		int count = 0;

		while (num > 0) {
			num /= 10;
			count++;
		}

		return count;
	}

}
