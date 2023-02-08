package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import auth.Validation;
import users.Instructor;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddInstructor {

	private JFrame frame;
	private JTextField usernameText;
	private JTextField phoneText;
	private JTextField emailText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AddInstructor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Add Instructor");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Poppins", Font.PLAIN, 10));
		usernameText.setBounds(107, 35, 96, 19);
		panel_1.add(usernameText);
		usernameText.setColumns(10);
		
		phoneText = new JTextField();
		phoneText.setFont(new Font("Poppins", Font.PLAIN, 10));
		phoneText.setColumns(10);
		phoneText.setBounds(261, 77, 96, 19);
		panel_1.add(phoneText);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Poppins", Font.PLAIN, 10));
		emailText.setColumns(10);
		emailText.setBounds(261, 35, 96, 19);
		panel_1.add(emailText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 77, 96, 19);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Add\r\n Instructor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validation v = new Validation();
				String pass = new String(passwordField.getPassword());
				Instructor i = new Instructor();
				if(v.emailCheck(emailText.getText())&&v.passCheck(pass)&& v.phoneCheck(phoneText.getText())) {
					i.addInstructor(usernameText.getText(), emailText.getText(), phoneText.getText(), pass);
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(117, 191, 64));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnNewButton.setBounds(177, 123, 112, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(107, 22, 70, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email\r\n");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(261, 21, 70, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(107, 64, 70, 13);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setFont(new Font("Poppins", Font.PLAIN, 10));
		lblNewLabel_1_3.setBounds(261, 64, 96, 13);
		panel_1.add(lblNewLabel_1_3);
	}
}
