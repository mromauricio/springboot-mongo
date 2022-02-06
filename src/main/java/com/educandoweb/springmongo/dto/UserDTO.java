package com.educandoweb.springmongo.dto;

import com.educandoweb.springmongo.domain.User;

import java.io.Serializable;

public class UserDTO  implements Serializable {
    private static final long serialversionUID = 1L;

    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User obj){
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
