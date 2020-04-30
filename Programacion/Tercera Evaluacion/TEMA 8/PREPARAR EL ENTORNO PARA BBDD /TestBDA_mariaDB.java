package probandomysql;

import java.sql.*;

public class TestBDA_mariaDB {

    public static void main(String[] args) throws Exception {
        String bd = "parques";
        String login = "root";
        String password = "";

        String url = "jdbc:mariadb://localhost:3306/" + bd;

        try (Connection conn = DriverManager.getConnection(url, login, password)) {

            if (conn != null) {
                //CONECTADOS CON LA BDA REFERENCIADA POR URL, CON EL USUARIO LOGIN Y SU PASSWORD
                System.out.println("Conexion a base de datos " + url + " ... OK");
            }

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + bd);
            System.out.println("URL utilizada" + url);
            System.out.println("ERROR: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
