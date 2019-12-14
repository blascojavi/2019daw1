		-- -- CREANDO BASE DE DATOS -- --
CREATE DATABASE duendes_sa char set = 'utf8'; 
use duendes_sa;  -- Seleccionando la base de datos --

		-- -- CREANDO TABLAS -- -- 
CREATE TABLE niños (
	id INT ,
    nombre VARCHAR(20) not null,
    apellido1 VARCHAR(20) not null, 
    apellido2 VARCHAR(20) not null,
    fecha_nacimiento DATE not null, 
    comportamiento ENUM('bien' , 'mal' ) not null, 
    id_hogar INT not null, 
    primary key (id)
);

CREATE TABLE hogares (
	id INT , 
    provincia VARCHAR(20) not null,
    localidad VARCHAR(20)not null,
    direccion VARCHAR(50)not null,
    portal INT(4)not null,
    piso INT(10)not null,
    planta INT(2)not null,
    codigo_postal INT(5)not null, 
    id_pais INT not null,
    PRIMARY KEY (id)
);

CREATE TABLE paises (
	id INT , 
    nombre VARCHAR(50) not null,
    PRIMARY KEY (id)
);

CREATE TABLE juguetes (
	id INT ,
    nombre VARCHAR(50) not null,
    descripcion VARCHAR(150),
    edad_recomendada INT(2) not null, 
    id_marca INT not null, 
    id_clase INT not null, 
    id_fabrica INT not null,
    PRIMARY KEY (id)
); 

CREATE TABLE marcas (
	id INT, 
	nombre VARCHAR(50) not null,
	id_fabrica INT not null, 
	primary key (id)
);

CREATE TABLE clases (
	id INT , 
    descripcion VARCHAR(150) not null,
    PRIMARY KEY (id)
);
    
CREATE TABLE fabricas (
	id INT ,
    nombre VARCHAR(50) not null,
    direccion VARCHAR(50) not null,
    provincia VARCHAR(50) not null, 
    pais VARCHAR(50) not null, 
    id_supervisor INT not null, 
    PRIMARY KEY (id)
);
    
CREATE TABLE almacenes (
	id INT , 
	nombre VARCHAR(50) not null,
    direccion VARCHAR(50) not null,
    provincia VARCHAR(50) not null, 
    pais VARCHAR(50) not null, 
    id_fabrica INT not null, 
    PRIMARY KEY (id)
);

CREATE TABLE duendes (
	id INT , 
    nombre VARCHAR(50)not null, 
    apodo VARCHAR(50) not null, 
    id_pais_destino INT not null, 
    id_supervisor INT not null, 
    PRIMARY KEY (id)
);

CREATE TABLE supervisores (
	id INT , 
	nombre VARCHAR(50)not null, 
    apodo VARCHAR(50) not null, 
PRIMARY KEY (id)
);

CREATE TABLE juguetes_niños (
	id_niño INT not null, 
    id_juguete INT not null, 
    PRIMARY KEY (id_niño , id_juguete)
);

CREATE TABLE almacenes_fabricas (
	id_almacen INT ,
    id_fabrica INT ,
    PRIMARY KEY (id_almacen , id_fabrica) 
);

		-- -- CREANDO RELACIONES -- --

-- JUGUETES NIÑOS --
ALTER TABLE juguetes_niños ADD constraint niño_juguete_FK 
								foreign key (id_niño)
								REFERENCES niños(id); 
ALTER TABLE juguetes_niños ADD constraint juguete_niño_FK 
								foreign key (id_juguete)
								REFERENCES juguetes(id);                                 
-- JUGUETES MARCA --
ALTER TABLE juguetes ADD constraint juguete_deMarca_FK
						 foreign key (id_marca)
                         REFERENCES marcas(id); 
-- JUGUETES CLASE (la clase se refiere a la temática del juguete) -- 
ALTER TABLE juguetes ADD constraint juguete_deClase_FK
						 foreign key (id_clase)
                         REFERENCES clases(id);

-- NIÑOS HOGAR --
ALTER TABLE niños ADD constraint hogar_niño_FK 
					  foreign key (id_hogar)
                      REFERENCES hogares(id); 
-- HOGAR PAIS --
ALTER TABLE hogares ADD constraint hogar_pais_FK 
					  foreign key (id_pais) 
                      REFERENCES paises(id); 
                      
-- DUENDE ASIGNADO A PAIS DE REPARTO -- 
ALTER TABLE duendes  ADD constraint pais_duende_FK 
						foreign key (id_pais_destino) 
                        REFERENCES paises(id); 
                        
-- DUENDE TIENE UN SUPERVISOR -- 
ALTER TABLE duendes ADD constraint duende_supervisor_FK 
						foreign key (id_supervisor)
                        REFERENCES supervisores(id); 
                        
-- SUPERVISOR FABRICA --
ALTER TABLE fabricas ADD constraint supervisor_fabrica_FK
						foreign key (id_supervisor)
                        REFERENCES supervisores(id); 

-- ALMACENES Y FABRICAS 
ALTER TABLE almacenes_fabricas ADD constraint fabricas_almacenan_FK
								foreign key (id_almacen)
                                REFERENCES almacenes(id);
ALTER TABLE almacenes_fabricas ADD constraint almacenes_fabricas_FK
								foreign key (id_fabrica)
                                REFERENCES fabricas(id); 

