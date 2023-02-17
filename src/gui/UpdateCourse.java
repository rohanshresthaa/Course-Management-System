package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import courses.CRUDCourse;
import exception.NullException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateCourse {

	private JFrame frame;
	private JTextField cid;
	private JTextField cname;



	/**
	 * Create the application.
	 */
	public UpdateCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 300);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Update Course");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		cid = new JTextField();
		cid.setColumns(10);

		cname = new JTextField();
		cname.setColumns(10);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(117, 191, 64));
		btnNewButton.addActionListener(new ActionListener() {
			CRUDCourse crud = new CRUDCourse();

			public void actionPerformed(ActionEvent e) {
//				Integer id = new Integer(cid.getText());
				int id;
				 
				try {
					id = Integer.parseInt(cid.getText().trim());
					String courseName = cname.getText();
					if(id == 0 ) {
						crud.updateCourse(id, courseName);
					}else {
						crud.updateCourse(id, courseName);
					}
					
				} catch (NullException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}catch(NumberFormatException ex1) {
					JOptionPane.showMessageDialog(null, "Please Enter Number in Id Field!!!");
				}

			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 10));

		JLabel lblNewLabel_1 = new JLabel("Course ID");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 10));

		JLabel lblNewLabel_1_1 = new JLabel("New Course Name");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(170)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cname)
										.addComponent(cid)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(170, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(14)
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_1_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addComponent(btnNewButton)
								.addContainerGap(80, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
	}
}
