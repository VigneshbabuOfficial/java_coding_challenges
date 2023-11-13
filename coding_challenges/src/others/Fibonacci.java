package others;

public class Fibonacci {
	public static void main(String[] args) {
		printFibonacci(10);
	}
	private static void printFibonacci(int count) {
		int n1=0,n2=1,n3=0;
		System.out.print(n1+" ");
		System.out.print(n2+" ");
		for(int i=1;i<=count;i++) {
			n3=n1+n2;
			System.out.print(n3+" ");
			n1=n2;
			n2=n3;
		}
	}
}
