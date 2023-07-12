package controllers;

import play.data.validation.Constraints;

public class UserProcess {
    @Constraints.Required protected String email;
    protected String nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
