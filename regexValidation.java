package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class regexValidation extends Throwable {
	String exString;
	public regexValidation() {
		exString="";
	}
	regexValidation(String exString){
		this.exString=exString;
	}
	public boolean regexvalid(Student student) throws regexValidation {
		
		//Firstname and Lastname
		String regexString = "([a-zA-Z]{3,30}\\s*)+";
		Pattern r = Pattern.compile(regexString);
		Matcher m = r.matcher(student.firstname+" "+student.lastname);
		Boolean bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Name Parameter");
		}
		
		//Register Number
		regexString = "([0-9]{2}EU[A-Za-z]{2}[0-9]{3})";
		r = Pattern.compile(regexString);
		m = r.matcher(student.regno);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Register Number Parameter");

		}
		
		//Email ID
		regexString = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		r = Pattern.compile(regexString);
		m = r.matcher(student.email);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Email ID Parameter");

		}
		
		//Date of Birth
		regexString = "^(0[1-9]|1[012])[- /.] (0[1-9]|[12][0-9]|3[01])[- /.] (19|20)\\d\\d$";
		r = Pattern.compile(regexString);
		m = r.matcher(student.dob);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Date of Birth \n Make Sure you have Entered in YYYY-MM-DD");

		}
		
		//Phonenumber
		regexString = "([9]{1})([234789]{1})([0-9]{8})";
		r = Pattern.compile(regexString);
		m = r.matcher(student.phonenumber);
		bool = new Boolean(m.find());
		if(bool==false) {
			//Throw Execution
			throw new regexValidation("Invalid Phone Parameter");

		}
		
		return true;
	}
}
