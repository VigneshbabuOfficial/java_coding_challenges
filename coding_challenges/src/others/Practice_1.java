package others;

public class Practice_1 {

    public static void main(String[] args) {
        printPatterns();
    }

    private static void printPatterns() {
        printRightTriangleStarPattern(5);
        printRightTriangleStarPattern(8);
        System.out.println("-------------------------------");
        printLeftTriangleStarPattern(5);
        printLeftTriangleStarPattern(8);
        System.out.println("-------------------------------");
        printUpperPyramidStarPattern(5);
        printUpperPyramidStarPattern(8);
        System.out.println("-------------------------------");
        printDownwardPyramid(5);
        printDownwardPyramid(8);
        System.out.println("-------------------------------");
        printDiamondPattern(5);
        printDiamondPattern(8);
        System.out.println("-------------------------------");
        printDownwardRightTriangle(5);
        printDownwardRightTriangle(8);
        System.out.println("-------------------------------");
        printDownwardLeftTriangle(5);
        printDownwardLeftTriangle(8);
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

    private static void printDownwardPyramid(int rowCount) {
        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < (rowIdx - 1); spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = rowIdx; starIdx <= rowCount; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printUpperPyramidStarPattern(int rowCount) {

        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void printLeftTriangleStarPattern(int rowCount) {

        for (int rowIdx = 1; rowIdx <= rowCount; rowIdx++) {
            for (int spaceIdx = 0; spaceIdx < rowCount - rowIdx; spaceIdx++) {
                System.out.print(" ");
            }
            for (int starIdx = 1; starIdx <= rowIdx; starIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printRightTriangleStarPattern(int n) {

        for (int rowIdx = 1; rowIdx <= n; rowIdx++) {
            for (int colIdx = 1; colIdx <= rowIdx; colIdx++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
