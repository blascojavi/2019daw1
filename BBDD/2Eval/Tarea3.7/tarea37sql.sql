CREATE DATABASE IF NOT EXISTS tasca37 ; 
USE tasca37; 

CREATE TABLE vehicle (
	matricula VARCHAR(7) not null , 
    marca VARCHAR(20) not null , 
    model VARCHAR(20) not null ,
    persona INTEGER , 
    PRIMARY KEY (matricula)
);

CREATE TABLE empleat (
	id INTEGER not null , 
    nom VARCHAR(20) not null ,
    dni VARCHAR(9) not null , 
    cap INTEGER , 
    PRIMARY KEY (id) 
);

CREATE TABLE assignacio (
	id INTEGER not null, 
    codigo INTEGER not null,
    PRIMARY KEY (id)
);

CREATE TABLE projecte(
	codigo INT not null, 
    nombre VARCHAR(20),
    PRIMARY KEY (codigo)
);


ALTER TABLE assignacio ADD 
	CONSTRAINT projecte_asignacio 
	FOREIGN KEY (codigo) 
	REFERENCES projecte(codigo) 
	ON DELETE cascade ON UPDATE CASCADE; 
ALTER TABLE assignacio ADD 
	CONSTRAINT empleats_asignats
    FOREIGN KEY (id) 
    REFERENCES empleat(id) 
    ON DELETE cascade ON UPDATE CASCADE;    
    
ALTER TABLE vehicle ADD 
CONSTRAINT empleado_VehiculoAsignado 
FOREIGN KEY (persona)
REFERENCES empleat(id)
ON DELETE no action  ON UPDATE cascade; 
ALTER TABLE empleat ADD 
	CONSTRAINT empleado_ES_jefe 
    FOREIGN KEY (cap)
    REFERENCES empleat(id)
    ON DELETE no action ON UPDATE cascade; 
    
    

