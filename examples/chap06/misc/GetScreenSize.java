package misc;
import java.awt.*;


/**
 * How to determine maximum screen size for all screens
 */

public class GetScreenSize {

	public static void main(String[] args) {

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		GraphicsDevice[] gs = ge.getScreenDevices(); 
		
		// Get size of each screen 
		for (int i=0; i<gs.length; i++) { 
			DisplayMode dm = gs[i].getDisplayMode(); 
			int screenWidth = dm.getWidth(); 
			int screenHeight = dm.getHeight(); 
			System.out.println("screen " + i + " size: " + screenWidth + " x " + screenHeight);
		} 

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		System.out.println("default screen size: " + dim);

	}

}
