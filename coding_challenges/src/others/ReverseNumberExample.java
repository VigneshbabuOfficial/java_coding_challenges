package others;

public class ReverseNumberExample {
	
	public static void main(String[] args) {
		getReversedNumber(1234);
		getReversedNumber(7654123);
	}

	private static void getReversedNumber(int num) {
		
		int quotient=0,remainder=0;
		int numberReversed = 0;
		int tempNum = num;
		
		do {
			quotient = tempNum / 10;
			remainder = tempNum % 10;
			numberReversed = numberReversed * 10 + remainder;
			tempNum = quotient;
			
		} while (quotient > 0 );
		
		System.out.println("reversed number for "+num+" is = "+numberReversed);
	}

}
