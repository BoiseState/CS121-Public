package basics;

/**
 	Create two  simple frames and show them both.
	@author Amit Jain
 */

public class FrameDemo3
{
	public static void main (String[] args)
	{
		SimpleFrame1 frame1 = new SimpleFrame1();
		frame1.setSize(400,600);
		frame1.setVisible(true);

		SimpleFrame1 frame2 = new SimpleFrame1();
		frame2.setVisible(true);

	}
}
