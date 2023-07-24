package bank.manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	static Long pin, account_number;		Random ran;
	JButton next;	private JRadioButton savings, fixed_deposit, current, recurring_deposit; 
	private JCheckBox card, internet, mobile, email, chequebook , e_statement; 
	String pinnumber = "" + SignupOne.pinnumber;
	SignupThree(){ 
		setTitle("SIGN UP - PAGE 2");
		setLayout(null);
		
		JLabel accountdetails = new JLabel("Page3: Account Details");
		accountdetails.setFont(new Font("Osward", Font.BOLD, 24));
		accountdetails.setBounds(250, 40, 400 , 50);
		add(accountdetails);
//random card number and PIN
		ran = new Random();
		pin = Math.abs(ran.nextLong()%9000L+1000L);
		account_number = Math.abs(ran.nextLong()%90000000L) + 5090434300000000L;
		
//account type
		JLabel accounttype = new JLabel("Account Type");
		accounttype.setFont(new Font("Osward", Font.BOLD, 18));
		accounttype.setBounds(100, 160, 400 , 30);
		add(accounttype);
		savings = new JRadioButton("Savings Account");
		fixed_deposit = new JRadioButton("Fixed Deposit Account");
		current = new JRadioButton("Current Account");
		recurring_deposit = new JRadioButton("Recurrong Deposit Account");
		savings.setBounds(100, 200, 150 , 30);				savings.setBackground(Color.WHITE);
		fixed_deposit.setBounds(300, 200, 300 , 30);		fixed_deposit.setBackground(Color.WHITE);
		current.setBounds(100, 250, 150 , 30);				current.setBackground(Color.WHITE);
		recurring_deposit.setBounds(300, 250, 300 , 30);	recurring_deposit.setBackground(Color.WHITE);
		add(savings);					add(fixed_deposit);
		add(current);					add(recurring_deposit);
		ButtonGroup accounttype_group = new ButtonGroup();
		accounttype_group.add(savings);		accounttype_group.add(fixed_deposit);
		accounttype_group.add(current);		accounttype_group.add(recurring_deposit);

//Card Number
		JLabel card_number = new JLabel("Card Number");
		JLabel info1 = new JLabel("(Your 16 Digit Number)");
		card_number.setFont(new Font("Osward", Font.BOLD, 18));
		info1.setFont(new Font("Osward", Font.BOLD, 12));
		card_number.setBounds(100, 300, 400, 30);
		info1.setBounds(100, 320, 400, 30);
		add(card_number);		add(info1);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-"+account_number.toString().substring(12,16));
		number.setFont(new Font("Osward", Font.BOLD, 18));
		number.setBounds(250, 300, 400, 30);
		add(number);

//pin/password
		JLabel pin_number = new JLabel("PIN");
		JLabel info2 = new JLabel("(Your 4 digit password)");
		pin_number.setFont(new Font("Osward", Font.BOLD, 18));
		info2.setFont(new Font("Osward", Font.BOLD, 12));
		pin_number.setBounds(100, 360, 400, 30);
		info2.setBounds(100, 380, 400, 30);
		add(pin_number);		add(info2);
		
		JLabel pass = new JLabel("XXXX");
		pass.setFont(new Font("Osward", Font.BOLD, 18));
		pass.setBounds(250, 380, 400, 30);
		add(pass);

//services
		JLabel service = new JLabel("Services Required");
		service.setFont(new Font("Osward", Font.BOLD, 18));
		service.setBounds(100, 440, 400, 30);
		add(service);

		card = new JCheckBox("ATM Card");
		card.setBackground(Color.WHITE);
		card.setFont(new Font("Osward", Font.BOLD, 12));
		card.setBounds(100, 480, 150, 30);
		internet = new JCheckBox("Internet Banking");
		internet.setBackground(Color.WHITE);
		internet.setFont(new Font("Osward", Font.BOLD, 12));
		internet.setBounds(300, 480, 150, 30);
		
		mobile = new JCheckBox("Moblie Banking");
		mobile.setBackground(Color.WHITE);
		mobile.setFont(new Font("Osward", Font.BOLD, 12));
		mobile.setBounds(100, 520, 150, 30);
		email = new JCheckBox("Email Alerts");
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Osward", Font.BOLD, 12));
		email.setBounds(300, 520, 150, 30);
		
		chequebook = new JCheckBox("Chequebook");
		chequebook.setBackground(Color.WHITE);
		chequebook.setFont(new Font("Osward", Font.BOLD, 12));
		chequebook.setBounds(100, 560, 150, 30);
		e_statement= new JCheckBox("E-Statements");
		e_statement.setBackground(Color.WHITE);
		e_statement.setFont(new Font("Osward", Font.BOLD, 12));
		e_statement.setBounds(300, 560, 150, 30);
		
		add(card);			add(internet);
		add(mobile);		add(email);
		add(chequebook);	add(e_statement);
		
		next = new JButton("Next"); 
		next.setBounds(500, 600, 100, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,800);
		setLocation(300,50);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent a) { 
		String formno = "" + SignupOne.r;
		String accounttype = "";
		if (savings.isSelected()) {
			accounttype = "Savings Account";
		}
		else if (fixed_deposit.isSelected()) {
			accounttype = "Fixed Deposit Account";
		}
		else if (current.isSelected()) {
			accounttype = "Current Account";
		}
		else if (recurring_deposit.isSelected()) {
			accounttype = "Recurring Deposit Account";
		}
		String account = "" + account_number; 
		String pin_number = "" + pin;
		
		String service = "";
		if (card.isSelected()) {
			service = service + "| ATM card";
		}
		if (internet.isSelected()) {
			service = service + "| Internet Banking service";
		}
		if (mobile.isSelected()) {
			service = service + "| Moblie Banking service";
		}
		if (email.isSelected()) {
			service = service + "| Email Alerts";
		}
		if (chequebook.isSelected()) {
			service = service + "| Chequebook";
		}
		if (e_statement.isSelected()) {
			service = service + "| E-Statement";
		}
		
		try {
			if (accounttype == ""){
				JOptionPane.showMessageDialog(null, "Please select a Account Type");
			}
			else {
				connection c = new connection(); 
				String query = "insert into signupthree values ('"+formno+"', '"+account+"', '"+pin_number+"', '"+accounttype+"', '"+service+"');";
				c.s.execute(query);	
				if (a.getSource()==next) { 
					JOptionPane.showMessageDialog(null, "Your card Number: "+account+"\nYour PIN: "+pin_number);
					setVisible(false);
					new Login().setVisible(true);
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new SignupThree();
	}
}
