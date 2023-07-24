package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;	

public class withdraw extends JFrame implements ActionListener{
	JTextField amountinfo; 
	JButton back, exit, withdraw;
	String password; 
	String account_number = Login.card;
	withdraw(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel withdrawdetails = new JLabel("Withdraw");
		withdrawdetails.setFont(new Font("Osward", Font.BOLD, 24));
		withdrawdetails.setForeground(Color.GREEN);
		withdrawdetails.setAlignmentX(CENTER_ALIGNMENT);
		withdrawdetails.setBounds(350, 40, 360 , 50);
		add(withdrawdetails);
		
		JLabel amount = new JLabel("Enter the amount to be Withdrawn: ");
		amount.setFont(new Font("Osward", Font.BOLD, 24));
		amount.setForeground(Color.GREEN);
		amount.setBounds(80, 200, 450 , 30);
		add(amount);
		amountinfo = new JTextField();
		amountinfo.setBounds(80, 250, 500, 40);
		add(amountinfo);
		
		withdraw = new JButton("Withdraw"); 
		withdraw.setBounds(600, 250, 100, 40);
		withdraw.setBackground(Color.white);		withdraw.setForeground(Color.black);
		withdraw.addActionListener(this);
		add(withdraw);
		
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
		if (a.getSource()==withdraw) { 
			String num = amountinfo.getText(); 
			String account = "" + account_number;
			Date date = new Date(); 
			if (num == "") { 
				JOptionPane.showMessageDialog(null, "please enter a sum of money");
			}
			try {
				connection c = new connection();
				JOptionPane.showMessageDialog(null, "Rs. "+num+" has been withdrawn successfully");
				String query = "insert into bank values ('"+password+"', '"+account+"', '"+date+"', 'Withdrawl', '"+num+"');";
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
			new transaction("").setVisible(true);;
		}
	}
}
