package others;

public class PrintPatterns {
	public static void main(String[] args) {

		printRightTriangleStarPattern(5);
		System.out.println("-------------------------------");
		printRightTriangleStarPattern(6);
		System.out.println("-------------------------------");

		printLeftTriangleStarPattern(5);
		System.out.println("-------------------------------");
		printLeftTriangleStarPattern(6);
		System.out.println("-------------------------------");

		printPyramidStarPattern(5);
		System.out.println("-------------------------------");
		printPyramidStarPattern(8);
		System.out.println("-------------------------------");

		printDownwardPyramid(5);
		System.out.println("-------------------------------");
		printDownwardPyramid(6);
		System.out.println("-------------------------------");

		printDiamondPattern(8);
		System.out.println("-------------------------------");
		printDiamondPattern(7);
		System.out.println("-------------------------------");

		printDownwardRightTriangle(5);
		System.out.println("-------------------------------");
		printDownwardRightTriangle(6);
		System.out.println("-------------------------------");

		printDownwardLeftTriangle(5);
		System.out.println("-------------------------------");
		printDownwardLeftTriangle(6);
		System.out.println("-------------------------------");

		printDownward2Triangles(5);
		System.out.println("-------------------------------");
		printDownward2Triangles(6);
		System.out.println("-------------------------------");

		print2Triangles(5);
		System.out.println("-------------------------------");
		print2Triangles(6);
		System.out.println("-------------------------------");

		printRightPyramid(5);
		System.out.println("-------------------------------");
		printRightPyramid(6);
		System.out.println("-------------------------------");

		printLeftPascalTriangle(5);
		System.out.println("-------------------------------");
		printLeftPascalTriangle(6);
		System.out.println("-------------------------------");

		printSandGlassPattern(5);
		System.out.println("-------------------------------");
		printSandGlassPattern(6);
		System.out.println("-------------------------------");

		printTriangleBorder(5);
		System.out.println("-------------------------------");
		printTriangleBorder(10);
		System.out.println("-------------------------------");

		printAlphabet(8);
		System.out.println("-------------------------------");

		printDownwardTriangleBorder(5);
		System.out.println("-------------------------------");
		printDownwardTriangleBorder(10);
		System.out.println("-------------------------------");

		printDiamondPatternBorder(8);
		System.out.println("-------------------------------");
		printDiamondPatternBorder(5);
		System.out.println("-------------------------------");

		printNumberPattern_1(5);
		System.out.println("-------------------------------");
		printNumberPattern_1(10);
		System.out.println("-------------------------------");

		printNumberPattern_2(7);
		System.out.println("-------------------------------");
		printNumberPattern_2(10);
		System.out.println("-------------------------------");

		printDiamondNumberPattern(5);
		System.out.println("-------------------------------");
		printDiamondNumberPattern(6);
		System.out.println("-------------------------------");
		
		printNumberPattern_1_reverse(5);
		System.out.println("-------------------------------");
		printNumberPattern_1_reverse(10);
		System.out.println("-------------------------------");
		
		printNumberPattern_3(5);
		System.out.println("-------------------------------");
		printNumberPattern_3(10);
		System.out.println("-------------------------------");

	}
	
	private static void printNumberPattern_3(final int rowCount) {
		System.out.println("---------- printNumberPattern_3 for row = " + rowCount + " ----------- ");
		int num;
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			num = rowIndex;
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(num-- + " ");
			}
			System.out.println();
		}
	}
	
	private static void printNumberPattern_1_reverse(final int rowCount) {
		System.out.println("---------- printNumberPattern_1_reverse for row = " + rowCount + " ----------- ");
		int num;
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			num = rowCount;
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(num-- + " ");
			}
			System.out.println();
		}
	}

	private static void printDiamondNumberPattern(final int rowCount) {
		System.out.println("---------- printDiamondNumberPattern for row = " + rowCount + " ----------- ");
		int num1, num2;
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			num1 = rowIndex;
			num2 = 1;
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowCount - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= (rowIndex * 2 - 1); starIndex++) {
				if (rowIndex == 1)
					System.out.print(1);
				else if (num1 == 1)
					System.out.print(num2++);
				else
					System.out.print(num1--);
			}
			System.out.println();
		}
		
		for (int rowIndex = 1; rowIndex <= rowCount-1; rowIndex++) {
			num1 = rowCount-rowIndex;
			num2 = 1;
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= (((rowCount-rowIndex) * 2) - 1); starIndex++) {
				if (num1 == 1)
					System.out.print(num2++);
				else
					System.out.print(num1--);
			}
			System.out.println();
		}
	}

	private static void printNumberPattern_2(final int rowCount) {
		System.out.println("---------- printNumberPattern_2 for row = " + rowCount + " ----------- ");
		int numValue = 1;
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(numValue + " ");
				numValue++;
			}
			System.out.println();
		}
	}

	private static void printNumberPattern_1(final int rowCount) {
		System.out.println("---------- printNumberPattern_1 for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int numIndex = 1; numIndex <= rowIndex; numIndex++) {
				System.out.print(numIndex + " ");
			}
			System.out.println();
		}
	}

	private static void printDiamondPatternBorder(final int rowCount) {
		System.out.println("---------- printDiamondPatternBorder for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= rowCount - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (starIndex == 1 || starIndex == rowIndex)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= rowCount - 1; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= rowCount - 1; starIndex++) {
				if (rowIndex == rowCount - 1 || starIndex == rowIndex || starIndex == rowCount - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

	}

	private static void printDownwardTriangleBorder(final int rowCount) {
		System.out.println("---------- printDownwardTriangleBorder for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				if (rowIndex == 1 || rowIndex == rowCount || starIndex == rowIndex || starIndex == rowCount)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printAlphabet(int rowCount) {
		System.out.println("---------- printAlphabet for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int starIndex = 1; starIndex <= 5; starIndex++) {
				if (rowIndex == 1 || rowIndex == (Math.round(rowCount / 1.5)) || starIndex == 1 || starIndex == 5)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

	private static void printTriangleBorder(final int rowCount) {
		System.out.println("---------- printTriangleBorder for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowCount - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				if (rowIndex == 1 || rowIndex == rowCount || starIndex == 1 || starIndex == rowIndex)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void printSandGlassPattern(final int rowCount) {
		System.out.println("---------- printSandGlassPattern for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowCount - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printLeftPascalTriangle(final int rowCount) {
		System.out.println("---------- printLeftPascalTriangle for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowCount - rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			// printing the spaces
			for (int spaceIndex = 1; spaceIndex <= rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = 1; starIndex <= rowCount - rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightPyramid(final int rowCount) {
		System.out.println("---------- printRightPyramid for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			for (int starIndex = 1; starIndex <= rowCount - rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void print2Triangles(final int rowCount) {
		System.out.println("---------- print2Triangles for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the stars
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			// printing spaces
			for (int spaceIndex = 1; spaceIndex <= (rowCount - rowIndex) * 2; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownward2Triangles(final int rowCount) {
		System.out.println("---------- printDownward2Triangles for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("*");
			}
			// printing spaces
			for (int spaceIndex = 0; spaceIndex < (rowIndex - 1) * 2; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardLeftTriangle(final int rowCount) {
		System.out.println("---------- printDownwardLeftTriangle for row = " + rowCount + " ----------- ");
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing spaces
			for (int spaceIndex = 0; spaceIndex < rowIndex - 1; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightTriangle(final int rowCount) {
		System.out.println("---------- printDownwardRightTriangle for row = " + rowCount + " ----------- ");
		// iteration over the row
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// print the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDiamondPattern(final int rowCount) {

		System.out.println("---------- printDiamondPattern for row = " + rowCount + " ----------- ");
		int i, j;

		// Outer loop work for rows
		for (i = 1; i <= rowCount - 1; i++) {

			// inner loop work for space
			for (j = 0; j <= (rowCount - 1) - i; j++) {
				// prints space between two stars
				System.out.print(" ");
			}

			// inner loop for columns
			for (j = 1; j <= i; j++) {
				// prints star
				System.out.print("* ");
			}

			// moves the cursor in a new line after printing each line
			System.out.println();
		}

		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing spaces
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	private static void printDownwardPyramid(final int rowCount) {
		System.out.println("---------- downward pyramid for row = " + rowCount + " ----------- ");
		// row iteration
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			// printing spaces
			for (int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			// printing the stars
			for (int starIndex = rowIndex; starIndex <= rowCount; starIndex++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	private static void printPyramidStarPattern(int row) {

		// i for rows and j for columns
		// row denotes the number of rows you want to print
		System.out.println("---------- pyramid for row = " + row + " ----------- ");
		int i, j;

		// Outer loop work for rows
		for (i = 1; i <= row; i++) {

			// inner loop work for space
			for (j = 1; j <= row - i; j++) {
				// prints space between two stars
				System.out.print(" ");
			}

			// inner loop for columns
			for (j = 1; j <= i; j++) {
				// prints star
				System.out.print("* ");
			}

			// throws the cursor in a new line after printing each line
			System.out.println();
		}

	}

	private static void printRightTriangleStarPattern(int limit) {
		System.out.println("---------- printRightTriangleStarPattern for row = " + limit + " ----------- ");
		for (int i = 1; i <= limit; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printLeftTriangleStarPattern(int limit) {
		System.out.println("---------- printLeftTriangleStarPattern for row = " + limit + " ----------- ");
		// iteration for steps
		for (int i = 1; i <= limit; i++) {

			// iteration for spaces
			int j = 1;
			while (j <= (limit - i)) {
				System.out.print(" ");
				j++;
			}

			// iteration for star
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

}
