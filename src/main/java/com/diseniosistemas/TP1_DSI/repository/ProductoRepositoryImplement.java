package com.diseniosistemas.TP1_DSI.repository;

import com.diseniosistemas.TP1_DSI.entity.Producto;
import com.diseniosistemas.TP1_DSI.util.DatabaseUtil;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImplement implements ProductoRepositoryInterfaz {

    @Override
    public void save(Producto producto) {
        String sql = "INSERT INTO productos (codigo, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }
    }

    @Override
    public void deleteByCodigo(String codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public Producto findByCodigo(String codigo) {
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        Producto producto = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return producto;
    }
}
