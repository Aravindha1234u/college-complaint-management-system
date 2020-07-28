package project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.*;


public class register {
	public String otp() {
		 Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < 6){
            sb.append(Integer.toHexString(r.nextInt()).toUpperCase());
        }
		return sb.toString().substring(0, 6);
	}
	public int appendRow(Student student)  {
		try {
			sqlconnect sql = new sqlconnect();
			String query = "insert into Db.student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//Parameterized Queries
			PreparedStatement p = sql.con.prepareStatement(query);
			
		    p.setString(1, student.regno);
		    p.setString(2, student.email);
		    p.setString(3, student.phonenumber);
		    p.setString(4, student.depart);
		    p.setString(5, student.section);
		    p.setDate(6, Date.valueOf(student.dob) );
		    p.setString(7, student.year);
		    p.setString(8, student.firstname);
		    p.setString(9, student.lastname);
		    p.setString(10, student.gender);
		    p.setString(11, student.password);
		    p.setString(12, "10");
		    p.setString(13, student.otp);
		    return p.executeUpdate(); 
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
