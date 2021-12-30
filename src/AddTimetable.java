import java.awt.BorderLayout;
import java.awt.EventQueue;
import connection.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddTimetable extends JFrame {

	private JPanel contentPane;
	private JTextField txt_filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTimetable frame = new AddTimetable();
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
	public AddTimetable() {
		Handler handle =new Handler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 0, 789, 423);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD TIMETABLE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(151, 11, 197, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SELECT CLASS");
		lblNewLabel_1.setBounds(10, 74, 81, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"P1", "P2", "P3", "P4", "P5", "P6", "P7"}));
		comboBox1.setBounds(128, 70, 53, 22);
		panel.add(comboBox1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home hme= new Home();
				hme.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(55, 331, 150, 38);
		panel.add(btnNewButton_1);
		
		JLabel Ibl_image = new JLabel("");
		Ibl_image.setIcon(null);
		Ibl_image.setBounds(226, 49, 540, 299);
		panel.add(Ibl_image);
		
		txt_filename = new JTextField();
		txt_filename.setBounds(321, 359, 394, 23);
		panel.add(txt_filename);
		txt_filename.setColumns(10);
		
		JButton btnNewButton = new JButton("BROWSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				txt_filename.setText(filename);
				Image getAbsolutePath = null;
				ImageIcon icon = new ImageIcon(filename);
				Image image = icon.getImage().getScaledInstance(Ibl_image.getWidth(), Ibl_image.getHeight(), Image.SCALE_SMOOTH);
				Ibl_image.setIcon(icon);
				
				
			}
		});
		btnNewButton.setBounds(55, 202, 150, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("ADD TIMETABLE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String image= txt_filename.getText();
				
				String  grade= comboBox1.getSelectedItem().toString();
				
				//image= image.replace("\\" , "\\\\"); 
				dbconn db = new dbconn();
				try { 
					Connection con = db.getConenction();
					
					handle.AddTimetable_meth(con, grade, image);
					
					JOptionPane.showMessageDialog(null,"Timetable Inserted");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Exception : " +e1.getMessage());
				}
				
				
			}
		});
		btnNewButton_2.setBounds(55, 269, 150, 31);
		panel.add(btnNewButton_2);
	}
}
