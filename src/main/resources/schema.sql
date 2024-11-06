CREATE TABLE IF NOT EXISTS productos (
    codigo VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios (
    dni INT PRIMARY KEY,
    nombreUsuario VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(100) NOT NULL,
    rol ENUM('ADMINISTRADOR', 'CLIENTE') NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos (
    idPedido BIGINT AUTO_INCREMENT PRIMARY KEY,
    fechaPedido DATE NOT NULL,
    usuarioDni INT NOT NULL,
    FOREIGN KEY (usuarioDni) REFERENCES usuarios(dni)
);

CREATE TABLE IF NOT EXISTS pedido_productos (
    idPedido BIGINT,
    codigoProducto VARCHAR(50),
    cantidad INT NOT NULL,
    PRIMARY KEY (idPedido, codigoProducto),
    FOREIGN KEY (idPedido) REFERENCES pedidos(idPedido),
    FOREIGN KEY (codigoProducto) REFERENCES productos(codigo)
);
