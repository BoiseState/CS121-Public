/**
 * A circle that can draw itself on a Graphics context.
 * This class serves as the "Model" in the CircleMaker
 * program's Model-View-Controller design.
 * @author mvail
 */
public class Circle {
	private int xAnchor;
	private int yAnchor;
	private int diameter;
	
	/**
	 * Construct a Circle
	 * @param xAnchor
	 * @param yAnchor
	 * @param diameter
	 */
	public Circle(int xAnchor, int yAnchor, int diameter) {
		this.xAnchor = xAnchor;
		this.yAnchor = yAnchor;
		this.diameter = diameter;
	}
	
	/**
	 * @return the xAnchor
	 */
	public int getXAnchor() {
		return xAnchor;
	}

	/**
	 * @param xAnchor the xAnchor to set
	 */
	public void setXAnchor(int xAnchor) {
		this.xAnchor = xAnchor;
	}

	/**
	 * @return the yAnchor
	 */
	public int getYAnchor() {
		return yAnchor;
	}

	/**
	 * @param yAnchor the yAnchor to set
	 */
	public void setYAnchor(int yAnchor) {
		this.yAnchor = yAnchor;
	}

	/**
	 * @return the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
}
