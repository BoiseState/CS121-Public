
public class Penguin implements Comparable<Penguin>, PenguinInterface {

	private String name;
	private int height; //inches
	private double age; //years
	private int id; 
	private static int nextId = 0;
	
	public Penguin(String name, int height, double age) {
		this.name = name;
		this.height = height;
		this.age = age;
		nextId++;
		id = nextId;
	}
	
	public Penguin(String name, int height) {
		this.name = name;
		this.height = height;
		this.age = 0;
		nextId++;
		id = nextId;
	}
	
	public boolean equals(Penguin other) {
		return id == other.getId();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getAge() {
		return age;
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	
	public String toString() {
		String output = ""; //empty string
		output +=  "Penguin[id = " + id + ", name = " + name + ", height = " + height + ", ";

		if (age == 0) {
			output += "age = unknown]";
		} else {
			output += "age = " + age + "]";
		}
		return output;
	}

	@Override
	public int compareTo(Penguin other) {		
		if (height < other.getHeight())
			return -1;
		else if (height == other.getHeight())
			return 0;
		else
			return +1;
	}

	public void waddle() {
		// TODO Auto-generated method stub
		System.out.println(name + ":" + " waddle waddle");
	}

	public void swim() {
		// TODO Auto-generated method stub
		System.out.println(name + ":" + " swim swim with my flippers");
	}
	
	
}
