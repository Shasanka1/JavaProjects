
/*******************************************************************************************
Name: Shasanka Nudurupati

Course: CS125-0X
Lab #: Extra Cedit 
Submission Date: 10:00 pm, Thurs (12/05/19) 
 * @throws NegativeDoubleException 
*********************************************************************************************/

public class RecursiveSum {

	private int num; // A global variable to store the data
	
	/*
	 * A constructor that takes in an integer and sets it to the global variable integer
	 */
	
	public RecursiveSum(int num) {
		this.num = num; // sets global variable integer to num
	}
	
	/*
	 * Function that returns the sum in recursion
	 */
	
	public int sumRecursive(int num){
		if(num==1){
			System.out.print(num + "  = "); 
			return 1; // Return the value 1
		}
		else{
			System.out.print(num + " + ");
			
			return num + sumRecursive(num-1);
		}
		
	}
}
