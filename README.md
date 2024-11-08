# Proyecto TP1_DSI

Este proyecto es un sistema de administración de productos desarrollado en **Java** utilizando **Spring Boot** como framework principal. Permite gestionar un inventario de productos mediante una interfaz de usuario en consola y se conecta a una base de datos **MySQL** para almacenar los datos de manera persistente.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
- **MySQL** como base de datos relacional

## Dependencias

El proyecto utiliza las siguientes dependencias:

- `spring-boot-starter-web`: Proporciona las capacidades de desarrollo web de Spring Boot.
- `mysql-connector-j`: Driver de MySQL para permitir la conexión a la base de datos.

Estas dependencias están especificadas en el archivo `pom.xml` y se instalan automáticamente al compilar el proyecto.

## Configuración de la Base de Datos

El sistema se conecta a una base de datos **MySQL** utilizando una conexión **JDBC**. La clase `DatabaseUtil` proporciona un método estático para establecer la conexión con la base de datos.

### Ejemplo de Código de Conexión

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/tp_dsi_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


Configuración de la Base de Datos en application.properties
La configuración de conexión a la base de datos en Spring Boot se define en el archivo application.properties de la siguiente manera:
spring.datasource.url=jdbc:mysql://localhost:3306/tp_dsi_db
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


## Funcionalidades del Proyecto


Este proyecto cumple su función únicamente a través de una interfaz de consola y está diseñado para realizar pruebas de funcionalidades básicas de administración de productos. Las funciones disponibles son las siguientes:

**Agregar Producto:** Permite agregar un nuevo producto al inventario.
**Eliminar Producto:** Elimina un producto del inventario según su código.
**Listar Productos:** Muestra una lista de todos los productos en el inventario.
**Buscar Producto:** Permite buscar un producto específico por su código.
Además, el proyecto cuenta con un menú de opciones adicionales para simular un sistema de solicitudes. Estas opciones están diseñadas para la interacción de un usuario de tipo cliente y un usuario de tipo administrador:

--- Aplicación de solicitud a viajante---
1. Registrarme
2. Iniciar Sesión
3. Ver administración de productos
4. Adquirir Productos
5. Mis Productos Solicitados
6. Salir


### Funcionalidades Adicionales
**Registrarme:** Permite a un usuario cliente registrarse en el sistema.
**Iniciar Sesión:** Permite a los usuarios iniciar sesión en el sistema.
**Ver Administración de Productos:** Accede a la funcionalidad de administración de productos descrita anteriormente (Agregar, Eliminar, Listar y Buscar productos).
**Adquirir Productos:** Opción para que un usuario cliente pueda solicitar productos disponibles.
**Mis Productos Solicitados:** Muestra los productos previamente solicitados por el usuario.
**Salir:** Finaliza la aplicación.

### Roles de Usuario
**Cliente:** Un usuario registrado como cliente puede iniciar sesión, solicitar productos y ver el historial de productos adquiridos.
**Administrador:** Existe un usuario administrador predeterminado, quien al iniciar sesión puede cargar, eliminar y administrar los productos del inventario en el sistema.

### Ejecución

Para ejecutar el proyecto:

Asegúrate de tener Java 17 y MySQL instalados y configurados.

Crea una base de datos en MySQL llamada tp_dsi_db.

Nota: Si estás utilizando un visualizador de base de datos como MySQL Workbench, debes crear la conexión como usuario root y luego crear el usuario admin con permisos sobre la base de datos tp_dsi_db. A continuación, se muestran los comandos necesarios para hacerlo en la consola de MySQL:

-- Conéctate a MySQL como root  
mysql -u root -p

-- Crear la base de datos  
CREATE DATABASE IF NOT EXISTS tp_dsi_db;

-- Crear el usuario admin con contraseña admin  
CREATE USER IF NOT EXISTS 'admin'@'localhost' IDENTIFIED BY 'admin';

-- Otorgar todos los privilegios sobre la base de datos al usuario admin  
GRANT ALL PRIVILEGES ON tp_dsi_db.* TO 'admin'@'localhost';

-- Aplicar los cambios de permisos  
FLUSH PRIVILEGES;


Modifica las credenciales de conexión en DatabaseUtil y application.properties si es necesario.

Ejecuta el proyecto desde tu IDE.

Notas
Este proyecto está diseñado para funcionar como una aplicación de consola y no incluye una interfaz gráfica o web. Toda la interacción se realiza a través de la consola, a fines practicos.




