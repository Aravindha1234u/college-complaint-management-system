package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class  viewform  {

   JFrame frame;
   JButton edit_button,delete_button;
   JTable table;
   JLabel view_label;
   JScrollPane scroll;
   DefaultTableModel model;
   
	 
   viewform(){
				
		   frame=new JFrame("View Complaints");
	       frame.setSize(1180,800);  
	       frame.setLayout(null);
	       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	       
	       view_label=new JLabel(" List Of Complaints",JLabel.CENTER);
	       view_label.setBounds(10, 10, 250, 50);
	       view_label.setFont(new Font("Yu Gothic", Font.BOLD, 20));
	       frame.getContentPane().add(view_label);
	      
	       table=new JTable();
	       model = new DefaultTableModel(new String[]{"SNO","VICTIM_NAME", "ROLLNUMBER", "DEPARTMENT","YEAR","SECTION","PLACE","TIMING","REASON","REMARKS"}, 0);	            
	       table.setRowHeight(60);	
	
	       scroll = new JScrollPane(table);
	       scroll.setBounds(50, 70, 1000, 550);
		       scroll.setWheelScrollingEnabled(true);
	       frame.getContentPane().add(scroll); 
	       
	       edit_button=new JButton("Edit");
	       edit_button.setBounds(50, 650, 80, 20);
	       edit_button.setFont(new Font("Yu Gothic", Font.BOLD, 12));
	       frame.getContentPane().add(edit_button);
	       edit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == edit_button) {
		    		  int i = table.getSelectedRow();
		              if(i >= 0){
		            	  new editform(i+1);
		    	     }
		    	  }
			}
	       });
	       
	       delete_button=new JButton("Delete");
	       delete_button.setBounds(980, 650, 80, 20);
	       delete_button.setFont(new Font("Yu Gothic", Font.BOLD, 12));
	       frame.getContentPane().add(delete_button); 
	       delete_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == delete_button) {
		    		  int i = table.getSelectedRow();
		                  if(i >= 0){
		            	  
		    //         	  new deleteform();
		            	  
		    	       }
		    	  }
			}
		}); 
	       
	       try {
	    	   sqlconnect sql=new sqlconnect();
	    	   Statement stmt=sql.con.createStatement();
	    	   ResultSet rs=stmt.executeQuery("select * from Db.complain");
	    	   while(rs.next())
	    	   {
	    		   int sno = rs.getInt("sno");
	    		   String victim_name = rs.getString("VICTIM_NAME")  ;
	    		   String rollnumber = rs.getString("REGNO")  ;
	    		   String department =rs.getString("DEPARTMENT") ;
	    		   String year = rs.getString("YEAR") ;
	    		   String section = rs.getString("SECTION") ; 
	    		   String place = rs.getString("PLACE") ;
	    		   Date timing = rs.getDate("TIME") ;
	    		   String reason = rs.getString("REASON") ;   
	    		   String remarks = rs.getString("REMARK") ; 
	    		   
	    		   model.addRow(new Object[]{sno,victim_name,rollnumber,department,year,section,place,timing,reason,remarks});  	    		   
	    		   table.setModel(model); 	    		   
	    	   } 	   
	         }
	         catch(Exception e) {
	        	 JOptionPane.showMessageDialog(null, e.toString());	
	         
	         }	       
	       	frame.setVisible(true);	
	}
      
}



