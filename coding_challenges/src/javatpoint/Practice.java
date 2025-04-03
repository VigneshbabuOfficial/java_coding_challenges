package javatpoint;

import java.util.List;
import java.util.stream.IntStream;

public class Practice {

	public static void main(String[] args) {

		printPatterns();

	}

	private static void printPatterns() {

		// -------------------- printing pattern problems --------------- //
		printRightTriangleStarPattern(5);
		printRightTriangleStarPattern(8);

		printDownwardRightTriangle(5);
		printDownwardRightTriangle(8);

		printLeftTriangleStarPattern(5);
		printLeftTriangleStarPattern(8);

		printDownwardLeftTriangle(5);
		printDownwardLeftTriangle(8);

		printUpwardRightLeftTriangles(7);

		printDownwardRightLeftTriangles(7);

		print_upward_downward_right_left_triangles(7);

		printUpwardPyramid_type_1(5);
		printUpwardPyramid_type_1(8);

		printUpwardPyramid_type_2(5);
		printUpwardPyramid_type_2(8);

		printDownwardPyramid_type_1(5);
		printDownwardPyramid_type_1(8);

		printDownwardPyramid_type_2(5);
		printDownwardPyramid_type_2(8);

		printDiamondPattern_type_1(8);
		printDiamondPattern_type_1(7);

		printDiamondPattern_type_2(8);
		printDiamondPattern_type_2(7);

		print_right_pyramid(5);

		print_left_pyramid(5);

		print_sand_glass_pattern(6);

		print_upward_triangle_border(6);

		print_downward_triangle_border(6);

		print_diamond_border(6);

		print_right_triangle_number_pattern_1(10);

		print_right_triangle_number_pattern_2(10);

		print_right_triangle_number_pattern_3(10);

		print_diamond_numbers(10);

		// -------------------- Logical problems --------------- //
		fibonacci_series();
		armstrong_number_problems();
		factorial();
		palindrome();
		primeNumber();

//		findGCD();
//		findLargest();

		// check few more javatpoint problems

		// ------------------- frequently asked problems ----------------- //
//		DONE	#1 find the highest word occurrence in a given paragraph
		/* findHighestOccurenceOfAword(); */
//		DONE	#2 find the least word occurrence in a given paragraph
		/* findLeastWordOccurence(); */
		// ------------- APR-02, 2024 ----------------
//		DONE	#3 find the longest words in a given paragraph
		/* findLongestWordInParagraph(); */
//		DONE	#4 finding the smallest words in a given paragraph
		/* findSmallestWordInParagraph(); */
		// ------------- APR-03, 2024 ----------------
//		DONE    #5 find the most repeating letter in a word
		/* findMostRepeatingLetter(); */
//		DONE	#6 find the least / non repeating letter in a word
		/* findNonRepeatingLetter(); */
//		DONE	#6.1 find the second least / non repeating letter in a word

//			  #7 longest substring without repeating character

//			  #8 smallest substring without repeating character

		// ------------- MAY-09,2024 ----------------
		// Program to copy all elements of one array into another array :
		// https://www.javatpoint.com/java-program-to-copy-all-elements-of-one-array-into-another-array
		// Difficulty : EASY
		// status : SUCCESS
		/*
		 * System.out.
		 * println("----- copy all elements of one array into another array *** begins ------- "
		 * ); copyArrayToArray(); System.out.
		 * println("----- copy all elements of one array into another array *** ends ------- "
		 * ); System.out.println(" ---------------------------------------------- ");
		 */

		// Program to find the frequency of each element in the array :
		// https://www.javatpoint.com/java-program-to-find-the-frequency-of-each-element-in-the-array
		// Difficulty : EASY
		// status : SUCCESS
		/*
		 * System.out.
		 * println("----- Program to find the frequency of each element in the array : *** begins ------- "
		 * ); frequencyOfElementsInArray(); System.out.
		 * println("----- Program to find the frequency of each element in the array : *** ends ------- "
		 * ); System.out.println(" ---------------------------------------------- ");
		 */

//			findHighestOccurenceOfAword();
//	        findLeastWordOccurence();
//	        findLongestWordInParagraph();

	}

	private static void primeNumber() {
		System.out.println("---- prime_number ------ ");

		System.out.println(7 + " is a " + (isPrimeNumber(7) ? "prime" : "not a prime"));
		List<Integer> primeList = IntStream.rangeClosed(1, 100).filter(Practice::isPrimeNumber).boxed().toList();
		System.out.println(" primeList = " + primeList);

	}

	private static boolean isPrimeNumber(int n) {
		boolean isPrime = true;

		if (n < 2) return false;
	    if (n == 2) return true;
	    if (n % 2 == 0) return false;
	    
		
		for (int i = 3; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	private static void palindrome() {
		System.out.println("---- palindrome ------ ");

		System.out.println(454 + " is a " + (isPalindrome(454) ? "palindrome" : "not a palindrome "));
		System.out.println(123 + " is a " + (isPalindrome(123) ? "palindrome" : "not a palindrome "));

		List<Integer> palindromeList = IntStream.rangeClosed(1, 1000).filter(Practice::isPalindrome).boxed().toList();
		System.out.println(" palindromeList = " + palindromeList);

	}

	private static boolean isPalindrome(int n) {

		int temp = n;
		int sum = 0;
		int r = 0;
		while (temp > 0) {
			r = temp % 10;
			sum = (sum * 10) + r;
			temp = temp / 10;
		}

		return sum == n;
	}

	private static void factorial() {
		System.out.println("---- factorial ------ ");

		findFactorial(5);
		findFactorial(10);

		System.out.println("-- findFactorialRecursive -- Factorial of 5 is " + findFactorialRecursive(5));

	}

	private static int findFactorialRecursive(int n) {

		if (n <= 1)
			return 1;

		return n * findFactorialRecursive(n - 1);
	}

	private static int findFactorial(int n) {

		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}

		System.out.println("Factorial of " + n + " is " + fact);
		return fact;
	}

	private static void armstrong_number_problems() {
		System.out.println("---- armstrong_number_problems ------ ");
		int n = 2025;
		boolean isArmstrongNum = armstrong_number(n);
		System.out.println(n + " is" + (isArmstrongNum ? " an Armstrong number " : " not a Armstrong"));
		n = 153;
		armstrong_number(n);
		System.out.println(n + " is" + (isArmstrongNum ? " an Armstrong number " : " not a Armstrong"));

		List<Integer> armstrongNumList = IntStream.rangeClosed(1, 1000000).filter(Practice::armstrong_number).boxed()
				.toList();

		System.out.println(armstrongNumList);

	}

	private static boolean armstrong_number(int n) {
//		System.out.println("---- armstrong_number ------ n = " + n);

		// sum_of_digits
		int digitsCount = digitsCount(n);
//		System.out.println("digitsCount = "+digitsCount);

		int tot = 0;
		int qVal = 0;
		int temp = n;
		for (int i = 1; i <= digitsCount; i++) {
			qVal = temp % 10;
			tot += Math.pow(qVal, digitsCount);
			temp = temp / 10;
		}

		return n == tot;

	}

	private static int digitsCount(int n) {

		int temp = n;
		int digitsCount = 0;
		int qVal = 0;
		do {
			qVal = temp / 10;
			digitsCount++;
			temp = qVal;
		} while (qVal > 0);

		return digitsCount;
	}

	// 0 1 1 2 3 5 8 13 21 34 55 89 ...
	private static void fibonacci_series() {

		int limit = 10;
		System.out.println("---- fibonacci_series ------ limit = " + limit);
		int num1 = 0;
		int num2 = 1;

		int fibNum = 0;

		System.out.print(num1 + " " + num2);
		for (int numLimit = 1; numLimit <= 10; numLimit++) {
			fibNum = num1 + num2;
			num1 = num2;
			num2 = fibNum;
			System.out.print(" " + fibNum);
		}
		System.out.println();
	}

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
	private static void print_diamond_numbers(int limit) {

		System.out.println("---- print_diamond_numbers ------ limit = " + limit);
		int num, num_1;
		for (int ri = 1; ri <= limit; ri++) {
			num = ri;
			num_1 = 2;
			for (int si = ri; si <= limit; si++) {
				System.out.print(" ");
			}
			for (int ni = 1; ni <= (ri * 2) - 1; ni++) {
				if (num > 0)
					System.out.print(num--);
				else
					System.out.print(num_1++);
			}
			System.out.println();
		}

		for (int ri = 1; ri <= limit; ri++) {
			num = limit - ri + 1;
			num_1 = 2;
			System.out.print(" ");
			for (int si = 1; si < ri; si++) {
				System.out.print(" ");
			}
			for (int ni = 1; ni <= ((limit - ri) * 2) + 1; ni++) {
				if (num > 0)
					System.out.print(num--);
				else
					System.out.print(num_1++);
			}
			System.out.println();
		}

	}

	// @formatter:off
	/*

	1 
	2 1 
	3 2 1 
	4 3 2 1 
	5 4 3 2 1

	*/
	// @formatter:on
	private static void print_right_triangle_number_pattern_3(int limit) {
		System.out.println("---- print_right_triangle_number_pattern_3 ------ limit = " + limit);
		int tempRI;
		for (int ri = 1; ri <= limit; ri++) {
			tempRI = ri;
			for (int ni = 1; ni <= ri; ni++) {
				System.out.print(tempRI-- + " ");
			}
			System.out.println();
		}
	}

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
	private static void print_right_triangle_number_pattern_2(int limit) {
		System.out.println("---- print_right_triangle_number_pattern_2 ------ limit = " + limit);
		int num = 1;
		for (int ri = 1; ri <= limit; ri++) {
			for (int ni = 1; ni <= ri; ni++) {
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	1 
	1 2 
	1 2 3 
	1 2 3 4 
	1 2 3 4 5 

	*/
	// @formatter:on
	private static void print_right_triangle_number_pattern_1(int limit) {
		System.out.println("---- print_right_triangle_number_pattern_1 ------ limit = " + limit);
		for (int ri = 1; ri <= limit; ri++) {
			for (int ni = 1; ni <= ri; ni++) {
				System.out.print(ni + " ");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*
	 
	      * 
	     * * 
	    *   * 
	   *     * 
	  *       * 
	 *         * 
	 *         * 
	  *       * 
	   *     * 
	    *   * 
	     * * 
	      * 

	*/
	// @formatter:on
	private static void print_diamond_border(int limit) {
		System.out.println("---- print_diamond_border ------ limit = " + limit);
		for (int ri = 1; ri <= limit; ri++) {
			for (int si = ri; si <= limit; si++) {
				System.out.print(" ");
			}
			for (int starI = 1; starI <= ri; starI++) {
				if (starI == 1 || starI == ri)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			System.out.print(" ");
			for (int si = 1; si < ri; si++) {
				System.out.print(" ");
			}
			for (int starI = ri; starI <= limit; starI++) {
				if (starI == ri || starI == limit)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	// @formatter:off
	 /*

	* * * * * 
	 *     * 
	  *   * 
	   * * 
	    * 

	*/
	// @formatter:on
	private static void print_downward_triangle_border(int limit) {
		System.out.println("---- print_downward_triangle_border ------ limit = " + limit);
		for (int ri = 1; ri <= limit; ri++) {
			for (int si = 1; si < ri; si++) {
				System.out.print(" ");
			}
			for (int starI = ri; starI <= limit; starI++) {
				if (ri == 1 || ri == limit || starI == ri || starI == limit)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

	}

	// @formatter:off
	 /*

	    * 
	   * * 
	  *   * 
	 *     * 
	* * * * * 

	 */
	// @formatter:on
	private static void print_upward_triangle_border(int limit) {
		System.out.println("---- print_upward_triangle_border ------ limit = " + limit);
		for (int ri = 1; ri <= limit; ri++) {
			for (int si = ri; si <= limit; si++) {
				System.out.print(" ");
			}
			for (int starI = 1; starI <= ri; starI++) {
				if (starI == 1 || starI == ri || ri == limit)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

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
	private static void print_sand_glass_pattern(int limit) {
		System.out.println("---- print_sand_glass_pattern ------ limit = " + limit);

		for (int ri = 1; ri <= limit; ri++) {
			for (int si = 1; si < ri; si++) {
				System.out.print(" ");
			}
			for (int starI = ri; starI <= limit; starI++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int si = ri; si < limit; si++) {
				System.out.print(" ");
			}
			for (int starI = 1; starI <= ri; starI++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	// @formatter:off
	/*

	     *
	    **
	   ***
	  ****
	 *****
	 *****
	  ****
	   ***
	    **
	     *

	*/
	// @formatter:on
	private static void print_left_pyramid(int limit) {
		System.out.println("---- print_left_pyramid ------ limit = " + limit);
		for (int rowInx = 1; rowInx <= limit; rowInx++) {
			for (int spaceInx = rowInx; spaceInx <= limit; spaceInx++) {
				System.out.print(" ");
			}
			for (int starInx = 1; starInx <= rowInx; starInx++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowInx = 1; rowInx <= limit; rowInx++) {
			System.out.print(" ");
			for (int spaceInx = 1; spaceInx < rowInx; spaceInx++) {
				System.out.print(" ");
			}
			for (int starInx = rowInx; starInx <= limit; starInx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	*
	**
	***
	****
	*****
	*****
	****
	***
	**
	*

	*/
	// @formatter:on
	private static void print_right_pyramid(int limit) {
		System.out.println("---- print_right_pyramid ------ limit = " + limit);
		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
			for (int starIndex = rowIndex; starIndex <= limit; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	**************
	******  ******
	*****    *****
	****      ****
	***        ***
	**          **
	*            *
	*            *
	**          **
	***        ***
	****      ****
	*****    *****
	******  ******
	**************

	*/
	// @formatter:on
	private static void print_upward_downward_right_left_triangles(int limit) {
		System.out.println("---- print_upward_downward_right_left_triangles ------ limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			for (int spaceIx = 1; rowIx > 1 && spaceIx <= (rowIx * 2) - 2; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("*");
			}
			for (int spaceIx = 1; spaceIx <= (limit - rowIx) * 2; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	**********
	****  ****
	***    ***
	**      **
	*        *

	*/
	// @formatter:on
	private static void printDownwardRightLeftTriangles(int limit) {
		System.out.println("---- printUpwardRightLeftTriangles ------- limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			for (int spaceIx = 1; rowIx > 1 && spaceIx <= (rowIx * 2) - 2; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
			/*

			*        *
			**      **
			***    ***
			****  ****
			**********

			*/
	// @formatter:on
	private static void printUpwardRightLeftTriangles(int limit) {
		System.out.println("---- printUpwardRightLeftTriangles ----- limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("*");
			}
			for (int spaceIx = 1; spaceIx <= (limit - rowIx) * 2; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*
	       *
	      ***
	     *****
	    *******
	   *********
	  ***********
	 *************
	  ***********
	   *********
	    *******
	     *****
	      ***
	       *

	*/
	// @formatter:on
	private static void printDiamondPattern_type_2(int limit) {
		System.out.println("---- printDiamondPattern_type_2 ----- limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = rowIx; spaceIx <= limit; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= ((rowIx * 2) - 1); starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// to skip the first order rowIx is assigned with value 2
		for (int rowIx = 2; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= rowIx; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= ((limit - rowIx) * 2) + 1; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

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
	private static void printDiamondPattern_type_1(int limit) {
		System.out.println("---- printDiamondPattern_type_1 // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = rowIx; spaceIx <= limit; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		// to skip the first order rowIx is assigned with value 2
		for (int rowIx = 2; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= rowIx; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	*****
	 ****
	  ***
	   **
	    *

	*/
	// @formatter:on
	private static void printDownwardLeftTriangle(int limit) {
		System.out.println("---- printDownwardLeftTriangle // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx < rowIx; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*

	*****
	****
	***
	**
	*

	*/
	// @formatter:on
	private static void printDownwardRightTriangle(int limit) {
		System.out.println("---- printDownwardRightTriangle // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
		/*	
					
		*******
		 *****
		  ***
		   *
								
		*/
	// @formatter:on
	private static void printDownwardPyramid_type_2(int limit) {
		System.out.println("---- printDownwardPyramid_type_2 // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= rowIx - 1; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= (limit - rowIx) * 2 - 1; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*	
				
	* * * * * 
	 * * * * 
	  * * * 
	   * * 
	    * 
							
	*/
	// @formatter:on
	private static void printDownwardPyramid_type_1(int limit) {
		System.out.println("---- printDownwardPyramid_type_1 // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= rowIx - 1; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = rowIx; starIx <= limit; starIx++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	// @formatter:off
		/*	
				
		    * 
		   *** 
		  ***** 
		 ******* 
		*********
						
		*/
	// @formatter:on
	private static void printUpwardPyramid_type_2(int limit) {
		System.out.println("---- printUpwardPyramid_type_2 // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= limit - rowIx; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= (rowIx * 2 - 1); starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*	
			
	    * 
	   * * 
	  * * * 
	 * * * * 
	* * * * *
					
	*/
	// @formatter:on
	private static void printUpwardPyramid_type_1(int limit) {
		System.out.println("---- printUpwardPyramid_type_1 // limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = 1; spaceIx <= limit - rowIx; spaceIx++) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*	
			  
	 	*
	   **
	  ***
	 ****
	*****
			
	*/
	// @formatter:on
	private static void printLeftTriangleStarPattern(int limit) {
		System.out.println("---- printLeftTriangleStarPattern limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int spaceIx = limit; spaceIx > rowIx; spaceIx--) {
				System.out.print(" ");
			}
			for (int starIx = 1; starIx <= rowIx; starIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @formatter:off
	/*
			 
	*
	**
	***
	****
	*****
			
	*/
	// @formatter:on
	private static void printRightTriangleStarPattern(int limit) {
		System.out.println("---- printRightTriangleStarPattern limit = " + limit);
		for (int rowIx = 1; rowIx <= limit; rowIx++) {
			for (int colIx = 1; colIx <= rowIx; colIx++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
