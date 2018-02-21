/**
 * Represents a Kennel with several Dogs.
 * @author 
 */
public class Kennel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//make some dogs
		Dog d1, d2, d3;
		
		d1 = new Dog("Bufford", 3);
		d2 = new Dog("Rosco", 4);
		d3 = new Dog("Princess Sophia", 2);
		
		//check some values
		System.out.println("d1: " + d1); //implicitly calls d1.toString()
		System.out.println("d2: " + d2.toString()); //explicitly calls d2.toString()
		System.out.println("d3: " + d3);
		
		System.out.println("d1 age: " + d1.getAge());
		System.out.println("d2 name: " + d2.getName());
		System.out.println("d3 age in dog years: " + d3.getDogYears());
		
		//change some values
		d1.setAge(d1.getAge() + 1); //the dog had a birthday
		d3.setName("Prince"); //"Princess Sophia wasn't a princess after all
		
		//check results
		System.out.println("d1: " + d1); //implicitly calls d1.toString()
		System.out.println("d2: " + d2.toString()); //explicitly calls d2.toString()
		System.out.println("d3: " + d3);
	}
}
