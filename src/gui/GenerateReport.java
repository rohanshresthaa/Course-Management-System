package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import exception.InvalidMarks;
import users.Instructor;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GenerateReport {

	private JFrame frame;
	private JTextField sid;
	private JTextField mid;
	private JTextField marks;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public GenerateReport() {
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
		
		JLabel lblNewLabel = new JLabel("Generate Report");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		sid = new JTextField();
		sid.setFont(new Font("Poppins", Font.PLAIN, 10));
		sid.setColumns(10);
		
		mid = new JTextField();
		mid.setFont(new Font("Poppins", Font.PLAIN, 10));
		mid.setColumns(10);
		
		marks = new JTextField();
		marks.setFont(new Font("Poppins", Font.PLAIN, 10));
		marks.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructor i = new Instructor();
				int s = Integer.parseInt(sid.getText().trim());
				int m = Integer.parseInt(mid.getText().trim());
				int mark = Integer.parseInt(marks.getText().trim());
				try {
					i.generateReport(s, m, mark);
				}catch(InvalidMarks | SQLException e1) {
					  JOptionPane.showMessageDialog(null, "Something went wrong!",
			                    "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(117, 191, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		
		JLabel lblNewLabel_1_1 = new JLabel("Module ID");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Marks");
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(170)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(marks)
						.addComponent(sid)
						.addComponent(mid)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_1_1)
					.addGap(4)
					.addComponent(marks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
