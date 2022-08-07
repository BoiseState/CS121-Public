/**
 * PetDriver uses the non-primitive data type Pet that is defined in Pet.java
 * 
 * @author sfrost
 *
 */
public class PetDriver {

	public static void main(String[] args){
		//declare three new pets using each constructor once 
	
		Pet fido = new Pet("Fido", "dog", 2);
		Pet yogi = new Pet("Yogi", "dog");
		Pet polly = new Pet();
	
		// use getters and setters to fill in the missing information for 
		// each pet
		yogi.setAge(7);
		polly.setName("Polly");
		polly.setType("bird");
		polly.setAge(2);
		
		System.out.println(yogi.toString());
		
	}
	
}
