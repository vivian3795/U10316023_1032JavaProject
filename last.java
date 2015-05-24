**
 * ID: U10316023
 * Ex: final program
 * Information:
 *      last class is written according to the report
 */
 
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
 
public class last{
	JPanel now = new JPanel();
	JPanel setting = new JPanel();
	JPanel week = new JPanel();
	JPanel date = new JPanel();
	String[] month = {"January","February","March","April","May","June",
		"July","August","September","October","November","December"};
	String[] num = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	JLabel nowyear = new JLabel();
	JLabel nowmonth = new JLabel();
	JTextField YEAR = new JTextField(4);
	JComboBox MONTH = new JComboBox(num);
	JButton RESET = new JButton("reset");
}
