package com.jesus.curso.springboot.webapp.springbootweb.models.dto;

import com.jesus.curso.springboot.webapp.springbootweb.models.User;

public class UserDto {
    private String title;
    private User user;

    //otra forma de ocupar el dto es pasandole los datos separados y no como un objeto de user
    private String name;
    private String lastName;

    private String fullName;

    


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    

}
