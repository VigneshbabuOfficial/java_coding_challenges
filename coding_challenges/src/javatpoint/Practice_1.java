package javatpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Practice_1 {

	public static void main(String[] args) {

		printPatterns();

		fibonacci_series();

		armstrong_number_problems();

		factorial();

		palindrome();

		primeNumber();
	}

	private static void primeNumber() {
		System.out.println("---- prime_number ------ ");

		System.out.println(7 + " is a " + (isPrimeNumber(7) ? "prime" : "not a prime"));
		List<Integer> primeList = IntStream.rangeClosed(1, 100).filter(Practice_1::isPrimeNumber).boxed().toList();
		System.out.println(" primeList = " + primeList);

	}

	private static boolean isPrimeNumber(int n) {

		if (n < 2)
			return false;
		else if (n == 2)
			return true;
		else if (n % 2 == 0)
			return false;

		for (int i = 3; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	private static void palindrome() {
		System.out.println("---- palindrome ------ ");

		System.out.println(454 + " is a " + (isPalindrome(454) ? "palindrome" : "not a palindrome "));
		System.out.println(123 + " is a " + (isPalindrome(123) ? "palindrome" : "not a palindrome "));

		List<Integer> palindromeList = IntStream.rangeClosed(1, 1000).filter(Practice_1::isPalindrome).boxed().toList();
		System.out.println(" palindromeList = " + palindromeList);

	}

	private static boolean isPalindrome(int n) {

		int sum = 0;
		int temp = n;
		int q, r;
		do {
			q = temp / 10;
			r = temp % 10;
			sum = (sum * 10) + r;
			temp = q;
		} while (q > 0);

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
		boolean isArmstrongNum = check_armstrong_number(n);
		System.out.println(n + " is" + (isArmstrongNum ? " an Armstrong number " : " not a Armstrong"));
		n = 153;
		isArmstrongNum = check_armstrong_number(n);
		System.out.println(n + " is" + (isArmstrongNum ? " an Armstrong number " : " not a Armstrong"));

		List<Integer> armstrongNumList = IntStream.rangeClosed(1, 1000).filter(Practice_1::check_armstrong_number)
				.boxed().toList();
		System.out.println(armstrongNumList);
	}

	private static boolean check_armstrong_number(int n) {

		// digits count
		int digitsCount = get_digits_count(n);
		// System.out.println(n+" -- "+digitsCount);
		int tempNum = n;
		int q = 0;
		int r = 0;
		int sum = 0;

		do {
			q = n / 10;
			r = n % 10;
			sum += Math.pow(r, digitsCount);
			n = q;

		} while (q > 0);

		return tempNum == sum;
	}

	private static int get_digits_count(int n) {

		int q = 0;
		int count = 0;

		do {
			q = n / 10;
			count++;
			n = q;
		} while (q > 0);

		return count;
	}

	// 0 1 1 2 3 5 8 13 21 34 55 89 ...
	private static void fibonacci_series() {
		System.out.println("-----------fibonacci_series-------------");
		int n1 = 0;
		int n2 = 1;
		int n3 = n1 + n2;
		int limit = 10;
		List<Integer> finList = new ArrayList<>();
		finList.add(n1);
		finList.add(n2);
		finList.add(n3);
		for (int i = 1; i <= limit; i++) {
			n1 = n2;
			n2 = n3;
			n3 = n1 + n2;
			finList.add(n3);
		}
		System.out.println(finList);
	}
	
	private static void printPatterns() {

		printRightTriangleStarPattern(5);

		printDownwardRightTriangle(5);

		printLeftTriangleStarPattern(5);

		printDownwardLeftTriangle(5);

		printUpwardRightLeftTriangles(5);

		printDownwardRightLeftTriangles(5);

		print_upward_downward_right_left_triangles(5);

		printUpwardPyramid_type_1(5);

		printUpwardPyramid_type_2(5);

		printDownwardPyramid_type_1(5);

		printDownwardPyramid_type_2(5);

		printDiamondPattern_type_1(5);

		printDiamondPattern_type_2(5);

		print_right_pyramid(5);

		print_left_pyramid(5);

		print_sand_glass_pattern(5);

		print_upward_triangle_border(5);

		print_downward_triangle_border(5);

		print_diamond_border(5);

		// @formatter:off
		/*

		1 
		1 2 
		1 2 3 
		1 2 3 4 
		1 2 3 4 5 

		*/
		// @formatter:on
		// print_right_triangle_number_pattern_1;

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
		// print_right_triangle_number_pattern_2

		// @formatter:off
		/*

		1 
		2 1 
		3 2 1 
		4 3 2 1 
		5 4 3 2 1

		*/
		// @formatter:on
		// print_right_triangle_number_pattern_3

		// @formatter:off
		/*

		    1
		   212
		  32123
		 4321234
		543212345
		543212345
		 4321234
		  32123
		   212
		    1

		*/
		// @formatter:on
		print_diamond_numbers(5);

	}

	

	private static void print_diamond_numbers(int limit) {
		System.out.println("-----------print_diamond_border-------------");
		int n1 = 0;
		int n2 = 0;
		for (int ri = 1; ri <= limit; ri++) {
			n1 = ri;
			n2 = 1;
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int ni = 1; ni <= (ri * 2) - 1; ni++) {
				if (n1 < 2)
					System.out.print(n2++ + " ");
				else
					System.out.print(n1-- + " ");
			}
			System.out.println();
		}

	}

	private static void print_diamond_border(int limit) {
		System.out.println("-----------print_diamond_border-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				if (sti == 1 || sti == ri) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				if (ri == limit || sti == ri || sti == limit) {
					System.out.print("* ");
				} else
					System.out.print("  ");
			}
			System.out.println();
		}

	}

	private static void print_downward_triangle_border(int limit) {
		System.out.println("-----------print_downward_triangle_border-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				if (ri == 1 || ri == limit || sti == ri || sti == limit) {
					System.out.print("* ");
				} else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void print_upward_triangle_border(int limit) {
		System.out.println("-----------print_upward_triangle_border-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				if (ri == limit || sti == 1 || sti == ri) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void print_sand_glass_pattern(int limit) {
		System.out.println("-----------print_sand_glass_pattern-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void print_left_pyramid(int limit) {
		System.out.println("-----------print_left_pyramid-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= limit - ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void print_right_pyramid(int limit) {
		System.out.println("-----------print_right_pyramid-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = 1; sti <= limit - ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDiamondPattern_type_2(int limit) {
		System.out.println("-----------printDiamondPattern_type_2-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = ri; spi < limit; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri * 2 - 1; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ((limit - ri) * 2) + 1; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDiamondPattern_type_1(int limit) {
		System.out.println("-----------printDiamondPattern_type_1-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	private static void printDownwardPyramid_type_2(int limit) {
		System.out.println("-----------printDownwardPyramid_type_2-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= (limit - ri) * 2 + 1; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardPyramid_type_1(int limit) {
		System.out.println("-----------printDownwardPyramid_type_1-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printUpwardPyramid_type_2(int limit) {
		System.out.println("-----------printUpwardPyramid_type_2-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= (ri * 2) - 1; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printUpwardPyramid_type_1(int limit) {
		System.out.println("-----------printUpwardPyramid_type_1-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi <= limit - ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	private static void print_upward_downward_right_left_triangles(int limit) {
		System.out.println("-----------print_upward_downward_right_left_triangles-------------");

		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("*");
			}
			for (int spi = 1; spi <= (ri * 2 - 2); spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			for (int spi = 1; spi <= (limit - ri) * 2; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightLeftTriangles(int limit) {
		System.out.println("-----------printDownwardRightLeftTriangles-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("*");
			}
			for (int spi = 1; spi <= (ri * 2) - 2; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printUpwardRightLeftTriangles(int limit) {
		System.out.println("-----------printUpwardRightLeftTriangles-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			for (int spi = 1; spi <= ((limit - ri) * 2); spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void printDownwardLeftTriangle(int limit) {
		System.out.println("-----------printDownwardLeftTriangle-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = 1; spi < ri; spi++) {
				System.out.print(" ");
			}
			for (int sti = ri; sti <= limit; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	private static void printLeftTriangleStarPattern(int limit) {
		System.out.println("-----------printLeftTriangleStarPattern-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int spi = ri; spi < limit; spi++) {
				System.out.print(" ");
			}
			for (int sti = 1; sti <= ri; sti++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightTriangle(int limit) {
		System.out.println("-----------printDownwardRightTriangle-------------");
		for (int ri = 1; ri <= limit; ri++) {
			for (int si = ri; si <= limit; si++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleStarPattern(int limit) {

		for (int ri = 1; ri <= limit; ri++) {
			for (int si = 1; si <= ri; si++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
