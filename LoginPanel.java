package onlinetest2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LoginPanel extends JPanel {
	private JButton btnUser;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Panel1());
			}
		});
		
		JButton btnTest = new JButton("Take A test");
		btnTest.setFocusable(false);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				MainFrame.AddPanel(new TakeTest());
				
			}
		});
		btnTest.setForeground(new Color(75, 0, 130));
		btnTest.setBackground(new Color(135, 206, 250));
		btnTest.setFont(new Font("MV Boli", Font.BOLD, 30));
		btnTest.setBounds(256, 220, 478, 99);
		add(btnTest);
		
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
			}
		});
		btnAdmin.setForeground(new Color(75, 0, 130));
		btnAdmin.setBackground(new Color(135, 206, 250));
		btnAdmin.setFont(new Font("MV Boli", Font.BOLD, 30));
		btnAdmin.setBounds(256, 322, 478, 99);
		add(btnAdmin);
	
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("LOGIN");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblOnlineExamination.setBounds(388, 46, 214, 105);
		add(lblOnlineExamination);
		
		

	}

}
