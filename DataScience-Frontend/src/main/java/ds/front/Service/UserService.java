package ds.front.Service;

import ds.front.Model.User;

public interface UserService {
    User userLogin(int username, String password);
    User getUserById(int id);
}
