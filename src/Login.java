import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_1;
	private JTextField TextUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(129, 61, 169, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(129, 149, 169, 29);
		contentPane.add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(129, 189, 169, 29);
		contentPane.add(passwordField_1);
		
		JLabel lblProvideDetailsTo = new JLabel("WELCOME TEACHER, PROVIDE DETAILS TO LOGIN IN ");
		lblProvideDetailsTo.setBounds(10, 11, 442, 39);
		contentPane.add(lblProvideDetailsTo);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					//we are going to open the connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/katikamu?useSSL=false","root","");
					
					String Uname=TextUsername.getText();
					String UPass=passwordField_1.getText();
					
					Statement stm = con.createStatement();
					
					//String sql = "select * from user where username ="+Uname+"' and Password
					
					String sql = "select * from user where user_name ='"+Uname+"' and password='"+UPass+"'";
					
					ResultSet rs =stm.executeQuery(sql);
					
					//if username and password are true, close the page and then go to homepage
					if(rs.next()) {
						
						dispose(); //close login page
						Home hp= new Home();
						hp.show();

						
					}else {
						//if username and password is wrong show
						JOptionPane.showMessageDialog(null, "username or password is wrong");
						TextUsername.setText("");
						passwordField_1.setText("");
						
					}
					
						
					 
				con.close();
					
					
				}
				catch(Exception ex){
					
					System.out.println(ex.getMessage());
					
				}
			}
		});
		btnNewButton.setBounds(195, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		TextUsername = new JTextField();
		TextUsername.setBounds(129, 101, 169, 29);
		contentPane.add(TextUsername);
		TextUsername.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creating an object of the signup page so that when the user clicks on sign up button in login page, it opens the signup page.
				dispose();
				SignUp u = new SignUp();
				u.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(405, 244, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adding fuctionality to clear button
				// the button will remove all text thats been  input
				TextUsername.setText("");
				passwordField_1.setText("");
			}
		});
		btnNewButton_2.setBounds(299, 244, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXIT TO MAIN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FirstHome Fhme= new FirstHome();
				Fhme.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(363, 287, 131, 23);
		contentPane.add(btnNewButton_3);
	}
}
