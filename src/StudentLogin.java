import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField TextRegNo;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(5, 5, 424, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME STUDENT PLEASE LOGIN");
		lblNewLabel.setBounds(81, 11, 215, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATION NUMBER");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 61, 137, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 115, 109, 14);
		panel.add(lblNewLabel_2);
		
		TextRegNo = new JTextField();
		TextRegNo.setBounds(157, 58, 215, 20);
		panel.add(TextRegNo);
		TextRegNo.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(157, 112, 215, 20);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("LOG IN ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
									
					//we are going to open the connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/katikamu?useSSL=false","root","");
					
					String RegNo5=TextRegNo.getText();
					String UPass5=passwordField_1.getText();
					
					Statement stm = con.createStatement();
					
					
					//Signing in student using RegNo and password
					//Checking database if the regNumber is that 
					
					String sql = "select * from students where Registration_no ='"+RegNo5+"' and password='"+UPass5+"'";
					
					ResultSet rs =stm.executeQuery(sql);
					
					//if username and password are true, close the page and then go to homepage
					if(rs.next()) {
						
						dispose(); //close login page
						StudentHome hp= new StudentHome();
						
						hp.show();
						
					}else {
						//if username and password is wrong show
						JOptionPane.showMessageDialog(null, "username or password is wrong");
						TextRegNo.setText("");
						passwordField_1.setText("");
						
					}
					
						
					 
				con.close();
					
					
				}
				catch(Exception ex){
					
					System.out.println(ex.getMessage());
					
				}
			}
				
			
			
		});
		btnNewButton.setBounds(157, 153, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBounds(298, 153, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT  TO  MAIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FirstHome Fhme1= new FirstHome();
				Fhme1.setVisible(true);

				
			}
		});
		btnNewButton_2.setBounds(209, 201, 129, 33);
		panel.add(btnNewButton_2);
	}
}
