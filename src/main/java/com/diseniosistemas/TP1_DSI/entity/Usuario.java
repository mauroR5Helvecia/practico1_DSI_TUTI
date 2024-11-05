package com.diseniosistemas.TP1_DSI.entity;

import com.diseniosistemas.TP1_DSI.util.Rol;

import java.util.List;

public class Usuario {

    private Integer dni;

    private String nombreUsuario;

    private String contrasenia;

    private Rol rol;

    private List<Pedido> misListaDePedidos;


    public Usuario(){

    }

    public Usuario(Integer dni, String nombreUsuario, String contrasenia, Rol rol, List<Pedido> misListaDePedidos) {
        this.dni = dni;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.misListaDePedidos= misListaDePedidos;
    }

    public List<Pedido> getMisListaDePedidos() {
        return misListaDePedidos;
    }

    public void setMisListaDePedidos(List<Pedido> misListaDePedidos) {
        this.misListaDePedidos = misListaDePedidos;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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
