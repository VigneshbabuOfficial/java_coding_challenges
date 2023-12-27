package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		// https://www.javatpoint.com/prime-number-program-in-java
		 getPrimenumbers(1000);
		
		// Display Alternate Prime Numbers
		// https://www.javatpoint.com/java-program-to-display-alternate-prime-numbers
		 getAlternativePrimenumbers(1000);
		
		// nth Prime Number
		// https://www.javatpoint.com/nth-prime-number-java
		getNthPrimeNumber(5);
	}

	private static void getNthPrimeNumber(final int nthIndex) {
		
		Scanner sc = new Scanner(System.in);  
		System.out.print("Enter the value of limit to compute the nth prime number: ");  
		//reading an integer from the user  
		int limit = sc.nextInt();   
		List<Integer> primelist = new ArrayList<>();
		boolean isPrime;
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					continue;
				}
			}
			if (isPrime) {
				primelist.add(i);
				isPrime = false;
			}
		}
		System.out.println(primelist);
		System.out.println();
		System.out.print(" the prime number at position "+nthIndex+" is "+primelist.get(nthIndex-1));
	}

	private static void getAlternativePrimenumbers(final int limit) {
		List<Integer> primelist = new ArrayList<>();
		boolean isPrime;
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					continue;
				}
			}
			if (isPrime) {
				primelist.add(i);
				isPrime = false;
			}
		}

		// printing the alternative prime numbers
		for (int i = 0; i < primelist.size(); i++) {
			if (i % 2 == 0) {
				System.out.print(primelist.get(i) + " ");
			}
		}
	}

	private static void getPrimenumbers(final int limit) {

		boolean isPrime = true;
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			if (i == 2) {
				System.out.print(i + ", ");
				continue;
			}
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + ", ");
				isPrime = false;
			}
		}

	}
}
