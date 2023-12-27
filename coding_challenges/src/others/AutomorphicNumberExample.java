package others;

import java.util.ArrayList;
import java.util.List;

public class AutomorphicNumberExample {

	public static void main(String[] args) {

		isAutomorphicNumber(25);
		isAutomorphicNumber(76);
		isAutomorphicNumber(13);
		isAutomorphicNumber(9376);
		printAutomorphicNumbers(10000);

	}

	private static void printAutomorphicNumbers(int limit) {
		List<Integer> automorphicNums = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (isAutomorphicNumber(i))
				automorphicNums.add(i);
		}
		System.out.println("Automorphic numbers upto the " + limit + " is " + automorphicNums);
	}

	private static boolean isAutomorphicNumber(int num) {
		int digitCount = getDigitCount(num);
//		System.out.println("total digit count for " + num + " is = " + digitCount);

		int sqrNum = num * num;
//		System.out.println("square of the num = " + num + " is = " + sqrNum);

		int lastDigitOfSqrNum = (int) (sqrNum % Math.pow(10, digitCount));
//		System.out.println("lastDigitOfSqrNum = " + lastDigitOfSqrNum);

		/*
		 * if (num == lastDigitOfSqrNum) System.out.println(num + " is Automorphic");
		 * else System.out.println(num + " is not an Automorphic");
		 */

		return num == lastDigitOfSqrNum;
	}

	private static int getDigitCount(int num) {
		int digitCount = 0, q = 0;
		int temp = num;
		do {
			q = temp / 10;
			digitCount++;
			temp = q;
		} while (q > 0);
		return digitCount;
	}
}
