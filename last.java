/**
 * ID: U10316023
 * Ex: final program
 * Information:
 *      the class are written according to the report
 */
 
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
 
class last extends JPanel{
	JPanel now = new JPanel();
	JPanel setting = new JPanel();
	JPanel top = new JPanel();
	JPanel week = new JPanel();
	JPanel date = new JPanel();
	String[] month = {"Jan","Feb","Mar","Apr","May",
		"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String[] num = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JLabel nowyear = new JLabel("now");
	JLabel nowmonth = new JLabel("time");
	JTextField YEAR = new JTextField();
	JComboBox MONTH = new JComboBox(num);
	JButton RESET = new JButton("set");
}
