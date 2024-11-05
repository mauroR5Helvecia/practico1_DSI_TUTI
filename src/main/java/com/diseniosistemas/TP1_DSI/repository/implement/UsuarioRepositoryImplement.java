package com.diseniosistemas.TP1_DSI.repository.implement;

import com.diseniosistemas.TP1_DSI.entity.Usuario;
import com.diseniosistemas.TP1_DSI.repository.UsuarioRepositoryInterfaz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImplement implements UsuarioRepositoryInterfaz {
    @Override
    public void save(Usuario usuario) {

    }

    @Override
    public void deleteUsuarioByDni(Integer dni) {

    }

    @Override
    public List<Usuario> findAllUsuario() {
        return null;
    }

    @Override
    public Usuario findByDNI(Integer dni) {
        return null;
    }
}
