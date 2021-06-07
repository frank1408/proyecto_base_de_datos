
//package modelo;
package com.sqlsamples;

public class LoginUser {
    
    private String nombre_de_usuario;
    private String password_de_usuario;
    private int miembro_id;
    
    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }
    
    public LoginUser(String username, String password){
        this.nombre_de_usuario = username;
        this.password_de_usuario = password;
        this.miembro_id = -1;
    }

    public String getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getPassword_de_usuario() {
        return password_de_usuario;
    }

    public void setPassword_de_usuario(String password_de_usuario) {
        this.password_de_usuario = password_de_usuario;
    }
    
}
