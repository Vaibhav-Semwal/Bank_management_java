package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import java.util.*;	

public class Deposit extends JFrame implements ActionListener{
	JTextField amountinfo; 
	JButton back, exit, deposit;
	String password; 
	String account_number = Login.card;
	Deposit(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);	
		setSize(800,800);
		setVisible(true);
		setLocation(300,50);
		
		JLabel transactiondetails = new JLabel("Deposit");
		transactiondetails.setFont(new Font("Osward", Font.BOLD, 24));
		transactiondetails.setForeground(Color.GREEN);
		transactiondetails.setAlignmentX(CENTER_ALIGNMENT);
		transactiondetails.setBounds(350, 40, 360 , 50);
		add(transactiondetails);
		
		JLabel amount = new JLabel("Enter the amount to be Deposited: ");
		amount.setFont(new Font("Osward", Font.BOLD, 24));
		amount.setForeground(Color.GREEN);
		amount.setBounds(80, 200, 400 , 30);
		add(amount);
		amountinfo = new JTextField();
		amountinfo.setBounds(80, 250, 500, 40);
		add(amountinfo);
		
		deposit = new JButton("Deposit"); 
		deposit.setBounds(600, 250, 100, 40);
		deposit.setBackground(Color.white);		deposit.setForeground(Color.black);
		deposit.addActionListener(this);
		add(deposit);
		
		back = new JButton("Back"); 
		back.setBounds(450, 580, 100, 30);
		back.setBackground(Color.white);		back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		exit = new JButton("Exit"); 
		exit.setBounds(600, 580, 100, 30);
		exit.setBackground(Color.white);		exit.setForeground(Color.black);
		exit.addActionListener(this);
		add(exit);
		
		
	}
	
	public void actionPerformed(ActionEvent a) { 
		if (a.getSource()==deposit) { 
			String num = amountinfo.getText();
			String account = "" + account_number;
			Date date = new Date(); 
			System.out.println(date);
			if (num == "") { 
				JOptionPane.showMessageDialog(null, "please enter a sum of money");
			}
			try {
				connection c = new connection();
				JOptionPane.showMessageDialog(null, "Rs. "+num+" has been deposited successfully");
				String query = "insert into bank values ('"+password+"', '"+account+"', '"+date+"', 'Deposit', '"+num+"');";
				c.s.execute(query);
				setVisible(false);
				new transaction(password).setVisible(true);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		else if (a.getSource()==exit) { 
			System.exit(0);
		}else if(a.getSource()==back) { 
			setVisible(false);
			new transaction("").setVisible(true);
		}
	}
	
}
