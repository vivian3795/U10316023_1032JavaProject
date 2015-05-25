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
	//12 months and its name
	String[] month = {"Jan","Feb","Mar","Apr","May",
		"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String[] num = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	
	//the components it needs
	JPanel now = new JPanel();
	JPanel setting = new JPanel();
	JPanel date = new JPanel();
	JLabel nowyear = new JLabel("set ");
	JLabel nowmonth = new JLabel("time ");
	JTextField YEAR = new JTextField();
	JComboBox MONTH = new JComboBox(num);
	JButton RESET = new JButton("set");
	
	//constructor
	last(){//Typesetting
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
		//a week (to align, plus blank)
		date.add(new JLabel("   SUN  "));
		date.add(new JLabel("   MON "));
		date.add(new JLabel("    TUE  "));
		date.add(new JLabel("   WED "));
		date.add(new JLabel("    THU  "));
		date.add(new JLabel("    FRI   "));
		date.add(new JLabel("   SAT   "));
		//blank monthly calendar 
		for(int i = 0; i <42 ;i++){
			date.add(new JLabel("           "));
		}		
		
		add(now,BorderLayout.NORTH);
		add(date,BorderLayout.CENTER);
		add(setting,BorderLayout.SOUTH);
		
		//add listener
		RESET.addActionListener(new ActionListener(){
			@Override//when press reset, it would find the month you need.
			public void actionPerformed(ActionEvent e){
				date.removeAll();//clear previous one
				//a week (to align, plus blank)
				date.add(new JLabel("   SUN  "));
				date.add(new JLabel("   MON "));
				date.add(new JLabel("    TUE  "));
				date.add(new JLabel("   WED "));
				date.add(new JLabel("    THU  "));
				date.add(new JLabel("    FRI   "));
				date.add(new JLabel("   SAT   "));
				
				//use methods to get first day and days of a month
				int F = FirstDay();
				int D = Days();
				int day = 1;
				//print out monthly calendar
				for(int i = 0; i<42 ;i++){
					if(i < F)
						date.add(new JLabel("           "));
					else if ( i >= (F+D))
						date.add(new JLabel("           "));
					else{
						date.add(new JLabel("     "+day+"    "));
						day++;
					}
				}
				date.revalidate();
				
				//get the year and month and print them on the top
				nowyear.setText(YEAR.getText() + "   ");
				int themonth = Integer.parseInt(MONTH.getSelectedItem().toString());
				nowmonth.setText("   " +month[themonth-1] + " ");
			}
		});
	}
	
	//Determination of the day of the week(Formula)
	int FirstDay(){
		int theyear = Integer.parseInt(YEAR.getText()) ;
		int themonth = Integer.parseInt(MONTH.getSelectedItem().toString());
			
		int m = (int)(3.4+(9+themonth)%12*2.6);
		int M = m%7;
		if (themonth == 1 || themonth == 2)
				M = M-1;
		
		int C = 2*(3-(theyear/100)%4);
		
		int y = (theyear % 100)%28;
		int Y = (y+y/4)%7;
		
		//leap year
		int febDay = feb();
		if (febDay == 29)
			Y = Y-1;
				
		int first = (C+Y+M+1) % 7;
		return  first;
	}
	
	//days of a month
	int Days(){
		int days = 0;
		int m = Integer.parseInt(MONTH.getSelectedItem().toString());
		switch(m){
			case 1: days = 31;break;
			case 2: days = feb();break;
			case 3: days = 31;break;
			case 4: days = 30;break;
			case 5: days = 31;break;
			case 6: days = 30;break;
			case 7: days = 31;break;
			case 8: days = 31;break;
			case 9: days = 30;break;
			case 10: days = 31;break;
			case 11: days = 30;break;
			case 12: days = 31;
		}
		return days;
	}
	
	//days of Feb, it needs to check leap year
	int feb(){
		int y = Integer.parseInt(YEAR.getText());
		int febDay = 28;
		if(y%4 == 0){
			febDay = 29;
			if(y%100 ==0)
				febDay = 28;
				if(y%400 == 0)
					febDay = 29;
						if(y%4000 ==0)
							febDay = 28;
		}
		return febDay;
	}
}
