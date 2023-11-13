package others;

public class PrimeNumber {
	public static void main(String[] args) {
		int limit = 1000;
		boolean isPrime = true;
		
		for (int i = 2; i <= limit; i++) {
			isPrime = true;
			if (i==2) {
				System.out.print(i+", ");
				continue;
			}
			 for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i+", ");
				isPrime = false;
			}
		}
	}
}
