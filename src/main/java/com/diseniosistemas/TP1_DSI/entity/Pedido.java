package com.diseniosistemas.TP1_DSI.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Long idPedido;

    private Date fechaPedido;

    private List<Producto> misProductosPedidos= new ArrayList<>();

    private Usuario usuarioQueHaceElPedido;


}
