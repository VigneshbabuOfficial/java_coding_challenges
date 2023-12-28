package others;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		swap2Nums(9,5);
		swap2NumsBitwise(9,5);
	}

	private static void swap2NumsBitwise(final int num1,final int num2) {
		System.out.println("----------- swap2NumsBitwise -----------");
		System.out.println("before swap, num1 = "+num1+", num2 = "+num2);
		int a = num1;
		int b = num2;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("after swap, num1 = "+a+", num2 = "+b);
	}

	private static void swap2Nums(final int num1,final int num2) {
		System.out.println("before swap, num1 = "+num1+", num2 = "+num2);
		int a = num1;
		int b = num2;
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("after swap, num1 = "+a+", num2 = "+b);
	}
}
