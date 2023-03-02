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

    @Override
    public void saveUser(User user) {
        int index = getUserIndex(user.getId());
        if (index == Constants.NOT_FOUND) {
            userRepository.addUser(user);
        } else {
            userRepository.updateUser(index, user);
        }


    }

    @Override
    public User getUser(int index) {
        return userRepository.getUser(index);
    }

    @Override
    public User findUserByEmail(String email){ 
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return userRepository.findUserByEmail(email) != null;
    }

    public int isLoginValid(String username, String password) {
        User user = userRepository.isUsernameValid(username);
        if (user == null) {
            return Constants.USERNAME_WRONG;
        }
        if (!user.getPassword().equals(password)) {
            return Constants.PASSWORD_WRONG;
        }
        return Constants.NOT_FOUND;
    }

    @Override
    public int getUserIndex(String id) {
        for (int i = 0; i < getAllUsers().size(); i++) {
            if (userRepository.getUser(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    @Override
    public User getUserById(String id) {
        int index = getUserIndex(id);
        return index == Constants.NOT_FOUND ? new User() : getUser(index);

    }



}
