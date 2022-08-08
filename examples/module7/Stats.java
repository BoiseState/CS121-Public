
/**
 * Write a program called Stats that takes an arbitrary list of doubles from the command line,
 * stores them in an array, and returns the minimum, maximum, and average.  (You'll need
 * Double.parseDouble(String s) to convert the command line args to doubles.)
 * @author unknown
 */
public class Stats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.out.println("usage: java Stats <list of double-precision floats");
			System.exit(1);
		}
		
		double[] nums = new double[args.length];
		double min, max, average, total;
		
		for (int i = 0; i < args.length; i++)
		{
			nums[i] = Double.parseDouble(args[i]);
		}
		
		min = nums[0];
		max = nums[0];
		total = 0;
		for (double num : nums)
		{
			if (num < min) min = num;
			if (num > max) max = num;
			total += num;
		}
		
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		System.out.println("Average: " + total/nums.length);
	}

}
