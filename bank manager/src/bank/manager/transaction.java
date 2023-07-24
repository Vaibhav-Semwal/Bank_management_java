package bank.manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;	

public class transaction extends JFrame implements ActionListener{
	JButton depositinfo,withdrawlinfo, fastcash, ministatement, pinchange, balance, exit; 
	String pinnumber ; 
	
	transaction(String pinnumber){ 
		this.pinnumber = pinnumber;
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel transactiondetails = new JLabel("Please select your Transaction");
		transactiondetails.setFont(new Font("Osward", Font.BOLD, 24));
		transactiondetails.setForeground(Color.GREEN);
		transactiondetails.setAlignmentX(CENTER_ALIGNMENT);
		transactiondetails.setBounds(250, 40, 360 , 50);
		add(transactiondetails);
		
		depositinfo = new JButton("Deposit");
		depositinfo.setFont(new Font("Osward", Font.BOLD, 18));
		depositinfo.setBackground(Color.WHITE);
		depositinfo.setBounds(50, 150, 300 , 50);
		depositinfo.addActionListener(this);
		add(depositinfo);
		
		withdrawlinfo = new JButton("Cash Withdrawl");
		withdrawlinfo.setFont(new Font("Osward", Font.BOLD, 18));
		withdrawlinfo.setBackground(Color.WHITE);
		withdrawlinfo.setBounds(450, 150, 300 , 50);
		withdrawlinfo.addActionListener(this);
		add(withdrawlinfo);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setFont(new Font("Osward", Font.BOLD, 18));
		fastcash.setBackground(Color.WHITE);
		fastcash.setBounds(50, 250, 300 , 50);
		fastcash.addActionListener(this);
		add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setFont(new Font("Osward", Font.BOLD, 18));
		ministatement.setBackground(Color.WHITE);
		ministatement.setBounds(450, 250, 300 , 50);
		ministatement.addActionListener(this);
		add(ministatement);
		
		pinchange = new JButton("PIN Change");
		pinchange.setFont(new Font("Osward", Font.BOLD, 18));
		pinchange.setBackground(Color.WHITE);
		pinchange.setBounds(50, 350, 300 , 50);
		pinchange.addActionListener(this);
		add(pinchange);
		
		balance = new JButton("Check Balance");
		balance.setFont(new Font("Osward", Font.BOLD, 18));
		balance.setBackground(Color.WHITE);
		balance.setBounds(450, 350, 300 , 50);
		balance.addActionListener(this);
		add(balance);
		
		exit = new JButton("Exit"); 
		exit.setBounds(250, 600, 300, 50);
		exit.setFont(new Font("Osward", Font.BOLD, 18));
		exit.setBackground(Color.WHITE);
		exit.addActionListener(this);
		add(exit);
		
		getContentPane().setBackground(Color.BLACK);
		
		setSize(800,800);
		setVisible(true);
		setLocation(300,50);
	}
	public void actionPerformed(ActionEvent ae) { 
		if (ae.getSource()==ministatement) { 
			new MiniStatement(pinnumber);
			return;
		}
		setVisible(false);
		if (ae.getSource()==depositinfo) {
			new Deposit(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==withdrawlinfo) { 
			new withdraw(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==fastcash) { 
			new fastcash(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==pinchange) { 
			new PinChange(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==balance) {
			new Balance(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==exit) { 
			new Login().setVisible(true);
		}
	}

}
