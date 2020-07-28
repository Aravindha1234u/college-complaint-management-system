package project;

import java.sql.SQLException;
class Student{
	String regno,email,phonenumber,depart,section,dob,year,firstname,lastname,gender,password,otp,credit;
}
public class Complain_System {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		//String username="root",password="Toor@123";
		//new login().checkcreds("Db.admin",username,password);
		new student_registerform();
	}
}
