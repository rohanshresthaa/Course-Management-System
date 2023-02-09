package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.NullException;

public class Admin extends User implements Activity {
	

	public Admin() {
	}

	public Admin(int id, String name, String email, String phone) {
		super(id, name, email, phone);
	}

	@Override
	public boolean login(String email, String password) {
		Connection connect = db.load();

		// Create a statement to execute the SQL query
		Statement stmt;
		ResultSet rs;
		if (email.isEmpty() || password.isEmpty()) {
			throw new NullException();
		}
		try {
			stmt = connect.createStatement();
			rs = stmt.executeQuery("SELECT admin_email, admin_password FROM admin WHERE admin_email='" + email + "'");
			if (rs.next()) {
				// Get the password from the database
				String passwordFromDB = rs.getString("admin_password");

				// Compare the password from the database with the entered password
				if (passwordFromDB.equals(password)) {

					JOptionPane.showMessageDialog(null, "Login successful!");
					connect.close();
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect email or password!");
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Email not found!");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Something went wrong!",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	public ArrayList<String> getAdminData(String email) {
		String select = "SELECT * FROM admin WHERE admin_email = '" + email + "'";
		ArrayList<String> admin = new ArrayList<String>();
		try {
			PreparedStatement state = connect.prepareStatement(select);
			ResultSet set = state.executeQuery(select);
			while (set.next()) {
				admin.add(set.getNString("admin_name"));

			}
			state.executeQuery();
			state.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return admin;
	}

	public void changePassword(String email, String oldPassword, String newPassword) {
		try {
			// Verify the old password first
			PreparedStatement stmt = connect
					.prepareStatement("SELECT admin_password FROM admin WHERE admin_email = ?");
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();
			if (!result.next() || !result.getString("admin_password").equals(oldPassword)) {
				JOptionPane.showMessageDialog(null, "Incorrect old password!");
				return;
			}

			// Update the password if the old password is correct
			stmt = connect.prepareStatement("UPDATE admin SET admin_password = ? WHERE admin_email = ?");
			stmt.setString(1, newPassword);
			stmt.setString(2, email);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Password changed successfully!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void assignModule(int instructId, int moduleId) {
		if (instructId == 0 || moduleId == 0) {
			throw new NullException();
		}
		try {
			PreparedStatement stmt = connect
					.prepareStatement("INSERT INTO assigned_modules (instructor_id, module_id) VALUES (?, ?)");
			stmt.setInt(1, instructId);
			stmt.setInt(2, moduleId);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Module assigned successfully!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}



}
