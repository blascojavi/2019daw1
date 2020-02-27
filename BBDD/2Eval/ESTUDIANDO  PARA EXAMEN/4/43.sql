/* 19 - SELECT salida , llegada FROM etapa WHERE netapa = (SELECT netapa FROM puerto ORDER BY pendiente DESC LIMIT 1 );*/

/* 20 - SELECT ciclista.dorsal , nombre FROM puerto , ciclista WHERE puerto.dorsal = ciclista.dorsal ORDER BY puerto.altura DESC LIMIT 2; */

/* 21 - SELECT nombre FROM ciclista ORDER BY edad  LIMIT 1 ; */

/* 22 - SELECT nombre FROM ciclista , etapa WHERE ciclista.dorsal = etapa.dorsal ORDER BY edad LIMIT 1; */

/* 23 - SELECT  nombre , nompuerto from ciclista , puerto WHERE  ciclista.dorsal = puerto.dorsal GROUP BY nombre HAVING COUNT(nombre) >= 2  ; */