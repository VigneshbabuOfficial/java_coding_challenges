package others;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquare {
	public static void main(String[] args) {
		System.out.println(checkPerfectSquare(100) ? 100 + " is perfect sqaure" : 100 + "is not perfect square.");
		getPerfectSquareNumbers(1000);
	}

	private static void getPerfectSquareNumbers(int limit) {
		List<Integer> numList = new ArrayList<>();

		for (int i = 1; i <= limit; i++) {
			if (checkPerfectSquare(i))
				numList.add(i);
		}
		System.out.println("Perfect Sqaures between 1 and " + limit + " is " + numList);
	}

	private static boolean checkPerfectSquare(int num) {

		for (int i = 1; i * i <= num; i++) {
			if (num / i == i && num % i == 0) {
				return true;
			}
		}
		return false;
	}
}
