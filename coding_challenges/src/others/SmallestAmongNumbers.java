package others;

import java.util.List;

public class SmallestAmongNumbers {

	public static void main(String[] args) {
		List<Integer> numList = List.of(12, 5, 20,100,9);
		findSmallestNum(numList);
		find2ndSmallestNum(numList);
	}

	private static void find2ndSmallestNum(List<Integer> numList) {
		int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < numList.size(); i++) {
			if ( numList.get(i) < smallest ) {
				secondSmallest = smallest;
				smallest = numList.get(i);
			}else if ( numList.get(i) < secondSmallest && numList.get(i) != smallest ) {
				secondSmallest = numList.get(i);
			}
		}
		System.out.println(secondSmallest+ " is the second smallest among numbers = " + numList);
		System.out.println("-----------------");
	}

	private static void findSmallestNum(List<Integer> numList) {
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) < smallest) {
				smallest = numList.get(i);
			}
		}
		System.out.println(smallest+ " is the smallest among numbers = " + numList);
		System.out.println("-----------------");
	}

}
