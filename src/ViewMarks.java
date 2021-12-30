import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ViewMarks extends JFrame {

	private JPanel contentPane;
	private JTable TableViewMarks;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMarks frame = new ViewMarks();
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
	public ViewMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 535, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TableViewMarks = new JTable();
		TableViewMarks.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null, null},
			},
			new String[] {
				"RegNo", "First Name", "English", "Math", "Science", "SST"
			}
		));
		TableViewMarks.setBounds(151, 70, 374, 221);
		panel.add(TableViewMarks);
		
		JLabel lblNewLabel = new JLabel("INPUT REG NUMBER ");
		lblNewLabel.setBounds(10, 103, 100, 20);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 126, 131, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("RETURN RESULTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username= "root";
					String password= "";
					String url = "jdbc:mysql://localhost/katikamu?useSSL=false";
					Connection con = DriverManager.getConnection(url,username,password);
					Statement st = con.createStatement();
					//lets first get the string that will be used in the sql query to get the results for a particular student number 
					
					String RgNo = textField.getText().toString();
					
					String sql ="SELECT `first_name`,`Registration_no`,`ENG`, `MATH`, `SCIENCE`, `SST` FROM `students` WHERE `Registration_no`='"+RgNo+"'";
					
					ResultSet rs= st.executeQuery(sql);
					
					while(rs.next()) {
						//`first_name``last_name``Registration_no``grade``ENG``MATH``SCIENCE``SST`
						//writing down the database fields
						String Fname3 = rs.getString("first_name");
						String RegNo3 = rs.getString("Registration_no");
						String Eng3 = rs.getString("ENG");
						String Math3 = rs.getString("MATH");
						String Science3 = rs.getString("SCIENCE");
						String SST3 = rs.getString("SST");
						
						
						//indicating order to insert data in Jtable
						//"RegNo", "Subject", "Complaint" these are the table fields
						String tbData[]= {Fname3, RegNo3, Eng3,Math3,Science3,SST3};
						DefaultTableModel tbModel= (DefaultTableModel)TableViewMarks.getModel();
						
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
		btnNewButton.setBounds(0, 169, 141, 32);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("VIEW MARKS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(137, 11, 207, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FirstName");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(151, 54, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RegNo");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(213, 54, 60, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ENG");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(277, 54, 48, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MATH");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(335, 54, 48, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("SCIENCE");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(403, 54, 48, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("SST");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(461, 54, 48, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentHome hme=new StudentHome();
				hme.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(21, 234, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("File Complaint");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentComplaints Shme= new StudentComplaints();
				Shme.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(10, 268, 131, 23);
		panel.add(btnNewButton_2);
	}
}
