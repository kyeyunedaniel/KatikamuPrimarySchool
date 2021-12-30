import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 11, 345, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(54, 73, 222, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER STUDENTS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close SignUp Page and Proceed to login
				RegisterStudents Reghp= new RegisterStudents();
				Reghp.show();
			}
		});
		btnNewButton_1.setBounds(54, 105, 222, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RECORD MARKS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecordMarks danie= new RecordMarks();
				danie.setVisible(true);
			}
			
		});
		btnNewButton_2.setBounds(54, 136, 222, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW STUDENTS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewStudents vstu = new ViewStudents();
				vstu.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(54, 168, 222, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PUBLISH TIMETABLE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddTimetable Att= new AddTimetable();
				Att.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(54, 199, 222, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("EDIT MARKS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecordMarks rks=new RecordMarks();
				rks.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(54, 231, 222, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("VIEW COMPLAINTS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewComplaints VAtt= new ViewComplaints();
				VAtt.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(54, 262, 222, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("LOGOUT");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close SignUp Page and Proceed to login
				Login Loginhpp = new Login();
				Loginhpp.show();
			}
		});
		btnNewButton_7.setBounds(100, 324, 73, 23);
		contentPane.add(btnNewButton_7);
	}
	

}
