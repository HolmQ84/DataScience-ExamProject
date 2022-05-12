package ds.front.Service;

import ds.front.Model.User;
import ds.front.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Cacheable(value="User", key="#userId")
    public User getOneInvoice(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    @Cacheable(value="User")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
