/**
 * ID: U10316023
 * Ex: final program
 * Information:
 *      last class is written according to the report
 */
 
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class last extends JPanel{
	JPanel now = new JPanel();
	JPanel setting = new JPanel();
	JPanel weekday = new JPanel();
	JPanel week = new JPanel();
	JPanel date = new JPanel();
	String[] month = {"Jan","Feb","Mar","Apr","May",
		"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String[] num = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	JLabel nowyear = new JLabel("set ");
	JLabel nowmonth = new JLabel("time");
	JTextField YEAR = new JTextField();
	JComboBox MONTH = new JComboBox(num);
	JButton RESET = new JButton("set");
	
	
	last(){
		setting.setLayout(new GridLayout(1,5));
		setting.add(new JLabel("year:"));
		setting.add(YEAR);
		setting.add(new JLabel("month:"));
		setting.add(MONTH);
		setting.add(RESET);
		setting.setBorder(new TitledBorder("Setting"));
		
		now.setLayout(new GridLayout(1,2));
		nowyear.setFont(new Font("Monospaced", 3 , 32));
		nowmonth.setFont(new Font("Monospaced", 3 , 32));
		now.add(nowyear);
		now.add(nowmonth);
		
		date.setLayout(new GridLayout(7,7));
		date.add(new JLabel("   SUN  "));
		date.add(new JLabel("   MON "));
		date.add(new JLabel("    TUE  "));
		date.add(new JLabel("   WED "));
		date.add(new JLabel("    THU  "));
		date.add(new JLabel("    FRI   "));
		date.add(new JLabel("   SAT   "));
		for(int i = 0; i <42 ;i++){
			date.add(new JLabel("           "));
		}		
		
		add(now,BorderLayout.NORTH);
		add(date,BorderLayout.CENTER);
		add(setting,BorderLayout.SOUTH);
}
