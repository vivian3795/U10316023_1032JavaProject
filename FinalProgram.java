/**
 * ID: U10316023
 * Ex: final program
 * Information:
 *      main class
 */
 
public class FinalProgram extends JFrame{
  //create an object
	last L = new last();

	FinalProgram(){
		add(L);
	}
	
	public static void main (String[] args){
		JFrame frame = new FinalProgram();
		frame.setTitle("U10316023");//set title
		frame.setSize(400,300);//set size
		frame.setLocationRelativeTo(null); // Center the frame
		//terminate when the frame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);//set visible
		frame.setResizable(false);//cannot change size
	}
}
