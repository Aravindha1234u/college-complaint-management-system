package project;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
public class admin_login
{
    public admin_login() {
    	JFrame f= new JFrame("Adminform");
	    f.setFont(new Font("Dialog", Font.BOLD, 12));
	    f.setTitle("Admin Login");
		f.setBounds(100, 100, 782, 778);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
        Container c=f.getContentPane();   
        c.setLayout(null);
        
        JLabel heading_lbl=new JLabel();
        heading_lbl.setBounds(120,40,400,40);
        heading_lbl.setText("Admin Login"); 
        
        JLabel l1=new JLabel("USERNAME");
        JLabel l2=new JLabel("PASSWORD");
        
        JTextField tf1=new JTextField(); 
        JPasswordField value = new JPasswordField(); 
        
        JButton b=new JButton("Login");
        b.setBounds(150,500,100, 40);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String username=tf1.getText(),password=value.getText();
				try {
					new login().checkcreds("Db.admin",username,password);
				} catch (regexValidation e1) {
					JOptionPane.showMessageDialog(null, e1.exString);
				}
				
			}
		});
        
        l1.setBounds(50,100, 100,30);  
        l2.setBounds(50,150, 100,30);
        
        tf1.setBounds(200,100, 200,30);  
        value.setBounds(200,150, 200,30); 
        c.add(heading_lbl); 
        c.add(l1); c.add(l2);c.add(b);
        c.add(tf1);c.add(value);
        f.setSize(700,700);  
        f.setLayout(null);  
        f.setVisible(true);  
	}
}

