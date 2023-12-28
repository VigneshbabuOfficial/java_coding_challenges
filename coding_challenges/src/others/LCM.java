package others;

public class LCM {

	public static void main(String[] args) {
		findLCM(12,9);
	}

	private static void findLCM(final int num1, final int num2) {
		int gcd = 0;
		for (int i = 1; i <= num1 && i <= num2; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.println("GCD of the " + num1 + " and " + num2 + " is " + gcd);
		
		int lcm = ( num1 * num2 ) / gcd;
		System.out.println("LCM of the " + num1 + " and " + num2 + " is " + lcm);
		
	}
}
