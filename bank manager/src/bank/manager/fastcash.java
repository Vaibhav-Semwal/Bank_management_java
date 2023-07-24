package bank.manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;	

public class fastcash extends JFrame implements ActionListener { 
	JButton back, exit, C100, C200, C500, C1000, C2000, C5000;
	String password;
	String account_number = Login.card;
	fastcash(String pinnumber) { 
		this.password = pinnumber; 
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel withdrawdetails = new JLabel("Fast Withdrawl");
		withdrawdetails.setFont(new Font("Osward", Font.BOLD, 24));
		withdrawdetails.setForeground(Color.GREEN);
		withdrawdetails.setAlignmentX(CENTER_ALIGNMENT);
		withdrawdetails.setBounds(350, 40, 360 , 50);
		add(withdrawdetails);
		
		JLabel info = new JLabel("select a option for withdrawal");
		info.setFont(new Font("Osward", Font.BOLD, 18));
		info.setForeground(Color.GREEN);
		info.setAlignmentX(CENTER_ALIGNMENT);
		info.setBounds(50, 140, 360 , 50);
		add(info);
		
		C100 = new JButton("Rs. 100"); 
		C100.setBounds(50, 250, 100, 40);
		C100.setBackground(Color.white);		C100.setForeground(Color.black);
		C100.addActionListener(this);
		add(C100);
		
		C200 = new JButton("Rs. 200"); 
		C200.setBounds(200, 250, 100, 40);
		C200.setBackground(Color.white);		C200.setForeground(Color.black);
		C200.addActionListener(this);
		add(C200);
		
		C500 = new JButton("Rs. 500"); 
		C500.setBounds(50, 350, 100, 40);
		C500.setBackground(Color.white);		C500.setForeground(Color.black);
		C500.addActionListener(this);
		add(C500);
		
		C1000 = new JButton("Rs. 1000"); 
		C1000.setBounds(200, 350, 100, 40);
		C1000.setBackground(Color.white);		C1000.setForeground(Color.black);
		C1000.addActionListener(this);
		add(C1000);
		
		C2000 = new JButton("Rs. 2000"); 
		C2000.setBounds(50, 450, 100, 40);
		C2000.setBackground(Color.white);		C2000.setForeground(Color.black);
		C2000.addActionListener(this);
		add(C2000);
		
		C5000 = new JButton("Rs. 5000"); 
		C5000.setBounds(200, 450, 100, 40);
		C5000.setBackground(Color.white);		C5000.setForeground(Color.black);
		C5000.addActionListener(this);
		add(C5000);
		
		
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
		String num = ""; 
		if (a.getSource()==C100) { 
			num = "100";
		}else if (a.getSource()==C200) { 
			num = "200";
		}else if (a.getSource()==C500) { 
			num = "500";
		}else if (a.getSource()==C1000) { 
			num = "1000";
		}else if (a.getSource()==C2000) { 
			num = "2000";
		}else if (a.getSource()==C5000) { 
			num = "5000";
		}
		String account = "" + account_number;
		Date date = new Date(); 
		try {
			connection c = new connection();
			JOptionPane.showMessageDialog(null, "Rs. "+num+" has been withdrawn successfully");
			String query = "insert into bank values ('"+password+"', '"+account+"', '"+date+"', 'fast cash', '"+num+"');";
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
