import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ViewTimetable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTimetable frame = new ViewTimetable();
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
	public ViewTimetable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(5, 5, 594, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW TIMETABLE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 11, 186, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SELECT CLASS");
		lblNewLabel_1.setBounds(10, 53, 89, 23);
		panel.add(lblNewLabel_1);
		
		JComboBox grade = new JComboBox();
		grade.setModel(new DefaultComboBoxModel(new String[] {"P1", "P2", "P3", "P4", "P5", "P6", "P7"}));
		grade.setBounds(101, 53, 54, 22);
		panel.add(grade);
		
		JLabel TimetableView = new JLabel("");
		TimetableView.setIcon(null);
		TimetableView.setBounds(165, 36, 419, 222);
		panel.add(TimetableView);
		
		JButton btnNewButton_1 = new JButton("VIEW TIMETABLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username= "root";
					String password= "";
					String url = "jdbc:mysql://localhost/katikamu?useSSL=false";
					Connection con = DriverManager.getConnection(url,username,password);
					Statement st = con.createStatement();
					
					String grade1 = grade.getSelectedItem().toString();
					
				
					String sql ="SELECT `TimetableImage` FROM `timetable` WHERE `class`='"+grade1+"'";
					ResultSet rs= st.executeQuery(sql);
					
					while(rs.next()) {
						//lets attain timetable from the table and  
						//String Timetable = rs.addItem("TimetableImage");
						
						
					byte[] img = rs.getBytes("TimetableImage");
					ImageIcon image = new ImageIcon(img);
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(TimetableView.getHeight(),TimetableView.getWidth(),Image.SCALE_SMOOTH);
					ImageIcon newImage = new ImageIcon(myImg); 
					TimetableView.setIcon(newImage);
				
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
		btnNewButton_1.setBounds(10, 145, 117, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentHome Hms = new StudentHome();
				Hms.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 199, 117, 29);
		panel.add(btnNewButton);
	}
}

