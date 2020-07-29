package forms;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class  viewform  {

   JFrame frame;
	 
   viewform(){
				
	       JFrame frame=new JFrame();
	       frame.setBounds(100,100, 600, 600);  
	       frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	       
	       JTable table=new JTable();
	       DefaultTableModel model = new DefaultTableModel(new String[]{"VICTIM_NAME", "ROLLNUMBER", "DEPARTMENT","YEAR","SECTION","PLACE","TIMING","REASON","OPTIONS"}, 0);	            
	       table.setRowHeight(80);	       
	       JScrollPane scroll = new JScrollPane(table);
  	       scroll.setWheelScrollingEnabled(true);
	       frame.getContentPane().add(scroll); 
	       
	       try {
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbc","pwd");
	    	   Statement stmt=con.createStatement();
	    	   ResultSet rs=stmt.executeQuery("select * from jdbc.complaint");
	    	   while(rs.next())
	    	   {
	    		   String victim_name = rs.getString("VICTIM_NAME")  ;
	    		   String rollnumber = rs.getString("ROLLNUMBER")  ;
	    		   String department =rs.getString("DEPARTMENT") ;
	    		   String year = rs.getString("YEAR") ;
	    		   String section = rs.getString("SECTION") ; 
	    		   String place = rs.getString("PLACE") ;
	    		   String timing = rs.getString("TIMIMG") ;
	    		   String reason = rs.getString("REASON") ;   		  
	    		   model.addRow(new Object[]{victim_name,rollnumber,department,year,section,place,timing,reason,"      "+"EDIT"+"      "+"DELETE",}); 	    		   
	    		   table.setModel(model); 	    		   
	    	   } 	   
	         }
	         catch(Exception e) {
	        	 JOptionPane.showMessageDialog(null, e.toString());	
	         
	         }	       
	       	frame.setVisible(true);	
	}
      
public static void main(String[] args)
   {
	   new viewform();
   }
}


