package bank.manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JButton login , clear, signup, exit;
	private JTextField cardinfo; 
	private JPasswordField pininfo; 
	static String card, password; 
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		// bank icon
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank-building.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(30, 10, 100, 100);
		add(label);
		
		// welcome to ATM
		JLabel text = new JLabel("Welcome To A.T.M");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(160, 40, 400 , 50);
		add(text);
		
		// card number
		JLabel cardno = new JLabel("Card Number");
		cardno.setFont(new Font("Osward", Font.BOLD, 24));
		cardno.setBounds(80, 200, 400 , 30);
		add(cardno);
		
		cardinfo = new JTextField();
		cardinfo.setBounds(300, 200, 300, 30);
		add(cardinfo);
		
		//PIN 
		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Osward", Font.BOLD, 24));
		pin.setBounds(80, 300, 400 , 30);
		add(pin);
		pininfo = new JPasswordField();
		pininfo.setBounds(300, 300, 300, 30);
		add(pininfo);
		
		//buttons 
		login = new JButton("LOG IN"); 
		login.setBounds(300, 400, 140, 50);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
	
		clear = new JButton("CLEAR"); 
		clear.setBounds(460, 400, 140, 50);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("Sign Up"); 
		signup.setBounds(300, 460, 300, 50);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		exit = new JButton("Exit"); 
		exit.setBounds(500, 680, 100, 50);
		exit.setBackground(Color.BLACK);			exit.setForeground(Color.WHITE);
		exit.addActionListener(this);
		add(exit);
		
		//setting up the content pane
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,800);
		setVisible(true);
		setLocation(300,50);
		
	}
	
	public void actionPerformed(ActionEvent a) { 
		if (a.getSource()==clear) { 
			cardinfo.setText("");
			pininfo.setText("");
		}
		else if (a.getSource()==signup) { 
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		else if (a.getSource()==exit) { 
			System.exit(0);
		}
		else if (a.getSource()==login) { 
			try {
				connection c = new connection(); 
				card = cardinfo.getText();
				String password = String.valueOf(pininfo.getPassword());
				System.out.println(card +"\n"+password);
				String query = "select * from signupthree where Account_Number = '"+ card +"' and pin = '"+password+"';";
				ResultSet r = c.s.executeQuery(query);
				if (r.next()) { 
					setVisible(false);
					new transaction(password).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, " Incorrect card number or password");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}