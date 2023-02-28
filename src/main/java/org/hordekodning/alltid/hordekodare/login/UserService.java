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

 /*    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } */

}
