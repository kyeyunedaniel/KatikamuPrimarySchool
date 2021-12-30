import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewComplaints extends JFrame {

	private JPanel contentPane;
	private JTable tableVie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewComplaints frame = new ViewComplaints();
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
	public ViewComplaints() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(5, 5, 504, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT WITH COMPLAINTS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(129, 11, 217, 26);
		panel.add(lblNewLabel);
		
		tableVie = new JTable();
		tableVie.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"RegNo", "Subject", "Complaint"
			}
		));
		tableVie.setBounds(128, 48, 366, 257);
		panel.add(tableVie);
		
		JButton btnNewButton = new JButton("LIST STUDENTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String username= "root";
					String password= "";
					String url = "jdbc:mysql://localhost/katikamu?useSSL=false";
					Connection con = DriverManager.getConnection(url,username,password);
					Statement st = con.createStatement();
					String sql ="SELECT `RegNo`, `Subject`, `Complaint` FROM `complaints`";
					ResultSet rs= st.executeQuery(sql);
					
					while(rs.next()) {
						//`first_name``last_name``Registration_no``grade``ENG``MATH``SCIENCE``SST`
						//writing down the database fields 
						String RegNo1 = rs.getString("RegNo");
						String Subject1 = rs.getString("Subject");
						String Complaint1 = rs.getString("Complaint");
						
						
						//indicating order to insert data in Jtable
						//"RegNo", "Subject", "Complaint" these are the table fields
						String tbData[]= {RegNo1, Subject1, Complaint1};
						DefaultTableModel tbModel= (DefaultTableModel)tableVie.getModel();
						
						//add string array into jtable1
						
						tbModel.addRow(tbData);
				
				
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
		btnNewButton.setBounds(10, 147, 108, 26);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home hme2= new Home();
				hme2.setVisible(true);

				
			}
		});
		btnNewButton_1.setBounds(10, 197, 89, 23);
		panel.add(btnNewButton_1);
	}

}
