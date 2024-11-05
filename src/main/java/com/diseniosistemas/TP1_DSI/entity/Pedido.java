package com.diseniosistemas.TP1_DSI.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Long idPedido;

    private Date fechaPedido;

    private List<Producto> misProductosPedidos= new ArrayList<>();

    private Integer usuarioDni;


    public Pedido(){

    }

    public Pedido(Long idPedido, Date fechaPedido, List<Producto> misProductosPedidos, Integer usuarioDni) {
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

    public List<Producto> getMisProductosPedidos() {
        return misProductosPedidos;
    }

    public void setMisProductosPedidos(List<Producto> misProductosPedidos) {
        this.misProductosPedidos = misProductosPedidos;
    }

    public Integer getUsuarioDni() {
        return usuarioDni;
    }

    public void setUsuarioDni(Integer usuarioDni) {
        this.usuarioDni = usuarioDni;
    }
}
