package unit2;

//not secure, no validation!

import java.sql.*;
import javax.swing.*;

public class SQLconnection {
	//TODO take in credentials and connect to MS SQL Server DB
	
	Connection conn = null;
	
	public static Connection dbConnector(String username, String password){
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String URL = "jdbc:sqlserver://DESKTOP-SGSJPJS\\NORTHWND:1433;user=Rafael;password=roadrunner1";
			String URL = "jdbc:sqlserver://DESKTOP-SGSJPJS\\NORTHWND:1433;user="+username+";password="+password;
			
			Connection conn = DriverManager.getConnection(URL);
			if (conn != null) {//check connection
			    JOptionPane.showMessageDialog(null, "Connected to SQL Server");
			}//end if statement
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Connection Failed, Check Credentials and Try Again");
			return null;
		}//end try/catch block
		
	}//end method dbConnector
	
}//end class SQLconnection