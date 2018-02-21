/**
 * Represents a solid sphere.
 * 
 * @author mvail
 */
public class Sphere {
	private double radius;
	private double mass;
	
	/**
	 * Constructor
	 * @param radius
	 * @param mass
	 */
	public Sphere(double radius, double mass) {
		this.radius = radius;
		this.mass = mass;
	}
	
	/**
	 * @return sphere volume
	 */
	public double getVolume() {
		double volume = 4.0/3.0 * Math.PI * Math.pow(radius, 3);
		return volume;
//		return 4.0/3.0 * Math.PI * Math.pow(radius, 3);
	}
	
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * @return the density
	 */
	public double getDensity() {
		return mass/getVolume();
	}
	
	/**
	 * @param mass the updated mass
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	/**
	 * @return mass of the sphere
	 */
	public double getMass() {
		return mass;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Sphere [radius=" + radius 
				+ ", mass=" + mass
				+ "]";
	}
}
