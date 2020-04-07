SELECT countries.countryName , COUNT(confirmedCases.numCases) AS TOTAL_CASOS
FROM countries INNER JOIN confirmedCases ON countries.geoId = confirmedCases.geoId
GROUP BY countries.countryName
ORDER BY TOTAL_CASOS DESC LIMIT 3;
