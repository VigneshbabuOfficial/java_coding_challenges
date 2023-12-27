package others;

import java.util.ArrayList;
import java.util.List;

public class SquareRootFinder {

	public static void main(String[] args) {
		System.out.println(" ===== ANS = "+Math.sqrt(12345.123456));
		getSquareRoot(12345.123456);
	}

	private static void getSquareRoot(final double num) {

		double sqrRtResult = 0;

		int divisor = 0;
		double dividend = num;
		int quotient = 0;
		int remainder = 0;

		String input = num + "";
		String decimal_1 = input.split("\\.")[0];
		String[] decimal_1_arr = input.split("\\.")[0].split("");
		String decimal_2 = input.split("\\.")[1];
		String[] decimal_2_arr = input.split("\\.")[1].split("");

		List<String> decimal_1_list = new ArrayList<>();
		List<String> decimal_2_list = new ArrayList<>();

		boolean isDecimal_1_odd = decimal_1_arr.length % 2 != 0;
		boolean isDecimal_2_odd = decimal_2_arr.length % 2 != 0;

		for (int i = 0; i < decimal_1_arr.length - 1;) {

			if (isDecimal_1_odd && i == 0) {
				decimal_1_list.add(decimal_1_arr[0]);
				i++;
				continue;
			}

			decimal_1_list.add(decimal_1_arr[i] + decimal_1_arr[i + 1]);

			i += 2;

		}

		for (int i = 0; i < decimal_2_arr.length - 1;) {

			if (isDecimal_2_odd && i == 0) {
				decimal_2_list.add(decimal_2_arr[0]);
				i++;
				continue;
			}

			decimal_2_list.add(decimal_2_arr[i] + decimal_2_arr[i + 1]);

			i += 2;

		}

		System.out.println("decimal_1 = " + decimal_1);
		System.out.println("decimal_1_list = " + decimal_1_list);
		System.out.println("decimal_2 = " + decimal_2);
		System.out.println("decimal_2_list = " + decimal_2_list);
		System.out.println("Square root of " + num + " is " + sqrRtResult);

		for (String dividendVal : decimal_1_list) {
			String result = getQuotientAndRemainder(divisor, quotient, dividendVal);
			quotient = Integer.valueOf(result.split("_")[0]);
			divisor = Integer.valueOf(result.split("_")[1]);
			remainder = Integer.valueOf(result.split("_")[2]);

			System.out.println("dividendVal = " + dividendVal);
			System.out.println("quotient = " + quotient);
			System.out.println("divisor = " + divisor);
			System.out.println("remainder = " + remainder);
			System.out.println("--------------------------");
		}
		
		for (String dividendVal : decimal_2_list) {
			String result = getQuotientAndRemainder(divisor, quotient, dividendVal);
			quotient = Integer.valueOf(result.split("_")[0]);
			divisor = Integer.valueOf(result.split("_")[1]);
			remainder = Integer.valueOf(result.split("_")[2]);

			System.out.println("dividendVal = " + dividendVal);
			System.out.println("quotient = " + quotient);
			System.out.println("divisor = " + divisor);
			System.out.println("remainder = " + remainder);
			System.out.println("--------------------------");
		}

	}

	private static String getQuotientAndRemainder(int divisor, int quotient, String dividendVal) {

		int divVal = 9;
		int tempDivisor = 0;
		int tempQuotient = 0;
		int tempRemainder = 0;
		int dividend = Integer.valueOf(dividendVal);

		while (divVal >= 1) {
			tempDivisor = Integer.valueOf((divisor + "" + divVal));
			tempQuotient = Integer.valueOf((quotient + "" + divVal));
			tempRemainder = Integer.valueOf(dividendVal) % tempQuotient;

			if ((divVal * tempDivisor) <= dividend)
				return tempQuotient + "_" + tempDivisor + "_" + tempRemainder;

			divVal--;
		}
		return tempQuotient + "_" + tempDivisor + "_" + tempRemainder;
	}

}
