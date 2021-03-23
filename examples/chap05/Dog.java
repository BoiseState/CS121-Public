

/**
 * A class to store information about a dog.
 * @author amit
 *
 */

public class Dog implements DogInterface, Comparable<Dog> {

	//instance data / properties / all together = "state"
	public final String DEFAULT_GENDER = "unknown";
	public final String DEFAULT_BREED = "mutt";
	
	private String name;
	private int age;
	private String breed;
	private String gender;
	private String temperament;
	private long id;
	private boolean isHungry = true;
	
//	private ArrayList<String> treats;
//	private ArrayList<String> activities;
	
	/**
	 * Constructor. Creates a Dog with the given name and age.
	 * @param name The dog's name.
	 * @param age The dog's age (in human years).
	 */
	public Dog(String name, int age)
	{
		this.name = name;
		this.age = age;
		this.id = (long) (Math.random() * Long.MAX_VALUE);
		this.breed = DEFAULT_BREED;
		this.gender = DEFAULT_GENDER;
	}
	
	
	/**
	 * Constructor. Create a dog with given name, age, breed and gender.
	 * @param name
	 * @param age
	 * @param breed
	 * @param gender
	 */
	public Dog(String name, int age, String breed, String gender) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.gender = gender;
		this.id = (long) (Math.random() * Long.MAX_VALUE);
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
	 * Returns the Dog's unique id
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	
	/**
	 * Returns the Dog's age in human years.
	 * @return the age.
	 */
	public int getAge()
	{
		return age;
	}
	
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	
	/**
	 * @return the temperament
	 */
	public String getTemperament() {
		return temperament;
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
	
	
	/**
	 * Calculates and returns the Dog's age in dog years.
	 * @return The age in "dog years".
	 */
	public int getDogYears()
	{
		return age * 7;
	}

	
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", breed=" + breed + ", gender=" + gender + ", temperament="
				+ temperament + ", id=" + id + "]";
	}
	

	/**
	 * Compare two dogs by id
	 */
	public boolean equals (Object obj) {
		Dog otherDog = (Dog) obj;
		return (this.id == otherDog.id);
	}
	

	@Override
	public int compareTo(Dog otherDog) {
		
//		if (this.age < otherDog.getAge())
//			return -1;
//		else if (this.age > otherDog.getAge())
//			return +1;
//		else
//			return 0;
		
		return this.age - otherDog.getAge();
	}
	

	@Override
	public String bark() {		
		return name + ": woof woof";
	}

	
	@Override
	public boolean isWaggingTail() {
		if (!isHungry)
			return true;
		return false;
	}
	

	@Override
	public boolean isHungry() {
		return isHungry;
	}
	
}
