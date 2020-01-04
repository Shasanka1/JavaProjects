import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*******************************************************************************************
Name: Shasanka Nudurupati

Course: CS125-0X
Lab #: Lab Five
Submission Date: 10:00 pm, Sat (11/27/19) 
 * @throws NegativeDoubleException 
*********************************************************************************************/



/*
 * Class: MPGGUI
 *  Purpose: 
 *  	This class is responsible for doing the validation for the miles and gallons that the user enters
 *  	but it is the context of GUI and GUI components. This will display the results of the circle in the GUI
 *  	with only the GUI components
 */

public class MPGGUI extends JFrame {
	
	private JPanel panel; //To reference a panel
	private JLabel messageGall;  // variable to store JLabel
	private JLabel messageMile;  // variable to store JLabel
	private JTextField galData; // variable to store JTextField
	private JTextField milData; // variable to store JTextField
	private JButton calculate, clear, exit; // variables to store JButton
	private JLabel answers; // variable to store answers
	
	private final static int WINDOW_WIDTH = 400; // variable to store the width of the GUI
	private final static int WINDOW_HEIGHT = 400; // variable to store the height of the GUI
	
	
	private MPG mpg1; // variable to store in instance of circle
	
	private double miles; // variable to store the miles
	private double gallons; // variable to store the gallons

	private double milesPerGallon; // variable to store the calculated miles per gallon
	private String answerMessage; // variable to store the answer message
	
	private String userMiles; // variable to store the string value of the miles
	private String userGallons; //variable to store the string of gallons
	
	/*
	 *  Constructor:
	 *  	The purpose of this constructor is to display the GUI Panel by calling the function buildPanel()
	 */
	
	public MPGGUI(){
		super("Miles Per Gallon Calculator"); // Labels the window
		
		
		setSize(WINDOW_HEIGHT,WINDOW_WIDTH); // sets the dimensions of the GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the GUI to have a default close window
		
		buildPanel(); // calls the build panel function
		
		add(panel); // adds the panel to the GUI
		
		setVisible(true); // shows that the GUI is visible 
	}

	private void buildPanel() {
		messageGall = new JLabel("Enter in the " + " gallons: " ); // setting to a JLabel with a string passed in 
		messageMile = new JLabel("Enter in the " + " miles :");  // setting to a JLabel with a string passed in 
		answers = new JLabel();
		galData = new JTextField(10);
		milData = new JTextField(10);
		
		calculate = new JButton(" Calculate MPG ");
		clear = new JButton(" Clear ");
		exit = new JButton(" Exit ");
		
		panel = new JPanel();
		
		/*
		 *  The actions of the buttons Exit, Clear, and Calculate
		 */
		
		exit.addActionListener(new ActionListener(){ 

			@Override // method to override the functionality of the button
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exits out the system

				
			}});
		
		clear.addActionListener(new ActionListener(){ 

			@Override // method to override the functionality of the button
			public void actionPerformed(ActionEvent e) {
				messageGall.setText("Enter in the " + " gallons: " );
				messageMile.setText("Enter in the " + " miles: ");
				milData.setText("");
				galData.setText("");
				answers.setText("");
//				calculate.show();
//				exit.show();
				
			}});
		
		
		calculate.addActionListener(new ActionListener(){ 

			@Override // method to override the functionality of the button
			public void actionPerformed(ActionEvent e) {
				/*
				 * the inside function will check for data validation with exception statements
				 */
					try{
						userMiles = milData.getText();
						userGallons = galData.getText();
						
						miles = Double.parseDouble(userMiles);
						gallons = Double.parseDouble(userGallons);
						
						if(miles <0 || gallons <0)
							throw new NegativeDoubleException(" Both miles and gallons need to be positive ");
					}	
					catch(NumberFormatException e2){
						answers.setText("<html> The values that you entered in have at least one with a letters...<br/>" + " Miles : " + userMiles + " <br/> Gallons" + userGallons +"<br/> Please Re-Enter the Miles and Gallons again by pressing the CLEAR Button</html>"); // Display Error Message
//						messageGall.setText("");
//						messageMile.setText("");
//						calculate.hide();
//						exit.hide();
						
					}
					catch(NegativeDoubleException e1){
						answers.setText("<html> The values that you entered in have at least one with a negative number...<br/>" + " Miles : " + userMiles + "<br/> Gallons" + userGallons + "<br/> Please Re-Enter the Miles and Gallons again by pressing the CLEAR Button</html>"); // Display Error Message
//						messageGall.setText("");
//						messageMile.setText("");
//						calculate.hide();
//						exit.hide();
					}
//					finally{
						if(miles >0 && gallons>0){
						mpg1 = new MPG(miles,gallons);
						
						milesPerGallon = mpg1.comMPG();
						
						answerMessage = "<html> The Calculated Miles Per Gallon from the valid inputs is : <br/>" + milesPerGallon + "mpg<br/> The Users Inputs are " + "<br/> Miles" + userMiles + "<br/> Gallons" + userGallons + "</html>";
						
						answers.setText(answerMessage);
//					}
						}
						
			}});
		
		panel.add(answers); // adds the JLabel
		panel.add(messageMile); // adds the JLabel
		panel.add(messageGall); // adds the JLabel
		panel.add(milData);  // adds the JField
		panel.add(galData);  // adds the JField
		panel.add(calculate); // adds the JButton submit
		panel.add(clear);// adds the JButton clear
		panel.add(exit); // adds the JButton exit
			
		
			
	}
	

}
