package others;

public class CreateObjectExample implements Cloneable{
	
	CreateObjectExample(){
		System.out.println("CreateObjectExample constructor called");
	}
	
	
	public static void main(String[] args) {
		
		// new keyword
		CreateObjectExample obj1 = new CreateObjectExample();
		CreateObjectExample obj2 = new CreateObjectExample();
		
		System.out.println("obj1.hashCode() = "+obj1.hashCode());
		System.out.println("obj2.hashCode() = "+obj2.hashCode());
		System.out.println(obj1 == obj2 );
		System.out.println(obj1.equals(obj2));
		
		// clone method
		try {
			CreateObjectExample obj3 = (CreateObjectExample) obj1.clone();
			System.out.println("obj3.hashCode() = "+obj3.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
