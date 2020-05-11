package EjercicioGuardarBBDD.CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private final String JDBC_DRIVER =  "jdbc:mariadb://";
    private final String SERVER =  "192.168.1.52";
    private final String PORT =  ":3306";
    private final String DATABASE =  "/parques";
    private final String USER_NAME =  "javaPruebas";
    private final String PASSWD =  "zIRSvXHPVfPBN8uT";

    public Connection connectToDb () throws SQLException {
         Connection conn = DriverManager.getConnection(JDBC_DRIVER+SERVER+PORT+DATABASE,USER_NAME,PASSWD);
        return conn;
    }


}
