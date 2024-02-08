package hackerrank;

import java.util.Arrays;
import java.util.List;

public class Feb022024 {

	public static void main(String[] args) {
		
		
		// DESC: Given an array of integers, find the sum of its elements.
		// REF : https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true
		sumOfArray(Arrays.asList(12,23,34));
		
		/* DESC :
		 * Given an array of integers, calculate the ratios of its elements that are
		 * positive, negative, and zero. Print the decimal value of each fraction on a
		 * new line with places after the decimal.
		 * 
		 * REF : https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
		 */
		findPlusMinus(Arrays.asList(1,1,0,-1,-1));
	}

	private static void findPlusMinus(List<Integer> numList) {
		
		final long size = numList.size();
		final long posNums = numList.stream().filter(a -> a > 0).count();
		final long negNums = numList.stream().filter(a -> a < 0).count();
		final long zeroNums = numList.stream().filter(a -> a == 0).count();
		
		System.out.println(" positive ratio : "+String.format("%.6f", (double)posNums/size));
		System.out.println(" negative ratio : "+String.format("%.6f", (double)negNums/size));
		System.out.println(" zeros ratio : "+String.format("%.6f", (double)zeroNums/size));
	}

	private static void sumOfArray(List<Integer> numList) {
		final int sum = numList.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum+" is the total sum of the array = "+numList);
	}
	
}
