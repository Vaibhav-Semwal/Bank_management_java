package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;	

public class PinChange extends JFrame implements ActionListener{
	JButton back, exit, change;
	JPasswordField newpininfo, repeatpininfo;
	String password; 
	String account_number = Login.card;
	PinChange(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel pindetails = new JLabel("Change your PIN");
		pindetails.setFont(new Font("Osward", Font.BOLD, 24));
		pindetails.setForeground(Color.GREEN);
		pindetails.setAlignmentX(CENTER_ALIGNMENT);
		pindetails.setBounds(300, 40, 360 , 50);
		add(pindetails);
		
		JLabel oldpin = new JLabel("type in the old PIN");
		oldpin.setFont(new Font("Osward", Font.BOLD, 18));
		oldpin.setForeground(Color.GREEN);
		oldpin.setAlignmentX(CENTER_ALIGNMENT);
		oldpin.setBounds(50, 140, 300 , 50);
		add(oldpin);
		newpininfo = new JPasswordField();
		newpininfo.setFont(new Font("Osward", Font.BOLD, 18));
		newpininfo.setBounds(350, 140, 300 , 50);
		add(newpininfo);
		
		JLabel newpin = new JLabel("type in the new PIN");
		newpin.setFont(new Font("Osward", Font.BOLD, 18));
		newpin.setForeground(Color.GREEN);
		newpin.setAlignmentX(CENTER_ALIGNMENT);
		newpin.setBounds(50, 200, 300 , 50);
		add(newpin);
		repeatpininfo = new JPasswordField();
		repeatpininfo.setFont(new Font("Osward", Font.BOLD, 18));
		repeatpininfo.setBounds(350, 200, 300 , 50);
		add(repeatpininfo);
		
		change = new JButton("Change"); 
		change.setBounds(500, 280, 100, 30);
		change.setBackground(Color.white);			change.setForeground(Color.black);
		change.addActionListener(this);
		add(change);
		
		back = new JButton("Back"); 
		back.setBounds(450, 580, 100, 30);
		back.setBackground(Color.white);			back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		exit = new JButton("Exit"); 
		exit.setBounds(600, 580, 100, 30);
		exit.setBackground(Color.white);			exit.setForeground(Color.black);
		exit.addActionListener(this);
		add(exit);
		
		getContentPane().setBackground(Color.BLACK);	
		setSize(800,800);
		setVisible(true);
		setLocation(300,50);
	}
	
	public void actionPerformed(ActionEvent a) { 
		if (a.getSource()==change) { 
			String New = String.valueOf(newpininfo.getPassword()); 
			String Repeat = String.valueOf(repeatpininfo.getPassword()) ;
			System.out.println(New + "\n"+ Repeat);
			String account = "" + account_number;
			Date date = new Date(); 
			if (Integer.getInteger(New) == Integer.getInteger(Repeat) ) {  
				try {
					connection c = new connection();
					JOptionPane.showMessageDialog(null, "PIN has been suscessfully changed");
					String query = "insert into bank values ('"+Repeat+"', '"+account+"', '"+date+"', 'PIN Change', 'null');";
					String query_signupone = "update signup set pin = '"+Repeat+"' where pin = '"+password+"';";
					String query_signupthree = "update signupthree set pin = '"+Repeat+"' where pin = '"+password+"';";
					c.s.execute(query);			c.s.execute(query_signupone);			c.s.execute(query_signupthree);
					setVisible(false);	
					new transaction(password).setVisible(true);
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			else { 
				JOptionPane.showMessageDialog(null, "the two values do not match \nplease refill the fields"); 
			}
		}
		else if (a.getSource()==exit) { 
			System.exit(0);
		}else if(a.getSource()==back) { 
			setVisible(false);
			new transaction("").setVisible(true);;
		}
	}
}
