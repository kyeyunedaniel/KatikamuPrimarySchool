

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.Handler;
import connection.dbconn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class RecordMarks extends JFrame {

	private JPanel contentPane;
	private JTextField F1RegNo;
	private JTextField Mmat1;
	private JTextField MEng;
	private JTextField Msst;
	private JTextField S1sci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordMarks frame = new RecordMarks();
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
	public RecordMarks() {
		Handler handle = new Handler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(10, 11, 658, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INPUT STUDENTS NAMES TO ADD MARKS OR CHANGE MARKS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 21, 482, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATION NUMBER");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 108, 136, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("ENGLISH");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(65, 139, 81, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SST");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(65, 179, 81, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MATH");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(65, 210, 81, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				

				String RegNo = F1RegNo.getText().toString();
				
				String RMMath = Mmat1.getText().toString();
				 	int RMMath1= Integer.parseInt(RMMath);
				 	
				String RMEnglish = MEng.getText().toString();
					int RMEnglish1= Integer.parseInt(RMMath);
					
				String RMSst= Msst.getText().toString();
					int RMSst1= Integer.parseInt(RMMath);
					
				String RMSci= S1sci.getText().toString();
					int RMSci1= Integer.parseInt(RMMath);
					
				
				
				
				//String 
				dbconn db = new dbconn();
				try { 
					Connection con = db.getConenction();
					handle.RecordMarks(con, RegNo, RMMath1, RMEnglish1, RMSst1, RMSci1);
					JOptionPane.showMessageDialog(null,"Student Data Entered");
					
					
					F1RegNo.setText("");
					Mmat1.setText("");
					MEng.setText("");
					Msst.setText("");
					S1sci.setText("");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Exception : " +e1.getMessage());
				}
				
			}
				
				
			}
		);
		btnNewButton.setBounds(166, 300, 127, 28);
		panel.add(btnNewButton);
		
		F1RegNo = new JTextField();
		F1RegNo.setBounds(166, 105, 221, 20);
		panel.add(F1RegNo);
		F1RegNo.setColumns(10);
		
		Mmat1 = new JTextField();
		Mmat1.setBounds(166, 207, 112, 20);
		panel.add(Mmat1);
		Mmat1.setColumns(10);
		
		MEng = new JTextField();
		MEng.setBounds(166, 136, 112, 20);
		panel.add(MEng);
		MEng.setColumns(10);
		
		Msst = new JTextField();
		Msst.setBounds(166, 176, 112, 20);
		panel.add(Msst);
		Msst.setColumns(10);
		
		JButton CLEAR = new JButton("CLEAR");
		CLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		CLEAR.setBounds(99, 339, 89, 23);
		panel.add(CLEAR);
		
		JButton btnbck = new JButton("BACK");
		btnbck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create an object the home class
				dispose();
				Home hme= new Home();
				hme.setVisible(true);
			}
		});
		btnbck.setBounds(220, 339, 89, 23);
		panel.add(btnbck);
		
		S1sci = new JTextField();
		S1sci.setBounds(166, 238, 112, 20);
		panel.add(S1sci);
		S1sci.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("SCIENCE");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(65, 241, 81, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(545, 339, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW CHANGES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					dispose();
					ViewStudents Ves= new ViewStudents();
					Ves.setVisible(true);

				
			}
		});
		btnNewButton_2.setBounds(344, 303, 112, 23);
		panel.add(btnNewButton_2);
	}
}
