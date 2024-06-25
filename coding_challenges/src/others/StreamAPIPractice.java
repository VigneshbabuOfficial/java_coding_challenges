package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIPractice {

	public static void main(String[] args) {

		// Creating Streams :
//		List<String> myList = Arrays.asList("apple", "banana", "orange");
//		Stream<String> sequentialStream = myList.stream();
//		Stream<String> parallelStream = myList.parallelStream();

		// When to Use Which?
		// Sequential Stream: Use when working with small datasets or operations that
		// are not CPU-bound. Also, use when the order of processing is important.
		// Parallel Stream: Use for large datasets or CPU-intensive operations where
		// processing time can be significantly reduced by parallel execution.
		// Be mindful of thread safety and the cost of context switching and
		// synchronization.

		// ------------- INTERMEDIATE OPERATIONS -------------
		// ------------- MAP -------------
		List<String> numbersStr = Arrays.asList("1", "2", "3", "4", "5", "6");
		// Convert list of string to even number list
		List<Integer> even = numbersStr.stream().map(Integer::valueOf).filter(number -> number % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("even = " + even);

		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Function<Integer, Integer> triple = (value) -> value * 3;
		Stream<Integer> mappedStream = integerStream.map(triple);

		// ------------- FLATMAP -------------
		List<String> names = Arrays.asList("john", "emma");
		List<Character> characterList = names.stream().flatMap(x -> x.chars().mapToObj(i -> (char) i))
				.collect(Collectors.toList());
		System.out.println(" characterList = " + characterList); // 'j', 'o', 'h', 'n', 'e', 'm', 'm', 'a'

		List<List<String>> fruits = Arrays.asList(Arrays.asList("apple", "mango"), Arrays.asList("banana"),
				Arrays.asList("orange"));
		List<String> fruitList = fruits.stream().flatMap(f -> f.stream()).collect(Collectors.toList());
		System.out.println(" fruitList = " + fruitList);

		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(" flattenedList = " + flattenedList);

		// ---------------------- FILTER ----------------------
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumList = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("evenNumList = " + evenNumList);

		// ---------------------- PEEK ----------------------
		// For performing side-effects, such as logging or debugging.
		// Operates on elements without modifying the stream itself.
		// Accepts a Consumer<T>, which performs an action and returns the same stream
		// of type T.
		// Used when you need to inspect elements of the stream or perform
		// non-transforming operations, such as logging.
		List<Integer> squares = numbers.stream().peek(n -> System.out.println("Processing number: " + n))
				.map(n -> n * n).peek(n -> System.out.println("Processed to square: " + n))
				.collect(Collectors.toList());

		// ---------------------- LIMIT ----------------------
		Stream<Integer> limitedNums = numbers.stream().limit(5);
		System.out.println("5 LIMIT numbers = ");
		limitedNums.forEach(System.out::println);

		// ---------------------- SKIP ----------------------
		Stream<Integer> skippedNums = numbers.stream().skip(5);
		System.out.println("5 skipped numbers = ");
		skippedNums.forEach(System.out::println);

		// ---------------------- DISTINCT ----------------------
		Stream<Integer> duplicatesStream = Stream.of(1, 1, 2, 2, 3, 3, 3, 4);
		List<Integer> distinctList = duplicatesStream.distinct().collect(Collectors.toList());
		System.out.println("distinctList = " + distinctList);

		// ---------------------- SORTED ----------------------
		Stream<Integer> unsortedStream = Stream.of(5, 7, 0, 2, 8, 0, 4);
		List<Integer> sortedList = unsortedStream.sorted().collect(Collectors.toList());
		System.out.println("sortedList = " + sortedList);

		List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 25),
				new Person("David", 30));
		List<Person> sortedPeople = people.stream()
				.sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName)).toList();

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
		boolean noneMatchStat = people.stream().noneMatch(p -> p.getAge() > 30); // true
		System.out.println("noneMatchStat = " + noneMatchStat);
		boolean anyMatchStat = people.stream().anyMatch(p -> p.getAge() > 25); // true
		System.out.println("anyMatchStat = " + anyMatchStat);

		// Min With Int Comparator
		Optional<Integer> minNum = numbers.stream().min(Integer::compare);
		System.out.println("minNum = " + minNum);

		// Max With Integer Comparator
		Optional<Integer> maxNum = numbers.stream().max(Integer::compare);
		System.out.println("maxNum = " + maxNum);

		// Boxing and Unboxing
		List<Integer> evenInts = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).boxed()
				.collect(Collectors.toList());
		System.out.println("evenInts = " + evenInts);

		// mapToInt -> sum, average, count
//		int sum = numbers.stream().filter(n-> n%2 ==0 ).mapToInt(Integer::intValue).sum();
//		int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).sum();
		int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
		double avg = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).average().orElse(0);
		System.out.println("avg = " + avg);
		long count = numbers.stream().filter(n -> n % 2 == 0).mapToInt(i -> i).count();
		System.out.println("count = " + count);

		// Reduction operations
		String[] myArray = { "Where", "is", "my", "stream", "?" };
		String result = Arrays.stream(myArray).reduce("", (a, b) -> a + " " + b);
		System.out.println("result = " + result);

		// From stream to array
		// mystream.toArray(String[]::new);

		// Collectors.groupingBy()
		Map<Integer, List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println("groupByAge = " + groupByAge);

		String paragraph = "Lorem ipsum dolor sit amet consectetur dolor adipiscing elit ipsum";
		String[] wordArr = paragraph.split(" ");
		Map<String, Long> wordMap = Arrays.stream(wordArr)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(wordMap);
		Map<String, Integer> wordMap_1 = Arrays.stream(wordArr).distinct()
				.collect(Collectors.toMap(String::valueOf, String::length));
		System.out.println(wordMap_1);

		// List to Map
		Map<String, Person> groupByName = people.stream().collect(Collectors.toMap(Person::getName, person -> person));
		System.out.println("groupByName = " + groupByName);

		// Map to List
		List<Person> _age_25_list = groupByAge.entrySet().stream().filter(p -> p.getKey() == 25)
				.flatMap(entry -> entry.getValue().stream()).toList();
		System.out.println("_age_25_list = " + _age_25_list);

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

        // Collect products with the maximum count
        List<String> mostOrderedProducts = prodCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("mostOrderedProducts = "+mostOrderedProducts+"("+maxCount+")");

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
