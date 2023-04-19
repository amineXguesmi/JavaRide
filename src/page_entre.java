package projet_java;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
public class page_entre extends JPanel {
	private JTextField textField;
	public static JFrame frame_main;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	public static String test;
	/**
	 * Create the panel.
	 */
	public page_entre() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome dear customer");
		lblNewLabel.setForeground(new Color(0, 0, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(0, 37, 601, 54);
		add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("Address :");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(40, 146, 141, 62);
		add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(40, 228, 119, 62);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField.setBounds(177, 153, 330, 58);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		passwordField.setBackground(SystemColor.inactiveCaption);
		passwordField.setBounds(177, 236, 330, 54);
		add(passwordField);
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add=textField.getText();
				String mdp=passwordField.getText();
				String v="";
				try {
					if((!add.equals(v))&&(!mdp.equals(v)))
					{
						if((!add.equals("admin"))&&(!mdp.equals("admin"))) {
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE address = '"+add+"' and mdp = '"+mdp +"'");
					 if(rs.next()) {
						test=rs.getString("cin");
						 page_entre.frame_main.dispose();
							page_entre.frame_main=page_user.entre();
							page_entre.frame_main.show();
					 }
					 else{
						 JOptionPane.showMessageDialog(btnNewButton,
								 "il n'existe pas un account avec cette addresse et password");
					 }
					connection.close();}
					else {
						page_entre.frame_main.dispose();
						page_entre.frame_main=admin_page.entre();
						page_entre.frame_main.show();
					}}
					 } catch (Exception exception) {
					 exception.printStackTrace();
					 }
			}
		});
		btnNewButton.setBackground(SystemColor.windowBorder);
		btnNewButton.setForeground(new Color(51, 0, 51));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnNewButton.setBounds(200, 325, 288, 37);
		add(btnNewButton);
		
		JButton btnPassword = new JButton("forgot password ?");
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_main.dispose();
				frame_main=forget_pass.forget();
				frame_main.show();	
			}
		});
		btnPassword.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnPassword.setBackground(SystemColor.windowBorder);
		btnPassword.setForeground(new Color(51, 0, 51));
		btnPassword.setBounds(200, 372, 288, 35);
		add(btnPassword);
		
		JLabel lblNewLabel_3 = new JLabel("create a new account :");
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_3.setBounds(0, 447, 288, 37);
		add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("create ");
		btnNewButton_1.setForeground(new Color(51, 0, 51));
		btnNewButton_1.setBackground(SystemColor.scrollbar);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_main.dispose();
				frame_main=inscription.inscrit();
				frame_main.show();				
				}
		});
		btnNewButton_1.setBounds(271, 448, 167, 33);
		add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\semah\\eclipse-workspace\\projet_java\\car2.jpg"));
		lblNewLabel_4.setBounds(0, 0, 601, 687);
		add(lblNewLabel_4);
		
	}
	public static JFrame entre() {
		JFrame frame = new JFrame("page entre");
        frame.setContentPane(new page_entre());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,720);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return(frame);}
	public static void main(String [] args) {
		frame_main=page_entre.entre();
	}
}
