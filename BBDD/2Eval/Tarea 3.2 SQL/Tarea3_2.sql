CREATE DATABASE IF NOT EXISTS Tarea3_2 CHAR SET = 'utf8' COLLATE = 'utf8_spanish_ci'; 
use Tarea3_2; 

CREATE TABLE IF NOT EXISTS proveedores (
	codigo INT auto_increment not null,
    direccion VARCHAR(50) not null,
    ciudad VARCHAR(20) not null,
    provincia VARCHAR(50) not null,
    PRIMARY KEY (codigo)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS categorias(
	codigo INT auto_increment not null,
    nombre VARCHAR(30),
    PRIMARY KEY (codigo)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS piezas (
	codigo INT auto_increment not null , 
    codigo_categoria INT not null,
    nombre VARCHAR(30) not null, 
    color VARCHAR(15) not null, 
    precio DOUBLE not null,
    PRIMARY KEY (codigo)
)ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS suministro_Pieza_Proveedor(
	codigo_proveedor INT not null,
    codigo_pieza INT not null, 
    cantidad INT not null,
    fecha DATE,
    PRIMARY KEY (codigo_proveedor , codigo_pieza)
)ENGINE=InnoDB;

-- CREACION DE RELACIONES --

ALTER TABLE piezas ADD CONSTRAINT pieza_categoria_FK 
					   FOREIGN KEY (codigo_categoria) 
                       REFERENCES categorias(codigo);

ALTER TABLE suministro_Pieza_Proveedor ADD CONSTRAINT proveedor_suministra_Pieza_FK 
											FOREIGN KEY (codigo_proveedor)
                                            REFERENCES proveedores(codigo);
                                            
ALTER TABLE suministro_Pieza_Proveedor ADD CONSTRAINT pieza_suministra_Proveedor_FK 
											FOREIGN KEY (codigo_pieza)
                                            REFERENCES piezas(codigo);