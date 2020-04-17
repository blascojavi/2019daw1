<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicial</title>
    <link rel="stylesheet" type="text/css" href="./styles/styles.css">
</head>
    <body>
        <header class="header">
            <h1>COVID  XML </h1>
            <br>
            <h2><p>Data Miner</p></h2>
        </header>
        <?php

        echo ' <section>
                    <h3 class="change-color">Creando estructura de la base de datos</h3>
                    </section>';
        if(!generateTablesIfNotExists()){
            echo ' <section>
                    <h3 class="change-color">Base de datos generada correctamente...</h3>
                    </section>';
        }
        if(insertValuesOnDataBase()){
            echo ' <section>
                    <h3 class="change-color">Insertando datos de los registros, se paciente PUEDE TARDAR UN TIEMPO</h3>
                    </section>';
        }



        /*

        $dbIsPrepared = createTableReferences();
        if($dbIsPrepared){
            echo ' <section>
                    <h3 class="change-color">Base de datos generada correctamente...</h3>
                    </section>';

           $dataInserted =  insertValuesOnDataBase();
           if(!$dataInserted){
               echo ' <section>
                    <h3 class="change-color">Insertando datos en la base de datos.</h3>
                    </section>';
           }
        }else{
            echo ' <section>
                    <h3 class="change-color">FALLO AL CARGAR DE BASE DE DATOS</h3>
                    </section>';
        }

        if(true){

        }
*/
        ?>
    </body>
</html>

<?php

function generateTablesIfNotExists(){
    $conn = new mysqli("192.168.1.52:3306", "covidxml", "AindyCVCUCGmvee0", "covidxml");
    $tableDates = "CREATE TABLE IF NOT EXISTS dates(
                    id VARCHAR(8),
                    dayRegistred INT ,
                    monthRegistred INT , 
                    yearRegistred INT , 
                    PRIMARY KEY (id)
                     );";
    $tableConfirmedCases = "CREATE TABLE IF NOT EXISTS confirmedCases(
                            id INT AUTO_INCREMENT , 
                            dateId VARCHAR(8) NOT NULL , 
                            numCases INT , 
                            geoId VARCHAR(3) NOT NULL , 
                            PRIMARY KEY (id)
                            );";
    $tableDeaths = "CREATE TABLE IF NOT EXISTS deaths(
                    id INT AUTO_INCREMENT , 
                    dateId VARCHAR(8) NOT NULL , 
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
                   );
";
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
function insertValuesOnDataBase()
{
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

        (String)$dateId = $year . $month . $day;

        $stmDates = $conn->prepare("INSERT INTO dates(id,dayRegistred,monthRegistred,yearRegistred) VALUES(?,?,?,?)");
        if ($stmDates) {
            $stmDates->bind_param('siii', $dateId, $day, $month, $year);
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
        if ($stmConfirmedCases) {    echo "DATOS INTRODUCCIDOS CO";
            $stmConfirmedCases->bind_param('sis', $dateId, $confirmedCases, $geoId);
            $stmConfirmedCases->execute();
        } else {
            echo mysqli_error($stmConfirmedCases);
        }

        $stmDeaths = $conn->prepare("INSERT INTO deaths(dateId,numDeaths,geoId) VALUES(?,?,?)");
        if ($stmDeaths) {
            $stmDeaths->bind_param('sis', $dateId, $deaths, $geoId);
            $stmDeaths->execute();
        } else {
            echo mysqli_error($stmDeaths);
        }

    }
    return $conn->close();
    /*7319 registros insertados*/
}
?>