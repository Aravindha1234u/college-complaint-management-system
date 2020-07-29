package project;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;

public class complaintform {

	 JFrame frame;
	 JLabel victim_label,roll_label,dept_label,time_label,reason_label,place_label,section_label,year_label;
	 JTextField name_textfield,roll_textfield,timing_textfield;
	 JTextArea reason_textarea;
	 JButton  submit_button,clear_button;
	 
	 complaintform()
	 {
		frame = new JFrame();
		frame.setTitle("Complaint Form");
		frame.setBounds(100, 100, 801, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		victim_label = new JLabel("Suspect Name");
		victim_label .setFont(new Font("Yu Gothic", Font.BOLD, 21));
		victim_label .setBounds(98, 117, 157, 31);
		frame.getContentPane().add(victim_label );
		
	    roll_label = new JLabel("Roll Number");
	    roll_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
	    roll_label.setBounds(102, 191, 153, 31);
		frame.getContentPane().add(roll_label);
		
		dept_label = new JLabel("Department");
		dept_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		dept_label.setBounds(107, 255, 140, 31);
		frame.getContentPane().add(dept_label);
		
		time_label = new JLabel("Timing");
		time_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		time_label.setBounds(141, 452, 106, 31);
		frame.getContentPane().add(time_label);
		
		reason_label = new JLabel("Reason");
		reason_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		reason_label.setBounds(141, 510, 76, 31);
		frame.getContentPane().add(reason_label);
		
		place_label = new JLabel("Place");
		place_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		place_label.setBounds(141, 387, 76, 31);
		frame.getContentPane().add(place_label );
		
	    section_label = new JLabel("Section");
		section_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		section_label.setBounds(406, 330, 82, 31);
		frame.getContentPane().add(section_label );
		
		year_label = new JLabel("Year");
		year_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		year_label.setBounds(141, 327, 76, 31);
		frame.getContentPane().add(year_label );
			
		name_textfield = new JTextField();
		name_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		name_textfield.setBounds(297, 117, 277, 34);
		frame.getContentPane().add(name_textfield);
				
		roll_textfield = new JTextField();
		roll_textfield.setFont(new Font("Yu Gothic", Font.BOLD, 19));
		roll_textfield.setBounds(297, 189, 277, 34);
		frame.getContentPane().add(roll_textfield);
				
		SpinnerDateModel model=new SpinnerDateModel();
		model.setCalendarField(Calendar.HOUR);
		JSpinner startTime=new JSpinner();
		startTime.setModel(model);
		startTime.setBounds(297, 455, 277, 34);
		startTime.setEditor(new JSpinner.DateEditor(startTime,"yyyy-mm-dd"));
		JFormattedTextField tf= ((JSpinner.DefaultEditor)startTime.getEditor()).getTextField();
	   	tf.setEditable(false);
	   	frame.getContentPane().add(startTime);
	   	
		 JComboBox<String> dept_combobox= new JComboBox<String>();
		 dept_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 dept_combobox.setBounds(297, 258, 116, 25);
		 dept_combobox.addItem("CSE");
		 dept_combobox.addItem("IT");
		 dept_combobox.addItem("EEE");
		 dept_combobox.addItem("ECE");
		 dept_combobox.addItem("MECH");
		 dept_combobox.addItem("MCT");
		 dept_combobox.addItem("CIVIL");
		 frame.getContentPane().add(dept_combobox);
		
	     JComboBox<String> year_combobox= new JComboBox<String>();
		 year_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 year_combobox.setBounds(297, 333, 76, 25);
		 year_combobox.addItem("1");
		 year_combobox.addItem("2");
		 year_combobox.addItem("3");
		 year_combobox.addItem("4");
		 frame.getContentPane().add(year_combobox);
		
		 JComboBox<String> section_combobox= new JComboBox<String>();
		 section_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 section_combobox.setBounds(500, 330, 66, 25);
		 section_combobox.addItem("A");
		 section_combobox.addItem("B");
		 section_combobox.addItem("C");
		 frame.getContentPane().add(section_combobox);
		
		 JComboBox<String> place_combobox= new JComboBox<String>();
		 place_combobox.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		 place_combobox.setBounds(297, 390, 150, 25);
		 place_combobox.addItem("C1 Block");
		 place_combobox.addItem("C2 Block");
		 place_combobox.addItem("C3 Block");
		 place_combobox.addItem("C4 Block");
		 place_combobox.addItem("C5 Block");
		 place_combobox.addItem("Library");
		 place_combobox.addItem("0/100");
		 place_combobox.addItem("Mexitos");
		 place_combobox.addItem("Convention center");
		 place_combobox.addItem("Krishna Hall");
		 place_combobox.addItem("Food Court");
		 frame.getContentPane().add(place_combobox);
		
		reason_textarea = new JTextArea();
		reason_textarea.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		reason_textarea.setBounds(297, 507, 280, 116);	
		frame.getContentPane().add(reason_textarea);

	    submit_button = new JButton("Submit");
	    submit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			            try{             
			            	sqlconnect sql = new sqlconnect();
			                String str_victimname=name_textfield.getText();
                            String str_roll=roll_textfield.getText();
                            String str_reason=reason_textarea.getText();
                            String str_timing=tf.getText();
			                String str_dept=dept_combobox.getSelectedItem().toString();
			                String str_year=year_combobox.getSelectedItem().toString();
			                String str_section=section_combobox.getSelectedItem().toString();
			                String str_place=place_combobox.getSelectedItem().toString();

			                String query="insert into Db.complain values(?,?,?,?,?,?,?,?,?)";
			                PreparedStatement p = sql.con.prepareStatement(query);
			                p.setString(1,str_place);
			                p.setString(2,str_timing);
			                p.setString(3,str_dept);
			                p.setString(4,str_victimname);
			                p.setString(5,str_roll);
			                p.setString(6,str_reason);
			                p.setNull(7, java.sql.Types.VARCHAR);
			                p.setString(8, str_year);
			                p.setString(9, str_section);
			                p.executeUpdate();
			                JOptionPane.showMessageDialog(null, "Registration Success!");     
			              }
			            catch(Exception ex){
			                JOptionPane.showMessageDialog(null, ex.toString());
			            }
			        }
		});
	    submit_button .setFont(new Font("Yu Gothic", Font.BOLD, 21));
	    submit_button .setBounds(235, 654, 131, 34);
		frame.getContentPane().add(submit_button);
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cl) {
				
				name_textfield.setText("");
				roll_textfield.setText("");
				reason_textarea.setText("");
				
				JOptionPane.showMessageDialog(null, "Cleared Successfully");
			}
		});
		clear_button.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		clear_button.setBounds(406, 654, 131, 34);
		frame.getContentPane().add(clear_button );
			
		frame.setVisible(true);
	}

 }
