package org.hordekodning.alltid.hordekodare.login;

import java.util.List;




public interface UserService {

    User getNewUser();

    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> getAllUsers();

}
