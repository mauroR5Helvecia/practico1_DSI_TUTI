package com.diseniosistemas.TP1_DSI.repository;
import com.diseniosistemas.TP1_DSI.entity.Producto;
import com.diseniosistemas.TP1_DSI.entity.Usuario;
import java.util.List;

public interface UsuarioRepositoryInterfaz {
    void save(Usuario usuario);

    void deleteUsuarioByDni(Integer dni);

    List<Usuario> findAllUsuario();

    Usuario findByDNI(Integer dni);



}
