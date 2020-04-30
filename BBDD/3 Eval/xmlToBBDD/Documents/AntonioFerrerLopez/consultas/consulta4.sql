SELECT countries.countryName 
FROM countries INNER JOIN deaths ON countries.geoId = deaths.geoId
WHERE deaths.numDeaths > 500 
GROUP BY countryName; 