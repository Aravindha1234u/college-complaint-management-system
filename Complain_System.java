package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
class Student extends Object{
	String regno,email,phonenumber,depart,section,dob,year,firstname,lastname,gender,password,otp,credit;
}
class Advisor extends Object{
	String adclass,email,password,phonenumber,department,otp,firstname,lastname,gender;
}
public class Complain_System {
	JFrame frame;
	JMenuBar menubar;
	JMenu admin,advisor,student;
	JMenuItem admin_login,student_register,student_complaint,advisor_register,advisor_login,advisor_update ;
	
	Complain_System()
	{
	 frame = new JFrame("COLLEGE COMPLAINT SYSTEM");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
     frame.setLayout(null);

     ImageIcon icon= new ImageIcon("C:\\Users\\Aravindha\\eclipse-workspace\\Bootcamp\\src\\project\\Logo.png");
     frame.setIconImage(icon.getImage());
     
      menubar =new JMenuBar();
      admin =new JMenu("Admin");
      admin.setMnemonic(KeyEvent.VK_A);
      admin.setForeground(Color.WHITE);
      admin.setFont(new Font("Yu Gothic", Font.BOLD, 21));
      
      advisor=new JMenu("Advisor");
      advisor.setMnemonic(KeyEvent.VK_T);
      advisor.setForeground(Color.WHITE);
      advisor.setFont(new Font("Yu Gothic", Font.BOLD, 21));
      
      student=new JMenu("Student");
      student.setMnemonic(KeyEvent.VK_S);
      student.setForeground(Color.WHITE);
      student.setFont(new Font("Yu Gothic", Font.BOLD, 21));
            
      admin_login=new JMenuItem("Login");
      admin_login.setFont(new Font("Yu Gothic", Font.BOLD, 19));   
      admin_login.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new admin_login();
    	  }
      });
      
      student_register=new JMenuItem("Register");
      student_register.setForeground(Color.BLUE);
      student_register.setFont(new Font("Yu Gothic", Font.BOLD,19 ));
      student_register.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    			new student_registerform();
    	  }
      });
      
      student_complaint=new JMenuItem("Login");
      student_complaint.setFont(new Font("Yu Gothic", Font.BOLD, 19));
      student_complaint.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  
    	  }
      });
      
      advisor_register=new JMenuItem("Register");
      advisor_register.setForeground(Color.BLUE);
      advisor_register.setFont(new Font("Yu Gothic", Font.BOLD, 19));
      advisor_register.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new advisor_registerform();
    	  }
      });
      
      advisor_login=new JMenuItem("Login");
      advisor_login.setFont(new Font("Yu Gothic", Font.BOLD, 19));
      advisor_login.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  
    	  }
      });
      
      advisor_update=new JMenuItem("Update");
      advisor_update.setFont(new Font("Yu Gothic", Font.BOLD, 19));
      advisor_update.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  
    	  }
      });
      
      
      admin.add(admin_login);
      advisor.add(advisor_register);
      advisor.add(advisor_login);
      advisor.add(advisor_update);
      student.add(student_register);
      student.add(student_complaint);
       
      menubar.add(admin);
      menubar.add(advisor);
      menubar.add(student);
       
      frame.setJMenuBar(menubar);
      menubar.setPreferredSize(new Dimension(50,50));
      menubar.setBackground(Color.BLACK);
         
      frame.setLayout(new BorderLayout());
  	  JLabel background=new JLabel(new ImageIcon("C:\\Users\\Aravindha\\eclipse-workspace\\Bootcamp\\src\\project\\bg.jpg"));
  	  frame.add(background);
     
  	 frame.setVisible(true);
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		new Complain_System();
	}
}
