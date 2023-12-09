package others;

public class TestPractice {

	public static void main(String[] args) {
		// print fibonacci upto 100
		System.out.println("------------------ FIBONACCI NUMBERS ------------------- ");
		printFibonacci(100);
		// print prime numbers
		System.out.println("------------------ PRIME NUMBERS ------------------- ");
		printPrimeNumbers(1000);
		System.out.println("------------------ ARMSTRONG NUMBERS ------------------- ");
		printArmstrongNumber(1000);
	}

	private static void printArmstrongNumber(final int limit) {
		
		
		
	}

	private static void printPrimeNumbers(final int limit) {
		boolean isPrime = false;
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
				isPrime = false;
			}
		}
	}

	private static void printFibonacci(final int limit) {
		StringBuilder result = new StringBuilder("0, 1");
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		for (int i = 1; i <= limit; i++) {
			if (i > 1) {
				n3 = n1 + n2;
				if (n3 > limit)
					break;
				result.append(", " + n3);
				n1 = n2;
				n2 = n3;

			}
		}
		System.out.println("Fibonacci - result = " + result.toString());
	}

}
