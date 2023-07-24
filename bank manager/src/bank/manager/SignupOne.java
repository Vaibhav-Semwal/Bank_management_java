package bank.manager;
	
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.*;

public class SignupOne extends JFrame implements ActionListener{
	private JTextField nameinfo, fatherinfo, phoneinfo, emailinfo, addressinfo, cityinfo, stateinfo, pininfo  ;
	JButton next;	private JRadioButton male,female; 
	Random ran;	static Long r;	JDateChooser dateinfo;
	static String pinnumber;
	
	SignupOne (){ 
		setTitle("SIGN UP - PAGE 1");
		setLayout(null);
		
		JLabel personaldetails = new JLabel("Page1: Personal Details");
		personaldetails.setFont(new Font("Osward", Font.BOLD, 24));
		personaldetails.setBounds(250, 40, 400 , 50);
		add(personaldetails);

//Randomized application number
		ran = new Random();
		r = Math.abs(ran.nextLong()%9000L + 1000L);
		JLabel form = new JLabel("Application no:  "+r);
		form.setFont(new Font("Osward", Font.BOLD, 18));
		form.setBounds(300, 80, 400 , 30);
		add(form);
//name
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Osward", Font.BOLD, 18));
		name.setBounds(100, 160, 400 , 30);
		add(name);
		nameinfo = new JTextField();
		nameinfo.setBounds(300, 160, 300, 30);
		add(nameinfo);
//dob
		JLabel date = new JLabel("Date Of Birth");
		date.setFont(new Font("Osward", Font.BOLD, 18));
		date.setBounds(100, 200, 400, 30);
		add(date);
		dateinfo = new JDateChooser(); 
		dateinfo.setBounds(300, 200, 200, 30);
		dateinfo.setForeground(Color.BLACK);
		add(dateinfo);
//father name	
		JLabel fathername = new JLabel("Father Name");
		fathername.setFont(new Font("Osward", Font.BOLD, 18));
		fathername.setBounds(100, 240, 400 , 30);
		add(fathername);
		fatherinfo = new JTextField(); 
		fatherinfo.setBounds(300, 240, 300, 30);
		add(fatherinfo);
//gender
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Osward", Font.BOLD, 18));
		gender.setBounds(100, 280, 400 , 30);
		add(gender);
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		male.setBounds(300, 280, 150 , 30);		male.setBackground(Color.WHITE);
		female.setBounds(450, 280, 150 , 30);	female.setBackground(Color.WHITE);
		add(male);					add(female);
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);		gendergroup.add(female);
//phone number
		JLabel phone = new JLabel("Phone Number");
		phone.setFont(new Font("Osward", Font.BOLD, 18));
		phone.setBounds(100, 320, 400 , 30);
		add(phone);
		phoneinfo = new JTextField(); 
		phoneinfo.setBounds(300, 320, 300, 30);
		add(phoneinfo);
//email address
		JLabel email = new JLabel("Email Address");
		email.setFont(new Font("Osward", Font.BOLD, 18));
		email.setBounds(100, 360, 400, 30);
		add(email);
		emailinfo = new JTextField(); 
		emailinfo.setBounds(300, 360, 300, 30);
		add(emailinfo);
//residential address
		JLabel address = new JLabel("Address");
		address.setFont(new Font("Osward", Font.BOLD, 18));
		address.setBounds(100, 400, 400, 30);
		add(address);
		addressinfo = new JTextField(); 
		addressinfo.setBounds(300, 400, 300, 30);
		add(addressinfo);
//city
		JLabel city = new JLabel("City");
		city.setFont(new Font("Osward", Font.BOLD, 18));
		city.setBounds(100, 440, 400, 30);
		add(city);
		cityinfo = new JTextField(); 
		cityinfo.setBounds(300, 440, 300, 30);
		add(cityinfo);
//state
		JLabel state = new JLabel("State");
		state.setFont(new Font("Osward", Font.BOLD, 18));
		state.setBounds(100, 480, 400, 30);
		add(state);
		stateinfo = new JTextField(); 
		stateinfo.setBounds(300, 480, 300, 30);
		add(stateinfo);
//PIN number
		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Osward", Font.BOLD, 18));
		pin.setBounds(100, 520, 400, 30);
		add(pin);
		pininfo = new JTextField(); 
		pininfo.setBounds(300, 520, 300, 30);
		add(pininfo);
		
		next = new JButton("Next"); 
		next.setBounds(500, 580, 100, 30);
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
		String formno = "" + r; 
		String name = nameinfo.getText(); 
		String dob = ((JTextField) dateinfo.getDateEditor().getUiComponent()).getText();
		String fathername = fatherinfo.getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "male";
		}
		else if (female.isSelected()) {
			gender = "female";
		}
		String phone = phoneinfo.getText(); 
		String email = emailinfo.getText();
		String address = addressinfo.getText(); 
		String city = cityinfo.getText(); 
		String state = stateinfo.getText(); 
		String pin = pininfo.getText(); 
		this.pinnumber = pin;
		try {
			if (name.equals("") || fathername.equals("") || dob.equals("") || gender == null || phone.equals("") || address.equals("")
				|| city.equals("") || state.equals("") || pin.equals("")) { 
				JOptionPane.showMessageDialog(null,"Please fill all the coloums");
			}else {
				connection c = new connection(); 
				String query = "insert into signup values ('"+formno+"', '"+pin+"', '"+name+"', '"+fathername+"', '"+
															dob+"', '"+gender+"', '"+phone+"', '"+email+"', '"+address+
															"', '"+city+"', '"+state+"');";
				c.s.execute(query);	
				if(a.getSource()==next) { 
					setVisible(false);
					new SignupTwo().setVisible(true);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new SignupOne(); 
	}
}
