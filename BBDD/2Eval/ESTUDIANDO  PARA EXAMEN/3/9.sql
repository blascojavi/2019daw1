create DATABASE tenda39 ; 
USE tenda39; 

CREATE TABLE tenda(
	id INT NOT NULL, 
    nom VARCHAR(50) NOT NULL, 
    direccion VARCHAR(50) NOT NULL, 
    contacte VARCHAR(50), 
    telefon INT , 
    CONSTRAINT PK_tenda PRIMARY KEY (id)
);

INSERT INTO tenda VALUES (1,'Pere','Valencia-FSLL',NULL,1111);
INSERT INTO tenda VALUES (5,'Pau','Barcelona',NULL,2222);
INSERT INTO tenda VALUES (33,'Joan','Valencia-C',NULL,3333);
INSERT INTO tenda VALUES (45,'Narcis','Mislata',NULL,4444);

