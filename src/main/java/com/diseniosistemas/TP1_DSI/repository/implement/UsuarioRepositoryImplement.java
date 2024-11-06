package com.diseniosistemas.TP1_DSI.repository.implement;

import com.diseniosistemas.TP1_DSI.entity.Usuario;
import com.diseniosistemas.TP1_DSI.repository.UsuarioRepositoryInterfaz;
import com.diseniosistemas.TP1_DSI.util.DatabaseUtil;
import com.diseniosistemas.TP1_DSI.util.Rol;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImplement implements UsuarioRepositoryInterfaz {

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuarios (dni, nombreUsuario, contrasenia, rol) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getDni());
            stmt.setString(2, usuario.getNombreUsuario());
            stmt.setString(3, usuario.getContrasenia());
            stmt.setString(4, usuario.getRol().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

    @Override
    public void deleteUsuarioByDni(Integer dni) {
        String sql = "DELETE FROM usuarios WHERE dni = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dni);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario con DNI " + dni + " eliminado correctamente.");
            } else {
                System.out.println("Usuario con DNI " + dni + " no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAllUsuario() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setDni(rs.getInt("dni"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setRol(Rol.valueOf(rs.getString("rol")));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    @Override
    public Usuario findByDNI(Integer dni) {
        String sql = "SELECT * FROM usuarios WHERE dni = ?";
        Usuario usuario = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setDni(rs.getInt("dni"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setRol(Rol.valueOf(rs.getString("rol")));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
        }
        return usuario;
    }
}