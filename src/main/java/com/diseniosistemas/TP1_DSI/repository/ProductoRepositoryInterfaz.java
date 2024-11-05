package com.diseniosistemas.TP1_DSI.repository;

import com.diseniosistemas.TP1_DSI.entity.Producto;

import java.util.List;

public interface ProductoRepositoryInterfaz {

    void save(Producto producto);

    void deleteByCodigo(String codigo);

    List<Producto> findAll();

    Producto findByCodigo(String codigo);
}