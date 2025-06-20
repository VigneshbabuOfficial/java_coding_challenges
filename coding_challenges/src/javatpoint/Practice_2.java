package javatpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice_2 {

    public static void main(String[] args) {

        printPatterns();

        fibonacci_series();

        armstrong_number_problems();

        factorial();

        palindrome();

        primeNumber();

        findGCD();

        findLargest();

        // ----------------- JavaTPoint String Programs -----------------
        // Java Program to divide a string in 'N' equal parts.
        // TODO
        // Java Program to find all subsets of a string
        findAllSubsetOfAString();
        // TODO
        // Java Program to find the longest repeating sequence in a string

        // Java Program to replace lower-case characters with upper-case and vice-versa
        changeCase();

        // Java Program to find maximum and minimum occurring character in a string.
        // Java program to find the duplicate characters in a string
        // Java Program to find the frequency of characters
        charFromString();

        // Java Program to find maximum and minimum occurring word in a string.
        // Java Program to find the largest and smallest word in a string.
        // Java program to find the duplicate words in a string
        removeSpecialCharsFromString();
        wordFromString();
        // Java Program to Count the Total Number of Punctuation Characters Exists in a String
        countSpecialChar();
        // Java Program to swap two string variables without using third or temp variable.
        swapString();
        // Reverse a String
        reverseString();


        // TODO
        // ------------------------ JavaTPoint Array Programs --------------------------
        // --------------------- JavaTPoint Searching and Sorting Programs ---------------------

        // Stream API methods ( collect , collectors )

        // all interview probs
        // hackerrank probs

    }

    private static void reverseString() {
        System.out.println("------- reverseString ------ ");
        String str="123456";
        StringBuilder sb = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        System.out.println("main string = "+str+"  reversed = "+sb);
    }

    private static void swapString() {
        System.out.println("------- swapString ------ ");
        String str1 = "123", str2 = "4567";
        System.out.println("BEFORE SWAP str1 = "+str1+"  str2 = "+str2);
        str1 = str1 + str2;
        str2 = str1.substring(0,str1.length()-str2.length());
        str1 = str1.substring(str2.length());
        System.out.println("AFTER SWAP str1 = "+str1+"  str2 = "+str2);
    }

    private static void countSpecialChar() {
        System.out.println("------- countSpecialChar ------ ");
        int count = 0;
        String str = "He said, 'The mailman loves you.' I heard it with my own ears.";
        List<String> splCharList = List.of("!",",",".",":",";","?","-","'","\"");
        for(int i=0; i<str.length(); i++){
            if(splCharList.contains(str.charAt(i)+"")) count++;
        }
        System.out.println("total special characters = "+count);
    }

    private static void removeSpecialCharsFromString() {
        System.out.println("------- removeSpecialCharsFromString ------ ");
        String paragraph = "Lorem ipsum! dolor sit. amet consectetur, dolor adipiscing elit ipsum?";

        // !,.:;?-'"
        String cleaned = paragraph.replaceAll("[!,.:;?\\-'\"]", "");
        System.out.println(" paragraph = "+paragraph);
        System.out.println(" cleaned = "+cleaned);
    }

    private static void wordFromString() {
        System.out.println("------- wordFromString ------ ");
        String paragraph = "Lorem ipsum! dolor sit. amet consectetur, dolor adipiscing elit ipsum? donsectetur";
        String removedSpecChar = paragraph.replaceAll("[!,.:;?\\-'\"]", "");
        Map<String, Long> wordMap = Arrays.stream(removedSpecChar.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordMap);

        // minimum occurrence word
        Long minWordCount = wordMap.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        List<String> minWords = wordMap.entrySet().stream().filter(a->a.getValue().equals(minWordCount)).map(Map.Entry::getKey).toList();
        System.out.println("minWords = "+minWords);

        // maximum occurrence words
        Long maxWordCount = wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        List<String> maxWords = wordMap.entrySet().stream().filter(a->a.getValue().equals(maxWordCount)).map(Map.Entry::getKey).toList();
        System.out.println("maxWords = "+maxWords);

        // largest word in a string
        Map<Integer, List<String>> wordsLengthMap = wordMap.keySet().stream().collect(Collectors.groupingBy(String::length));
        System.out.println("wordsLengthMap = "+wordsLengthMap);
        List<String> largeWords = wordsLengthMap.entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);
        System.out.println("largeWords = "+largeWords);

        // smallest word in a string
        List<String> smallWords = wordsLengthMap.entrySet().stream().min(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);
        System.out.println("smallWords = "+smallWords);

        // duplicate words
        List<String> duplicateWords = wordMap.entrySet().stream().filter(a->a.getValue() > 1L ).map(Map.Entry::getKey).toList();
        System.out.println("duplicateWords = "+duplicateWords);

    }

    private static void charFromString() {
        System.out.println("------- charFromString ------ ");
        String str = "abcaba";
        Map<String, Long> wordMapObj = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordMapObj);

        // maximum occurred character
        Map.Entry<String, Long> maxChar = wordMapObj.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println("maximum occurred char = " + maxChar);

        // minimum occurred character
        Map.Entry<String, Long> minChar = wordMapObj.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
        System.out.println("minimum occurred char = " + minChar);

        // duplicate characters
        List<String> list = wordMapObj.entrySet().stream().filter(a -> a.getValue() > 1L).map(Map.Entry::getKey).toList();
        System.out.println("duplicate characters = " +list);

        // frequency of characters = wordMapObj
        Map<Character, Long> strMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strMap);
    }

    private static void changeCase() {
        System.out.println("------- changeCase ------ ");
        String str1 = "Great Power";
        StringBuffer newStr = new StringBuffer(str1);
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLowerCase(str1.charAt(i))) {
                newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));
            } else if (Character.isUpperCase(str1.charAt(i))) {
                newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));
            }
        }
        System.out.println("String before case conversion : " + str1);
        System.out.println("String after case conversion : " + newStr);
    }


    private static void findAllSubsetOfAString() {
        System.out.println("------- findAllSubsetOfAString ------ ");
        String input = "teacher";
        List<String> combinations = new ArrayList<>();
        combinations.add(""); // start with empty combination

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int size = combinations.size();

            // For every existing combination, add new character
            for (int j = 0; j < size; j++) {
                String newCombo = combinations.get(j) + currentChar;
                combinations.add(newCombo);
            }
        }

        // Print all non-empty combinations
        System.out.println("All combinations of \"" + input + "\":");
        combinations.removeIf(a -> a.isEmpty());
        List<String> newComb = combinations.stream().distinct().toList();
        System.out.println(newComb.size());
    }

    private static void findLargest() {
        System.out.println("------- findLargest ------ ");
        List<Integer> numList = List.of(545, 499, 8, 111, 550, 520, 45, 455, 500);
        // biggest
//        Integer maxNum = numList.stream().max(Integer::compare).get();
        Integer maxNum = Collections.max(numList);
        System.out.println("Max num is " + maxNum);

        // second biggest
        int biggest = Integer.MIN_VALUE, secondBigg = Integer.MIN_VALUE, num;
        for (int i = 0; i < numList.size(); i++) {
            num = numList.get(i);
            if (num > biggest) {
                secondBigg = biggest;
                biggest = num;
            } else if (num > secondBigg && num < biggest) secondBigg = num;
        }
        System.out.println("biggest = " + biggest + "  secondBigg = " + secondBigg);
    }

    private static void findGCD() {
        System.out.println("------- findGCD ------ ");
        int num1 = 8, num2 = 100, gcd = 0;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) gcd = i;
        }
        System.out.println("GCD of " + num1 + " & " + num2 + " is " + gcd);
    }

    private static void primeNumber() {
        System.out.println("------- primeNumber ------ ");
        System.out.println("15 is " + (isPrime(15) ? " a " : " not a ") + " prime number");
        generatePrimeNum();
    }

    private static void generatePrimeNum() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i)) sb.append(" ").append(i);
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static void palindrome() {
        System.out.println("------- palindrome ------ ");
        System.out.println("121 is " + (isPalindrome(121) == true ? " a " : " not a ") + "palindrome");
        generatePalindrome();
    }

    private static void generatePalindrome() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            if (isPalindrome(i)) sb.append(" " + i);
        }
        System.out.println(sb);
    }

    private static boolean isPalindrome(int num) {
        StringBuilder sb = new StringBuilder();
        int r, temp = num;
        do {
            r = num % 10;
            sb.append(r);
            num /= 10;
        } while (num > 0);

        return String.valueOf(temp).equals(sb.toString());
    }

    private static void factorial() {
        System.out.println("------- factorial ------ ");
        findFactorial(5);
        System.out.println("factorial of 5 is " + findFactorialRecursive(5));
    }

    private static int findFactorialRecursive(int num) {
        if (num <= 1) return 1;
        return num * findFactorialRecursive(num - 1);
    }

    private static void findFactorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("factorial of " + num + " is " + fact);
    }

    private static void armstrong_number_problems() {
        System.out.println("------- armstrong_number_problems ------ ");
        int num = 153;
        System.out.println(num + (isArmstrong(num) ? " is" : " is not") + " an Armstrong number");
        getArmstrongNumbers(10000);
    }

    private static void getArmstrongNumbers(int limit) {
        System.out.println("Armstrong numbers for the limit : " + limit);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < limit; i++) {
            if (isArmstrong(i)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static boolean isArmstrong(int num) {
        int digits = (int) Math.log10(num) + 1;
        int temp = num, sum = 0;
        while (temp > 0) {
            int r = temp % 10;
            sum += Math.pow(r, digits);
            temp /= 10;
        }
        return sum == num;
    }

    private static void fibonacci_series() {
        System.out.println("------- fibonacci_series ------ ");
        int limit = 10, first = 0, second = 1, next;
        if (limit < 1) {
            System.out.println("Fibonacci series is not possible with limit less than 1.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for (int i = 1; i < limit; i++) {
            sb.append(" ").append(second);
            next = first + second;
            first = second;
            second = next;
        }
        System.out.println("Fibonacci series with limit = " + limit + ": ");
        System.out.println(sb);
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
        for (int ri = 1; ri <= limit; ri++) {
            n1 = ri;
            n2 = 1;
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int ni = 1; ni <= (ri * 2) - 1; ni++) {
                System.out.print(ni < ri ? n1-- : n2++);
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            n1 = limit - ri + 1;
            n2 = 1;
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int ni = 1; ni <= ((limit - ri) * 2) + 1; ni++) {
                System.out.print(ni <= limit - ri ? n1-- : n2++);
            }
            System.out.println();
        }
    }

    private static void print_diamond_numbers_type_1(int limit) {
        System.out.println("------- print_diamond_numbers_type_1 ------ ");
        int n1;
        for (int ri = 1; ri <= limit; ri++) {
            n1 = ri;
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int ni = 1; ni <= (ri * 2) - 1; ni++) {
//                System.out.print(ni <= ri ? ni : (ri*2)-ni);
                System.out.print(ni <= ri ? ni : --n1);
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            n1 = ri == limit ? 1 : limit - ri + 1;
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int ni = 1; ni <= ((limit - ri) * 2) + 1; ni++) {
//                System.out.print(ni <= limit ? ni : ((limit-ri)*2)+1-ni);
                System.out.print(ni <= limit - ri ? ni : n1--);
            }
            System.out.println();
        }
    }

    private static void print_diamond_border(int limit) {
        System.out.println("------- print_diamond_border ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                if (strI == 1 || strI == ri) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                if (strI == ri || ri == limit || strI == limit) {
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
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                if (ri == 1 || strI == ri || ri == limit || strI == limit) {
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
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                if (strI == 1 || strI == ri || ri == limit) {
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
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ((limit - ri) * 2) + 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI <= (limit - ri); spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri * 2 - 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print_sand_glass_pattern_type_1(int limit) {
        System.out.println("------- print_sand_glass_pattern_type_1 ------ with space in between -----");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI <= (limit - ri); spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void print_left_pyramid(int limit) {
        System.out.println("------- print_left_pyramid ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI <= (limit - ri); spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI <= ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= (limit - ri); strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void print_right_pyramid(int limit) {
        System.out.println("------- print_right_pyramid ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= (limit - ri); strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDiamondPattern_type_2(int limit) {
        System.out.println("------- printDiamondPattern_type_2 ------  without space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= (ri * 2) - 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= (limit - ri) * 2 + 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDiamondPattern_type_1(int limit) {
        System.out.println("------- printDiamondPattern_type_1 ------  with space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printDownwardPyramid_type_2(int limit) {
        System.out.println("------- printDownwardPyramid_type_2 ------  without space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= (limit - ri) * 2 + 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardPyramid_type_1(int limit) {
        System.out.println("------- printDownwardPyramid_type_1 ------ with space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printUpwardPyramid_type_2(int limit) {
        System.out.println("------- printUpwardPyramid_type_2 ------ without space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= (ri * 2) - 1; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printUpwardPyramid_type_1(int limit) {
        System.out.println("------- printUpwardPyramid_type_1 ------ with space in between ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = ri; spcI < limit; spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void print_downward_upward_right_left_triangles(int limit) {
        System.out.println("------- print_downward_upward_right_left_triangles ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            for (int spI = 1; spI <= (ri * 2 - 2); spI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            for (int spcI = 1; spcI <= ((limit - ri) * 2); spcI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printXpattern(int limit) {
        System.out.println("------- printXpattern ------ ");
        int limit_1 = limit * 2;
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            for (int spi = 1; spi <= (limit_1 - (ri * 2)); spi++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            for (int spcI = 1; spcI <= (ri * 2 - 2); spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardRightLeftTriangles(int limit) {
        System.out.println("------- printDownwardRightLeftTriangles ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            for (int spcI = 1; spcI <= (ri * 2 - 2); spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printUpwardRightLeftTriangles(int limit) {
        System.out.println("------- printUpwardRightLeftTriangles ------ ");
        int limit_1 = limit * 2;
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            for (int spi = 1; spi <= (limit_1 - (ri * 2)); spi++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    private static void printDownwardLeftTriangle(int limit) {
        System.out.println("------- printDownwardLeftTriangle ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spcI = 1; spcI < ri; spcI++) {
                System.out.print(" ");
            }
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printLeftTriangleStarPattern(int limit) {
        System.out.println("------- printLeftTriangleStarPattern ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int spI = 1; spI <= (limit - ri); spI++) {
                System.out.print(" ");
            }
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDownwardRightTriangle(int limit) {
        System.out.println("------- printDownwardRightTriangle ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = ri; strI <= limit; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void printRightTriangleStarPattern(int limit) {
        System.out.println("------- printRightTriangleStarPattern ------ ");
        for (int ri = 1; ri <= limit; ri++) {
            for (int strI = 1; strI <= ri; strI++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
