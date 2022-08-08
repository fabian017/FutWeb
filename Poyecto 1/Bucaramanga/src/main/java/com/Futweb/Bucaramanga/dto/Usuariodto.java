package com.Futweb.Bucaramanga.dto;

import com.Futweb.Bucaramanga.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuariodto {

    private String nombre;
    private String correo;
    private String password;
    private String telefono;


    private String username;

    public Usuario getusuariofromdto() {
        Usuario user=new Usuario();
        user.setNombre(nombre);
        user.setCorreo(correo);
        user.setPassword(password);
        user.setTelefono(telefono);
        user.setUsername(username);
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
