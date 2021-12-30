

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import connection.dbconn;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewStudents extends JFrame {

	private JPanel contentPane;
	private JTable jTable1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudents frame = new ViewStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public ViewStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setBounds(10, 5, 739, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		jTable1 = new JTable();
		jTable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"FirstName", "LastName", "Reg.Number", "CLASS", "ENGLISH", "MATH", "SCIENCE", "SST"
			}
		));
		jTable1.setBounds(211, 30, 518, 362);
		panel_1.add(jTable1);
		
		JButton btnNewButton = new JButton("VIEW STUDENTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username= "root";
					String password= "";
					String url = "jdbc:mysql://localhost/katikamu?useSSL=false";
					Connection con = DriverManager.getConnection(url,username,password);
					Statement st = con.createStatement();
					String sql ="SELECT `first_name`,`last_name`,`Registration_no`,`grade`,`ENG`,`MATH`,`SCIENCE`,`SST` FROM `students` ";
					ResultSet rs= st.executeQuery(sql);
					
					while(rs.next()) {
						//`first_name``last_name``Registration_no``grade``ENG``MATH``SCIENCE``SST`
						String fname = rs.getString("first_name");
						String Lname = rs.getString("last_name");
						String RegNo = rs.getString("Registration_nO");
						String Sclass = rs.getString("grade");
						String feng = rs.getString("ENG");
						String fmtc = rs.getString("MATH");
						String sci = rs.getString("SCIENCE");
						String sst = rs.getString("SST");
						
						//indicating order to insert data in Jtable
						String tbData[]= {fname,Lname,RegNo,Sclass,feng,fmtc,sci,sst};
						DefaultTableModel tbModel= (DefaultTableModel)jTable1.getModel();
						
						//add string array into jtable1
						
						tbModel.addRow(tbData);
						
						
						
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(10, 99, 153, 45);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("EDIT MARKS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RecordMarks RMks = new RecordMarks();
				RMks.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 172, 153, 37);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home hme= new Home();
				hme.setVisible(true);


			}
		});
		btnNewButton_2.setBounds(10, 243, 153, 31);
		panel_1.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setBounds(211, 11, 60, 14);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setBounds(281, 11, 57, 14);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("REG NO.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(348, 11, 48, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CLASS");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(406, 11, 48, 14);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ENG");
		lblNewLabel_4.setBounds(481, 11, 48, 14);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("MATH");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(539, 11, 48, 14);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("SCIENCE");
		lblNewLabel_6.setBounds(608, 11, 48, 14);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("SST");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(666, 11, 48, 14);
		panel_1.add(lblNewLabel_7);
	}
}
