/**
 * 
 */

/**
 * @author amit
 *
 */
public class Penguin
{
	private String name;
	private int age;
	private double height;
	
	/**
	 * @param newName
	 * @param newAge
	 * @param newHeight
	 */
	public Penguin(String newName, int newAge, double newHeight) 
	{
		name = newName;
		age = newAge;
		height = newHeight;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * @param newAge
	 */
	public void setAge(int newAge) {
		if (newAge < 0) {
			System.out.println("Penguin: Invalid age, must be positive");
		}
		age = newAge;
	}
	
	/**
	 * @param newHeight
	 */
	public void setHeight(double newHeight) {
		height = newHeight;
	}
	
	public String toString() {
		return "Penguin[" + "name = " + name + ", age = " + age + ", height = " + height + "]";
	}
	

}
