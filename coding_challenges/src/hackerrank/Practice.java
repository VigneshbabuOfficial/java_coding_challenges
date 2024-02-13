package hackerrank;

import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {

		// ------------- FEB-13,2024 ----------------
		// REF :
		// https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
		miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));

		// REF : https://www.hackerrank.com/challenges/staircase/problem
		staircase(6);
		
		
	}
	
	public static void staircase(int n) {
		for(int rowIndex = 1; rowIndex <= n; rowIndex++ ) {
			for( int spaceIndex = 1; spaceIndex <= n-rowIndex; spaceIndex++ ) {
				System.out.print(" ");
			}
			for( int printIndex = 1; printIndex <= rowIndex; printIndex++ ) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void miniMaxSum(List<Integer> arr) {

		int maxSum = arr.stream().sorted().skip(1).mapToInt(Integer::intValue).sum();
		int minSum = arr.stream().sorted((a,b) -> b.compareTo(a)).skip(1).mapToInt(Integer::intValue).sum();
		
		System.out.println(minSum+" "+maxSum);
		
		// another way of solution
		int sum = arr.stream().mapToInt(Integer::intValue).sum();
		List<Integer> numList = arr.stream().sorted().toList();
		
		int minSum_1 = sum - numList.get(4); 
		int maxSum_1 = sum - numList.get(0); 
		System.out.println(minSum_1+" "+maxSum_1);
	}

}
