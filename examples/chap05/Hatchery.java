
public class Hatchery
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Penguin pet1 = new Penguin("Sheldon", 3, 0.75);
		Penguin pet2 = new Penguin("Kunta", 7, 1.2);
		
		System.out.println(pet1);
		System.out.println(pet2);
		
		pet1.setAge(10);
		pet1.setHeight(1.5);
		System.out.println(pet1);

	}

}
