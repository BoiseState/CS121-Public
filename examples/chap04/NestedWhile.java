import java.util.Scanner;

public class NestedWhile {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int nextValue = 0;
		int count = 0;
		String response = "y";
		
		System.out.println("Welcome! Start entering numbers");
		
		while (response.equalsIgnoreCase("y")) {
			
			System.out.print("Enter next number (-1 to quit): ");
			nextValue = scan.nextInt();

			while (nextValue != -1) {
				sum += nextValue;
				count++;
				System.out.print("Enter next number (-1 to quit): ");
				nextValue = scan.nextInt();
			}

			double average = (double) sum / count;
			System.out.println("Average is: " + average);

			System.out.println("Do you want to calculate another average?: (y/n) ");
			response = scan.next();
			if (response.equalsIgnoreCase("y")) {
				count = 0;
				sum = 0;
				System.out.println("Starting new average. Start entering numbers");
			}
		}
		System.out.println("Thanks for visiting the average center. Goodbye!");
		scan.close();
	}

}
