package org.hordekodning.alltid.hordekodare.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getNewUser() {
        return new User();
    }

    public void saveUser(User user) {
        userRepository.addUser(user);
    }

    public User findUserByEmail(String email){ 
        return new User();
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    
}
