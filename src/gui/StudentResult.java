package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import courses.Result;
import javax.swing.JScrollPane;

public class StudentResult {

	private JFrame frame;
	private JTable table;

	

	/**
	 * Create the application.
	 */
	int id;
	private JScrollPane scrollPane;
	public StudentResult(int id) {
		this.id = id;
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		Result r = new Result();
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(new String[] {"Module Name", "Marks"});
		for(int k = 0;k<r.displayResult(id).size();k++) {
			model.addRow(new Object[] {r.displayResult(id).get(k).moduleName, r.displayResult(id).get(k).marks});
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 37, 356, 192);
		panel.add(scrollPane);
			
		table = new JTable(model);
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}

}
