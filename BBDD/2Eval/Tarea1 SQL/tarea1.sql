CREATE DATABASE IF NOT EXISTS Tarea1 char set = 'utf8' COLLATE = 'utf8_spanish_ci'; 

use Tarea1; 

CREATE TABLE IF NOT EXISTS usuarios  (
	dni VARCHAR(9) not null  , 
    nombre VARCHAR(10) not null,
    apellido1 VARCHAR(10) not null,
    apellido2 VARCHAR(10) not null,
    fecha_Incorporacion DATE not null,
    PRIMARY KEY (dni)
)ENGINE= InnoDB; 

CREATE TABLE IF NOT EXISTS libros (
	isbn INT(13) not null , 
    extension INT(4) not null, 
    titulo VARCHAR(20) not null,
    editorial VARCHAR(20) not null,
    fecha_incorporacion DATE not null,
    PRIMARY KEY (isbn)
)ENGINE= InnoDB;

CREATE TABLE IF NOT EXISTS prestamo (
	usuario VARCHAR(9) not null,  	-- Empleamos el DNI como numero identificador de usuario --
    libro INT(13) not null,  -- Empleamos el ISBN como identificador del libro --
    fecha_inicio DATE not null,
    fecha_fin DATE not null,
    PRIMARY KEY (usuario , libro) 
)ENGINE=InnoDB;

-- Creacion de las relaciones en tre las tablas --

ALTER TABLE prestamo ADD CONSTRAINT dni_usuario_FK FOREIGN KEY (usuario) REFERENCES usuarios(dni);
ALTER TABLE prestamo ADD CONSTRAINT isbn_libro_FK FOREIGN KEY (libro) REFERENCES libros(isbn); 
