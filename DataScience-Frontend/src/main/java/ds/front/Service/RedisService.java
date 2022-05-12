package ds.front.Service;

import ds.front.Model.User;

import java.util.List;

public interface RedisService {
    public User saveUser(User user);
    public User getOneInvoice(Integer userId);
    public List<User> getAllUsers();
}
