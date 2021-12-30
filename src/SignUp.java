import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.Handler;
import connection.dbconn;
import java. sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField Lname;
	private JPasswordField Tpas1;
	private JPasswordField Tpas2;
	private JTextField TuserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		Handler handle = new Handler();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(10, 11, 554, 349);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 30, 127, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 77, 127, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 226, 127, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 261, 127, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 185, 127, 25);
		panel.add(lblNewLabel_4);
		
		Fname = new JTextField();
		Fname.setBounds(182, 38, 154, 28);
		panel.add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setBounds(182, 85, 154, 29);
		panel.add(Lname);
		Lname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("TEACHER SIGN UP, IF YOU HAVE NO ACCOUNT");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(76, 11, 331, 14);
		panel.add(lblNewLabel_5);
		
		Tpas1 = new JPasswordField();
		Tpas1.setBounds(182, 220, 154, 24);
		panel.add(Tpas1);
		
		Tpas2 = new JPasswordField();
		Tpas2.setBounds(182, 255, 154, 24);
		panel.add(Tpas2);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here 
			
				String Firstname = Fname.getText();
				String Lastname = Lname.getText();
				String UserN=TuserName.getText();
				String Email= Temail.getText();
				String Pass1=Tpas1.getText();
				String Pass2=Tpas2.getText();
				
			dbconn db = new dbconn();
			
			try {
				Connection con = db.getConenction();
				
				handle.Teacher_SignUp(con, Firstname, Lastname, UserN, Email, Pass1);
				JOptionPane.showMessageDialog(null,"New Teacher Added");
				Fname.setText("");
				Lname.setText("");
				TuserName.setText("");
				Temail.setText("");
				Tpas1.setText("");
				Tpas2.setText("");
				
				//lets redirect the person onto a new page upon successful creation of account in 
				dispose();
				Home Khme= new Home();
				Khme.setVisible(true);

				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Exeception:"+e1.getMessage());
			}


				
			}
		});
		btnNewButton.setBounds(220, 290, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fname.setText("");
				Lname.setText("");
				TuserName.setText("");
				Temail.setText("");
				Tpas1.setText("");
				Tpas2.setText("");
				
			}
		});
		btnNewButton_1.setBounds(318, 315, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("USER NAME");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 136, 154, 21);
		panel.add(lblNewLabel_6);
		
		TuserName = new JTextField();
		TuserName.setBounds(182, 133, 154, 24);
		panel.add(TuserName);
		TuserName.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("RETURN TO LOG IN");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
			
				dispose(); //close SignUp Page and Proceed to login
				Login Loginhp= new Login();
				Loginhp.show();
			}
		});
		btnNewButton_2.setBounds(417, 315, 127, 23);
		panel.add(btnNewButton_2);
		
		Temail = new JTextField();
		Temail.setBounds(182, 180, 154, 25);
		panel.add(Temail);
		Temail.setColumns(10);
	}
	
	
	Connection con;
	PreparedStatement pst;
	private JTextField Temail;
	
	
	
	public void Connect() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/katikamu", "root","");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
