package org.hordekodning.alltid.hordekodare.login;

import jakarta.annotation.Generated;
import java.util.UUID;

public class User {


    private String id;
    private String name;
    private String email;
    private String password;

    // Can addera en lista för att definera hur man ska formatera det i SQL databas

    
    public User() {
        this.id = UUID.randomUUID().toString();
    
    }

    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
