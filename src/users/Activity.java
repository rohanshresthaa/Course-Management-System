package users;

import exception.InvalidCredintial;

public interface Activity {
    abstract boolean login(String email, String password) throws InvalidCredintial, Exception;
	abstract boolean logout();
}