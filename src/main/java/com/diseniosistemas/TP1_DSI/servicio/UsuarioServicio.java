package com.diseniosistemas.TP1_DSI.servicio;
import com.diseniosistemas.TP1_DSI.entity.Usuario;
import com.diseniosistemas.TP1_DSI.repository.UsuarioRepositoryInterfaz;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UsuarioServicio {

    private final UsuarioRepositoryInterfaz usuarioRepository;

    @Autowired
    public UsuarioServicio(UsuarioRepositoryInterfaz usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) {
        // Aquí puedes agregar lógica de validación antes de guardar el usuario
        usuarioRepository.save(usuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    public Usuario buscarUsuarioPorDni(Integer dni) {
        return usuarioRepository.findByDNI(dni);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAllUsuario();
    }

    public void eliminarUsuarioPorDni(Integer dni) {
        usuarioRepository.deleteUsuarioByDni(dni);
        System.out.println("Usuario con DNI " + dni + " eliminado exitosamente.");
    }
}
