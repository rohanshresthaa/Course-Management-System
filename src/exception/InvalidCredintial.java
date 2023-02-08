package exception;

import java.sql.SQLException;

public class InvalidCredintial extends SQLException{
		public InvalidCredintial() {
			super("Invalid Credintial");
		}
}
