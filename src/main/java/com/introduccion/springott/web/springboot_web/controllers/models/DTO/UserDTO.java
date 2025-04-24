package com.introduccion.springott.web.springboot_web.controllers.models.DTO;

import com.introduccion.springott.web.springboot_web.controllers.models.User;


public class UserDTO {

    private String title;
    private User user;
    private String email; 

    public UserDTO() {
    }
    public UserDTO(String title, User user, String email) {
        this.title = title;
        this.user = user;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

}