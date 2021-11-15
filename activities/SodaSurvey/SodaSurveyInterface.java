/**
 * Methods supporting the calculation and reporting of survey data as read from a file. 
 * 
 * @author mvail
 */
public interface SodaSurveyInterface {
	
	/*
	 * The constructor for the implementing class is expected
	 * to take in an input filename as its only argument.
	 * The first row of the file contains two integers - the
	 * number of rows (people) and the number of columns (sodas).
	 * Instantiate a 2D int array with the given dimensions and
	 * read remaining rows of data into the array. 
	 */
	
	/**
	 * Return the mean of the indexed row values,
	 * representing all responses from one person.
	 * @param rowIndex index of row to average
	 * @return mean of indexed row or -1 if invalid rowIndex
	 */
	public double rowAvg(int rowIndex);
	
	/**
	 * Return the mean of the indexed column values, 
	 * representing responses for one soda.
	 * @param colIndex index of column to average
	 * @return mean of indexed column or -1 if invalid colIndex
	 */
	public double colAvg(int colIndex);
	
	/**
	 * Report the averages for each person and soda. Example:
	 * 
	 * 	Person 0 Mean: 3.50
	 * 	Person 1 Mean: 3.00
	 * 	Person 2 Mean: 3.25
	 * 
	 * 	Soda 0 Mean: 2.00
	 * 	Soda 1 Mean: 4.00
	 * 	Soda 2 Mean: 1.67
	 * 	Soda 3 Mean: 5.33
	 * 
	 * @return well-formatted String reporting row and column means
	 */
	public String toString();
	
}
