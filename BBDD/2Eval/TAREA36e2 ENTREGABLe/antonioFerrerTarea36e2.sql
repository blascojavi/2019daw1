CREATE DATABASE IF NOT EXISTS tarea36e2AFL char set = 'utf8';
USE  tarea36e2AFL;

CREATE TABLE IF NOT EXISTS equipos (
	codigo INT AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL,
    stock INTEGER ,
    PRIMARY KEY (codigo) );
CREATE TABLE IF NOT EXISTS componentes (
	codigo INT AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL,
    stock INTEGER ,
    PRIMARY KEY (codigo) );
 CREATE TABLE IF NOT EXISTS clientes (
	id INT AUTO_INCREMENT,
    nif VARCHAR(9) NOT NULL,
	nombre VARCHAR(20) NOT NULL ,
	apellido1 VARCHAR(20) NOT NULL ,
    apellido2 VARCHAR(20) NOT NULL ,
    telefono VARCHAR(12) NOT NULL , /* EL TELEFONO PUEDE ACEPTAR EL CODIGO DE PAIS EJ españa +35000000000*/
    domicilio VARCHAR(60) NOT NULL ,
    ciudad VARCHAR(30) NOT NULL , 
    provincia VARCHAR(30) NOT NULl ,
    PRIMARY KEY (id) ); 
    
CREATE TABLE IF NOT EXISTS empleados (
	id INT AUTO_INCREMENT,
	id_seccion INT,
    nif VARCHAR(9) NOT NULL,
	nombre VARCHAR(20) NOT NULL ,
	apellido1 VARCHAR(20) NOT NULL ,
    apellido2 VARCHAR(20) NOT NULL ,
    PRIMARY KEY (id) );
    
CREATE TABLE IF NOT EXISTS secciones (
	id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id) );
    
CREATE TABLE IF NOT EXISTS consta (
	codigo_equipo INT NOT NULL,
    codigo_componente INT NOT NULL, 
    cantidad INT NOT NULL, 
    PRIMARY KEY (codigo_equipo,codigo_componente) );
    
CREATE TABLE IF NOT EXISTS compra_equipos (
	codigo_equipo INT NOT NULL , 
    id_cliente INT NOT NULL , 
    id_empleado INT NOT NULL , 
    fecha DATE NOT NULL ,
    cantidad INT NOT NULL,
    PRIMARY KEY (codigo_equipo, id_cliente, id_empleado));
CREATE TABLE IF NOT EXISTS compra_componentes (
	codigo_componente INT NOT NULL, 
    id_cliente INT NOT NULL, 
    id_empleado INT NOT NULL , 
    fecha DATE NOT NULL ,
    cantidad INT NOT NULL,
    PRIMARY KEY (codigo_componente, id_cliente, id_empleado));

ALTER TABLE consta ADD CONSTRAINT consta_equipo FOREIGN KEY (codigo_equipo) REFERENCES equipos(codigo); 
ALTER TABLE consta ADD CONSTRAINT consta_componente FOREIGN KEY (codigo_componente) REFERENCES componentes(codigo);
ALTER TABLE compra_equipos ADD CONSTRAINT compraEquipo_equipo FOREIGN KEY (codigo_equipo) REFERENCES equipos(codigo);
ALTER TABLE compra_equipos ADD CONSTRAINT compraEquipo_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id);
ALTER TABLE compra_equipos ADD CONSTRAINT compraEquipo_empleado FOREIGN KEY (id_empleado) REFERENCES empleados(id);
ALTER TABLE compra_componentes ADD CONSTRAINT compraComponente_componente FOREIGN KEY (codigo_componente) REFERENCES componentes(codigo);
ALTER TABLE compra_componentes ADD CONSTRAINT compraComponente_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id);
ALTER TABLE compra_componentes ADD CONSTRAINT compraComponenete_empleado FOREIGN KEY (id_empleado) REFERENCES empleados(id);
ALTER TABLE empleados ADD CONSTRAINT empleado_seccion FOREIGN KEY (id_seccion) REFERENCES secciones(id);


 
 
 
