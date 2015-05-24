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
		
		RESET.addActionListener(new ActionListener(){
			@Override//when press reset, it would find the month you need.
			public void actionPerformed(ActionEvent e){
				date.removeAll();
				date.add(new JLabel("   SUN  "));
				date.add(new JLabel("   MON "));
				date.add(new JLabel("    TUE  "));
				date.add(new JLabel("   WED "));
				date.add(new JLabel("    THU  "));
				date.add(new JLabel("    FRI   "));
				date.add(new JLabel("   SAT   "));
				int F = FirstDay();
				int D = Days();
				int day = 1;
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
				nowyear.setText(YEAR.getText() + "   ");
				int themonth = Integer.parseInt(MONTH.getSelectedItem().toString());
				nowmonth.setText("   " +month[themonth-1] + " ");
			}
		});
	}
	
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
