package users;

import java.nio.InvalidMarkException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import courses.AssignedModule;
import database.ConnectionDB;
import exception.NullException;

public class Instructor extends User implements Activity {
    private Connection connect;
    ConnectionDB db = new ConnectionDB();

    // default constructor
    public Instructor() {
        try {
            connect = db.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // parameter
    public Instructor(int id, String name, String email, String phone) {
        super(id, name, email, phone);
    }

    // geiing instructors
    public ArrayList<Instructor> getInstructor() {
        String select = "SELECT * FROM instructors";
        ArrayList<Instructor> instruct = new ArrayList<Instructor>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            ResultSet set = state.executeQuery(select);
            while (set.next()) {
                instruct.add(new Instructor(set.getInt("instructor_id"), set.getString("instructor_name"),
                        set.getString("instructor_email"),
                        set.getString("instructor_phone")));
            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return instruct;
    }

    @Override
    public boolean login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new NullException();
        }
        // TODO Auto-generated method stub
        Connection connect = db.load();

        // Create a statement to execute the SQL query
        Statement stmt;
        ResultSet rs;
        try {
            stmt = connect.createStatement();
            rs = stmt.executeQuery(
                    "SELECT instructor_email, instructor_password FROM instructors WHERE instructor_email='" + email
                            + "'");
            if (rs.next()) {
                // Get the password from the database
                String passwordFromDB = rs.getString("instructor_password");

                // Compare the password from the database with the entered password
                if (passwordFromDB.equals(password)) {
                    System.out.println("Login successful!");
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecet email or password!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Email not found!");

            }
            connect.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public ArrayList<String> getInstructorData(String email) {
        String select = "SELECT * FROM instructors WHERE instructor_email = '" + email + "'";
        ArrayList<String> instruct = new ArrayList<String>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            ResultSet set = state.executeQuery(select);
            while (set.next()) {
                instruct.add(set.getString("instructor_name"));
                instruct.add(set.getString("instructor_phone"));

            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return instruct;
    }

    public ArrayList<AssignedModule> assignedModuleView() {
        String query = "SELECT instructors.instructor_id, modules.module_name FROM instructors JOIN assigned_modules ON instructors.instructor_id = assigned_modules.instructor_id JOIN modules ON assigned_modules.module_id = modules.module_id;";
        ArrayList<AssignedModule> assignedModule = new ArrayList<AssignedModule>();
        try {

            PreparedStatement state = connect.prepareStatement(query);
            ResultSet set = state.executeQuery(query);
            while (set.next()) {
                assignedModule.add(new AssignedModule(set.getInt("instructor_id"), set.getString("module_name")));

            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return assignedModule;
    }

    public void changePassword(String email, String oldPassword, String newPassword) {
        try {
            // Verify the old password first
            PreparedStatement stmt = connect
                    .prepareStatement("SELECT instructor_password FROM instructors WHERE instructor_email = ?");
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if (!result.next() || !result.getString("instructor_password").equals(oldPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect old password!");
                return;
            }

            // Update the password if the old password is correct
            stmt = connect
                    .prepareStatement("UPDATE instructors SET instructor_password = ? WHERE instructor_email = ?");
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password changed successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void deleteInstructor(int id) {
        String query = "DELETE FROM instructors WHERE instructor_id = ?";
        String query1 = "DELETE FROM assigned_modules WHERE instructor_id = ?";
        try {
            PreparedStatement state1 = connect.prepareStatement(query1);
            PreparedStatement state = connect.prepareStatement(query);
            state1.setInt(1, id);
            state1.executeUpdate();
            state.setInt(1, id);
            state.executeUpdate();

            state.close();
            state1.close();
            JOptionPane.showMessageDialog(null, "Instructor deleted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addInstructor(String name, String email, String phone, String password) {
        String query = "INSERT INTO instructors (instructor_name, instructor_email, instructor_phone, instructor_password) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, name);
            state.setString(2, email);
            state.setString(3, phone);
            state.setString(4, password);
            state.executeUpdate();
            state.close();
            JOptionPane.showMessageDialog(null, "Instructor added successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generateReport(int studentId, int moduleId, int marks) throws SQLException {
        if (marks < 0 || marks > 100 || studentId == 0 || moduleId == 0) {
            throw new InvalidMarkException();

        }
        String sql = "INSERT INTO results (student_id, module_id, marks) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, studentId);
            statement.setInt(2, moduleId);
            statement.setInt(3, marks);
            statement.executeUpdate();
            statement.close();
            connect.close();
            JOptionPane.showMessageDialog(null, "Report generated successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
