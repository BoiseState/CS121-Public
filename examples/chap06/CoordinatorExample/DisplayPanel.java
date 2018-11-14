package CoordinatorExample;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**Example GUI demonstrating coordination of components between panels.
 * This panel is responsible for painting a specified shape in a specified color.
 * The call to paint a shape comes from an outside source.
 * @author mvail
 */
@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {
	public static enum Shape {RECTANGLE, OVAL};

	private Shape shape;
	private Color color;
	
	/** Initialize panel as plain black canvas */
	public DisplayPanel() {
		this.setBackground(Color.BLACK);
		shape = Shape.RECTANGLE;
		color = Color.BLACK;
		this.repaint();
	}
	
	/** Get shape and color to paint and paint it.
	 * @param shape 
	 * @param color
	 */
	public void paintShape(Shape shape, Color color) {
		this.shape = shape;
		this.color = color;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		
		g.setColor(getBackground());
		g.fillRect(0, 0, panelWidth, panelHeight);
		
		int shapeWidth = panelWidth*3/4;
		int shapeHeight = panelHeight*3/4;
		int xOffset = (panelWidth - shapeWidth) / 2;
		int yOffset = (panelHeight - shapeHeight) / 2;
		
		g.setColor(color);
		switch (shape) {
		case RECTANGLE:
			g.fillRect(xOffset, yOffset, shapeWidth, shapeHeight);
			break;
		case OVAL:
			g.fillOval(xOffset, yOffset, shapeWidth, shapeHeight);
			break;
		}
	}
}
