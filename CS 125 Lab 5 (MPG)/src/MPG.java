
/*******************************************************************************************
Name: Shasanka Nudurupati

Course: CS125-0X
Lab #: Lab Five
Submission Date: 10:00 pm, Sat (11/27/19) 
 * @throws NegativeDoubleException 
*********************************************************************************************/

public class MPG {

	private double miles; // variable to hold miles
	private double gallons; // variable to hold gallons
	
	/*
	 * The constructor of MPH that takes in two arguments
	 */
	public MPG(double miles,double gallons){
		this.miles = miles; //sets the user miles to the miles
		this.gallons = gallons; //sets the user gallons to gallons
	}
	
		//Mutator Function
	
		/***This function sets the gallons****/
		
		public void setGall(double gallons) {
			this.gallons = gallons; //sets the user gallons to gallons
		}
		
		/***This function sets the miles ****/
		public void setMile(double miles) {
			this.miles = miles; //sets the user miles to the miles
		}
		
		
		// Accessor Function

		/****** Returns the gallons*****/
		
		public double getGall() {
			return this.gallons;
		}
		
		/****** Returns the miles*****/
		
		public double getMiles() {
			return this.miles;
		}
		
		
		// Computes the Miles Per Gallon
		
		public double comMPG() {
			return (this.miles/this.gallons);
		}
		
		// Function to Compute the Miles Per Gallon with the two parameters
		
		public double comMPG(int miles, int gallons) {
			return (miles/gallons);
		}
		
		
}
	
