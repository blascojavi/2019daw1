CREATE DATABASE elperiodico ; 
USE elperiodico; 

CREATE TABLE periodista(
	id INT NOT NULL, 
    nombre VARCHAR(20) NOT NULL,
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50) NOT NULL,
    telefono INT NOT NULL, 
    especialidad VARCHAR(50) not null, 
    CONSTRAINT pk_periodista PRIMARY KEY (id) 
);

CREATE TABLE sucursal (
	codigo INT NOT NULL, 
    direccion VARCHAR (50) NOT NULL , 
    cuidad VARCHAR(50) NOT NULL , 
    provincia VARCHAR(50) NOT null ,
    telefono INT NOT NULL , 
    CONSTRAINT pk_sucursal PRIMARY KEY (codigo)
);

CREATE TABLE empleado (
	id INT NOT NULL , 
    codigo INT NOT NULL, 
    nif VARCHAR (9) not null, 
    nombre VARCHAR(20) NOT NULL,
	apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50) NOT NULL,
	telefono INT NOT NULL , 
    CONSTRAINT PK_empleado PRIMARY KEY (id),
    CONSTRAINT FK_empleado_Suscursal FOREIGN KEY (codigo) REFERENCES sucursal(codigo) 
    ON DELETE  cascade ON UPDATE cascade 
);
 
CREATE TABLE revista (
	nRegistro INT NOT NULL , 
    titulo VARCHAR(50) NOT NULL , 
    periodicidad INT NOT NULL, 
    tipo VARCHAR(50) NOT NULL,
    CONSTRAINT PK_revista PRIMARY KEY (nRegistro) 
);

CREATE TABLE vende (
	codigo INT NOT NULL, 
    nRegistro INT NOT NULL , 
    CONSTRAINT PK_vende PRIMARY KEY (codigo , nRegistro), 
    CONSTRAINT FK_vende_suscursal FOREIGN KEY (codigo) REFERENCES sucursal(codigo)
    ON DELETE cascade  ON UPDATE cascade , 
    CONSTRAINT FK_vende_revista FOREIGN KEY (nRegistro) REFERENCES revista(nRegistro)
    ON DELETE cascade  ON UPDATE cascade 
);

CREATE TABLE escribe (
	nRegistro INT NOT NULL, 
    idPeriodista INT NOT NULL, 
    CONSTRAINT PK_escribe PRIMARY KEY (nRegistro,idPeriodista), 
    CONSTRAINT FK_escribe_periodista FOREIGN KEY (idPeriodista) REFERENCES periodista(id)
    ON DELETE cascade  ON UPDATE cascade , 
    CONSTRAINT FK_escribe_revista FOREIGN KEY (nRegistro) REFERENCES revista(nRegistro)
    ON DELETE cascade  ON UPDATE cascade
);


CREATE TABLE seccion (
	id INT NOT NULL , 
    numRegistro INT NOT NULL , 
    titulo VARCHAR (50), 
    extension INT NOT NULL, 
    CONSTRAINT PK_seccion PRIMARY KEY (id) , 
    CONSTRAINT FK_seccion_Revista FOREIGN KEY (numRegistro) REFERENCES revista(nRegistro)
    ON DELETE cascade  ON UPDATE cascade
);

CREATE TABLE numero (
	id INT NOT NULL , 
    nRegistro INT NOT NULL , 
    fecha DATE NOT NULL, 
    nPaginas INT NOT NULL, 
    nEjemplares INT NOT NULL, 
    CONSTRAINT PK_numero PRIMARY KEY (id), 
    CONSTRAINT FK_numero_revista FOREIGN KEY (nRegistro) REFERENCES revista(nRegistro) 
    ON DELETE cascade  ON UPDATE cascade 
    );


















































