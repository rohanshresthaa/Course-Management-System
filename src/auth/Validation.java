package auth;

import java.util.regex.Pattern;

import exception.InvalidFormat;
import exception.NullException;

public class Validation {
	public boolean emailCheck(String email) throws InvalidFormat, NullException {
		String patternString = "^(.+)@(.+)$";
		if (email == null) {
			throw new NullException();
		} else if (!Pattern.matches(patternString, email)) {
			throw new InvalidFormat();
		} else {
			return true;
		}
	}

	public boolean passCheck(String pass) throws InvalidFormat, NullException {
		String patternString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$";

		if (pass == null) {
			throw new NullException();
		} else if (!Pattern.matches(patternString, pass)) {
			throw new InvalidFormat();
		} else {
			return true;
		}

	}

	public boolean phoneCheck(String phone) throws InvalidFormat, NullException {
		String patternString = "[0-9]*{10}";
		if (phone == null) {
			throw new NullException();
		} else if (!Pattern.matches(patternString, phone)) {
			throw new InvalidFormat();
		} else {
			return true;
		}
	}

}
