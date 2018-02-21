/**
 * Represents a mailing address. Modelled after Amazon address book.
 * @author CS121 Instructors
 */
public class AmazonAddress
{
	private String name;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private int zip;
	private String country;
	private boolean deliverOnWeekends;
	private String accessCode;
	private boolean isDefault;

	/**
	 * Default constructor.
	 */
	public AmazonAddress()
	{
		this.name = null;
		this.line1 = null;
		this.line2 = null;
		this.city = null;
		this.state = null;
		this.zip = 0;
		this.country = null;
		this.deliverOnWeekends = true;
		this.accessCode = null;
		this.isDefault = false;
	}

	/**
	 * Overloaded constructor.
	 *
	 * @param name
	 * @param line1
	 * @param line2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param deliverOnWeekends
	 * @param accessCode
	 * @param isDefault
	 */
	public AmazonAddress(String name, String line1, String line2, String city,
			String state, int zip, String country, boolean deliverOnWeekends,
			String accessCode, boolean isDefault)
	{
		this.name = name;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.deliverOnWeekends = deliverOnWeekends;
		this.accessCode = accessCode;
		this.isDefault = isDefault;
	}

	/**
	 * Overloaded constructor.
	 *
	 * @param name
	 * @param line1
	 * @param line2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 */
	public AmazonAddress(String name, String line1, String line2, String city,
			String state, int zip, String country)
	{
		this(name, line1, line2, city, state, zip, country, true, null, false);
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the line1
	 */
	public String getLine1()
	{
		return line1;
	}

	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1)
	{
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2()
	{
		return line2;
	}

	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2)
	{
		this.line2 = line2;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip()
	{
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip)
	{
		this.zip = zip;
	}

	/**
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

	/**
	 * @return the deliverOnWeekends
	 */
	public boolean isDeliverOnWeekends()
	{
		return deliverOnWeekends;
	}

	/**
	 * @param deliverOnWeekends the deliverOnWeekends to set
	 */
	public void setDeliverOnWeekends(boolean deliverOnWeekends)
	{
		this.deliverOnWeekends = deliverOnWeekends;
	}

	/**
	 * @return the accessCode
	 */
	public String getAccessCode()
	{
		return accessCode;
	}

	/**
	 * @param accessCode the accessCode to set
	 */
	public void setAccessCode(String accessCode)
	{
		this.accessCode = accessCode;
	}

	/**
	 * @return the isDefault
	 */
	public boolean getIsDefault()
	{
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(boolean isDefault)
	{
		this.isDefault = isDefault;
	}

	public String getUSMailingAddressString()
	{
		String toPrint = name + "\n";
		toPrint += line1 + "\n";
		if(!line2.isEmpty()) {
			toPrint += line2 + "\n";
		}
		toPrint += city + ", " + state + " " + zip;
		return toPrint;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AmazonAddress [name=" + name + ", line1=" + line1 + ", line2="
				+ line2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + ", deliverOnWeekends="
				+ deliverOnWeekends + ", accessCode=" + accessCode
				+ ", isDefault=" + isDefault + "]";
	}


//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Address [name=");
//		builder.append(name);
//		builder.append(", line1=");
//		builder.append(line1);
//		builder.append(", line2=");
//		builder.append(line2);
//		builder.append(", city=");
//		builder.append(city);
//		builder.append(", state=");
//		builder.append(state);
//		builder.append(", zip=");
//		builder.append(zip);
//		builder.append(", country=");
//		builder.append(country);
//		builder.append(", deliverOnWeekends=");
//		builder.append(deliverOnWeekends);
//		builder.append(", accessCode=");
//		builder.append(accessCode);
//		builder.append(", isDefault=");
//		builder.append(isDefault);
//		builder.append("]");
//		return builder.toString();
//	}

}
