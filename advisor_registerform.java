package project;

import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;  

public class advisor_registerform {
	String str_gender="";
	advisor_registerform() {
		JFrame f= new JFrame("Advisorform");
	    f.setFont(new Font("Dialog", Font.BOLD, 12));
	    f.setTitle("Advisor Registration Form");
		f.setBounds(100, 100, 782, 778);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
	    Container c=f.getContentPane();   
	    c.setLayout(null);
	    
	    JLabel heading_lbl=new JLabel();
	    heading_lbl.setBounds(120,40,400,40);
	    heading_lbl.setText("ADVISOR REGISTRATION FORM"); 

	    JLabel l1=new JLabel("CLASS");
	    JLabel l2=new JLabel("First Name");  
	    JLabel l2_1=new JLabel("Last Name");  
	    JLabel l5=new JLabel("EMAIL");
	    JLabel l6=new JLabel("PASSWORD");
	    JLabel l7=new JLabel("RETYPE PSWD");
	    JLabel l4=new JLabel("PHONE NUMBER");
	    
	    String dept[]={"CSE","IT","ECE","EEE","MECH","MCT","CIVIL"};        
	    JComboBox <String> cb= new JComboBox<String>(dept);
	    JLabel l3=new JLabel("DEPARTMENT");
	    
	    JRadioButton male_radio,female_radio;
	    
	    ButtonGroup bg;
	    
	    male_radio = new JRadioButton("Male");
		male_radio .addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent m) {
				ItemSelectable itemselected=m.getItemSelectable();
		        if(itemselected==male_radio){
		                str_gender="Male";	
			}
		}});
		male_radio.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		male_radio.setBounds(400, 278, 100, 25);
		bg=new ButtonGroup();
		bg.add(male_radio);
		c.add(male_radio);
		
		female_radio = new JRadioButton("Female");
		female_radio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent f) {
				ItemSelectable itemselected=f.getItemSelectable();
		        if(itemselected==female_radio ){
		                str_gender="Female";	
			}}		
		});
		female_radio.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		female_radio.setBounds(500, 278, 100, 25);
		bg.add(female_radio);
		c.add(female_radio);
	    
	   // JLabel l6=new JLabel("DEPARTMENT");
	    
	    JTextField tf1=new JTextField(); 
	    JTextField tf2=new JTextField();
	    JTextField tf2_1=new JTextField();
	    JTextField tf4=new JTextField();
	    JTextField tf5=new JTextField();
	    
	    JPasswordField value = new JPasswordField(); 
	    JPasswordField value1 = new JPasswordField(); 
	    
	    JButton b=new JButton("Register");
	    b.setBounds(150,500,100, 40);
	    
	    l1.setBounds(50,100, 100,30);  
	    l2.setBounds(50,150, 50,30);
	    l2_1.setBounds(310,150, 100,30);
	    l3.setBounds(50,200, 100,30);
	    l4.setBounds(50,250, 100,30);
	    l5.setBounds(50,300, 100,30);
	    l6.setBounds(50,350, 100,30);
	    l7.setBounds(50,400, 100,30);
	    
	    tf1.setBounds(200,100, 200,30);  
	    tf2.setBounds(200,150, 100,30);
	    tf2_1.setBounds(380,150, 100,30);
	    cb.setBounds(200,200, 200,30); 
	    tf4.setBounds(200,250,200,30);
	    tf5.setBounds(200,300, 200,30);  
	    value.setBounds(200,350, 200,30);
	    value1.setBounds(200,400, 200,30);
	    
	    //cb.setBounds(150,350,200,30);
	    
	    c.add(heading_lbl); 
	    c.add(l1); c.add(l2);c.add(l3);c.add(l4);c.add(l5);c.add(l6);c.add(l7);c.add(b);c.add(l2_1);
	    c.add(tf1);c.add(tf2);c.add(cb);c.add(tf4);c.add(tf5);c.add(value);c.add(value1);c.add(tf2_1);
	    
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	    
	    //Register Process
	    b.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Advisor advisor = new Advisor();
					advisor.adclass=tf1.getText();
					advisor.firstname=tf2.getText();
					advisor.lastname=tf2_1.getText();
					advisor.email=tf5.getText();
					advisor.phonenumber=tf4.getText();
					advisor.department=cb.getSelectedItem().toString();
					advisor.gender=str_gender;
					
					//Regex Validation
                    regexValidation regex = new regexValidation();
                    regex.regexvalid((Advisor) advisor);
					
					if(value1.getText().toString().equals(value.getText().toString())==false) {
                    	throw new regexValidation("Password Did not Match");
                    }
					
                    password p1=new password();
                    String encrypedString = p1.regexString(new String(value.getText()));
                    if("Password Did not match the requirement" == encrypedString){
                    	throw new regexValidation(encrypedString);
                    }
                    advisor.password=encrypedString;
					
					register reg = new register();
					advisor.otp=reg.otp();
					new sendmail(advisor.email,advisor.otp);
					reg.appendRow(advisor);
					JOptionPane.showMessageDialog(null, "Registration Success!");
				} catch (regexValidation e1) {
					JOptionPane.showMessageDialog(null, e1.exString);
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				} 
				
			}
		});
	}
}
