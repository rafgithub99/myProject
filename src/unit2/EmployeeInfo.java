package unit2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection connection = null;
	String total;
	private JTable table_1;
	private JLabel lblTotalRecords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}//end try/catch block
			}//end run()
		});//end EventQueue Runnable
	}//end main method

	/**
	 * Create the frame.
	 */
	public Connection conn (Connection connection){
		this.connection = connection;
		return connection;
	}
	
	public EmployeeInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadData = new JButton("Load Employee Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String employeeQuery = "USE NORTHWND SELECT * FROM Employees";
					PreparedStatement pst = connection.prepareStatement(employeeQuery);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					String employeeCount = "SELECT COUNT(EmployeeID) AS Total FROM Employees";
					PreparedStatement pst2 = connection.prepareStatement(employeeCount);
					ResultSet rs2 = pst2.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
					connection.close();
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, e);
				}//end try/catch block				
			}//end actionPerformed
		});//end ActionListener
		btnLoadData.setBounds(504, 48, 207, 29);
		contentPane.add(btnLoadData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 119, 1056, 375);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.menu);
		table_1.setBounds(250, 553, 115, 33);
		contentPane.add(table_1);
		
		lblTotalRecords = new JLabel("Total Records");
		lblTotalRecords.setBounds(110, 544, 115, 33);
		contentPane.add(lblTotalRecords);
		
	}//end constructor EmployeeInfo
}//end class EmployeeInfo
