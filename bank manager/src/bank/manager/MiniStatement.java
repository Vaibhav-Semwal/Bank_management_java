package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class MiniStatement extends JFrame implements ActionListener{
	JButton back;
	String password; 
	String account_number = Login.card;
	MiniStatement(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("Mini Statement");
		setLayout(null);
		getContentPane().setBackground(Color.white);	
		setSize(600,600);
		setVisible(true);
		setLocation(100,50);
		
		JLabel statementdetails = new JLabel("Mini Statement");
		statementdetails.setFont(new Font("Osward", Font.BOLD, 24));
		statementdetails.setAlignmentX(CENTER_ALIGNMENT);
		statementdetails.setBounds(200, 40, 360 , 50);
		add(statementdetails);
		
		JLabel name = new JLabel();
		name.setBounds(50, 120, 400 , 400);
		name.setAlignmentY(TOP_ALIGNMENT);

		add(name);
		try {
			connection c = new connection();
			ResultSet r = c.s.executeQuery("Select * from bank where accountnumber = '"+account_number+"';"); 
			while (r.next()) { 
				name.setText(name.getText() + "<html>Card Number: "+ r.getString("accountnumber").substring(0,4) + "-XXXX-XXXX-"+ r.getString("accountnumber").substring(12) + "<br><html>");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		JLabel log = new JLabel();
		log.setBounds(350, 120, 300 , 400);
		add(log);
		log.setAlignmentY(TOP_ALIGNMENT);
		try {
			connection c = new connection();
			ResultSet r = c.s.executeQuery("Select * from bank where accountnumber = '"+account_number+"';"); 
			while (r.next()) { 
				log.setText(log.getText() +"<html>"+ r.getString("type")+" | "+ r.getString("amount") + "<br><html>");		
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		back = new JButton("Back"); 
		back.setBounds(450, 500, 100, 30);
		back.setBackground(Color.white);			back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
	}
	
	public void actionPerformed(ActionEvent a) { 
		if (a.getSource()==back) { 
			setVisible(false);
		}
	}
	
	
}
