
/*******************************************************************************************
Name: Shasanka Nudurupati

Course: CS125-0X
Lab #: Lab Five
Submission Date: 10:00 pm, Sat (11/27/19) 
 * @throws NegativeDoubleException 
*********************************************************************************************/

/*
 * This class  is a customized exception that is in charge of dealing with Negative values from the user 
 */
public class NegativeDoubleException extends Exception {

	public NegativeDoubleException() { // this exception is an empty constructor
		
	}
	public NegativeDoubleException(String message) { // takes in the message of user's input 
		super(message); // calls the super constructor with the message passed in
	}

}
