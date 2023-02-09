package users;

import exception.InvalidCredintial;

public interface Activity {
     boolean login(String email, String password) throws InvalidCredintial, Exception;

}