package onlinetest2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;



import javax.swing.JTextArea;



public class TakeTest extends JPanel {


	Connect c=new Connect("root","mohit");
	private String[] Courses;
	private String Name;
	private String Username;
	private JComboBox<String> comboBox;
	private String Selected_course="";
	private String totalQuestions;
	private String eachMark;
	private String time;

	private void dataBaseWork()
	{
		String course_query="select *from course_details where hide=0";
		try{
			Statement stmt=c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(course_name) from course_details where hide=0");
			rs.next();
			int i=rs.getInt(1);
			rs=stmt.executeQuery(course_query);
			Courses=new String[i];
			i=0;
			while(rs.next())
				Courses[i++]=rs.getString("course_name");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	// this function helps the start button to add beginTest panel or not.
	private int courseDetail(String Course)
	{
		try {
			Statement stmt = c.con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from course_details where course_name='"+Course+"'");
			rs.next();
			int i=(int)rs.getInt("total_question");
			time=rs.getString("time");
			totalQuestions=rs.getString("total_question");
			eachMark=rs.getString("question_mark");
			System.out.println("Questions are available : "+i);
			return i;
		} catch (SQLException e) {
			System.out.println("UserPanel->availableQuestions : "+e);
		}
		System.out.println("No questions are available ");
		return -1;
	}
	
	
	JTextArea instructions;
	
	
	public TakeTest() {
		setLayout(null);
		Username="user";
		dataBaseWork();
		
		
		JButton btnStartTest = new JButton("START TEST");
		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Selected_course.equals(""))
				{
					
						
						MainFrame.AddPanel(new BeginTest(Username,Selected_course,eachMark));
					
				}
				else
					JOptionPane.showMessageDialog(null, "Select course first.");;	
			}
		});

		
		
		btnStartTest.setBorder(new LineBorder(new Color(0, 255, 0), 3, true));
		btnStartTest.setBackground(new Color(144, 238, 144));
		btnStartTest.setForeground(new Color(128, 128, 0));
		btnStartTest.setFont(new Font("Serif", Font.ITALIC, 18));
		btnStartTest.setBounds(565, 184, 166, 42);
		add(btnStartTest);
		
		instructions = new JTextArea();
		instructions.setToolTipText("INSTRUCTIONS");
		instructions.setEditable(false);
		instructions.setDisabledTextColor(new Color(221, 160, 221));
		instructions.setBackground(new Color(192, 192, 192));
		instructions.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		instructions.setForeground(new Color(70, 130, 180));
		instructions.setBounds(10, 299, 971, 248);
		instructions.setVisible(false);
		add(instructions);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new LoginPanel());
			}
		});
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(Courses));
		comboBox.setFont(new Font("Perpetua Titling MT", Font.BOLD, 21));
		comboBox.setBounds(355, 180, 171, 36);
		comboBox.setSelectedIndex(-1);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Selected_course=(String)comboBox.getSelectedItem();
				courseDetail(Selected_course);
				
				instructions.setText("\n              INSTRUCTIONS   \n\n\n1. There are total "+totalQuestions+" questions each with "+eachMark+" marks in this course.\r\n2. Maximum time is "+time+" .\r\n3. There is no negative marking for any question.\r\n4. After time up you will be automatically logged out.\r\n5. You can see the time left on the upper right corner.\r\n6.Wish You All The Best.");
				instructions.setVisible(true);
				revalidate();
			}
		});
				
		JLabel lblSelectCourse = new JLabel("SELECT COURSE");
		lblSelectCourse.setForeground(UIManager.getColor("CheckBoxMenuItem.foreground"));
		lblSelectCourse.setFont(new Font("Rod", Font.BOLD, 20));
		lblSelectCourse.setBounds(152, 184, 180, 28);
		add(lblSelectCourse);
	

		JLabel lblOnlineExamination = new JLabel("WELCOME");
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblOnlineExamination.setBounds(388, 46, 250, 105);
		add(lblOnlineExamination);
		
		
	
	}
}

