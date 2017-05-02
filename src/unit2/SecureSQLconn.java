package unit2;

import java.sql.*;
import javax.swing.*;


public class SecureSQLconn {
	//TODO take in credentials and connect to MS SQL Server DB
	
	Connection conn = null;
	
	public static Connection dbConnector(String username, String password){
		
		//username validation
		if (username.length() > 8){
			JOptionPane.showMessageDialog(null, "Username must be 8 characters or less");
			return null;
			
		//password validation	
		} else if (password.contains(" ")||password.contains("=")){
			JOptionPane.showMessageDialog(null, "Password cannot contain spaces or illegal characters");
			return null;
		
		} else {
			
			//validation passed proceed
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//String URL = "jdbc:sqlserver://DESKTOP-SGSJPJS\\NORTHWND:1433;user=Rafael;password=roadrunner1";
				String URL = "jdbc:sqlserver://DESKTOP-SGSJPJS\\NORTHWND:1433";
				
				//separate arguments so that username and pass are passes as single values instead of a whole statement
				Connection conn = DriverManager.getConnection(URL, username, password);
				
				if (conn != null) {//check connection
				    JOptionPane.showMessageDialog(null, "Connected to SQL Server");
				}//end if statement
				return conn;
			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Connection Failed, Check Credentials and Try Again");
				return null;
			}//end try/catch block
		}//end if/else block
	}//end method dbConnector
	
}//end class
