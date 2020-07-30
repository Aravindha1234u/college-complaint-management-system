package project;

import java.sql.SQLException;

class Student extends Object{
	String regno,email,phonenumber,depart,section,dob,year,firstname,lastname,gender,password,otp,credit;
}
class Advisor extends Object{
	String adclass,email,password,phonenumber,department,otp,firstname,lastname,gender;
}
public class Complain_System {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		//new frontPage();
		//new complaintform();
		new viewform();
	}
}
