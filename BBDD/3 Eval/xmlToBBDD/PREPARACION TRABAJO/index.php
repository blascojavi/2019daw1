<?php
    generateTablesIfNotExists();
    $dbIsPrepared = createTableReferences();
    if($dbIsPrepared){
        echo "Insertando datos en la base de datos-->>>";
        insertValuesOnDataBase();
        echo "DATOS INSERTADOS CORRECTAMENTE";
    }else{
        echo "LA BASE DE DATOS NO ESTA LISTA.";
    }
    function generateTablesIfNotExists(){
        $conn = new mysqli("192.168.1.52:3306", "covidxml", "AindyCVCUCGmvee0", "covidxml");
        $tableDates = "CREATE TABLE IF NOT EXISTS dates(
                        id DATE,
                        dayRegistred INT ,
                        monthRegistred INT , 
                        yearRegistred INT , 
                        PRIMARY KEY (id)
                         );";
        $tableConfirmedCases = "CREATE TABLE IF NOT EXISTS confirmedCases(
                                id INT AUTO_INCREMENT , 
                                dateId DATE NOT NULL , 
                                numCases INT , 
                                geoId VARCHAR(3) NOT NULL , 
                                PRIMARY KEY (id)
                                );";
        $tableDeaths = "CREATE TABLE IF NOT EXISTS deaths(
                        id INT AUTO_INCREMENT , 
                        dateId DATE NOT NULL , 
                        numDeaths INT , 
                        geoId VARCHAR(3) NOT NULL , 
                        PRIMARY KEY (id)
                        );";
        $tableCountries = "CREATE TABLE IF NOT EXISTS countries(
                        geoId VARCHAR(3) NOT NULL, 
                        countryName VARCHAR(20) , 
                        countryCode VARCHAR(4), 
                        PRIMARY KEY (geoId)
                        );";
        $tablePopulationData = "CREATE TABLE IF NOT EXISTS populationData(
                        id INT AUTO_INCREMENT , 
                        populationCountry INT , 
                        geoId VARCHAR(3) NOT NULL, 
                        PRIMARY KEY (id)
                       );";

        $allTables = $tableDates . $tableConfirmedCases . $tableDeaths . $tableCountries . $tablePopulationData;
        try{
            mysqli_multi_query($conn , $allTables);
        }catch(mysqli_sql_exception $e){
            echo "Error al crear las tablas :  " . $e;
        } finally {
           mysqli_close($conn);
        }
    }

    function createTableReferences(){
        $conn = new mysqli("192.168.1.52:3306", "covidxml", "AindyCVCUCGmvee0", "covidxml");
        $tableReferences = "ALTER TABLE confirmedCases ADD CONSTRAINT confirmedCases_Date_PK FOREIGN KEY (dateId) REFERENCES dates(id); 
                            ALTER TABLE confirmedCases ADD CONSTRAINT confirmedCases_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId); 
                            ALTER TABLE deaths ADD CONSTRAINT deaths_Date_PK FOREIGN KEY (dateId) REFERENCES dates(id); 
                            ALTER TABLE deaths ADD CONSTRAINT deaths_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId);
                            ALTER TABLE populationData ADD CONSTRAINT population_Country_PK FOREIGN KEY (geoId) REFERENCES countries(geoId);
                            ";
        try {
            mysqli_multi_query($conn, $tableReferences);
        }catch (mysqli_sql_exception $e){
            echo "Fallo al crear las referencias :  " . $e;
        } finally {
          return mysqli_close($conn);
        }
    }

    function insertValuesOnDataBase(){
        $conn = new mysqli("192.168.1.52:3306", "covidxml", "AindyCVCUCGmvee0", "covidxml");
        $xml = simplexml_load_file("Casos.xml") or die("Error: No se puede cargar el fichero xml");

        foreach ($xml->children() as $fila) {
            $day = $fila->day;
            $month = $fila->month;
            $year = $fila->year;
            $confirmedCases = $fila->cases;
            $deaths = $fila->deaths;
            $countriesName = $fila->countriesAndTerritories;
            $geoId = $fila->geoId;
            $countryCode = $fila->countryterritoryCode;
            $population = $fila->popData2018;

            $dateFormatted = $year."-".$month."-".$day;
            if($month < 10 ){
                $month = str_pad($month, 1, "0", STR_PAD_LEFT);
            }
            $stmDates = $conn->prepare("INSERT INTO dates(id,dayRegistred,monthRegistred,yearRegistred) VALUES(?,?,?,?)");
            if ($stmDates) {
                $stmDates->bind_param('siii', $dateFormatted, $day, $month, $year);
                $stmDates->execute();
            } else {
                echo mysqli_error($stmDates);
            }
            $stmCountries = $conn->prepare("INSERT INTO countries(geoId,countryName,countryCode) VALUES(?,?,?)");
            if ($stmCountries) {
                $stmCountries->bind_param('sss', $geoId, $countriesName, $countryCode);
                $stmCountries->execute();
            } else {
                echo mysqli_error($stmCountries);
            }
            $stmPopulation = $conn->prepare("INSERT INTO populationData(populationCountry,geoId) VALUES(?,?)");
            if ($stmPopulation) {
                $stmPopulation->bind_param('is', $population, $geoId);
                $stmPopulation->execute();
            } else {
                echo mysqli_error($stmPopulation);
            }

            $stmConfirmedCases = $conn->prepare("INSERT INTO confirmedCases(dateId,numCases,geoId) VALUES(?,?,?)");
            if ($stmConfirmedCases) {
                $stmConfirmedCases->bind_param('sis', $dateFormatted, $confirmedCases, $geoId);
                $stmConfirmedCases->execute();
            } else {
                echo mysqli_error($stmConfirmedCases);
            }

            $stmDeaths = $conn->prepare("INSERT INTO deaths(dateId,numDeaths,geoId) VALUES(?,?,?)");
            if ($stmDeaths) {
                $stmDeaths->bind_param('sis', $dateFormatted, $deaths, $geoId);
                $stmDeaths->execute();
            } else {
                echo mysqli_error($stmDeaths);
            }
        }

        $conn->close();
    }

?>