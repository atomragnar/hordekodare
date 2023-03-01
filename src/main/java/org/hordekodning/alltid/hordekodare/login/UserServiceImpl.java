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
        return userRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public boolean isEmailRegistered(String email) {
        return userRepository.findUserByEmail(email) != null ? true : false;
    }

    public int isLoginValid(String username, String password) {
        User user = userRepository.isUsernameValid(username);
        if (user == null) {
            return Constants.USERNAME_WRONG;
        }
        if (!user.getPassword().equals(password)) {
            return Constants.PASSWORD_WRONG;
        }
        return 0;
    }
    
}
