SELECT COUNT(dates.id) AS Dias0Casos , countries.countryName
FROM dates INNER JOIN confirmedCases ON dates.id = confirmedCases.dateId
INNER JOIN countries ON countries.geoId  = confirmedCases.geoId 
WHERE confirmedCases.numCases = 0 GROUP BY countries.countryName ORDER BY Dias0Casos DESC LIMIT 1;
