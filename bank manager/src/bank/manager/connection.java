package bank.manager;

import java.sql.*;

public class connection {
	
	Connection c;
	Statement s;
	public connection () { 
		try { 
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "2020NFSheat!");
			s = c.createStatement();
		} catch (Exception e) { 
			System.out.println(e);
		}
	}
}
