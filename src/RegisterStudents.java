import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import connection.*;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterStudents extends JFrame {

	private JPanel contentPane;
	private JTextField SRfName;
	private JTextField SRLName;
	private JTextField SRAge;
	private JPasswordField SRpass;
	private JTextField SRegNo;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterStudents frame = new RegisterStudents();
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
	public RegisterStudents() {
		Handler handle = new Handler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 0, 0);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 0, 0, 0);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 0, 0);
		contentPane.add(label_4);
		
		JLabel lblNewLabel = new JLabel("REGISTER STUDENTS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 11, 205, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setBounds(129, 68, 60, 14);
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblFirstName);
		
		SRfName = new JTextField();
		SRfName.setBounds(199, 65, 205, 20);
		contentPane.add(SRfName);
		SRfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setBounds(134, 123, 55, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1);
		
		SRLName = new JTextField();
		SRLName.setBounds(199, 120, 205, 20);
		contentPane.add(SRLName);
		SRLName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(113, 164, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		SRAge = new JTextField();
		SRAge.setBounds(199, 161, 205, 20);
		contentPane.add(SRAge);
		SRAge.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CLASS");
		lblNewLabel_3.setBounds(158, 236, 31, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STUDENT PASSWORD");
		lblNewLabel_4.setBounds(84, 291, 105, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox SRgrade = new JComboBox();
		SRgrade.setModel(new DefaultComboBoxModel(new String[] {"P1", "P2", "P3", "P4", "P5", "P6", "P7"}));
		SRgrade.setBounds(199, 232, 65, 22);
		contentPane.add(SRgrade);
		
		JButton SRSubmit = new JButton("SUBMIT");
		SRSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 

				String fname = SRfName.getText().toString();
				String lname = SRLName.getText().toString();
				String age = SRAge.getText().toString();
				String RegNum = SRegNo.getText();
				String grade= SRgrade.getSelectedItem().toString();
				
				String password = SRpass.getText().toString();
				
				//String 
				dbconn db = new dbconn();
				try { 
					Connection con = db.getConenction();
					handle.create_student(con, fname, lname, RegNum, age, grade, password);
					JOptionPane.showMessageDialog(null,"Student Registerd");
					SRfName.setText("");
					SRLName.setText("");
					SRAge.setText("");
					SRegNo.setText("");
					SRgrade.setSelectedIndex(-1);
					SRpass.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Exception : " +e1.getMessage());
				}
				
				
			}
			
			
		});
		SRSubmit.setBounds(235, 332, 89, 23);
		contentPane.add(SRSubmit);
		
		
		JButton SRClear = new JButton("CLEAR");
		SRClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SRfName.setText("");
				SRLName.setText("");
				SRAge.setText("");
				SRgrade.setSelectedIndex(-1);
				SRpass.setText("");
				
				
			}
		});
		SRClear.setBounds(352, 332, 89, 23);
		contentPane.add(SRClear);
		
		JButton SRExit = new JButton("BACK");
		SRExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //go back to home
				Home hme= new Home();
				hme.show();
				
			}
		});
		SRExit.setBounds(470, 332, 89, 23);
		contentPane.add(SRExit);
		
		SRpass = new JPasswordField();
		SRpass.setBounds(199, 288, 205, 20);
		contentPane.add(SRpass);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRATION NUMBER");
		lblNewLabel_5.setBounds(59, 189, 130, 21);
		contentPane.add(lblNewLabel_5);
		
		SRegNo = new JTextField();
		SRegNo.setBounds(199, 192, 205, 20);
		contentPane.add(SRegNo);
		SRegNo.setColumns(10);
}
}
