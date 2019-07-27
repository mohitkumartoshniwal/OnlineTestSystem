package onlinetest2;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Panel1 extends JPanel {

	public Panel1() {
		setLayout(null);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setFocusable(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new LoginPanel());
			}
		});
		btnNext.setForeground(new Color(253, 245, 230));
		btnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNext.setBackground(new Color(250, 128, 114));
		btnNext.setBounds(892, 511, 89, 36);
		add(btnNext);
		
		JLabel lblOnlineExamination = new JLabel("EXAM SYSTEM");
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 41));
		lblOnlineExamination.setBounds(198, 130, 603, 105);
		add(lblOnlineExamination);
		
		
		
	}
}
