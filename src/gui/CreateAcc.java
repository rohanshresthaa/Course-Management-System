package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import auth.Validation;
import courses.Courses;
import exception.InvalidFormat;
import exception.NullException;
import users.Instructor;
import users.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateAcc {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField phone;
	private JComboBox rolesSelect;
	private JComboBox course;
	private JButton btnCreate;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Create the application.
	 */
	public CreateAcc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 825, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(164, 201, 58));
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 30));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		username = new JTextField();
		username.setToolTipText("");
		username.setColumns(10);
		username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		email = new JTextField();
		email.setToolTipText("");
		email.setColumns(10);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		password = new JPasswordField();
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		phone = new JTextField();
		phone.setToolTipText("");
		phone.setColumns(10);
		phone.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		rolesSelect = new JComboBox(new Object[] { "Student", "Instructor" });
		rolesSelect.setForeground(Color.BLACK);
		rolesSelect.setFont(new Font("Poppins", Font.PLAIN, 14));
		rolesSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rolesSelect.setBackground(new Color(248, 248, 248));

		ArrayList<Courses> cor = new ArrayList<Courses>();
		Courses c = new Courses();
		cor = c.getCourse();
		// cor.toArray();

		course = new JComboBox(new Object[] {});
		for (int i = 0; i < cor.size(); i++) {
			course.addItem(cor.get(i).course_name);
		}
		course.setForeground(Color.BLACK);
		course.setFont(new Font("Poppins", Font.PLAIN, 14));
		course.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		course.setBackground(new Color(248, 248, 248));

		Student s = new Student();
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructor i = new Instructor();
				String uname = username.getText();
				String p = new String(password.getPassword());
				String em = email.getText();
				String ph = phone.getText();
				Validation v = new Validation();
				int courseId = c.getCourseId(course.getSelectedItem().toString());
				try {
					if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)){
						if(rolesSelect.getSelectedItem().equals("Student")) {
						s.studentRegister(uname,courseId, em, p, ph, 1);
						}else {
							i.addInstructor(uname, em, ph, p);
						}
					}
					
				} catch (NullException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				} catch (InvalidFormat ex1) {
					JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
				}

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.setBackground(new Color(117, 191, 67));

		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
			}
		});
		btnNewButton.setForeground(new Color(248, 248, 248));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(117, 191, 67));

		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setForeground(new Color(117, 191, 165));
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1 = new JLabel("Enter Email:");
		lblNewLabel_1_1.setForeground(new Color(117, 191, 165));
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Enter Password:\r\n");
		lblNewLabel_1_2.setForeground(new Color(117, 191, 165));
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Enter Pnone Number:");
		lblNewLabel_1_3.setForeground(new Color(117, 191, 165));
		lblNewLabel_1_3.setFont(new Font("Poppins", Font.PLAIN, 14));

		lblNewLabel_2 = new JLabel("Select Role:");
		lblNewLabel_2.setForeground(new Color(117, 191, 165));
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));

		lblNewLabel_3 = new JLabel("Select Course:");
		lblNewLabel_3.setForeground(new Color(117, 191, 165));
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		
		lblNewLabel_4 = new JLabel("*Note: Ignore for Teacher");
		lblNewLabel_4.setForeground(new Color(117, 191, 165));
		lblNewLabel_4.setFont(new Font("Poppins", Font.ITALIC, 9));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(300)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rolesSelect, 0, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(phone, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(password, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(email, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(username, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(course, 0, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(304, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(username, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(email, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(phone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rolesSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(course, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);

		String[] roles = { "Teacher", "Student" };
	}
}
