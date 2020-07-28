package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class login {
	void checkcreds(String tableName,String username,String passwd) throws regexValidation {
		password p1=new password();
		try {
			sqlconnect sql=new sqlconnect();
			
			String query = "select * from "+tableName+" where username=?";
			
			//Parameterized Queries
			PreparedStatement p = sql.con.prepareStatement(query);
		    p.setString(1, username);

			try {
			//resultset for storing query
				ResultSet rs=p.executeQuery();
			
				//fetching query
				if(rs.next()) {
					String checkString=p1.regexString(passwd);
					if (rs.getString("password").equals(checkString)) {
						throw new regexValidation("Access Granted");
					}else if(checkString!="") {
						throw new regexValidation("Username or Password is incorrect");
					}
					
				}else {
					throw new regexValidation("Username Not Found");
				}
			}catch(SQLException e) {
				throw new regexValidation("Sql Injection");
			}
			p.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
