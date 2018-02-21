/**
 * A class to store information about a dog.
 * @author 
 *
 */
public class Dog {

	//instance data / properties / all together = "state"
	private String name;
	private int age;
	
	/**
	 * Constructor. Creates a Dog with the given name and age.
	 * @param name The dog's name.
	 * @param age The dog's age (in human years).
	 */
	public Dog(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//getters
	/**
	 * Returns the Dog's name.
	 * @return the name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the Dog's age in human years.
	 * @return the age.
	 */
	public int getAge()
	{
		return age;
	}
	
	//setters
	/**
	 * Sets the Dog's name.
	 * @param newName
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	/**
	 * Sets the Dog's age.
	 * @param newAge
	 */
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
	//getDogYears()
	/**
	 * Calculates and returns the Dog's age in dog years.
	 * @return The age in "dog years".
	 */
	public int getDogYears()
	{
		return age * 7;
	}
	
	//toString()
	public String toString()
	{
		return "Dog: [name: " + name + " age: " + age + "]";
	}
}
