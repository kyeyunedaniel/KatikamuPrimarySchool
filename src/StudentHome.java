import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
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
	public StudentHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(5, 5, 547, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("VIEW MARKS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewMarks Vhme= new ViewMarks();
				Vhme.setVisible(true);

			}
		});
		btnNewButton.setBounds(109, 32, 159, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FILE COMPLAIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentComplaints Stc =new StudentComplaints();
				Stc.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(109, 84, 159, 41);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW TIMETABLE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cLOSING THE OLD PAGE AND REDIRECTING TO A NEW PAGE!!
				
				dispose();
				ViewTimetable Stc =new ViewTimetable();
				Stc.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(109, 136, 159, 46);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOG OUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FirstHome Fhme3= new FirstHome();
				Fhme3.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(109, 193, 102, 41);
		panel.add(btnNewButton_3);
	}

}
