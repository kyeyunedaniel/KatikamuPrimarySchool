

import java.awt.BorderLayout;
import java.awt.EventQueue;
import connection.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class StudentComplaints extends JFrame {

	private JPanel contentPane;
	private JTextField RegF;
	private JTextField TextComplaint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentComplaints frame = new StudentComplaints();
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
	public StudentComplaints() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(5, 5, 424, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION NUMBER");
		lblNewLabel.setBounds(10, 54, 127, 22);
		panel.add(lblNewLabel);
		
		RegF = new JTextField();
		RegF.setBounds(176, 55, 110, 20);
		panel.add(RegF);
		RegF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SUBMIT A COMPLAINT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(40, 11, 333, 32);
		panel.add(lblNewLabel_1);
		
		JComboBox ComSub = new JComboBox();
		ComSub.setModel(new DefaultComboBoxModel(new String[] {"SST", "SCIENCE", "MATH ", "ENGLISH"}));
		ComSub.setBounds(176, 108, 78, 22);
		panel.add(ComSub);
		
		JLabel lblNewLabel_2 = new JLabel("SELECT SUBJECT");
		lblNewLabel_2.setBounds(55, 103, 82, 32);
		panel.add(lblNewLabel_2);
		
		JLabel txtfd = new JLabel("COMPLAINT");
		txtfd.setBounds(65, 146, 72, 14);
		panel.add(txtfd);
		
		TextComplaint = new JTextField();
		TextComplaint.setBounds(176, 141, 165, 50);
		panel.add(TextComplaint);
		TextComplaint.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT COMPLAINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RegNum = RegF.getText().toString();
				String TComp= TextComplaint.getText().toString();
				String Sub = ComSub.getSelectedItem().toString();
				Handler hand = new Handler();
				dbconn db = new dbconn();
				try { 
					Connection con = db.getConenction();
					
					hand.Submit_Complaint(con, RegNum,TComp,Sub);
					JOptionPane.showMessageDialog(null,"Complaint Submitted");
					RegF.setText("");
					TextComplaint.setText("");
					ComSub.setSelectedIndex(-1);

					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Exception : " +e1.getMessage());
				}
				
			}
			
			
		});
		btnNewButton.setBounds(65, 202, 149, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentHome Shme2= new StudentHome();
				Shme2.setVisible(true);

			}
			
		});
		btnNewButton_1.setBounds(325, 230, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegF.setText("");
				TextComplaint.setText("");
				ComSub.setSelectedIndex(-1);
				
				
			}
		});
		btnNewButton_2.setBounds(204, 230, 89, 23);
		panel.add(btnNewButton_2);
	}
}
