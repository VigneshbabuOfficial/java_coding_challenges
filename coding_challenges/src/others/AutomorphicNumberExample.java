package others;

import java.util.ArrayList;
import java.util.List;


/*
 * A number is called an automorphic number if and only if the square of the given number ends with 
 * the same number itself. For example, 25, 76 are automorphic numbers because their square is 625 
 * and 5776, respectively and the last two digits of the square represent the number itself. 
 * Some other automorphic numbers are 5, 6, 36, 890625, etc.
 */

public class AutomorphicNumberExample {

	public static void main(String[] args) {

		isAutomorphicNumber(25);
		isAutomorphicNumber(76);
		isAutomorphicNumber(13);
		isAutomorphicNumber(9376);
		printAutomorphicNumbers(10000);
		
//		practiceAutomorphicNumber();

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
		for(int i = 1; i <= limit; i++) {
			if( checkIfAutomorphic(i) ) {
				automorphicNumbs.add(i);
			}
		}
		
		System.out.println("Automorphic numbers between 1 to " + limit + " is " + automorphicNumbs);
	}
	
	private static boolean checkIfAutomorphic(int num) {

		String squareVal = Integer.valueOf(num * num).toString();

		return squareVal.endsWith(num + "");
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
