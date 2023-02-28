package org.hordekodning.alltid.hordekodare.login;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Scope("singleton")
@Repository
public class UserRepository {

    //  could make a backup list for users.
    
    List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users.stream().toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void updateUser(int index, User user) {
        users.set(index, user);
    }

    public User getUser(int index) {
        return users.get(index);
    }


}
