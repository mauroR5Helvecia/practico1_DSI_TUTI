package com.diseniosistemas.TP1_DSI.entity;

import java.util.*;

public class Pedido {

    private Long idPedido;
    private Date fechaPedido;
    private Map<Producto, Integer> misProductosPedidos;
    private Integer usuarioDni;

    public Pedido() {
        this.misProductosPedidos = new HashMap<>();
    }

    public Pedido(Long idPedido, Date fechaPedido, Map<Producto, Integer> misProductosPedidos, Integer usuarioDni) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.misProductosPedidos = misProductosPedidos;
        this.usuarioDni = usuarioDni;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Map<Producto, Integer> getMisProductosPedidos() {
        return misProductosPedidos;
    }

    public void setMisProductosPedidos(Map<Producto, Integer> misProductosPedidos) {
        this.misProductosPedidos = misProductosPedidos;
    }

    public Integer getUsuarioDni() {
        return usuarioDni;
    }

    public void setUsuarioDni(Integer usuarioDni) {
        this.usuarioDni = usuarioDni;
    }
}

