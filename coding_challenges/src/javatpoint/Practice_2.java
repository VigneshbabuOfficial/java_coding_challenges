package javatpoint;

public class Practice_2 {

    public static void main(String[] args) {

        printPatterns();
    }

    private static void printPatterns() {

        printRightTriangleStarPattern(5);
        printDownwardRightTriangle(5);
        printLeftTriangleStarPattern(5);
        printDownwardLeftTriangle(5);
        printUpwardRightLeftTriangles(5);
        printDownwardRightLeftTriangles(5);
        print_downward_upward_right_left_triangles(5);
        printXpattern(5);

        printUpwardPyramid_type_1(5); // with space in between
        printUpwardPyramid_type_2(5); // without space
        printDownwardPyramid_type_1(5); // with space in between
        printDownwardPyramid_type_2(5); // without space
        printDiamondPattern_type_1(5);  // with space in between
        printDiamondPattern_type_2(5); // without space

        print_right_pyramid(5);
        print_left_pyramid(5);
        print_sand_glass_pattern_type_1(5);  // with space in between
        print_sand_glass_pattern_type_2(5);  // without space in between

        print_upward_triangle_border(5);
        print_downward_triangle_border(5);
        print_diamond_border(5);

        // print_right_triangle_number_pattern_1;
        // print_right_triangle_number_pattern_2
        // print_right_triangle_number_pattern_3
        // @formatter:off
		/*

		    1
           121
          12321
         1234321
        123454321
        123453210
         1234510
          12345
           123
            1

		*/
        // @formatter:on
        print_diamond_numbers_type_1(5);

        // @formatter:off
		/*
		    1
		   212
		  32123
		 4321234
		543212345
		543212345
		 4321234
		  32123
		   212
		    1
		*/
        // @formatter:on
        print_diamond_numbers_type_2(5);
    }

    private static void print_diamond_numbers_type_2(int limit) {
        System.out.println("------- print_diamond_numbers_type_2 ------ ");
        int n1;
        int n2;
        for(int ri=1; ri<=limit; ri++){
            n1=ri;
            n2=1;
            for(int spcI=ri; spcI<limit; spcI++){
                System.out.print(" ");
            }
            for(int ni=1; ni<=(ri*2)-1; ni++){
                System.out.print(ni < ri ? n1-- : n2++);
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            n1=limit-ri+1;
            n2=1;
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int ni=1; ni<=((limit-ri)*2)+1; ni++){
                System.out.print(ni <= limit-ri ? n1-- : n2++);
            }
            System.out.println();
        }
    }

    private static void print_diamond_numbers_type_1(int limit) {
        System.out.println("------- print_diamond_numbers_type_1 ------ ");
        int n1;
        for(int ri=1; ri<=limit; ri++){
            n1=ri;
            for(int spcI=ri; spcI<limit; spcI++){
                System.out.print(" ");
            }
            for(int ni=1; ni<=(ri*2)-1; ni++){
//                System.out.print(ni <= ri ? ni : (ri*2)-ni);
                System.out.print(ni <= ri ? ni : --n1);
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            n1= ri==limit ? 1 : limit-ri+1;
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int ni=1; ni<=((limit-ri)*2)+1; ni++){
//                System.out.print(ni <= limit ? ni : ((limit-ri)*2)+1-ni);
                System.out.print(ni <= limit-ri ? ni : n1--);
            }
            System.out.println();
        }
    }

    private static void print_diamond_border(int limit) {
        System.out.println("------- print_diamond_border ------ ");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=ri; spcI<limit; spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=ri; strI++){
                if(strI == 1 || strI == ri ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int strI=ri; strI<=limit; strI++){
                if(strI == ri || ri == limit || strI == limit) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    private static void print_downward_triangle_border(int limit) {
        System.out.println("------- print_downward_triangle_border ------ ");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int strI=ri; strI<=limit; strI++){
                if(ri == 1 || strI == ri || ri == limit || strI == limit) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void print_upward_triangle_border(int limit) {
        System.out.println("------- print_upward_triangle_border ------ ");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=ri; spcI<limit; spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=ri; strI++){
                if(strI == 1 || strI == ri || ri == limit) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void print_sand_glass_pattern_type_2(int limit) {
        System.out.println("------- print_sand_glass_pattern_type_2 ------ without space in between -----");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=((limit-ri)*2)+1; strI++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<=(limit-ri); spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=ri*2-1; strI++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print_sand_glass_pattern_type_1(int limit) {
        System.out.println("------- print_sand_glass_pattern_type_1 ------ with space in between -----");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<ri; spcI++){
                System.out.print(" ");
            }
            for(int strI=ri; strI<=limit; strI++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<=(limit-ri); spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=ri; strI++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void print_left_pyramid(int limit) {
        System.out.println("------- print_left_pyramid ------ ");
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<=(limit-ri); spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=ri; strI++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            for(int spcI=1; spcI<=ri; spcI++){
                System.out.print(" ");
            }
            for(int strI=1; strI<=(limit-ri); strI++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print_right_pyramid(int limit) {
        System.out.println("------- print_right_pyramid ------ ");
        for(int ri=1; ri<=limit; ri++){
            for(int strI=1; strI<=ri; strI++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int ri=1; ri<=limit; ri++){
            for(int strI=1; strI<=(limit-ri); strI++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDiamondPattern_type_2(int limit) {
        System.out.println("------- printDiamondPattern_type_2 ------  without space in between ");
        for(int ri=1;ri<=limit;ri++) {
            for(int spcI=ri;spcI<limit;spcI++) {
                System.out.print(" ");
            }
            for(int strI=1;strI<=(ri*2)-1;strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int ri=1;ri<=limit;ri++){
            for(int spcI=1;spcI<ri;spcI++){
                System.out.print(" ");
            }
            for(int strI=1;strI<=(limit-ri)*2+1;strI++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDiamondPattern_type_1(int limit) {
        System.out.println("------- printDiamondPattern_type_1 ------  with space in between ");
        for(int ri=1;ri<=limit;ri++) {
            for(int spcI=ri;spcI<limit;spcI++) {
                System.out.print(" ");
            }
            for(int strI=1;strI<=ri;strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int ri=1;ri<=limit;ri++){
            for(int spcI=1;spcI<ri;spcI++){
                System.out.print(" ");
            }
            for(int strI=ri;strI<=limit;strI++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printDownwardPyramid_type_2(int limit) {
        System.out.println("------- printDownwardPyramid_type_2 ------  without space in between ");
        for(int ri=1;ri<=limit;ri++){
            for(int spcI=1;spcI<ri;spcI++){
                System.out.print(" ");
            }
            for(int strI=1;strI<=(limit-ri)*2+1;strI++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardPyramid_type_1(int limit) {
        System.out.println("------- printDownwardPyramid_type_1 ------ with space in between ");
        for(int ri=1;ri<=limit;ri++){
            for(int spcI=1;spcI<ri;spcI++){
                System.out.print(" ");
            }
            for(int strI=ri;strI<=limit;strI++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printUpwardPyramid_type_2(int limit) {
        System.out.println("------- printUpwardPyramid_type_2 ------ without space in between ");
        for(int ri=1;ri<=limit;ri++) {
            for(int spcI=ri;spcI<limit;spcI++) {
                System.out.print(" ");
            }
            for(int strI=1;strI<=(ri*2)-1;strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printUpwardPyramid_type_1(int limit) {
        System.out.println("------- printUpwardPyramid_type_1 ------ with space in between ");
        for(int ri=1;ri<=limit;ri++) {
            for(int spcI=ri;spcI<limit;spcI++) {
                System.out.print(" ");
            }
            for(int strI=1;strI<=ri;strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void print_downward_upward_right_left_triangles(int limit) {
        System.out.println("------- print_downward_upward_right_left_triangles ------ ");
        for(int ri=1;ri<=limit;ri++) {
            for(int strI=ri;strI<=limit;strI++) {
                System.out.print("*");
            }
            for(int spI=1;spI<=(ri*2-2);spI++) {
                System.out.print(" ");
            }
            for(int strI=ri;strI<=limit;strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int ri=1;ri<=limit;ri++) {
            for(int strI=1;strI<=ri;strI++) {
                System.out.print("*");
            }
            for(int spcI=1;spcI<=((limit-ri)*2);spcI++) {
                System.out.print(" ");
            }
            for(int strI=1;strI<=ri;strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printXpattern(int limit) {
        System.out.println("------- printXpattern ------ ");
        int limit_1=limit*2;
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int strI=1; strI<=ri; strI++ ) {
                System.out.print("*");
            }
            for ( int spi=1; spi<=(limit_1-(ri*2)); spi++ ) {
                System.out.print(" ");
            }
            for ( int strI=1; strI<=ri; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int strI=ri; strI<=limit; strI++ ) {
                System.out.print("*");
            }
            for ( int spcI=1; spcI<=(ri*2-2); spcI++ ) {
                System.out.print(" ");
            }
            for ( int strI=ri; strI<=limit; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardRightLeftTriangles(int limit) {
        System.out.println("------- printDownwardRightLeftTriangles ------ ");
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int strI=ri; strI<=limit; strI++ ) {
                System.out.print("*");
            }
            for ( int spcI=1; spcI<=(ri*2-2); spcI++ ) {
                System.out.print(" ");
            }
            for ( int strI=ri; strI<=limit; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printUpwardRightLeftTriangles(int limit) {
        System.out.println("------- printUpwardRightLeftTriangles ------ ");
        int limit_1=limit*2;
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int strI=1; strI<=ri; strI++ ) {
                System.out.print("*");
            }
            for ( int spi=1; spi<=(limit_1-(ri*2)); spi++ ) {
                System.out.print(" ");
            }
            for ( int strI=1; strI<=ri; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    private static void printDownwardLeftTriangle(int limit) {
        System.out.println("------- printDownwardLeftTriangle ------ ");
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int spcI=1; spcI<ri; spcI++ ) {
                System.out.print(" ");
            }
            for ( int strI=ri; strI<=limit; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printLeftTriangleStarPattern(int limit) {
        System.out.println("------- printLeftTriangleStarPattern ------ ");
        for ( int ri=1; ri<=limit; ri++ ) {
            for ( int spI=1; spI<=(limit-ri); spI++ ) {
                System.out.print(" ");
            }
            for ( int strI=1; strI<=ri; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardRightTriangle(int limit) {
        System.out.println("------- printDownwardRightTriangle ------ ");
        for ( int ri = 1; ri <= limit; ri++ ) {
            for ( int strI = ri; strI <= limit; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void printRightTriangleStarPattern(int limit) {
        System.out.println("------- printRightTriangleStarPattern ------ ");
        for ( int ri = 1; ri <= limit; ri++ ) {
            for ( int strI = 1; strI <= ri; strI++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
