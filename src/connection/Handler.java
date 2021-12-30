package connection;
import java.sql.*;

public class Handler {
public void create_student(Connection con, String fname, String lname, String RegNo, String age, String lgrade, String password) throws Exception{

	String sql = "INSERT INTO students (first_name, last_name, Registration_no, age, grade, password) VALUES (?,?,?,?,?,?)";
	PreparedStatement pmt = con.prepareStatement(sql);
	pmt.setString(1, fname);
	pmt.setString(2, lname); 
	pmt.setString(3, RegNo);
	
	pmt.setString(4, age);
	pmt.setString(5, lgrade);
	pmt.setString(6, password);
	pmt.execute();
	
	}

 


public void Teacher_SignUp(Connection con, String TFname, String TLname, String UserName, String TEmail, String TPassw) throws Exception {
	String sqx ="INSERT INTO user(first_name, last_name, user_name, password, email_id) VALUES (?,?,?,?,?)";
	PreparedStatement pmt= con.prepareStatement(sqx);
	pmt.setString(1, TFname);
	pmt.setString(2, TLname);
	pmt.setString(3, UserName);
	pmt.setString(4, TPassw);
	pmt.setString(5, TEmail);
	pmt.execute();
		
}

public void RecordMarks(Connection con, String RegNum1 , int eng , int mat, int sci, int sst) throws Exception {
	//lets first check if the input RegNo is in the database
//	String sql2="SELECT * FROM students WHERE Registration_no='"+RegNum1+"'";
//	PreparedStatement pmt= con.prepareStatement(sql2);
//	System.out.println("you get the result");
	
	String sql3 = "UPDATE students SET ENG= ?, MATH= ?, SCIENCE=?, SST=? WHERE Registration_no = ?";
	PreparedStatement pmt = con.prepareStatement(sql3);
	
	pmt.setLong(1, eng);
	pmt.setLong(2, mat);
	pmt.setLong(3, sci);
	pmt.setLong(4, sst);
	pmt.setString(5, RegNum1);
	pmt.execute();
		
		
}
public void Submit_Complaint(Connection con, String TRegNum, String TTComp, String TSub ) {
	

	
	String sqx2 ="INSERT INTO complaints(RegNo, Subject, Complaint) VALUES (?,?,?)";
	PreparedStatement pmt2;
	try {
		pmt2 = con.prepareStatement(sqx2);
		pmt2.setString(1, TRegNum);
		pmt2.setString(2, TSub);
		pmt2.setString(3, TTComp);
		pmt2.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}

public void AddTimetable_meth(Connection con, String Tclass, String TimeTab) {
	

	//INSERT INTO `timetable`(`ID`, `class`, `TimetableImage`) VALUES ([value-1],[value-2],[value-3])
	String sqx5 ="INSERT INTO timetable(class, TimetableImage) VALUES (?,?)";
	PreparedStatement pmt5;
	try {
		pmt5 = con.prepareStatement(sqx5);
		pmt5.setString(1, Tclass);
		pmt5.setString(2, TimeTab);
		
		pmt5.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}

	

}
