package com.diseniosistemas.TP1_DSI.controller;

import com.diseniosistemas.TP1_DSI.entity.Producto;
import com.diseniosistemas.TP1_DSI.servicio.ServicioProducto;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ProductoController {

    private final Scanner scanner = new Scanner(System.in);  // Scanner para manejar entradas en consola
    private final ServicioProducto servicioProducto;
    private boolean salir = false;

    // Inyección de dependencias: ServicioProducto es inyectado por el contenedor de Spring
    public ProductoController(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    // Método que muestra el menú y maneja las opciones
    public void mostrarMenu() {
        while (!salir) {
            System.out.println("\n--- Menú Administración de Productos ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> eliminarProducto();
                case 3 -> listarProductos();
                case 4 -> buscarProducto();
                case 5 -> salirDelMenu();
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void agregarProducto() {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        Producto producto = new Producto(codigo, nombre, precio, cantidad);
        servicioProducto.agregarProducto(producto);
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        String codigo = scanner.nextLine();
        servicioProducto.eliminarProducto(codigo);
    }

    private void listarProductos() {
        servicioProducto.listarProductos();
    }

    private void buscarProducto() {
        System.out.print("Ingrese el código del producto a buscar: ");
        String codigo = scanner.nextLine();
        Producto producto = servicioProducto.buscarProducto(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void salirDelMenu() {
        System.out.println("Saliendo del sistema de inventario...");
        salir = true;
    }
}


