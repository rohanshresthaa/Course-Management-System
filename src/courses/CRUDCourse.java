package courses;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import database.ConnectionDB;
import exception.NullException;

public class CRUDCourse {
    private Connection connect = null;
    private ConnectionDB db = new ConnectionDB();

    public CRUDCourse() {
        try {
            connect = db.load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createCourse(String courseName) {
        String query = "INSERT INTO courses(course_name) VALUES(?)";
        if(courseName.isEmpty()) {
        	throw new NullException();
        }
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, courseName);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course created successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't create the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteCourse(int courseId) {
        String module = "DELETE FROM modules WHERE course_id = ?";
        String query = "DELETE FROM courses WHERE course_id = ?";
        if (courseId == 0) {
            throw new NullException();
        }
        try {
            PreparedStatement state = connect.prepareStatement(query);
            PreparedStatement state2 = connect.prepareStatement(module);
            state2.setInt(1, courseId);
            state.setInt(1, courseId);
            state2.executeUpdate();
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course deleted successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't delete the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCourse(int courseId, String courseName) {
        if (courseName.equals("") || courseId == 0) {
            throw new NullException();
        }
        String query = "UPDATE courses SET course_name = ? WHERE course_id = ?";
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, courseName);
            state.setInt(2, courseId);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course updated successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't update the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
