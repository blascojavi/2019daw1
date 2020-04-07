CREATE DATABASE covidxml; 
USE covidxml; 


CREATE TABLE IF NOT EXISTS dates(
	id INT AUTO_INCREMENT,
    day INT ,
    month INT , 
    year INT , 
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS confirmedCases(
	id INT AUTO_INCREMENT , 
    dateId INT NOT NULL , 
    numCases INT , 
    geoId VARCHAR(3) NOT NULL , 
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS deaths(
	id INT AUTO_INCREMENT , 
    dateId INT NOT NULL , 
    numDeaths INT , 
    geoId VARCHAR(3) NOT NULL , 
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS countries(
	geoId VARCHAR(3) NOT NULL, 
    countryName VARCHAR(20) , 
    countryCode VARCHAR(4), 
    PRIMARY KEY (geoId)
);
CREATE TABLE IF NOT EXISTS populationData(
	id INT AUTO_INCREMENT , 
    population INT , 
    geoId VARCHAR(3) NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE confirmedCases ADD CONSTRAINT confirmedCases_Date_PK FOREIGN KEY (dateId) REFERENCES dates(id); 
ALTER TABLE confirmedCases ADD CONSTRAINT confirmedCases_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId); 
ALTER TABLE deaths ADD CONSTRAINT deaths_Date_PK FOREIGN KEY (dateId) REFERENCES dates(id); 
ALTER TABLE deaths ADD CONSTRAINT deaths_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId);
ALTER TABLE populationData ADD CONSTRAINT population_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId);

