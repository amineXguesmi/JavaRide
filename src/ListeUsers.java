package projet_java;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ListeUsers extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	DefaultTableModel model;
	int i=0;

	/**
	 * Create the panel.
	 */
	public ListeUsers() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 71, 433, 518);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model=new DefaultTableModel();
		Object[] column= {"ID","cin","Name","Address","dob","location","mdp"};
		Object[] row =new Object[7];
		model.setColumnIdentifiers(column);
		
		table.setModel(model);
		JLabel lblNewLabel_1 = new JLabel("last name :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(0, 79, 134, 40);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CIN :");
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1.setBounds(0, 140, 134, 40);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Password :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1.setBounds(0, 207, 141, 40);
		add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("location :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1_1_1.setBounds(0, 328, 141, 40);
		add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dob :");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(0, 267, 134, 40);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("First name :");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_1.setBounds(0, 24, 134, 40);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(116, 23, 192, 40);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(116, 79, 192, 40);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(116, 140, 192, 40);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(116, 207, 192, 40);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(116, 267, 192, 40);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(116, 328, 192, 40);
		add(textField_5);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				String fname=textField.getText();
				String lname=textField_1.getText();
				String add=lname+"."+fname+"@user.com";
				String name=fname+"_"+lname;
				row[0]=i;
				row[2]=lname+" "+fname;
				row[1]=textField_2.getText();
				row[3]=add;
				row[4]=textField_3.getText();
				row[5]=textField_4.getText();
				row[6]=textField_5.getText();		
				model.addRow(row);
				try{
				Connection connection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
						"amine**--");
				
				PreparedStatement ps= connection.prepareStatement("insert into client(cin,fname,address,dob,location,mdp) values(?,?,?,?,?,?)");
				ps.setString(1, textField_2.getText());
				ps.setString(2, name);
				ps.setString(3, add);
				ps.setString(4, textField_3.getText());
				ps.setString(5, textField_4.getText());
				ps.setString(6, textField_5.getText());
				 Boolean a = ps.execute();
				 if (a == true) {
				 JOptionPane.showMessageDialog(btnAdd, "This is alredy exist");
				 } else {
				 JOptionPane.showMessageDialog(btnAdd,
				 " account is sucessfully created :)");
				 }
				connection.close();}
				  catch (Exception exception) {
				 exception.printStackTrace();
				 }
	
			}}
		);
		btnAdd.setForeground(new Color(95, 158, 160));
		btnAdd.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnAdd.setBackground(Color.CYAN);
		btnAdd.setBounds(0, 419, 141, 35);
		add(btnAdd);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int b=table.getSelectedRow();
				if(b>=0) {
				String cin1=(String) model.getValueAt(b, 1);
				model.removeRow(b);
				try {
				Connection connection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
						"amine**--");
				Statement stmt = connection.createStatement();
				boolean a=stmt.execute("DELETE FROM client WHERE cin = '"+cin1+"'");}
				catch (Exception exception) {
					 exception.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "delete successfully");}
				else {
					JOptionPane.showMessageDialog(null, "please select a row");
				}
			}}
			);
		btnDelete.setForeground(new Color(95, 158, 160));
		btnDelete.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnDelete.setBackground(Color.CYAN);
		btnDelete.setBounds(155, 419, 153, 35);
		add(btnDelete);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnClear.setForeground(new Color(95, 158, 160));
		btnClear.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnClear.setBackground(Color.CYAN);
		btnClear.setBounds(0, 475, 308, 35);
		add(btnClear);
		
		JButton btnGetListe = new JButton("get Liste");
		btnGetListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				model.setRowCount(0);
				try {
					
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM client ");
					 while(rs.next()) {	
						 
						 String fname=rs.getString("fname");
						 String cin=rs.getString("cin");
						 String address=rs.getString("address");
						 String dob=rs.getString("dob");
						 String location=rs.getString("location");
						 String mdp=rs.getString("mdp");
						 i++;
						 row[0]=i;
						 row[1]=cin;
						 row[2]=fname;
						 row[3]=address;
						 row[4]=dob;
						 row[5]=location;
						 row[6]=mdp;
						 model.addRow(row);
						 
					 }
					
					connection.close();}
					  catch (Exception exception) {
					 exception.printStackTrace();
					 }
			}
		});
		btnGetListe.setForeground(new Color(95, 158, 160));
		btnGetListe.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnGetListe.setBackground(Color.CYAN);
		btnGetListe.setBounds(388, 26, 308, 35);
		add(btnGetListe);
		
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_entre.frame_main.dispose();
				page_entre.frame_main=admin_page.entre();
				page_entre.frame_main.show();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(0, 560, 79, 29);
		add(btnNewButton_1);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);

	}
	public static JFrame entre() {
		JFrame frame = new JFrame("page admin");
        frame.setContentPane(new ListeUsers());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820,720);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return(frame);}
}
