package com.diseniosistemas.TP1_DSI.entity;

import com.diseniosistemas.TP1_DSI.util.Rol;

public class Usuario {

    private String idUsuario;

    private String nombreUsuario;

    private String contrasenia;

    private Rol rol;

    public Usuario(){

    }

    public Usuario(String idUsuario, String nombreUsuario, String contrasenia, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
