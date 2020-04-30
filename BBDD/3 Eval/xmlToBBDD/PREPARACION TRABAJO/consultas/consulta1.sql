SELECT countries.countryName AS PAÍS  , confirmedCases.numCases AS NUMERO_CASOS , dates.id AS FECHA
FROM dates INNER JOIN confirmedCases ON dates.id = confirmedCases.dateId RIGHT JOIN countries ON confirmedCases.geoId = countries.geoId 
ORDER BY numCases DESC LIMIT 3;