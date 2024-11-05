package com.diseniosistemas.TP1_DSI;
import com.diseniosistemas.TP1_DSI.controller.ProductoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import java.util.Scanner;

@SpringBootApplication
public class Tp1DsiApplication implements CommandLineRunner {

	private final ProductoController productoController;

	@Autowired
	public Tp1DsiApplication(ProductoController productoController) {
		this.productoController = productoController;
	}

	public static void main(String[] args) {
		SpringApplication.run(Tp1DsiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Aplicación iniciada: Ejecutando el menú principal");
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("\n--- Aplicacion de solicitud a viajante---");
			System.out.println("1. Registrarme");
			System.out.println("2. Iniciar Sesion");
			System.out.println("3. Ver administracion de productos");
			System.out.println("4. Adquirir Productos");
			System.out.println("5. Mis Productos Solicitados");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion1 = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea

			switch (opcion1) {
				case 1 -> System.out.println("Todavia no hay nada 2");
				case 2 -> System.out.println("Todavia no hay nada 3");
				case 3 -> productoController.mostrarMenu();
				case 4 -> System.out.println("Todavia no hay nada 4");
				case 5 -> System.out.println("Todavia no hay nada 5");
				case 6 -> {
					System.out.println("Saliendo de la aplicación.");
					salir = true;
					System.exit(0);
				}
				default -> System.out.println("Opción no válida. Intente de nuevo.");
			}
		}
		scanner.close();
	}
}
