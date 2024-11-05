CREATE TABLE IF NOT EXISTS productos (
    codigo VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL
);