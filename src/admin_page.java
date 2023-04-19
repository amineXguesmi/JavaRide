package projet_java;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_page extends JPanel {

	/**
	 * Create the panel.
	 */
	public admin_page() {
		setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("welcome admin");
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeAdmin.setForeground(new Color(0, 0, 80));
		lblWelcomeAdmin.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lblWelcomeAdmin.setBounds(0, 23, 601, 54);
		add(lblWelcomeAdmin);
		
		JButton btnListeDeUsers = new JButton("Liste de users");
		btnListeDeUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_entre.frame_main.dispose();
				page_entre.frame_main=ListeUsers.entre();
				page_entre.frame_main.show();
			}
		});
		btnListeDeUsers.setForeground(new Color(51, 153, 204));
		btnListeDeUsers.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnListeDeUsers.setBounds(65, 160, 194, 46);
		add(btnListeDeUsers);
		
		JButton btnAjouterUnVoiture_1_1 = new JButton("liste des voitures");
		btnAjouterUnVoiture_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_entre.frame_main.dispose();
				page_entre.frame_main=ListeVoiture.entre();
				page_entre.frame_main.show();
			}
		});
		btnAjouterUnVoiture_1_1.setForeground(new Color(51, 153, 204));
		btnAjouterUnVoiture_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAjouterUnVoiture_1_1.setBounds(375, 160, 194, 46);
		add(btnAjouterUnVoiture_1_1);
		}
		public static JFrame entre() {
			JFrame frame = new JFrame("page admin");
	        frame.setContentPane(new admin_page());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600,720);	
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        return(frame);}
		
}
