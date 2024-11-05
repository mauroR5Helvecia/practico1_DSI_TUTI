package com.diseniosistemas.TP1_DSI.servicio;

import com.diseniosistemas.TP1_DSI.entity.Producto;
import com.diseniosistemas.TP1_DSI.repository.ProductoRepositoryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioProducto {

    private final ProductoRepositoryImplement productoRepository;

    @Autowired
    public ServicioProducto(ProductoRepositoryImplement productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void agregarProducto(Producto producto) {
        productoRepository.save(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void eliminarProducto(String codigo) {
        productoRepository.deleteByCodigo(codigo);
        System.out.println("Producto eliminado con código: " + codigo);
    }

    public void listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        productos.forEach(System.out::println);
    }

    public Producto buscarProducto(String codigo) {
        return productoRepository.findByCodigo(codigo);
    }
}
