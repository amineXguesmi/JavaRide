package projet_java;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class page_user extends JPanel {
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Create the panel.
	 */
	public page_user() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome dear customer");
		lblNewLabel.setBounds(156, 10, 422, 52);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 80));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		add(lblNewLabel);
		
		JButton btnReserver = new JButton("reserver");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int b=table.getSelectedRow();
				if(b>=0) {
				String matricule1=(String) model.getValueAt(b, 4);
				try {
				Connection connection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
						"amine**--");
				Statement stmt = connection.createStatement();
				ResultSet x=stmt.executeQuery("SELECT louer FROM voiture WHERE matricule = '"+matricule1+"'");
				if(x.next()) {
					String louer =x.getString("louer");
					if(louer.equals("oui")) {
						JOptionPane.showMessageDialog(null, "already reserved");
					}
					else{
						int cin=Integer.parseInt(page_entre.test);
						JOptionPane.showMessageDialog(null, "reserved successfully");
						boolean a=stmt.execute("UPDATE voiture SET louer = 'oui' , user = '"+cin+"' WHERE matricule = '"+matricule1+"'");
					}
				}
				
				
				}
				catch (Exception exception) {
					 exception.printStackTrace();
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "please select a row");
				}
			}
		});
		btnReserver.setForeground(new Color(95, 158, 160));
		btnReserver.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnReserver.setBackground(Color.CYAN);
		btnReserver.setBounds(529, 536, 211, 35);
		add(btnReserver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 117, 496, 409);
		add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel();
		Object[] column= {"ID","name","type","class","matricule","prix","louer"};
		Object[] row =new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		JButton btnGetListe = new JButton("get List");
		btnGetListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				model.setRowCount(0);
                try {
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM voiture ");
					 while(rs.next()) {	
						 
						 String name=rs.getString("name");
						 String matricule=rs.getString("matricule");
						 String type=rs.getString("type");
						 String classVoi=rs.getString("classVoi");
						 String prix=rs.getString("prix");
						 String louer=rs.getString("louer");
						 i++;
						 row[0]=i;
						 row[1]=name;
						 row[2]=type;
						 row[3]=classVoi;
						 row[4]=matricule;
						 row[5]=prix;
						 row[6]=louer;
					
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
		btnGetListe.setBounds(322, 72, 308, 35);
		add(btnGetListe);
		
		JButton btnGetPictures = new JButton("get pictures");
		btnGetPictures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int b=table.getSelectedRow();
				if(b>=0) {
					if(b%3==1) {
            ImageIcon icon= new ImageIcon("C:\\\\Users\\\\semah\\\\eclipse-workspace\\\\projet_java\\\\img\\\\kiario.jpg");
				JOptionPane.showMessageDialog(null,"fegfs","Display Image",JOptionPane.INFORMATION_MESSAGE,icon);}
					else if(b%3==2) {
			            ImageIcon icon= new ImageIcon("C:\\\\Users\\\\semah\\\\eclipse-workspace\\\\projet_java\\\\car2.jpg");
						JOptionPane.showMessageDialog(null,"fegfs","Display Image",JOptionPane.INFORMATION_MESSAGE,icon);}
					else if(b%3==0) {
			            ImageIcon icon= new ImageIcon("C:\\\\Users\\\\semah\\\\eclipse-workspace\\\\projet_java\\\\img\\\\peugeot208.jpg");
						JOptionPane.showMessageDialog(null,"","Display Image",JOptionPane.INFORMATION_MESSAGE,icon);}
				}
				else {
					JOptionPane.showMessageDialog(null, "please select a row");
				}
			}
		});
		btnGetPictures.setForeground(new Color(95, 158, 160));
		btnGetPictures.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnGetPictures.setBackground(Color.CYAN);
		btnGetPictures.setBounds(265, 536, 211, 35);
		add(btnGetPictures);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("name :");
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_1_1.setBounds(0, 122, 88, 40);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CIN :");
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1.setBounds(0, 171, 59, 40);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Password :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1.setBounds(0, 298, 117, 40);
		add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dob :");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2.setBounds(0, 387, 69, 40);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("address");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1_1.setBounds(0, 219, 117, 40);
		add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("location :");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		lblNewLabel_1_2_1_1_1_1.setBounds(0, 437, 98, 40);
		add(lblNewLabel_1_2_1_1_1_1);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();	
						
							int cin=Integer.parseInt(page_entre.test);
							String nam=textField.getText();
							String address=textField_2.getText();
							String mdp=textField_3.getText();
							String dob=textField_4.getText();
							String location=textField_5.getText();
							boolean a=stmt.execute("UPDATE client SET fname = '"+nam+"',address= '"+address+"', mdp='"+mdp+"',dob ='"+dob+"',location ='"+location+"'   WHERE cin = '"+page_entre.test+"'");
							JOptionPane.showMessageDialog(null, "updated successfully");
					}
					
					
					
					catch (Exception exception) {
						 exception.printStackTrace();
					}
					}
			
		});
		btnUpdate.setForeground(new Color(95, 158, 160));
		btnUpdate.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setBounds(0, 487, 245, 35);
		add(btnUpdate);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(68, 122, 187, 40);
		
		
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(69, 170, 187, 40);
		
			 
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(0, 258, 255, 40);
	
			 
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(0, 332, 255, 40);

			
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(68, 387, 187, 40);
	
			 
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana Pro", Font.PLAIN, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(88, 437, 167, 40);
		add(textField_5);
		
		JButton btnGetInfo = new JButton("get info");
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Connection connection = 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", 
							"amine**--");
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE cin='"+page_entre.test+"'");
					 if(rs.next()) {	
						 
						 String fname=rs.getString("fname");
						 String cin=rs.getString("cin");
						 String address=rs.getString("address");
						 String dob=rs.getString("dob");
						 String location=rs.getString("location");
						 String mdp=rs.getString("mdp");
						 textField.setText(fname);
						 textField_1.setText(cin);
						 textField_2.setText(address);
						 textField_3.setText(mdp);
						 textField_4.setText(dob);
						 textField_5.setText(location);
						 
					 }
					
					connection.close();}
					  catch (Exception exception) {
					 exception.printStackTrace();
					 }
			}
		});
		btnGetInfo.setForeground(new Color(95, 158, 160));
		btnGetInfo.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		btnGetInfo.setBackground(Color.CYAN);
		btnGetInfo.setBounds(10, 72, 245, 35);
		add(btnGetInfo);
		
	}
	public static JFrame entre() {
		JFrame frame = new JFrame("page admin");
        frame.setContentPane(new page_user());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820,720);	
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return(frame);}
}
