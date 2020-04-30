CREATE DATABASE  IF NOT EXISTS `parques`;
USE `parques`;



CREATE TABLE `comunidad` (
  `id` smallint(5) unsigned NOT NULL ,
  `nombre` char(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



LOCK TABLES `comunidad` WRITE;

INSERT INTO `comunidad` VALUES (1,'Andalucia'),(2,'Aragon'),(3,'Castilla La Mancha'),(4,'Canarias'),(5,'Comunidad Valenciana');

UNLOCK TABLES;



CREATE TABLE `parque` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` char(60) NOT NULL,
  `extension` double DEFAULT NULL,
  `idComunidad` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comunidad_idx` (`idComunidad`),
  CONSTRAINT `comunidad` FOREIGN KEY (`idComunidad`) REFERENCES `comunidad` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;



LOCK TABLES `parque` WRITE;

INSERT INTO `parque` VALUES (1,'Doñaña',54204,1),(2,'Ordesa',16608,2),(3,'Teide',18990,4),(4,'timanfaya',5990,4),(5,'Tablas de Daimiel',3030,3),(6,'Albufera',21120,5),(7,'Hoces del Cabriel',31446,5);

UNLOCK TABLES;


