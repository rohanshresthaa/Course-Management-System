package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionDB {
	
	public Connection load() {
		DatabaseMGMT c = new DatabaseMGMT();
		// driver loading
		DatabaseMGMT db = new DatabaseMGMT();
		 db.setUrl("jdbc:mysql://localhost:3306/cms");
		 db.setUsername("root");
		 db.setPassword("1234567890");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
			return connect;
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Couldn't connect to the database! Please make sure that your database server is active.",
					"Connection Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
			return null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Couldn't connect to the database! Please make sure that your database server is active.",
					"Connection Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
			return null;
		}

	}

}
