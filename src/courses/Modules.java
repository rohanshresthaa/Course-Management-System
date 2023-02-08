package courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.ConnectionDB;

//model for modules
public class Modules {
    public int module_id;
    public String module_name;
    public int course_id;
    public String module_type;
    public Modules(int module_id, String module_name, int course_id, String module_type) {
        this.module_id = module_id;
        this.module_name = module_name;
        this.course_id = course_id;
        this.module_type = module_type;
    }
    private  Connection connect;
    ConnectionDB db = new ConnectionDB();
    //default constructor
    public Modules() {
        try {
            connect = db.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    	//getting modules
	public  ArrayList<Modules> getModules(){
		String select = "SELECT * FROM modules";
		ArrayList<Modules> module = new ArrayList<Modules>();
		try {
			PreparedStatement state = connect.prepareStatement(select);
			ResultSet set = state.executeQuery(select);
			while(set.next()) {
				module.add(new Modules(set.getInt("module_id"), set.getString("module_name"), set.getInt("course_id"), set.getString("module_type")));
			}
			state.executeQuery();
			state.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
		return module;
	}
    public void addModule(String module_name, int course_id, String module_type) {
        String insert = "INSERT INTO modules(module_name, course_id, module_type) VALUES(?,?,?)";
        try {
            PreparedStatement state = connect.prepareStatement(insert);
            state.setString(1, module_name);
            state.setInt(2, course_id);
            state.setString(3, module_type);
            state.executeUpdate();
            state.close();
            JOptionPane.showMessageDialog(null, "Module added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding module");
        }
    }
    public void deleteModule(int module_id) {
        String delete = "DELETE FROM modules WHERE module_id = ?";
        try {
            PreparedStatement state = connect.prepareStatement(delete);
            state.setInt(1, module_id);
            state.executeUpdate();
            state.close();
            JOptionPane.showMessageDialog(null, "Module deleted successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting module");
        }
    }
}
