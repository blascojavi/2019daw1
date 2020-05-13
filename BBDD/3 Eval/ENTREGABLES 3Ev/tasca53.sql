/*CREACIÓN DE BASE DE DATOS Y TABLAS*/
CREATE DATABASE tienda;
USE tienda;
CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    email VARCHAR(60) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE productos (
    idProducto INT AUTO_INCREMENT,
    descripcion VARCHAR(120) NOT NULL,
    precio DOUBLE NOT NULL,
    PRIMARY KEY (idProducto)
);

CREATE TABLE compras (
    idCompra INT AUTO_INCREMENT,
    descripcion VARCHAR(120) NOT NULL DEFAULT "SIN DESCRIPCIÓN",
    importe DOUBLE NOT NULL,
    idUsuario INT NOT NULL,
    idProducto INT NOT NULL,
    fechaHoraCompra TIMESTAMP,
    PRIMARY KEY (idCompra),
    CONSTRAINT compra_usuario_FK FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
    CONSTRAINT compra_Producto_FK FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

/*INSERCIONES*/
INSERT INTO usuarios (nombre,email,direccion) VALUES ("Ozores" , "nohijano@losbingueros.es" , "calle del destape 1");
INSERT INTO usuarios (nombre,email,direccion) VALUES ("Faemino" , "elQueTienePelo@faeminoycansado.com" , "avenida del humor inteligente 22");
INSERT INTO usuarios (nombre,email,direccion) VALUES ("Monty Pyton S.A " , "montyPyton@monty.com" , "calle del sentido de la vida 42 ");

INSERT INTO productos (descripcion, precio) VALUES ("Curso de iniciación al humor" , 250);
INSERT INTO productos (descripcion, precio) VALUES ("Pack de libros sobre Como ser director de cine y no morir en el intento" , 89);
INSERT INTO productos (descripcion, precio) VALUES ("Yate + derechos de amarre en las Maldivas" , 889900001);

/*PRIVILEGIOS*/
GRANT SELECT(idCompra,descripcion,importe) ON tienda.compras TO propietario@'localhost'  IDENTIFIED BY  'propietarioPWD';
GRANT SELECT ON tienda.usuarios TO almacen1@'localhost' IDENTIFIED BY  'almacenista';
GRANT SELECT ON tienda.compras TO almacen1@'localhost'  IDENTIFIED BY  'almacenista';
GRANT UPDATE(importe) ON tienda.compras TO almacen1@'localhost' IDENTIFIED BY  'almacenista';


/*CREACIÓN DEL TRIGGER PARA LA AUTO-INSERCIÓN DEL REGISTRO DE LA COMPRA.*/
DELIMITER //
    CREATE TRIGGER registraCompra_AI BEFORE INSERT ON compras
		FOR EACH ROW
        BEGIN
        DECLARE precioProducto DOUBLE;
        SET precioProducto = (SELECT productos.precio FROM productos WHERE idProducto = NEW.idProducto);
			SET NEW.fechaHoraCompra = NOW() , NEW.importe = precioProducto ;
		END
// DELIMITER


/*CREACIÓN DEL PROCEDIMIENTO ALMACENADO PARA CÁLCULO DEL IMPORTE TOTAL DEL PEDIDO*/
DELIMITER //
  create procedure calculoImporteConGastos(in transportista VARCHAR(20), idCompraRealizada int)
    begin
        case transportista
          when "seur" then UPDATE compras SET importe = (importe + 6.18) WHERE idCompra = idCompraRealizada;
          when "MRW" then UPDATE compras SET importe = (importe + 9.99) WHERE idCompra = idCompraRealizada;
          when "UPS" then UPDATE compras SET importe = (importe + 3.80) WHERE idCompra = idCompraRealizada;
          when "NACEX" then UPDATE compras SET importe = (importe + 5.28) WHERE idCompra = idCompraRealizada;
          when "CORREOS" then UPDATE compras SET importe = (importe + 666.66) WHERE idCompra = idCompraRealizada;
          else UPDATE compras SET importe = (importe + 1.80) WHERE idCompra = idCompraRealizada;
        end case;
    end;
DELIMITER ;