package javatpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        // ====================================================== //

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
        // find non-repeating character in a string
        nonRepeatingChracter();

        // find non-repeating character in a string
        nonRepeatingWord();
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

        // ====================================================== //

        // ------------------------ JavaTPoint Array Programs --------------------------
        // Java Program to find the frequency of each element in the array
        freqOfElement();
        // Java Program to print the duplicate elements of an array
        duplicateElements();
        // Java Program to Remove Duplicate Element in an array
        removeDuplicates();

        // Program to left rotate the elements of an array
        leftRotation();
        // Java Program to right rotate the elements of an array
        rightRotation();

        // Java Program to print the largest element in an array
        // Java Program to Find 2nd Largest Number in an array
        largestElement();
        // Java Program to print the smallest element in an array
        // Java Program to Find 2nd smallest Number in an array
        smallestElement();

        // Java Program to print the sum of all the items of the array
        arraySum();

        // Java Program to sort the elements of an array in ascending order
        arrayAscending();
        // Java Program to sort the elements of an array in descending order
        arrayDescending();

        // ====================================================== //

        // TODO
        // --------------------- JavaTPoint Searching and Sorting Programs ---------------------

        // ------------------ Stream API methods ( collect , collectors ) --------------------
        streamAPIMethods();

        // all previous interview probs

        // hackerrank probs

    }

    private static void nonRepeatingWord() {
        System.out.println("------- nonRepeatingWord ------ ");
        String paragraph = "Lorem ipsum! dolor sit. amet consectetur, dolor adipiscing elit ipsum? donsectetur";
        String removedSpecChar = paragraph.replaceAll("[!,.:;?\\-'\"]", "").toLowerCase();
        System.out.println(" removedSpecChar = "+removedSpecChar);
        String nonRepeatedString = Arrays.stream(removedSpecChar.split(" ")).map(String::toLowerCase).filter(a -> removedSpecChar.indexOf(a) == removedSpecChar.lastIndexOf(a)).findFirst().orElse(null);
        System.out.println(" nonRepeatedString = "+nonRepeatedString);
        List<String> list = Arrays.stream(removedSpecChar.split(" ")).map(String::toLowerCase).filter(a -> removedSpecChar.indexOf(a) == removedSpecChar.lastIndexOf(a)).toList();
        System.out.println(list);

    }

    private static void nonRepeatingChracter() {
        System.out.println("------- nonRepeatingChracter ------ ");
        String str = "swiss";
        Character nonRepeatChar = str.chars().mapToObj(a -> (char) a).filter(a -> str.indexOf(a) == str.lastIndexOf(a)).findFirst().orElse(null);
        System.out.println(nonRepeatChar);

        // find all non-repeating characters in a string
        List<Character> list = str.chars().mapToObj(a -> (char) a).filter(a -> str.indexOf(a) == str.lastIndexOf(a)).toList();
        System.out.println(list);
    }

    private static void streamAPIMethods() {
        System.out.println("------- streamAPIMethods ------ ");

        // Creating Streams :
        List<String> myList = Arrays.asList("apple", "banana", "orange");
        Stream<String> sequentialStream = myList.stream();
        Stream<String> parallelStream = myList.parallelStream();

        /*
        -------------- Intermediate Operations -----------
        Filtering -----	filter(), distinct(), limit(), skip()
        Mapping	------ map(), mapToInt(), flatMap()
        Sorting	----- sorted(), sorted(Comparator)
        Peeking	----- peek()
        */
        // ---------- MAP --------
        // map() is an intermediate stream method that takes a Function as input, processes each element by applying the function, and returns a new stream of transformed results
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Function<Integer, Integer> triple = value -> value * 3;
        Stream<Integer> mappedStream = integerStream.map(triple);
        mappedStream.forEach(System.out::print);

        Predicate<String> isLong = s -> s.length() > 5;
        Stream<String> strStream = Stream.of("vicky","steven");
        List<String> list = strStream.filter(isLong).toList();
        System.out.println(list);

        // ------------- FLATMAP -------------
        // flatMap() is an intermediate stream operation that takes a function which maps each element to a stream, then flattens those nested streams into a single stream of elements.
        List<String> names = Arrays.asList("john", "emma");
        List<Character> characterList = names.stream().flatMap(x -> x.chars().mapToObj(i -> (char) i))
                .collect(Collectors.toList());
        System.out.println(" characterList = " + characterList); // 'j', 'o', 'h', 'n', 'e', 'm', 'm', 'a'

        List<List<String>> fruits = Arrays.asList(Arrays.asList("apple", "mango"), Arrays.asList("banana"),
                Arrays.asList("orange"));
        List<String> fruitList = fruits.stream().flatMap(f -> f.stream()).toList();
        System.out.println(" fruitList = " + fruitList);

        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).toList();
        System.out.println(" flattenedList = " + flattenedList);

        // Filtering -----	filter(), distinct(), limit(), skip()

        // Sorting	----- sorted(), sorted(Comparator)
        // ---------------------- SORTED ----------------------
        Stream<Integer> unsortedStream = Stream.of(5, 7, 0, 2, 8, 0, 4);
        List<Integer> sortedList = unsortedStream.sorted().toList();
        System.out.println("sortedList = " + sortedList);

        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 26),
                new Person("David", 30));
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName)).toList();
        System.out.println("sortedPeople = "+sortedPeople);

        // Peeking	----- peek()
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squares = numbers.stream()
                .peek(n -> System.out.println("Processing number: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("Processed to square: " + n))
                .toList();
        System.out.println("squares = "+squares);

        /*
        ------------------------- Terminal Operations -------------------------
        Iteration -------	forEach(), forEachOrdered()
        Reduction ------	reduce(), count(), min(), max(), sum(), average()
        Matching -------	anyMatch(), allMatch(), noneMatch()
        Finding --------	findFirst(), findAny()
        Collection -----	collect(), Collectors.toList(), toSet(), toMap()
        */
        // findAny(), findFirst()
        Person findFirstData = people.stream().filter(p -> p.getName().equalsIgnoreCase("bob")).findFirst()
                .orElse(new Person("NOT_FOUND", 0));
        System.out.println("findFirstData = " + findFirstData);
        Person findFirstData_2 = people.stream().filter(p -> p.getAge() > 30).findFirst()
                .orElse(new Person("NOT_FOUND", 0));
        System.out.println("findFirstData_2 = " + findFirstData_2);
        Person findFirstData_3 = people.stream().filter(p -> p.getAge() > 30).findAny()
                .orElse(new Person("NOT_FOUND", 0));
        System.out.println("findFirstData_3 = " + findFirstData_3);

        // allMatch(), noneMatch(), anyMatch()
        boolean allMatchStat = people.stream().allMatch(p -> p.getAge() > 25); // false
        System.out.println("allMatchStat = " + allMatchStat);

        // boolean noneMatchStat = people.stream().noneMatch(p -> p.getAge() > 25); //
        // false
        List<String> names1 = List.of("John", "Alex", "Bob");
        boolean result = names1.stream().noneMatch(name -> name.startsWith("Z"));
        System.out.println(result);  // true

        boolean anyMatchStat = people.stream().anyMatch(p -> p.getAge() > 25); // true
        System.out.println("anyMatchStat = " + anyMatchStat);

        // Min With Int Comparator
        Optional<Integer> minNum = numbers.stream().min(Integer::compare);
        System.out.println("minNum = " + minNum);

        // Max With Integer Comparator
        Optional<Integer> maxNum = numbers.stream().max(Integer::compare);
        System.out.println("maxNum = " + maxNum);

        // mapToInt -> sum, average, count
        // int sum = numbers.stream().filter(n-> n%2 ==0 ).mapToInt(Integer::intValue).sum();
        // int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).sum();
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        double avg = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).average().orElse(0);
        System.out.println("avg = " + avg);
        long count = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).count();
        System.out.println("count = " + count);

        // Reduction operations
        String[] myArray = { "Where", "is", "my", "stream", "?" };
        String result1 = Arrays.stream(myArray).reduce("", (a, b) -> a + " " + b);
        System.out.println("result1 = " + result1);

        // From stream to array
        // mystream.toArray(String[]::new);

        // Collectors.groupingBy()
        Map<Integer, List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("groupByAge = " + groupByAge);

        String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";
        String[] wordArr = paragraph.replaceAll(" ", "").split(" ");
        Map<String, Long> wordMap = Arrays.stream(wordArr)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println(wordMap);
        Map<String, Integer> wordMap_1 = Arrays.stream(wordArr).distinct()
                .collect(Collectors.toMap(String::valueOf, String::length));
        System.out.println(wordMap_1);

        // List to Map
        Map<String, Person> groupByName = people.stream().collect(Collectors.toMap(Person::getName, person -> person));
        System.out.println("groupByName = " + groupByName);

        // List to Set
        // numbers.stream().collect(Collectors.toSet());

        // Map to List
        List<Person> _age_25_list = groupByAge.entrySet().stream().filter(p -> p.getKey() == 25)
                .flatMap(entry -> entry.getValue().stream()).toList();
        System.out.println("_age_25_list = " + _age_25_list);

        /*
        Collectors API
        Grouping -------	groupingBy(), groupingBy(..., counting()) - more than 2 partitions
        Partitioning ---	partitioningBy() - 2 partition
        Aggregation ----	counting(), summarizingInt(), joining()
        Mapping inside --	mapping(), reducing()
        */

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitioned);
        // {false=[1, 3, 5], true=[2, 4, 6]}

        // example
        // find mostly ordered product
        Order order1 = new Order(new ArrayList<>() {
            {
                add(new Product("dell"));
                add(new Product("HP"));
                add(new Product("DELL"));
                add(new Product("VAIO"));
            }
        });

        Order order2 = new Order(new ArrayList<>() {
            {
                add(new Product("HP"));
                add(new Product("HP"));
                add(new Product("DELL"));
                add(new Product("apple"));
                add(new Product("VAIO"));
            }
        });

        Order order3 = new Order(new ArrayList<>() {
            {
                add(new Product("APPLE"));
                add(new Product("HP"));
                add(new Product("DELL"));
                add(new Product("APPLE"));
                add(new Product("APPLE"));
                add(new Product("vaio"));
            }
        });


        List<Product> productList = List.of(order1,order2,order3).stream().flatMap(o -> o.getProductList().stream()).toList();
        Map<String, Long> prodCount = productList.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

        // Find the maximum count
        long maxCount = prodCount.values().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0);

        Long max = prodCount.values().stream().max(Long::compare).get();

        // Collect products with the maximum count
        List<String> mostOrderedProducts = prodCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey).toList();
//                .collect(Collectors.toList());
        System.out.println("mostly Ordered Products = "+mostOrderedProducts+"("+maxCount+")");


        String[] str = new String[5];
        String value = Optional.ofNullable(str[2]).orElse("DEFAULT_VAL");
        System.out.println(value); // O/P : DEFAULT_VAL


    }

    private static void arrayDescending() {
        System.out.println("------- arrayDescending ------ ");
        int[] arr = {4,3,1,6,2,5};
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if( arr[j] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Descending order = "+Arrays.toString(arr));
    }

    private static void arrayAscending() {
        System.out.println("------- arrayAscending ------ ");
        int[] arr = {4,3,1,6,2,5};
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j] ){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("Ascending order = "+Arrays.toString(arr));
    }

    private static void arraySum() {
        System.out.println("------- arraySum ------ ");
        int[] arr = new int[]{1, 2, 8, 3, 2, 2, 2, 5, 1};
        int sum = Arrays.stream(arr).boxed().mapToInt(Integer::intValue).sum();
        System.out.println("sum = "+sum);

        int sum2 = Arrays.stream(arr).sum();
        System.out.println("sum2 = "+sum2);

        Integer[] arr1 = {1,2,3};
        int sum1 = Arrays.stream(arr1).mapToInt(Integer::intValue).sum();
        System.out.println("sum1 = "+sum1);

    }

    private static void removeDuplicates() {
        System.out.println("------- removeDuplicates ------ ");
        int[] arr = new int[]{1, 2, 8, 3, 2, 2, 2, 5, 1};
        System.out.println("arr = " + Arrays.toString(arr));
        int[] dupRem = Arrays.stream(arr).distinct().toArray();
        System.out.println("dupRem = " + Arrays.toString(dupRem));

    }

    private static void rightRotation() {
        System.out.println("------- rightRotation ------ ");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("before rotation = " + Arrays.toString(arr));
        int last = 0, rot = 3, len = arr.length;
        for (int r = 1; r <= rot; r++) {
            last = arr[len - 1];
            for (int i = len - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
        }
        System.out.println("after rotation = " + Arrays.toString(arr));
    }

    private static void smallestElement() {
        System.out.println("------- smallestElement ------ ");
        int[] arr = new int[]{25, 11, 7, 75, 56};
        System.out.println(Arrays.toString(arr));
        Integer smallestEle = Arrays.stream(arr).boxed().min(Integer::compare).orElse(null);
        System.out.println("smallestEle = " + smallestEle);
        Integer smallestEle2nd = Arrays.stream(arr).boxed().filter(a -> !a.equals(smallestEle)).min(Integer::compare).orElse(null);
        System.out.println("smallestEle2nd = " + smallestEle2nd);

        // without stream api
        int smallest = Integer.MAX_VALUE, smallest2nd = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest2nd = smallest;
                smallest = arr[i];
            } else if (arr[i] < smallest2nd) {
                smallest2nd = arr[i];
            }
        }
        System.out.println("smallest = " + smallest + "  smallest2nd = " + smallest2nd);
    }

    private static void largestElement() {
        System.out.println("------- largestElement ------ ");
        int[] arr = new int[]{25, 11, 7, 75, 56};
        System.out.println(Arrays.toString(arr));
        Integer max = Arrays.stream(arr).boxed().max(Integer::compare).orElse(null);
        System.out.println("max = " + max);
        Integer max2nd = Arrays.stream(arr).boxed().filter(a -> !a.equals(max)).max(Integer::compare).orElse(null);
        System.out.println("max2nd = " + max2nd);

        // without stream api
        int largest = Integer.MIN_VALUE, secLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        System.out.println("largest = " + largest + "   sec-largest = " + secLargest);
    }

    private static void duplicateElements() {
        System.out.println("------- duplicateElements ------ ");
        int[] arr = new int[]{1, 2, 8, 3, 2, 2, 2, 5, 1};
        System.out.println(Arrays.toString(arr));
        Map<Integer, Long> freElem = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freElem);
        List<Integer> list = freElem.entrySet().stream().filter(a -> a.getValue() > 1L).map(Map.Entry::getKey).toList();
        System.out.println(list);
    }

    private static void leftRotation() {
        System.out.println("------- leftRotation ------ ");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("before rotation = " + Arrays.toString(arr));
        int n = 3, first; // no.of times rotation
        for (int r = 1; r <= n; r++) {
            first = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = first;
        }
        System.out.println("after rotation = " + Arrays.toString(arr));
    }

    private static void freqOfElement() {
        System.out.println("------- freqOfElement ------ ");
        int[] arr = new int[]{1, 2, 8, 3, 2, 2, 2, 5, 1};
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Function.identity() => a->a
        System.out.println("freqMap = " + freqMap);
    }

    private static void reverseString() {
        System.out.println("------- reverseString ------ ");
        String str = "123456";
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println("main string = " + str + "  reversed = " + sb);
    }

    private static void swapString() {
        System.out.println("------- swapString ------ ");
        String str1 = "123", str2 = "4567";
        System.out.println("BEFORE SWAP str1 = " + str1 + "  str2 = " + str2);
        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());
        str1 = str1.substring(str2.length());
        System.out.println("AFTER SWAP str1 = " + str1 + "  str2 = " + str2);
    }

    private static void countSpecialChar() {
        System.out.println("------- countSpecialChar ------ ");
        int count = 0;
        String str = "He said, 'The mailman loves you.' I heard it with my own ears.";
        List<String> splCharList = List.of("!", ",", ".", ":", ";", "?", "-", "'", "\"");
        for (int i = 0; i < str.length(); i++) {
            if (splCharList.contains(str.charAt(i) + "")) count++;
        }
        System.out.println("total special characters = " + count);
    }

    private static void removeSpecialCharsFromString() {
        System.out.println("------- removeSpecialCharsFromString ------ ");
        String paragraph = "Lorem ipsum! dolor sit. amet consectetur, dolor adipiscing elit ipsum?";

        // !,.:;?-'"
        String cleaned = paragraph.replaceAll("[!,.:;?\\-'\"]", "");
        System.out.println(" paragraph = " + paragraph);
        System.out.println(" cleaned = " + cleaned);
    }

    private static void wordFromString() {
        System.out.println("------- wordFromString ------ ");
        String paragraph = "Lorem ipsum! dolor sit. amet consectetur, dolor adipiscing elit ipsum? donsectetur";
        String removedSpecChar = paragraph.replaceAll("[!,.:;?\\-'\"]", "");
        Map<String, Long> wordMap = Arrays.stream(removedSpecChar.split(" ")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordMap);

        // minimum occurrence word
        Long minWordCount = wordMap.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        List<String> minWords = wordMap.entrySet().stream().filter(a -> a.getValue().equals(minWordCount)).map(Map.Entry::getKey).toList();
        System.out.println("minWords = " + minWords);
        // alternate way - nonRepeatingWord()

        // maximum occurrence words
        Long maxWordCount = wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        List<String> maxWords = wordMap.entrySet().stream().filter(a -> a.getValue().equals(maxWordCount)).map(Map.Entry::getKey).toList();
        System.out.println("maxWords = " + maxWords);
        // alternate way - nonRepeatingWord()

        // largest word in a string
        Map<Integer, List<String>> wordsLengthMap = wordMap.keySet().stream().collect(Collectors.groupingBy(String::length));
        System.out.println("wordsLengthMap = " + wordsLengthMap);
        List<String> largeWords = wordsLengthMap.entrySet().stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);
        System.out.println("largeWords = " + largeWords);

        // smallest word in a string
        List<String> smallWords = wordsLengthMap.entrySet().stream().min(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(null);
        System.out.println("smallWords = " + smallWords);

        // duplicate words
        List<String> duplicateWords = wordMap.entrySet().stream().filter(a -> a.getValue() > 1L).map(Map.Entry::getKey).toList();
        System.out.println("duplicateWords = " + duplicateWords);
        // alternate way - nonRepeatingWord()

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
        // alternate way - nonRepeatingChracter();

        // duplicate characters
        List<String> list = wordMapObj.entrySet().stream().filter(a -> a.getValue() > 1L).map(Map.Entry::getKey).toList();
        System.out.println("duplicate characters = " + list);
        // alternate way - nonRepeatingChracter();

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

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class Order {

    private List<Product> productList = new ArrayList<>();

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}

class Product {

    private String name;

    public Product(String name) {
        this.name = name.toLowerCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
