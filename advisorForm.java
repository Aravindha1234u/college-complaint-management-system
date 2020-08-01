package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class advisorForm {

	private JFrame frame;
	private JTable table1;
	sqlconnect sql;
	Statement stmt;
  	ResultSet rs;
  	ArrayList<Integer> csno = new ArrayList<Integer>();
  	int length=0;
	public advisorForm(String email) {
		frame = new JFrame();
		Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize1.width, screenSize1.height);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("Complaint Panel", SwingConstants.CENTER);
		label1.setBounds(620, 20, 100, 14);
		frame.getContentPane().add(label1);
		
		
		JLabel label = new JLabel("Welcome!!!");
		label.setBounds(5, 5, 80, 20);
		frame.getContentPane().add(label);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 47,screenSize1.width-25,screenSize1.height-500); 
		frame.getContentPane().add(scrollPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
		
		table1 = new JTable();		
		table1.setModel(new DefaultTableModel(new Object[0][9],new String[] {"sno","Victim_name","regno","Department","Year","section","Place", "Time","reason","remark"})
				{
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, true, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];}
				});
		
		table1.setRowHeight(50);
		table1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table1.getColumnModel().getColumn(5).setPreferredWidth(100);
		table1.getColumnModel().getColumn(6).setPreferredWidth(100);
		table1.getColumnModel().getColumn(7).setPreferredWidth(100);
		table1.getColumnModel().getColumn(8).setPreferredWidth(100);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(620, 600, 80, 30);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new editform(csno.get(table1.getSelectedRow()));
			}
		});
		frame.getContentPane().add(btnNewButton,BorderLayout.SOUTH);
		
		
		try {
			   DefaultTableModel model = (DefaultTableModel)table1.getModel();
	    	   sql=new sqlconnect();
	    	   stmt=sql.con.createStatement();
	    	   rs = stmt.executeQuery("select * from Db.advisor where EMAIL='"+email+"'");
	    	   rs.next();
	    	   
	    	   rs=stmt.executeQuery("select * from Db.complain where section = '"+rs.getString("CLASS")+"' and department='"+rs.getString("DEPARTMENT")+"'");
	    	   while(rs.next())
	    	   {
	    		   int sno = rs.getInt("sno");
	    		   csno.add(sno);
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
	    		   table1.setModel(model); 	    		   
	    	   } 	   
	         }
	         catch(Exception e) {
	        	 JOptionPane.showMessageDialog(null, e.toString());		         
	         }
		scrollPane.setViewportView(table1);
		frame.setVisible(true);
	}
}
