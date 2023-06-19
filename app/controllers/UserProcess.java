package controllers;

import play.data.validation.Constraints;

public class UserProcess {
    @Constraints.Required protected String email;
    protected String password;

    public UserProcess(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
