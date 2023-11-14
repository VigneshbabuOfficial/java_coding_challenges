package others;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
	public static void main(String[] args) {
		int num = 5;
		System.out.println("factorial of "+num+" is "+ getFactorialValue(num));
		getFactorials(10);
	}

	private static void getFactorials(int num) {
		Map<Integer,Integer> factorialMap = new HashMap<>();
		for (int i = 1; i <= num; i++) {
			factorialMap.put(i, getFactorialValue(i));
		}
		System.out.println(factorialMap);
	}

	private static Integer getFactorialValue(int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}

}
