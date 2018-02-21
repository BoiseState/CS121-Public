
import javax.swing.JFrame;


public class SawtoothSunrise
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sawtooth Sunrise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new SawtoothSunrisePanel());

		frame.pack();
		frame.setVisible(true);
	}
}
