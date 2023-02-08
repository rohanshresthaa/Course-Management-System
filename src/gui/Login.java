package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.border.MatteBorder;

import exception.InvalidCredintial;
import exception.NullException;
import users.Admin;
import users.Instructor;
import users.Student;

import java.awt.Panel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Login {

	public JFrame frame;
	private JTextField email;
	private JPasswordField password;


	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 500, 850, 620);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 60, 60));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		ImageIcon icon = new ImageIcon("/logo.png");

		JLabel lblNewLabel = new JLabel("Welcome to Course Management System");
		lblNewLabel.setForeground(new Color(164, 201, 58));
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(165)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(115, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		email = new JTextField();
		email.setBounds(316, 153, 207, 34);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		email.setToolTipText("");
		email.setColumns(10);
		JLabel invalid1 = new JLabel("Invalid");
		invalid1.setBounds(491, 198, 32, 16);
		invalid1.setVisible(false);
		JLabel invalid2 = new JLabel("Invalid");
		invalid2.setBounds(491, 270, 32, 16);
		invalid2.setVisible(false);
		password = new JPasswordField();
		password.setBounds(316, 223, 207, 34);
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.add(email);
		panel_1.add(password);
		String roles[] = { "admin", "instructors", "students" };
		JComboBox comboBox = new JComboBox(roles);
		comboBox.setBackground(new Color(248, 248, 248));
		comboBox.setBounds(316, 313, 207, 34);
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(comboBox);

		JButton login = new JButton("Log In");
		login.setBounds(436, 376, 85, 34);
		login.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailField = email.getText();
				String passField = new String(password.getPassword());

				Student s = new Student();
				Instructor i = new Instructor();
				Admin a = new Admin();
				try {
					if (comboBox.getSelectedItem().equals("students")) {
						if (s.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("instructors")) {
						if (i.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("admin")) {
						if (a.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Email or Password!!", "Invalid Information!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} catch (NullException e1) {
					JOptionPane.showMessageDialog(null, "Please fill up the empty boxes!!", "Error!!",
							JOptionPane.ERROR_MESSAGE);
					invalid1.setVisible(true);
					invalid2.setVisible(true);
				}

			}
		});
		login.setBackground(new Color(117, 191, 67));
		login.setForeground(new Color(248, 248, 248));
		login.setFont(new Font("Poppins", Font.PLAIN, 16));
		panel_1.add(login);

		JLabel cacc = new JLabel("Enter Email:");
		cacc.setForeground(new Color(117, 191, 165));
		cacc.setBounds(316, 133, 96, 22);
		cacc.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(cacc);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Password:");
		lblNewLabel_1_1.setForeground(new Color(90, 186, 207));
		lblNewLabel_1_1.setBounds(316, 202, 110, 22);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Select Role:");
		lblNewLabel_1_1_1.setForeground(new Color(90, 186, 207));
		lblNewLabel_1_1_1.setBounds(316, 293, 79, 22);
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1);

		invalid2.setForeground(new Color(255, 0, 0));
		invalid2.setFont(new Font("Poppins", Font.PLAIN, 10));
		panel_1.add(invalid2);

		invalid1.setForeground(new Color(255, 0, 0));
		invalid1.setFont(new Font("Poppins", Font.PLAIN, 10));
		panel_1.add(invalid1);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(316, 376, 91, 34);
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAcc();
				System.out.println("Clicked");
				frame.setVisible(false);

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBackground(new Color(117, 191, 67));
		panel_1.add(btnCreate);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setAlignmentX(0.5f);
		lblNewLabel_2.setBounds(285, 10, 268, 113);
		Image logo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(logo));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(285, 153, 32, 34);
		Image mail = new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(mail));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(285, 224, 32, 34);
		Image pass = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_3_1.setIcon(new ImageIcon(pass));
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBounds(285, 316, 32, 34);
		Image user = new ImageIcon(this.getClass().getResource("/account.png")).getImage();
		lblNewLabel_3_1_1.setIcon(new ImageIcon(user));
		panel_1.add(lblNewLabel_3_1_1);
	}
}
