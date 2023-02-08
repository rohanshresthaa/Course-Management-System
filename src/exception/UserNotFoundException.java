package exception;

import java.sql.SQLException;

public class UserNotFoundException extends SQLException{
	public UserNotFoundException() {
		super("User not Found");
	}
}	
