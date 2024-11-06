package com.diseniosistemas.TP1_DSI.controller;
import com.diseniosistemas.TP1_DSI.entity.Usuario;
import com.diseniosistemas.TP1_DSI.servicio.UsuarioServicio;
import com.diseniosistemas.TP1_DSI.util.Rol;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;

@Component
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;
    private Usuario usuarioActual; // Para fines practicos, almaceno el usuario de la sesion actual aca

    @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su DNI: ");
        Integer dni = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();

//        sOLO UN ADMINISTRADOR
        Rol rol;
        if (dni.equals(36670070) && contrasenia.equals("admin")) {
            rol = Rol.ADMINISTRADOR;
        } else {
            rol = Rol.CLIENTE;
        }

        Usuario nuevoUsuario = new Usuario(dni, nombreUsuario, contrasenia, rol, null);
        usuarioServicio.registrarUsuario(nuevoUsuario);
    }

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su DNI: ");
        Integer dni = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = usuarioServicio.buscarUsuarioPorDni(dni);
        if (usuario != null) {
            System.out.print("Ingrese su contraseña: ");
            String contrasenia = scanner.nextLine();

            if (usuario.getContrasenia().equals(contrasenia)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombreUsuario() + ".");
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada.");
    }

    public boolean usuarioAutenticado() {
        return usuarioActual != null;
    }
}
