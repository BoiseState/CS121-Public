package inclass;

public class RunningSum
{
	public static void main(String[] args) 
	{
		int low = 20;
		int high = 70;
		int sum = 0;
		
		for(int i = low; i <= high; i++) {
			sum += i;
		}
		
		System.out.println("sum: " + sum);
	}

}
