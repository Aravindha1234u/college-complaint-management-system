package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class loginForm {
	JFrame frame;
    JLabel email_label,password_lablel;
    JTextField email_textfield;
    JPasswordField password_pass;
    JButton submit_button,clear_button;

    loginForm() {
        frame = new JFrame();
        frame.setFont(new Font("Dialog", Font.BOLD, 12));
        frame.setTitle("LoginForm");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        email_label = new JLabel("Email-ID");
        email_label.setFont(new Font("Yu Gothic", Font.BOLD, 21));
        email_label.setBounds(70, 150, 150, 30);
        frame.getContentPane().add(email_label);

        password_lablel = new JLabel("Password");
        password_lablel.setFont(new Font("Yu Gothic", Font.BOLD, 21));
        password_lablel.setBounds(70, 250, 150, 30);
        frame.getContentPane().add(password_lablel );

        email_textfield = new JTextField();
        email_textfield.setBounds(200, 150, 300,30 );
        frame.getContentPane().add(email_textfield);

        password_pass = new JPasswordField();
        password_pass  .setFont(new Font("Yu Gothic", Font.BOLD, 20));
        password_pass  .setBounds(200, 250, 300, 30);
        frame.getContentPane().add(password_pass );

        submit_button = new JButton("Submit");
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                	String regexString = "^[0-9]{2}eu[A-Za-z]{2}[0-9]{3}@?skcet\\.ac\\.in$";
            		String dbName,Email=email_textfield.getText().toLowerCase();
            		
            		Pattern r = Pattern.compile(regexString);
            		Matcher m = r.matcher(Email);
            		Boolean bool = new Boolean(m.find());
            		@SuppressWarnings("deprecation")
					String Password=password_pass.getText();
            		if(bool==true) {
            			dbName="Db.student";
            		}else{
            			dbName="Db.advisor";
            		}

            		new login().checkcreds(dbName,Email,Password);
                }catch(regexValidation re) {
                	JOptionPane.showMessageDialog(null, re.exString);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        });
        submit_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
        submit_button.setBounds(150, 320, 112, 36);
        frame.getContentPane().add(submit_button);

        clear_button = new JButton("Clear");
        clear_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent cl) {

                email_textfield.setText("");
                password_pass .setText("");
                JOptionPane.showMessageDialog(null, "Form Cleared");
            }
        });
        clear_button.setFont(new Font("Yu Gothic", Font.BOLD, 22));
        clear_button.setBounds(350, 320, 112, 36);
        frame.getContentPane().add(clear_button);
        frame.setVisible(true);


    }
}
