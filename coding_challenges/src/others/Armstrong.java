package others;

import java.util.ArrayList;
import java.util.List;

public class Armstrong {
	public static void main(String[] args) {
		int num = 163;
		if (isArmstrongNumber(num))
			System.out.println(num + " is an Armstrong number");
		else
			System.out.println(num + " is not an Armstrong number");
		
		getArmstrongNumbers(10000);
	}

	private static boolean isArmstrongNumber(int num) {
		int digitCount = String.valueOf(num).length();
		int sum = 0;
		int temp = num;
		int quotient = 0;
		int remainder = 0;
		do {
			quotient = temp / 10;
			remainder = temp % 10;
			sum = (int) (sum + Math.pow(remainder, digitCount));
			temp = quotient;
		} while (temp > 0);
		return num == sum;
	}

	private static void getArmstrongNumbers(int limit) {
		List<Integer> armstrongNums = new ArrayList<>();
		for (int i = 0; i <= limit; i++) {
			if(isArmstrongNumber(i)) armstrongNums.add(i);
		}
		System.out.println(armstrongNums);
	}

}
