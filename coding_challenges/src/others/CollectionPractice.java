package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionPractice {

	public static void main(String[] args) {

		List<String> colors = new ArrayList<>() {
			{
				add("RED");
				add("WHITE");
				add("GREEN");
				add("BLUE");
			}
		};

		// ConcurrentModificationException occurs
		/*
		 * for (String color : colors) { if ("WHITE".equals(color)) {
		 * colors.remove(color); System.out.println(color + " is removed"); }
		 * System.out.println(color); }
		 */

		// METHOD 1 : using Iterator

		Iterator<String> colorItr = colors.iterator();
		while (colorItr.hasNext()) {
			String val = colorItr.next();
			if ("WHITE".equals(val)) {
				colorItr.remove();
				System.out.println(val + " is removed");
			}
			System.out.println(val);
		}

		System.out.println("BEFORE = " + colors);

		// METHOD 2 : removeIf method
		colors.removeIf(c -> "WHITE".equals(c));
		System.out.println("AFTER = " + colors);
		
		
		
		
		
		// iterating map
		
		String[] wordArr = "apple".split("");

		Map<String, Long> lettersCountMap = Arrays.stream(wordArr)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		
		Set<Entry<String, Long>> entrySet = lettersCountMap.entrySet();
		
		for (Entry<String, Long> entry : entrySet) {
			entry.getKey();
			entry.getValue();
		}
		
		
		
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		System.out.println("");
		System.out.println("Sorting By Comparable");

		Collections.sort(al);
		/*
		 * for (Student st : al) { System.out.println(st.rollno + " | " + st.name +
		 * " | " + st.age); }
		 */
		System.out.println(al);
		System.out.println("");

		System.out.println("Sorting By Stream API");

		// sorting ascending by using stream
		System.out.println("----- ASCENDING --------");
		al.stream().sorted((a, b) -> a.age.compareTo(b.age)).forEach(System.out::println);

		// sorting descending by using stream
		System.out.println("----- DESCENDING --------");
		al.stream().sorted((a, b) -> b.age.compareTo(a.age)).forEach(System.out::println);
		
		Comparator<Student> cm1=Comparator.comparing(Student::getName); 
		Comparator<Student> cm2=Comparator.comparing(Student::getAge);  
		Collections.sort(al,cm1);
		Collections.sort(al,cm2);
		System.out.println(al);
	}

}


class Student implements Comparable<Student> {
	Integer rollno;
	String name;
	Integer age;

	Student(Integer rollno, String name, Integer age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	
	public int getRollno() {  
        return rollno;  
    }  
  
    public void setRollno(int rollno) {  
        this.rollno = rollno;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  

	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		// ascending
		else if (age > st.age)
			return 1;
		// descending
		/*
		 * else if (age < st.age) return 1;
		 */
		else
			return -1;
	}

	@Override
	public String toString() {
		return this.rollno + " | " + this.name + " | " + this.age;
	}
}

class ListExt implements List {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
