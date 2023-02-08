package courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.ConnectionDB;
import exception.NullException;

//module for courses
public class Result {
    public String moduleName;
    public int marks;
    ConnectionDB db = new ConnectionDB();
    Connection connect = db.load();

    public Result() {

        try {
            connect = db.load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Result(String moduleName, int marks) {
        this.moduleName = moduleName;
        this.marks = marks;
    }

    public ArrayList<Result> displayResult(int student_id) {
        if (student_id == 0) {
            throw new NullException();
        }
        ArrayList<Result> result = new ArrayList<Result>();
        String query = "SELECT modules.module_name, results.marks FROM modules JOIN results ON modules.module_id = results.module_id WHERE results.student_id = ? ";
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setInt(1, student_id);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                result.add(new Result(rs.getString("module_name"), rs.getInt("marks")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't display the result!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return result;

    }

}
