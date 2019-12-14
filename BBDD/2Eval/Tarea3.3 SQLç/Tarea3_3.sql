CREATE DATABASE IF NOT EXISTS Tarea3_3 char set = 'utf8' COLLATE = 'utf8_spanish_ci'; 
use Tarea3_3; 

CREATE TABLE  IF NOT EXISTS sucursales(
	codigo_sucursal INT auto_increment not null,
    direccion VARCHAR(50) not null,
    ciudad VARCHAR(50) not null, 
    provincia VARCHAR(50) not null,
    telefono INT(9) not null,
	PRIMARY KEY (codigo_sucursal)
)ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS revistas(
	numero_registro INT auto_increment not null, 
    titulo VARCHAR(50) not null, 
    periodicidad VARCHAR(30) not null, 
    tipo VARCHAR(20) not null ,
    PRIMARY KEY (numero_registro)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Vende_Sucur_Revista (
	codigo_sucursal INT not null , 
    numero_registro_revista INT not null, 
    PRIMARY KEY (codigo_sucursal , numero_registro_revista)
)ENGINE= INNODB;

CREATE TABLE IF NOT EXISTS secciones  (
	id INT auto_increment not null , 
    numero_regisro_revista INT not null, 
    titulo VARCHAR(50) not null , 
    extension INT(4) not null , 
    PRIMARY KEY (id)
)ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS empleados  (
	id INT auto_increment not null, 
    codigo_sucursal INT not null , 
    nif VARCHAR(9) not null, 
    nombre VARCHAR(20) not null, 
    apellido1 VARCHAR(20) not null, 
    apellido2 VARCHAR(20) not null, 
    telefono INT(9),
    PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS  periodistas (
	id INT auto_increment not null , 
    nombre VARCHAR(20) not null, 
    apellido1 VARCHAR(20) not null, 
    apellido2 VARCHAR(20) not null, 
    telefono INT(9),
    especialidad VARCHAR(50) not null , 
    PRIMARY KEY (id)
)ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS escribe_Revista_Periodista (
	numero_registro_revista INT not null, 
    id_periodista INT not null, 
    PRIMARY KEY (numero_registro_revista , id_periodista)
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS numeros (
	id INT auto_increment not null , 
    numero_regisro_revista INT not null,
    fecha DATE not null, 
    numero_paginas INT(4) not null, 
    numero_ejemplares INT(10) not null, 
    PRIMARY KEY (id)
)ENGINE = InnoDB;

-- CREANDO RELACIONES --

ALTER TABLE empleados ADD constraint Sucursal_FK 
						  FOREIGN KEY (id) 
                          REFERENCES sucursales(codigo_sucursal); 
ALTER TABLE  Vende_Sucur_Revista ADD CONSTRAINT Vende_Revista_Sucursal_FK 
									 FOREIGN KEY (codigo_sucursal) 
                                     REFERENCES sucursales(codigo_sucursal); 
ALTER TABLE  Vende_Sucur_Revista ADD CONSTRAINT Vende_Sucursal_Revista_FK 
									 FOREIGN KEY (numero_registro_revista) 
                                     REFERENCES revistas(numero_registro);
ALTER TABLE secciones ADD CONSTRAINT seccion_revista_FK 
						  FOREIGN KEY (numero_regisro_revista) 
						  REFERENCES revistas(numero_registro); 
ALTER TABLE numeros ADD CONSTRAINT numero_Revista_FK 
						FOREIGN KEY (numero_regisro_revista) 
						REFERENCES revistas(numero_registro); 
ALTER TABLE escribe_Revista_Periodista ADD CONSTRAINT periodista_escribe_Revista_FK 
											FOREIGN KEY (numero_registro_revista) 
											REFERENCES revistas(numero_registro); 
ALTER TABLE escribe_Revista_Periodista ADD CONSTRAINT revista_escrita_Periodista_FK 
											FOREIGN KEY (id_periodista) 
											REFERENCES periodistas(id); 
							
					
									
                                     



