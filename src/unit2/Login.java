package unit2;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	public Connection connection = null;//db connection global variable
	private JTextField textField;
	private JPasswordField passwordField;
	String username;
	String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}//end try/catch block
			}//end run()
		});//end EventQueue Runnable
	}//end main method

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
	}//end Login

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//TODO create login pane objects
		frame = new JFrame();
		frame.setBounds(100, 100, 902, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//create username label
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(159, 170, 99, 33);
		frame.getContentPane().add(lblUsername);
		
		//create password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(159, 267, 69, 33);
		frame.getContentPane().add(lblPassword);
		
		//create username input field
		textField = new JTextField();
		textField.setBounds(273, 167, 146, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//create password input field
		passwordField = new JPasswordField();
		passwordField.setBounds(273, 264, 146, 33);
		frame.getContentPane().add(passwordField);
		
		//create login button
		JButton btnLogin = new JButton("Login");
		Image btnImg = new ImageIcon(this.getClass().getResource("/OkIcon.png")).getImage();
		btnLogin.setIcon(new ImageIcon(btnImg));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try{
					username = textField.getText();
					password = passwordField.getText();
					Connection connection=SQLconnection.dbConnector(username, password);//pass values to connect
					if(connection != null){
						frame.dispose();//close current frame
						EmployeeInfo empInfo = new EmployeeInfo();//new instance of EmployeeInfo class
						empInfo.conn(connection);
						empInfo.setVisible(true);//display EmployeeInfo frame
						}//end if block

				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}//end try/catch block
			}//end actionPerformed
		});//end Action Listener
		btnLogin.setBounds(273, 346, 146, 33);
		frame.getContentPane().add(btnLogin);
		
		//create database login image
		JLabel loginImage = new JLabel("");
		Image dbImg = new ImageIcon(this.getClass().getResource("/databaseIcon.png")).getImage();
		loginImage.setIcon(new ImageIcon(dbImg));
		loginImage.setBounds(498, 135, 256, 256);
		frame.getContentPane().add(loginImage);
		
	}//end initialize
}//end class Login
