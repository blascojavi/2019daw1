CREATE DATABASE IF NOT EXISTS preexamen; 
USE preexamen; 

CREATE TABLE maillot(
codigo VARCHAR(5) not null , 
tipo VARCHAR(20) not null, 
premio INTEGER , 
color VARCHAR(25) not null, 
CONSTRAINT pk_mallot PRIMARY KEY(codigo)
);
CREATE TABLE equipo (
nomeq VARCHAR(20) not null , 
director VARCHAR(20) not null ,
CONSTRAINT pk_equipo PRIMARY KEY (nomeq)
);
CREATE TABLE ciclista(
dorsal INTEGER not null , 
nombre VARCHAR(20) not null, 
edad INTEGER not null , 
nomeq VARCHAR(20) not null , 
CONSTRAINT pk_ciclista PRIMARY KEY (dorsal),
CONSTRAINT fk_ciclista_Equipo FOREIGN KEY (nomeq) REFERENCES equipo(nomeq) ON DELETE cascade
ON UPDATE cascade
); 
CREATE TABLE etapa (
netapa INTEGER not null,
km FLOAT NOT NULL, 
salida VARCHAR(50) not null , 
llegada VARCHAR(50) NOT NULL, 
dorsal INTEGER not null, 
CONSTRAINT pk_etapa PRIMARY KEY (netapa), 
CONSTRAINT fk_etapa_ciclista FOREIGN KEY (dorsal) REFERENCES ciclista(dorsal) ON DELETE cascade
ON UPDATE cascade
);
CREATE TABLE puerto (
nompuerto VARCHAR(50) not null , 
altura FLOAT not null , 
categoria VARCHAR(1) not null, 
pendiente FLOAT not null , 
netapa INTEGER not null , 
dorsal INTEGER not null, 
Constraint pk_puerto PRIMARY KEY (nompuerto),
CONSTRAINT fk_puerto_etapa FOREIGN KEY (netapa) REFERENCES etapa(netapa)ON DELETE cascade
ON UPDATE cascade ,
CONSTRAINT fk_puerto_ciclista FOREIGN KEY(dorsal) REFERENCES ciclista(dorsal) ON DELETE cascade
ON UPDATE cascade
);
CREATE TABLE llevar (
dorsal INTEGER not null , 
netapa INTEGER not null , 
codigo VARCHAR(5) not null , 
CONSTRAINT pk_llevar PRIMARY KEY (netapa,dorsal), 
CONSTRAINT fk_llevar_maillot FOREIGN KEY (codigo) REFERENCES maillot(codigo) ON DELETE cascade
ON UPDATE cascade, 
CONSTRAINT fk_llevar_etapa FOREIGN KEY(netapa) REFERENCES etapa(netapa) ON DELETE cascade
ON UPDATE cascade,
CONSTRAINT fk_llevar_ciclista FOREIGN KEY(dorsal) REFERENCES ciclista(dorsal) ON DELETE cascade
ON UPDATE cascade
); 
 