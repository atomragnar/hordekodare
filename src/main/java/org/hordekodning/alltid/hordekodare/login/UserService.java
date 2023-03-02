package org.hordekodning.alltid.hordekodare.login;

import java.util.List;

import org.springframework.context.annotation.Bean;




public interface UserService {

    User getNewUser();

    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> getAllUsers();

    public boolean isEmailRegistered(String email);

    public int isLoginValid(String username, String password);

    public int getUserIndex(String id);

    public User getUserById(String id);

    public User getUser(int index);

}
