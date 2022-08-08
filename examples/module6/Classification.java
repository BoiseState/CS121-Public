
public enum Classification {
	FRESHMEN("first year"), 
	SOPHOMORE("second year"), 
	JUNIOR("third year"), 
	SENIOR("fourth or more year"), 
	GRADUATE("rest of my life");
	
	private String name;
	
	private Classification(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
