package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import courses.AssignedModule;
import courses.Courses;
import courses.Modules;
import users.Admin;
import users.Instructor;
import users.Student;
import users.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class Dashboard {

	private JFrame frame;
	private Desktop desktop;
	private CardLayout card = new CardLayout(0, 0);


	/**
	 * Create the application.
	 */
	private String user;
	private String emailInfo;
	private JTable table;
	private JTable table_1;
	private JTable instructorTable;
	private JPasswordField pwdOldPassword;
	private JTable table_2;
	private JPasswordField pwdNewPass;
	private JTable table_3;

	public Dashboard(String user, String emailInfo) {
		this.user = user;
		this.emailInfo=emailInfo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 25));

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(60, 60, 60));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(card);

		JPanel dashboard = new JPanel();
		panel_2.add(dashboard, "name_883401573051700");

		// for number of courses
		ArrayList<Courses> cor = new ArrayList<Courses>();
		Courses c = new Courses();
		cor = c.getCourse();

		JLabel lblNewLabel_2 = new JLabel("No of Courses");
		lblNewLabel_2.setBounds(39, 58, 197, 46);
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 24));

		JLabel lblNewLabel_2_1 = new JLabel("No of Tutors");
		lblNewLabel_2_1.setBounds(472, 58, 177, 46);
		lblNewLabel_2_1.setFont(new Font("Poppins", Font.PLAIN, 24));

		JLabel lblNewLabel_2_2_5 = new JLabel("Dashboard");
		lblNewLabel_2_2_5.setBounds(10, 10, 175, 46);
		lblNewLabel_2_2_5.setFont(new Font("Poppins", Font.BOLD, 25));

		JLabel lblNewLabel = new JLabel("" + c.getCourse().size());
		lblNewLabel.setBounds(39, 110, 197, 69);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 63));

		Instructor i = new Instructor();
		JLabel lblNewLabel_3 = new JLabel("" + i.getInstructor().size());
		lblNewLabel_3.setBounds(472, 110, 197, 69);
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 63));

		JLabel lblNewLabel_2_3 = new JLabel("No of Modules\r\n");
		lblNewLabel_2_3.setBounds(39, 230, 197, 46);
		lblNewLabel_2_3.setFont(new Font("Poppins", Font.PLAIN, 24));

		Modules m = new Modules();
		JLabel lblNewLabel_4 = new JLabel("" + m.getModules().size());
		lblNewLabel_4.setBounds(39, 282, 197, 69);
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 63));

		JLabel lblNewLabel_2_3_1 = new JLabel("No of Students\r\n");
		lblNewLabel_2_3_1.setBounds(472, 230, 197, 46);
		lblNewLabel_2_3_1.setFont(new Font("Poppins", Font.PLAIN, 24));

		Student s = new Student();
		JLabel lblNewLabel_6 = new JLabel("" + s.getStudents().size());
		lblNewLabel_6.setBounds(472, 282, 197, 69);
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD, 63));
		
		JLabel lblNewLabel_8 = new JLabel("Modules");
		lblNewLabel_8.setBounds(39, 379, 166, 20);
		lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 13));
		dashboard.setLayout(null);
		
		
		DefaultTableModel enroll = new DefaultTableModel();
		enroll.setColumnIdentifiers(new String[] {"Sn","Module Name"});
		for(int j = 0; j<s.moduleEnrollment(emailInfo).size(); j++) {
			enroll.addRow(new Object[] {j+1,s.moduleEnrollment(emailInfo).get(j).toString()});
		}
		dashboard.add(lblNewLabel_8);
		dashboard.add(lblNewLabel);
		dashboard.add(lblNewLabel_2);
		dashboard.add(lblNewLabel_2_3);
		dashboard.add(lblNewLabel_4);
		dashboard.add(lblNewLabel_6);
		dashboard.add(lblNewLabel_2_3_1);
		dashboard.add(lblNewLabel_2_1);
		dashboard.add(lblNewLabel_3);
		dashboard.add(lblNewLabel_2_2_5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(49, 409, 324, 110);
		dashboard.add(scrollPane_4);
		
		table_3 = new JTable(enroll);
		scrollPane_4.setViewportView(table_3);
		if(user=="students") {
			scrollPane_4.setVisible(true);
			lblNewLabel_8.setVisible(true);
		}else {
			scrollPane_4.setVisible(false);
			lblNewLabel_8.setVisible(false);
		}
		JPanel courses = new JPanel();
		panel_2.add(courses, "name_883428383006400");

		JLabel lblNewLabel_2_2 = new JLabel("Total No of Courses:");
		lblNewLabel_2_2.setBounds(48, 65, 219, 46);
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.PLAIN, 20));

		JLabel lblNewLabel_2_2_4 = new JLabel("Courses");
		lblNewLabel_2_2_4.setBounds(10, 13, 124, 46);
		lblNewLabel_2_2_4.setFont(new Font("Poppins", Font.BOLD, 25));
		courses.setLayout(null);
		courses.add(lblNewLabel_2_2);
		courses.add(lblNewLabel_2_2_4);

		JLabel lblNewLabel_7 = new JLabel("" + c.getCourse().size());
		lblNewLabel_7.setBounds(48, 121, 197, 69);
		lblNewLabel_7.setFont(new Font("Poppins", Font.BOLD, 63));
		courses.add(lblNewLabel_7);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Course Name" });

		for (int j = 0; j < c.getCourse().size(); j++) {
			model.addRow(new Object[] { c.getCourse().get(j).course_id, c.getCourse().get(j).course_name });
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setFocusable(false);
		scrollPane.setOpaque(false);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setBounds(48, 243, 421, 248);
		courses.add(scrollPane);
		table = new JTable(model);
		table.setEnabled(false);
		table.setFont(new Font("Poppins", Font.PLAIN, 10));
		table.setRequestFocusEnabled(false);
		table.setOpaque(false);
		table.setShowVerticalLines(false);
		table.setRowSelectionAllowed(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_2_6 = new JLabel("Total No of Modules:");
		lblNewLabel_2_2_6.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNewLabel_2_2_6.setBounds(513, 65, 219, 46);
		courses.add(lblNewLabel_2_2_6);

		JLabel lblNewLabel_7_2 = new JLabel("" + m.getModules().size());
		lblNewLabel_7_2.setFont(new Font("Poppins", Font.BOLD, 63));
		lblNewLabel_7_2.setBounds(513, 121, 197, 69);
		courses.add(lblNewLabel_7_2);

		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(new String[] { "ID", "Module Name", "Course", "Type" });

		for (int j = 0; j < m.getModules().size(); j++) {
			model1.addRow(new Object[] { m.getModules().get(j).module_id, m.getModules().get(j).module_name,
					m.getModules().get(j).course_id, m.getModules().get(j).module_type });
		}
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(491, 243, 421, 245);
		courses.add(scrollPane_1);

		table_1 = new JTable(model1);
		table_1.setRowSelectionAllowed(false);
		table_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		table_1.setEnabled(false);
		scrollPane_1.setViewportView(table_1);

		JButton editCourse = new JButton("Update");
		editCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateCourse();
			}
		});
		if(user=="admin") {
			editCourse.setVisible(true);
		}else {
			editCourse.setVisible(false);

		}
		editCourse.setBorderPainted(false);
		editCourse.setBackground(new Color(117, 197, 67));
		editCourse.setForeground(new Color(255, 255, 255));
		editCourse.setFont(new Font("Poppins", Font.PLAIN, 9));
		editCourse.setBounds(144, 28, 70, 25);
		courses.add(editCourse);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteCourse();
			}
		});
		if(user=="admin") {
			btnDelete.setVisible(true);
		}else {
			btnDelete.setVisible(false);

		}
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Poppins", Font.PLAIN, 9));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(117, 197, 67));
		btnDelete.setBounds(226, 29, 70, 25);
		courses.add(btnDelete);


		JButton addCourse = new JButton("Add");
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourse();
			}
		});
		
	addCourse.setVisible(false);
		addCourse.setForeground(Color.WHITE);
		addCourse.setFont(new Font("Poppins", Font.PLAIN, 9));
		addCourse.setBorderPainted(false);
		addCourse.setBackground(new Color(117, 197, 67));
		addCourse.setBounds(306, 29, 70, 25);
		addCourse.setVisible(false);
		courses.add(addCourse);
		if(user=="admin") {
			addCourse.setVisible(true);
		}
		JButton addModule = new JButton(" Add Module");
		addModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddModule();
			}
		});
		addModule.setVisible(false);
		addModule.setForeground(Color.WHITE);
		addModule.setFont(new Font("Poppins", Font.PLAIN, 9));
		addModule.setBorderPainted(false);
		addModule.setBackground(new Color(117, 197, 67));
		addModule.setBounds(607, 101, 101, 25);
		courses.add(addModule);
if(user=="admin") {
	addModule.setVisible(true);
		}
		
		JButton deleteModule = new JButton("Delete Module");
		deleteModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteModule();
			}
		});
		
		deleteModule.setForeground(Color.WHITE);
		deleteModule.setVisible(false);
		deleteModule.setFont(new Font("Poppins", Font.PLAIN, 9));
		deleteModule.setBorderPainted(false);
		deleteModule.setBackground(new Color(117, 197, 67));
		deleteModule.setBounds(720, 102, 101, 25);
		courses.add(deleteModule);
		if(user=="admin") {
			deleteModule.setVisible(true);
				}

		JPanel tutors = new JPanel();
		panel_2.add(tutors, "name_883448439532000");

		JLabel lblNewLabel_2_2_1 = new JLabel("Total No of Teachers");
		lblNewLabel_2_2_1.setBounds(48, 62, 257, 46);
		lblNewLabel_2_2_1.setFont(new Font("Poppins", Font.PLAIN, 20));

		JLabel lblNewLabel_2_2_3 = new JLabel("Tutors");
		lblNewLabel_2_2_3.setBounds(10, 10, 92, 46);
		lblNewLabel_2_2_3.setFont(new Font("Poppins", Font.BOLD, 25));

		JLabel lblNewLabel_7_1 = new JLabel("" + i.getInstructor().size());
		lblNewLabel_7_1.setBounds(48, 114, 197, 69);
		lblNewLabel_7_1.setFont(new Font("Poppins", Font.BOLD, 63));
		tutors.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBounds(48, 201, 397, 356);
		tutors.add(scrollPane_2);

		DefaultTableModel instructTable = new DefaultTableModel();
		instructTable.setColumnIdentifiers(new String[] { "ID", "Name", "Email", "Phone" });
		for (int j = 0; j < i.getInstructor().size(); j++) {
			instructTable.addRow(new Object[] { i.getInstructor().get(j).id, i.getInstructor().get(j).name,
					i.getInstructor().get(j).email, i.getInstructor().get(j).phone });
		}
		instructorTable = new JTable(instructTable);
		instructorTable.setBackground(new Color(255, 255, 255));
		instructorTable.setFont(new Font("Poppins", Font.PLAIN, 10));
		instructorTable.setRowSelectionAllowed(false);
		instructorTable.setShowVerticalLines(false);
		instructorTable.setShowHorizontalLines(false);
		instructorTable.setShowGrid(false);
		instructorTable.setEnabled(false);
		scrollPane_2.setViewportView(instructorTable);
		tutors.add(lblNewLabel_2_2_3);
		tutors.add(lblNewLabel_7_1);
		tutors.add(lblNewLabel_2_2_1);

		JButton editTutor = new JButton("Add Tutor");
		editTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddInstructor();
			}
		});
		editTutor.setForeground(Color.WHITE);
		editTutor.setFont(new Font("Poppins", Font.PLAIN, 11));
		editTutor.setBorderPainted(false);
		editTutor.setBackground(new Color(117, 197, 67));
		editTutor.setBounds(112, 27, 108, 25);
		tutors.add(editTutor);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(469, 201, 432, 356);
		tutors.add(scrollPane_3);

		DefaultTableModel assignTable = new DefaultTableModel();
		ArrayList<AssignedModule> assigned = new ArrayList<>();
		assigned = i.assignedModuleView();
		assignTable.setColumnIdentifiers(new String[] { "Instructor ID", "Module Name" });
		for (int k = 0; k < i.assignedModuleView().size(); k++) {
			assignTable.addRow(new Object[] { assigned.get(k).instructorId, assigned.get(k).moduleName });
		}

		table_2 = new JTable(assignTable);
		scrollPane_3.setViewportView(table_2);
		
		JButton deleteTutor = new JButton("Delete Tutor");
		deleteTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteInstructor();
				
			}
		});
		if(user=="admin"){
			deleteTutor.setVisible(true);
		}
		
		deleteTutor.setVisible(false);
		deleteTutor.setFont(new Font("Poppins", Font.PLAIN, 11));
		deleteTutor.setForeground(new Color(255, 255, 255));
		deleteTutor.setBackground(new Color(117, 191, 64));
		deleteTutor.setBorderPainted(false);
		deleteTutor.setBounds(230, 27, 108, 25);
		tutors.add(deleteTutor);
		
		JButton assignModule = new JButton("Assign Module");
		assignModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		if(user=="admin") {
			assignModule.setVisible(true);
		}
		assignModule.setVisible(false);
		assignModule.setForeground(Color.WHITE);
		assignModule.setFont(new Font("Poppins", Font.PLAIN, 11));
		assignModule.setBorderPainted(false);
		assignModule.setBackground(new Color(117, 191, 64));
		assignModule.setBounds(353, 27, 121, 25);
		tutors.add(assignModule);
		editTutor.setVisible(false);
		if (user.equals("admin")) {
			editTutor.setVisible(true);
		}

		JPanel setting = new JPanel();
		panel_2.add(setting, "name_883463467586300");

		JLabel lblNewLabel_2_2_2 = new JLabel("Setting");
		lblNewLabel_2_2_2.setBounds(10, 10, 101, 39);
		lblNewLabel_2_2_2.setFont(new Font("Poppins", Font.BOLD, 25));

		JLabel lblNewLabel_9_2 = new JLabel("Email:");
		lblNewLabel_9_2.setBounds(53, 110, 64, 16);
		lblNewLabel_9_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		

		JLabel lblNewLabel_8_1 = new JLabel("Security");
		lblNewLabel_8_1.setBounds(53, 172, 144, 25);
		lblNewLabel_8_1.setFont(new Font("Poppins", Font.PLAIN, 16));

		JLabel lblNewLabel_9_3 = new JLabel("Old Password");
		lblNewLabel_9_3.setBounds(53, 217, 96, 20);
		lblNewLabel_9_3.setFont(new Font("Poppins", Font.PLAIN, 13));

		pwdOldPassword = new JPasswordField();
		pwdOldPassword.setBounds(153, 217, 179, 22);
		pwdOldPassword.setEchoChar('*');

		JLabel lblNewLabel_9_3_1 = new JLabel("New Password");
		lblNewLabel_9_3_1.setBounds(336, 217, 96, 20);
		lblNewLabel_9_3_1.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnNewButton_1_1 = new JButton("Change");
		btnNewButton_1_1.setBounds(633, 217, 100, 21);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPass = new String(pwdNewPass.getPassword());
				String oldPass = new String(pwdOldPassword.getPassword()) ;
				Admin a = new Admin();
				if(user=="students") {
					s.changePassword(emailInfo, oldPass, newPass);
				 } else if(user=="instructors"){
					 i.changePassword(emailInfo, oldPass, newPass);
				 }else if(user=="admin") {
					 a.changePassword(emailInfo, oldPass, newPass);
				 }
			}
		});
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(117, 191, 64));
		btnNewButton_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9_2_1 = new JLabel(emailInfo);
		lblNewLabel_9_2_1.setBounds(123, 110, 159, 16);
		lblNewLabel_9_2_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		setting.setLayout(null);
		
		pwdNewPass = new JPasswordField();
		pwdNewPass.setBounds(436, 217, 179, 22);
		pwdNewPass.setEchoChar('*');
		setting.add(pwdNewPass);
		setting.add(lblNewLabel_8_1);
		setting.add(lblNewLabel_9_3);
		setting.add(pwdOldPassword);
		setting.add(lblNewLabel_9_2);
		setting.add(lblNewLabel_9_2_1);
		setting.add(lblNewLabel_9_3_1);
		setting.add(lblNewLabel_2_2_2);
		setting.add(btnNewButton_1_1);
		
		JButton generateReport = new JButton("Generate Report ");
		generateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GenerateReport();
			}
		});
		if(user!="students") {
			generateReport.setVisible(true);
		}else {
			generateReport.setVisible(false);
		}
		
		generateReport.setForeground(new Color(255, 255, 255));
		generateReport.setBackground(new Color(117, 191, 64));
		generateReport.setFont(new Font("Poppins", Font.PLAIN, 10));
		generateReport.setBorderPainted(false);
		generateReport.setBounds(53, 324, 119, 25);
		setting.add(generateReport);
		
		JButton btnNewButton_2_1 = new JButton("View Report");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewReport();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBackground(new Color(117, 191, 64));
		btnNewButton_2_1.setBounds(180, 325, 119, 25);
		setting.add(btnNewButton_2_1);

		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "name_883401573051700");
				frame.revalidate();
				frame.repaint();
				
				
			}
		});
		btnNewButton.setBackground(new Color(164, 201, 58));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnCourses = new JButton("Courses");
		btnCourses.setBorderPainted(false);
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "name_883428383006400");
				frame.revalidate();
			
			}
		});
		btnCourses.setBackground(new Color(164, 201, 58));
		btnCourses.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnTutors = new JButton("Tutors");
		btnTutors.setBorderPainted(false);
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "name_883448439532000");
				frame.revalidate();
			
			}
		});
		btnTutors.setBackground(new Color(164, 201, 58));
		btnTutors.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnMail = new JButton("Mail");
		btnMail.setBorderPainted(false);
		btnMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop = Desktop.getDesktop();

				// pushing to borwser
				try {
					desktop.browse(new URI("https://gmail.com/"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnMail.setBackground(new Color(164, 201, 58));
		btnMail.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnSettings = new JButton("Setting");
		btnSettings.setBorderPainted(false);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "name_883463467586300");
				frame.revalidate();
				
			}
		});
		btnSettings.setBackground(new Color(164, 201, 58));
		btnSettings.setFont(new Font("Poppins", Font.PLAIN, 13));

		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(164, 201, 58));
		btnLogOut.setFont(new Font("Poppins", Font.PLAIN, 13));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
				frame.dispose();
			}
		});

		JLabel lblNewLabel_5 = new JLabel("" + user);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 11));

		JLabel lblNewLabel_10 = new JLabel("© 2023 | Copyright");
		lblNewLabel_10.setFont(new Font("Poppins", Font.PLAIN, 10));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnNewButton, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnCourses, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnTutors, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnMail, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnSettings, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnLogOut, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addContainerGap(25, Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 103,
														Short.MAX_VALUE)
												.addGap(25))
										.addComponent(lblNewLabel_10, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128,
												Short.MAX_VALUE))));
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(32)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnCourses, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnTutors, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnMail, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5)
								.addGap(35)
								.addComponent(lblNewLabel_10)
								.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

	}
}
