package others;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice_1 {

    public static void main(String[] args) {
        printPatterns();
        findHighestOccurenceOfAword();
        findLeastWordOccurence();
        findLongestWordInParagraph();
        
        // armstrongNumber();
    }

    private static void findLongestWordInParagraph() {
    	System.out.println("------------ findLongestWordInParagraph -------------------");
		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";
		String[] wordArr = paragraph.split(" ");
		Map<String, Integer> wordsLen = Arrays.stream(wordArr).distinct().collect(Collectors.toMap(String::valueOf,String::length));
		System.out.println("wordsLen = "+wordsLen);
		Integer maxLen = wordsLen.values().stream().max(Integer::compare).orElse(null);
		List<String> longestWords = wordsLen.entrySet().stream().filter(a -> a.getValue().equals(maxLen)).map(Map.Entry::getKey).distinct().toList();
		System.out.println("maxLen = "+maxLen);
		System.out.println("longestWords = "+longestWords);
		
		// --------- find second largest word --------------- //
		// to find second largest word count
		Integer secondLargest = wordsLen.values().stream().filter(Predicate.not(a-> a.equals(maxLen))).max(Integer::compare).orElse(null);
		List<String> secondLargestWordList = wordsLen.entrySet().stream().filter( a-> a.getValue().equals(secondLargest)).map(Map.Entry::getKey).toList();
		System.out.println("secondLargest = "+secondLargest);
		System.out.println("secondLargestWordList = "+secondLargestWordList);
	}

	private static void findLeastWordOccurence() {
    	System.out.println("------------ findLeastWordOccurence -------------------");
    	String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";
		String[] wordArr = paragraph.split(" ");
		Map<String, Long> wordsCount = Arrays.stream(wordArr).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(" wordsCount = "+wordsCount);
		Long minCommonWordCount = wordsCount.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
		List<String> minCommonWordList = wordsCount.entrySet().stream().filter(a -> a.getValue().equals(minCommonWordCount)).map(Map.Entry::getKey).distinct().toList();
		System.out.println(" minCommonWordCount = "+minCommonWordCount);
		System.out.println(" minCommonWordList = "+minCommonWordList);
    }

    private static void findHighestOccurenceOfAword() {

        System.out.println("------------ fidingHighestOccurenceOfAword -------------------");
        String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";

        String[] wordsArr = paragraph.split(" ");

        Map<String, Long> wordMap = Arrays.stream(wordsArr).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println("wordMap = "+wordMap);
        Long mostCommonWordCount = wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        List<String> mostCommonWordList = wordMap.entrySet().stream().filter(a -> a.getValue().equals(mostCommonWordCount))
                .map(Map.Entry::getKey).distinct().toList();

        System.out.println("mostCommonWordCount = "+mostCommonWordCount);
        System.out.println("mostCommonWordList = "+mostCommonWordList);

        String secondCommonWord = wordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).skip(1).findFirst()
                .map(Map.Entry::getKey).orElse(null);
        System.out.println("second most common word = " + secondCommonWord);
        // another way
        String secondMostCommonWord = mostCommonWordList.stream().sorted().skip(1).findFirst().get();
        System.out.println("second most common word = " + secondMostCommonWord);

    }

    private static void printPatterns() {
    	System.out.println("--------------printRightTriangleStarPattern-----------------");
		printRightTriangleStarPattern(5);
        printRightTriangleStarPattern(8);
        System.out.println("-------------------------------");
        
        System.out.println("--------------printLeftTriangleStarPattern-----------------");
        printLeftTriangleStarPattern(5);
        printLeftTriangleStarPattern(8);
        System.out.println("-------------------------------");
        
        System.out.println("--------------printUpperPyramidStarPattern-----------------");
        printUpperPyramidStarPattern(5);
        printUpperPyramidStarPattern(8);
        System.out.println("-------------------------------");
        
        System.out.println("--------------printDownwardRightTriangleStarPattern-----------------");
        printDownwardRightTriangleStarPattern(5);
        printDownwardRightTriangleStarPattern(8);
        System.out.println("-------------------------------");
        
        System.out.println("--------------prinDownwardtLeftTriangleStarPattern-----------------");
        prinDownwardLeftTriangleStarPattern(5);
        prinDownwardLeftTriangleStarPattern(8);
        System.out.println("-------------------------------");
        
        System.out.println("--------------printDownwardPyramidStarPattern-----------------");
        printDownwardPyramidStarPattern(5);
        printDownwardPyramidStarPattern(8);
        System.out.println("-------------------------------");
        
        printDiamondPattern(5);
        printDiamondPattern(8);
        System.out.println("-------------------------------");

        print2DownwardTriangles(5);
        print2DownwardTriangles(8);
        System.out.println("-------------------------------");
        print2UpwardTriangles(5);
        print2UpwardTriangles(8);
        System.out.println("-------------------------------");
        printRightPyramid(5);
        printRightPyramid(8);
        System.out.println("-------------------------------");
        printLeftPyramid(5);
        printLeftPyramid(8);
        System.out.println("-------------------------------");
        printSandGlassPattern(5);
        printSandGlassPattern(8);
        System.out.println("-------------------------------");
        printTriangleBorder(5);
        printTriangleBorder(8);
        System.out.println("-------------------------------");
        printDownwardTriangleBorder(5);
        printDownwardTriangleBorder(8);
        System.out.println("-------------------------------");
        printDiamondPatternBorder(5);
        printDiamondPatternBorder(8);
        System.out.println("-------------------------------");
        printRightTriangleWithNumbersPattern_1(5);
        printRightTriangleWithNumbersPattern_1(8);
        System.out.println("-------------------------------");
        printRightTriangleWithNumbersPattern_2(5);
        printRightTriangleWithNumbersPattern_2(8);
        System.out.println("-------------------------------");
        printRightTriangleWithNumbersPattern_3(5);
        printRightTriangleWithNumbersPattern_3(8);
        System.out.println("-------------------------------");



    }

    private static void printRightTriangleWithNumbersPattern_3(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount ; rowIdx++) {
            int num = rowIdx;
            for (int nIdx = 1; nIdx <= rowIdx ; nIdx++) {
                System.out.print(num-- +" ");
            }
            System.out.println();
        }
    }

    private static void printRightTriangleWithNumbersPattern_2(int rowCount) {
        int num = 1;
        for (int rowIdx = 1; rowIdx <= rowCount ; rowIdx++) {
            for (int nIdx = 1; nIdx <= rowIdx ; nIdx++) {
                System.out.print(num++ +" ");
            }
            System.out.println();
        }
    }

    private static void printRightTriangleWithNumbersPattern_1(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount ; rowIdx++) {
            for (int nIdx = 1; nIdx <= rowIdx ; nIdx++) {
                System.out.print(nIdx+" ");
            }
            System.out.println();
        }
    }

    private static void printDiamondPatternBorder(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                if (starIdx == 1 || starIdx == rowIdx )
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowIdx - 1; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                if (starIdx == rowIdx || starIdx == rowCount)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void printDownwardTriangleBorder(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowIdx - 1; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                if (rowIdx == 1 || starIdx == rowIdx || starIdx == rowCount)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void printTriangleBorder(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                if (starIdx == 1 || starIdx == rowIdx || rowIdx == rowCount)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void printSandGlassPattern(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowIdx - 1; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printLeftPyramid(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = rowIdx; spaceIdx < rowCount; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
        int rowCount_1 = rowCount - 1;
        for (int rowIdx = 1; rowIdx <= rowCount_1; rowIdx++) {
            for (int spaceIdx = 1; spaceIdx <= rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount_1; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printRightPyramid(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int starIdx = rowCount - rowIdx; starIdx >= 1; starIdx--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print2UpwardTriangles(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("*");
            }
            for (int spaceIdx = 0; spaceIdx < (rowCount - rowIdx) * 2; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print2DownwardTriangles(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int starIdx = rowCount; starIdx >= rowIdx; starIdx--) {
                System.out.print("*");
            }
            for (int spaceIdx = 0; spaceIdx < (rowIdx - 1) * 2; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void printDownwardLeftTriangle(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowIdx - 1; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardRightTriangle(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int starIdx = rowCount; starIdx >= rowIdx; starIdx--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDiamondPattern(int rowCount) {
        // printing upper pyramid
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        // printing lower pyramid
        int rowCount_1 = rowCount - 1;
        for (int rowIdx = 1; rowIdx <= rowCount_1; rowIdx++) {
            System.out.print(" ");
            for (int spaceIdx = 1; spaceIdx < rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount_1; starIdx++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void printDownwardPyramidStarPattern(int r) {
		for( int rowIndex = 1; rowIndex <= r; rowIndex++ ) {
			for(int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++ ) {
				System.out.print(" ");
			}
			for( int starIndex = r; starIndex >= rowIndex; starIndex-- ) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void prinDownwardLeftTriangleStarPattern(int r) {
		for( int rowIndex = 1; rowIndex <= r; rowIndex++ ) {
			for( int spaceIndex = 1; spaceIndex < rowIndex; spaceIndex++ ) {
				System.out.print(" ");
			}
			for( int starIndex = r; starIndex >= rowIndex; starIndex-- ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printDownwardRightTriangleStarPattern(int r) {
		for(int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for(int starIndex = r; starIndex >= rowIndex; starIndex-- ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printUpperPyramidStarPattern(int r) {
		for(int rowIndex = 1; rowIndex <= r; rowIndex++) {
			for( int spaceIndex = 1; spaceIndex <= r-rowIndex; spaceIndex++ ) {
				System.out.print(" ");
			}
			for( int starIndex = 1; starIndex <= rowIndex; starIndex++ ) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void printLeftTriangleStarPattern(int r) {
		for( int rowIndex = 1; rowIndex <= r; rowIndex++ ) {
			for( int spaceIndex = 1; spaceIndex <= r-rowIndex; spaceIndex++ ) {
				System.out.print(" ");
			}
			for( int starIndex = 1; starIndex <= rowIndex; starIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printRightTriangleStarPattern(int r) {
		for( int rowIndex = 1; rowIndex <= r; rowIndex++ ) {
			for(int starIndex = 1; starIndex <= rowIndex; starIndex++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
