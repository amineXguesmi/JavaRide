package projet_java;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class inscription extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3; 
	private JLabel lblNewLabel_2_4; 
	private JLabel lblNewLabel_2_5; 
	private JLabel lblNewLabel_2_6; 
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public boolean date(String s) {
		String regex="(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		return(matcher.matches());
	}
	public boolean verife(String s) {
		int n=0;
		for(int i=0;i<s.length();i++) {
			char x=s.charAt(i);
			if((((x>='a')&&(x<='z'))||((x>='A')&&(x<='Z')))||(x==' '))
				n=0;
			else return(false);
		}
		return(true);
	}
	public boolean verifeCIN(String s) {
		int n=0;
		if(s.length()!=8) return(false);
		for(int i=0;i<s.length();i++) {
			char x=s.charAt(i);
			if((((x>='0')&&(x<='9'))))
				n=0;
			else return(false);
		}
		return(true);
	}
	public inscription() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("create a new account ");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(10, 10, 584, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(49, 120, 134, 40);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("last name :");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(49, 186, 134, 40);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dob :");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(49, 260, 134, 40);
		add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(191, 110, 330, 58);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(191, 180, 330, 58);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(191, 250, 330, 58);
		add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CIN :");
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1.setBounds(49, 328, 134, 40);
		add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(191, 318, 330, 58);
		add(textField_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Password :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1.setBounds(49, 396, 141, 40);
		add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("rw-Password :");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1_1.setBounds(49, 464, 141, 40);
		add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("location :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1_1_1.setBounds(49, 536, 141, 40);
		add(lblNewLabel_1_2_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_6.setColumns(10);
		textField_6.setBounds(191, 526, 330, 58);
		add(textField_6);
		
		btnNewButton = new JButton("create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textField.getText();
				String lname=textField_1.getText();
				String dob=textField_2.getText();
				String cin=textField_3.getText();
				String location=textField_6.getText();
				String mdp1=passwordField.getText();
				String mdp2=passwordField_1.getText();
				String v="";
				String t="(:";
				String c="):";
				
				if((fname.equals(v))||(!verife(fname)))
				{ lblNewLabel_2.setText(c);
				lblNewLabel_2.setForeground(Color.red);					
				}
				else {
					lblNewLabel_2.setText(t);
					lblNewLabel_2.setForeground(Color.green);
				}
				if((lname.equals(v))||(!verife(lname)))
				{	lblNewLabel_2_1.setText(c);
				lblNewLabel_2_1.setForeground(Color.red);				
				}
				else {lblNewLabel_2_1.setText(t);
				lblNewLabel_2_1.setForeground(Color.green);			
				}
				if((dob.equals(v))||(!date(dob)))
				{	lblNewLabel_2_2.setText(c);
				lblNewLabel_2_2.setForeground(Color.red);				
				}
				else {lblNewLabel_2_2.setText(t);
				lblNewLabel_2_2.setForeground(Color.green);			
				}
				if((cin.equals(v))||(!verifeCIN(cin)))
				{	lblNewLabel_2_3.setText(c);
				lblNewLabel_2_3.setForeground(Color.red);				
				}
				else {lblNewLabel_2_3.setText(t);
				lblNewLabel_2_3.setForeground(Color.green);			
				}
				if(location.equals(v))
				{	lblNewLabel_2_6.setText(c);
				lblNewLabel_2_6.setForeground(Color.red);				
				}
				else {lblNewLabel_2_6.setText(t);
				lblNewLabel_2_6.setForeground(Color.green);			
				}
				if(mdp1.equals(v))
				{	lblNewLabel_2_4.setText(c);
				lblNewLabel_2_4.setForeground(Color.red);				
				}
				else {lblNewLabel_2_4.setText(t);
				lblNewLabel_2_4.setForeground(Color.green);			
				}
				if((mdp2.equals(v))||!(mdp2.equals(mdp1)))
				{	lblNewLabel_2_5.setText(c);
				lblNewLabel_2_5.setForeground(Color.red);				
				}
				else {lblNewLabel_2_5.setText(t);
				lblNewLabel_2_5.setForeground(Color.green);			
				}
				
					if(((lblNewLabel_2_5.getText()).equals(t))&&((lblNewLabel_2_6.getText()).equals(t))&&((lblNewLabel_2_4.getText()).equals(t))&&((lblNewLabel_2_3.getText()).equals(t))&&((lblNewLabel_2_1.getText()).equals(t))&&((lblNewLabel_2_2.getText()).equals(t))&&((lblNewLabel_2.getText()).equals(t)))
					{
						try {
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					String add=lname+"."+fname+"@user.com";
					String name=fname+"_"+lname;
					PreparedStatement ps= connection.prepareStatement("insert into client(cin,fname,address,dob,location,mdp) values(?,?,?,?,?,?)");
					ps.setString(1, cin);
					ps.setString(2, name);
					ps.setString(3, add);
					ps.setString(4, dob);
					ps.setString(5, location);
					ps.setString(6, mdp1);
					 Boolean a = ps.execute();
					 if (a == true) {
					 JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
					 } else {
					 JOptionPane.showMessageDialog(btnNewButton,
					 "Welcome, " + fname +lname + "  Your account is sucessfully created \n votre address est "+add+" et mdp est "+mdp1+" :)");
					 }
					connection.close();
					page_entre.frame_main.dispose();
					page_entre.frame_main=page_entre.entre();
					page_entre.frame_main.show();
					 } catch (Exception exception) {
					 exception.printStackTrace();
					 }}
				else {
					 JOptionPane.showMessageDialog(null,"il y'a un champ invalide");

				}
				
			}
		});
		btnNewButton.setForeground(new Color(95, 158, 160));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnNewButton.setBounds(210, 619, 291, 46);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_entre.frame_main.dispose();
				page_entre.frame_main=page_entre.entre();
				page_entre.frame_main.show();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(10, 661, 79, 29);
		add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 386, 330, 58);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(191, 458, 330, 58);
		add(passwordField_1);
		
		lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_2.setBounds(531, 260, 45, 29);
		add(lblNewLabel_2_2);
		
		lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_3.setBounds(531, 328, 45, 29);
		add(lblNewLabel_2_3);
		
		lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_4.setBounds(531, 396, 45, 29);
		add(lblNewLabel_2_4);
		
		lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_5.setBounds(531, 464, 45, 29);
		add(lblNewLabel_2_5);
		
		lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_6.setBounds(531, 536, 45, 29);
		add(lblNewLabel_2_6);
		
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(531, 186, 45, 29);
		add(lblNewLabel_2_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(531, 120, 45, 29);
		add(lblNewLabel_2);
        
	}
	
	public static JFrame inscrit() {
		JFrame frame = new JFrame("inscription");
        frame.setContentPane(new inscription());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,750);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return(frame);
	     }
}
