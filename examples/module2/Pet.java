/** 
 * Pet.java creates a Pet object.  The Pet object has three pieces
 * of data associated with it: the name, the type of pet it is, and
 * the age of the pet.
 * 
 * @author sfrost
 *
 */

public class Pet{
	// Instance variables
	String name, type;
	int age;
	
	// constructor methods
	// Notice: constructor name is the same as the class name
	public Pet(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	// this is an overloaded constructor. A Pet object can be declared
	// with either two or three arguments.
	public Pet(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	// this makes a pet object with no values yet
	public Pet() {
		this.name = "";
		this.type = "";
		this.age = 0;
	}
	
	//methods
	// getters
	public String getName() {
		return this.name;
	}
	
	public String gettype() {
		return this.type;
	}
	
	public int getAge() {
		return this.age;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		String toReturn = "";
		
		//build the string to return
		toReturn = this.name + ", " + this.type + ", " + this.age;
		
		return toReturn;
	
	}
	
}
