package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;	

public class Balance extends JFrame implements ActionListener{
	private static final String String = null;
	JButton back, exit;
	String password; 
	String account_number = Login.card;
	private int sum = 0;
	Balance(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel balancedetails = new JLabel("Balance");
		balancedetails.setFont(new Font("Osward", Font.BOLD, 24));
		balancedetails.setForeground(Color.GREEN);
		balancedetails.setAlignmentX(CENTER_ALIGNMENT);
		balancedetails.setBounds(300, 40, 360 , 50);
		add(balancedetails);
		
		JLabel oldpin = new JLabel("Your Current Account Balance is:");
		oldpin.setFont(new Font("Osward", Font.BOLD, 16));
		oldpin.setForeground(Color.GREEN);
		oldpin.setAlignmentX(CENTER_ALIGNMENT);
		oldpin.setBounds(50, 140, 500 , 50);
		add(oldpin);
		
		JLabel balance = new JLabel();
		balance.setFont(new Font("Osward", Font.BOLD, 24));
		balance.setBounds(50, 180, 300 , 100);
		balance.setForeground(Color.GREEN);
		try {
			connection c = new connection();
			ResultSet r = c.s.executeQuery("Select * from bank where accountnumber = '"+account_number+"';"); 
			while (r.next()) {
				if (r.getString("type").equals("Withdrawl") || r.getString("type").equals("fast cash")) {
					sum = sum - r.getInt("amount");
				} else if (r.getString("type").equals("Deposit")) { 
					sum = sum + r.getInt("amount");
				}
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(sum);
		balance.setText("Rs. "+String.valueOf(sum));
		add(balance);
		
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
		String account = "" + account_number;
		Date date = new Date(); 
		try {
			connection c = new connection();
			String query = "insert into bank values ('"+password+"', '"+account+"', '"+date+"', 'Balance', '"+sum+"');";
			c.s.execute(query);
		} catch (SQLException e) {
			System.out.println(e);
		}

		if (a.getSource()==exit) { 
			System.exit(0);
		}else if(a.getSource()==back) { 
			setVisible(false);
			new transaction("").setVisible(true);;
		}
	}
}
