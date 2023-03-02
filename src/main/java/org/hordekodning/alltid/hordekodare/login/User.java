package org.hordekodning.alltid.hordekodare.login;


import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {


    private String id;
    @NotBlank(message = "Username should not be empty")
    private String username;
/*    @NotBlank(message = "First name should not be empty")
    private String firstName;
    @NotBlank(message = "Last name should not be empty")
    private String lastName;*/
    @NotBlank(message = "Email should not be empty")
    @Email
    private String email;
    @NotBlank(message = "Password should not be empty")
    private String password;

    
    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}
