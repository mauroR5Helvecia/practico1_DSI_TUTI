package com.diseniosistemas.TP1_DSI.repository.implement;

import com.diseniosistemas.TP1_DSI.entity.Pedido;
import com.diseniosistemas.TP1_DSI.repository.PedidoRepositoryInterfaz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepositoryImplement implements PedidoRepositoryInterfaz {
    @Override
    public void save(Pedido pedido) {

    }

    @Override
    public void deletePedido(Long idPedido) {

    }

    @Override
    public List<Pedido> findAllPedidosPorUsuario(Integer dni) {
        return null;
    }

    @Override
    public Pedido findByPedido(Long idPedido) {
        return null;
    }

    @Override
    public List<Pedido> findAllPedidosRealizadosPorCliente() {
        return null;
    }
}
