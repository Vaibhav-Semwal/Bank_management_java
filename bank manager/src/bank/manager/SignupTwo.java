package bank.manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
	private JComboBox<String> religioninfo, categoryinfo, incomeinfo, educationinfo, occupationinfo;
	private JTextField qualificationinfo, panidinfo, aadharinfo;
	JButton next;	private JRadioButton senior_yes,senior_no, extraaccounts_yes, extraaccounts_no; 
	
	SignupTwo (){ 
		setTitle("SIGN UP - PAGE 2");
		setLayout(null);
		
		JLabel additionaldetails = new JLabel("Page2: Additional Details");
		additionaldetails.setFont(new Font("Osward", Font.BOLD, 24));
		additionaldetails.setBounds(250, 40, 400 , 50);
		add(additionaldetails);
		
//religion
		JLabel religion = new JLabel("Religion");
		religion.setFont(new Font("Osward", Font.BOLD, 18));
		religion.setBounds(100, 160, 400 , 30);
		add(religion);
		String list_of_religions[] = {" ", "Hindu","Muslim","Cristians","Sikh","Others"};
		religioninfo = new JComboBox<>(list_of_religions);		religioninfo.setBackground(Color.WHITE);
		religioninfo.setBounds(300, 160, 300, 30);
		add(religioninfo);
//category
		JLabel category = new JLabel("Category");
		category.setFont(new Font("Osward", Font.BOLD, 18));
		category.setBounds(100, 200, 400, 30);
		add(category);
		String list_of_categories[] = {" ","General","Schedule Caste","Schedue Tribes","Other Backward Classes (OBC)"};
		categoryinfo = new JComboBox<>(list_of_categories); 	categoryinfo.setBackground(Color.WHITE); 
		categoryinfo.setBounds(300, 200, 200, 30);
		add(categoryinfo);
//income
		JLabel Income = new JLabel("Income");
		Income.setFont(new Font("Osward", Font.BOLD, 18));
		Income.setBounds(100, 240, 400 , 30);
		add(Income);
		String list_of_income[] = {" ","Below 1-Lakh","1Lakh to 2Lakh","2Lakh to 3lakh","3Lakh to 4lakh","4Lakh to 5lakh","5Lakh above"};
		incomeinfo = new JComboBox<>(list_of_income); 			incomeinfo.setBackground(Color.WHITE);
		incomeinfo.setBounds(300, 240, 300, 30);
		add(incomeinfo);
//educational qualification
		JLabel education = new JLabel("<html>Education <br> Qualifications</html>");
		education.setFont(new Font("Osward", Font.BOLD, 18));
		education.setBounds(100, 280, 400 , 50);
		add(education);
		String list_of_education[] = {" ","Non Graduate","Graduate" ,"Post Graduate", "Doctrate", "Others"}; 
		educationinfo = new JComboBox<>(list_of_education); 	educationinfo.setBackground(Color.WHITE);
		educationinfo.setBounds(300, 280, 300, 30);
		add(educationinfo);
//other qualifications
		JLabel qualification = new JLabel("Other Qualifications");
		qualification.setFont(new Font("Osward", Font.BOLD, 18));
		qualification.setBounds(100, 340, 400 , 30);
		add(qualification);
		qualificationinfo = new JTextField(); 
		qualificationinfo.setBounds(300, 340, 300, 30);
		add(qualificationinfo);
//occupations
		JLabel occupation = new JLabel("Occupation");
		occupation.setFont(new Font("Osward", Font.BOLD, 18));
		occupation.setBounds(100, 380, 400, 30);
		add(occupation);
		String list_of_occupation[] = {" ","Salaried","Self Employed" ,"Bussiness", "Student", "Others"}; 
		occupationinfo = new JComboBox<>(list_of_occupation); occupationinfo.setBackground(Color.WHITE);
		occupationinfo.setBounds(300, 380, 300, 30);
		add(occupationinfo);
//pan number
		JLabel panid = new JLabel("PAN number");
		panid.setFont(new Font("Osward", Font.BOLD, 18));
		panid.setBounds(100, 420, 400, 30);
		add(panid);
		panidinfo = new JTextField(); 
		panidinfo.setBounds(300, 420, 300, 30);
		add(panidinfo);
//aadhar number
		JLabel aadhar = new JLabel("Aadhar Card Number");
		aadhar.setFont(new Font("Osward", Font.BOLD, 18));
		aadhar.setBounds(100, 460, 400, 30);
		add(aadhar);
		aadharinfo = new JTextField(); 
		aadharinfo.setBounds(300, 460, 300, 30);
		add(aadharinfo);
//senior citizen or not
		JLabel senior = new JLabel("Senior Citizen");
		senior.setFont(new Font("Osward", Font.BOLD, 18));
		senior.setBounds(100, 500, 400, 30);
		add(senior);
		senior_yes = new JRadioButton("Yes");
		senior_no = new JRadioButton("No");
		senior_yes.setBounds(300, 500, 150 , 30);		senior_yes.setBackground(Color.WHITE);
		senior_no.setBounds(450, 500, 150 , 30);	senior_no.setBackground(Color.WHITE);
		add(senior_yes);					add(senior_no);
		ButtonGroup seniorgroup = new ButtonGroup();
		seniorgroup.add(senior_yes);		seniorgroup.add(senior_no);
//other accounts
		JLabel extraaccounts = new JLabel("Exisiting Acoounts");
		extraaccounts.setFont(new Font("Osward", Font.BOLD, 18));
		extraaccounts.setBounds(100, 540, 400, 30);
		add(extraaccounts);
		extraaccounts_yes = new JRadioButton("Yes");
		extraaccounts_no = new JRadioButton("No");
		extraaccounts_yes.setBounds(300, 540, 150 , 30);		extraaccounts_yes.setBackground(Color.WHITE);
		extraaccounts_no.setBounds(450, 540, 150 , 30);	extraaccounts_no.setBackground(Color.WHITE);
		add(extraaccounts_yes);					add(extraaccounts_no);
		ButtonGroup extraaccountsgroup = new ButtonGroup();
		extraaccountsgroup.add(extraaccounts_yes);		extraaccountsgroup.add(extraaccounts_no);
		
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
		String religion = (String) religioninfo.getSelectedItem(); 
		String category = (String) categoryinfo.getSelectedItem(); 
		String income = (String) incomeinfo.getSelectedItem();
		String education = (String) educationinfo.getSelectedItem(); 
		String qualifications = qualificationinfo.getText();
		String occupation = (String) occupationinfo.getSelectedItem(); 
		String panid = panidinfo.getText();
		String aadhar = aadharinfo.getText();
		String senior = null;
		if (senior_yes.isSelected()) {
			senior = "Yes";
		}
		else if (senior_no.isSelected()) {
			senior = "No";
		}
		String extraaccount = null;
		if (extraaccounts_yes.isSelected()) {
			extraaccount = "Yes";
		}
		else if (extraaccounts_no.isSelected()) {
			extraaccount = "No";
		}
		
		try {
			if (aadhar.length() != 12 || religion == " " || category == " " || income == " " || education == " " || occupation == " ") { 
				JOptionPane.showMessageDialog(null,"please fill in the form correctly");
				
			}else {
				connection c = new connection(); 
				String query = "insert into signuptwo values ('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+
															occupation+"', '"+qualifications+"', '"+panid+"', '"+aadhar+"', '"+senior+
															"', '"+extraaccount+"');";
				c.s.execute(query);	
				if (a.getSource()==next) { 
					setVisible(false);
					new SignupThree().setVisible(true);
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new SignupTwo();
	}
}
