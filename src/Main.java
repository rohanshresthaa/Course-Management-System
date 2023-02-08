import java.awt.EventQueue;

import database.ConnectionDB;
import database.DatabaseMGMT;
import gui.Login;
import gui.UpdateCourse;

public class Main {
	 public static void main(String[] args) {
		 DatabaseMGMT db = new DatabaseMGMT();
		 db.setUrl("jdbc:mysql://localhost:3306/cms");
		 db.setUsername("root");
		 db.setPassword("1234567890");
		 EventQueue.invokeLater(new Runnable() {
		 public void run() {
		 try {
		 Login window = new Login();
		 window.frame.setVisible(true);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 }
});
		 }
}
