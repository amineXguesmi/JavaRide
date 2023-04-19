package projet_java;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class forget_pass extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public forget_pass() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("name :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(29, 70, 134, 40);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("address :");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(29, 148, 134, 40);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CIN :");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(29, 225, 134, 40);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DOB:");
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_3.setBounds(29, 302, 134, 40);
		add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(140, 58, 330, 58);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(140, 138, 330, 58);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(140, 215, 330, 58);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(140, 295, 330, 58);
		add(textField_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel.setBounds(29, 456, 441, 51);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_entre.frame_main.dispose();
				page_entre.frame_main=page_entre.entre();
				page_entre.frame_main.show();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(10, 570, 79, 29);
		add(btnNewButton_1);
		
		JButton btnGetPassword = new JButton("get password");
		btnGetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String add=textField_1.getText();
				String cin=textField_2.getText();
				String dob=textField_3.getText();
				String v="";
				try {
					if((!add.equals(v))&&(!name.equals(v))&&(!cin.equals(v))&&(!dob.equals(v)))
					{
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE address = '"+add+"' and cin = '"+cin+"' and fname = '"+name +"' and dob = '"+dob +"'");
					 if(rs.next()) {
						 String mdp=rs.getString("mdp");
						 JOptionPane.showMessageDialog(btnNewButton_1,
								 "votre Password est "+ mdp );
					 
						 page_entre.frame_main.dispose();
							page_entre.frame_main=page_entre.entre();
							page_entre.frame_main.show();
					 }
					 else{
						 JOptionPane.showMessageDialog(btnNewButton_1,
								 "il n'existe pas un account avec cette addresse et cin");
					 }
					connection.close();}
					 } catch (Exception exception) {
					 exception.printStackTrace();
					 }
				
				
			}}
		);
		btnGetPassword.setForeground(new Color(95, 158, 160));
		btnGetPassword.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnGetPassword.setBackground(Color.CYAN);
		btnGetPassword.setBounds(161, 382, 291, 46);
		add(btnGetPassword);

	}
	public static JFrame forget() {
		JFrame frame = new JFrame("forget password");
        frame.setContentPane(new forget_pass());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,650);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return(frame);
	     }
}
