package com.diseniosistemas.TP1_DSI.repository;

import com.diseniosistemas.TP1_DSI.entity.Pedido;
import com.diseniosistemas.TP1_DSI.entity.Usuario;

import java.util.List;

public interface PedidoRepositoryInterfaz {


        void save(Pedido pedido);

        void deletePedido(Long idPedido);

        List<Pedido> findAllPedidosPorUsuario(Integer dni);

        Pedido findByPedido(Long idPedido);

        List<Pedido> findAllPedidosRealizadosPorCliente();






}
