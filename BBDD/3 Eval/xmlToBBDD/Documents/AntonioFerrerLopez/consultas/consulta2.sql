SELECT SUM(numCases) AS TOTAL_CASOS
FROM confirmedCases
WHERE geoId LIKE "ES" OR  geoId LIKE "FR" OR geoId LIKE "IT" 
LIMIT 7320;