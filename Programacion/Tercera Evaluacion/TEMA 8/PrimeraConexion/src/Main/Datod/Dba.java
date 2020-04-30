package Main.Datod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dba {
    private final String SQL_DRIVER = "jdbc:mariadb://";
    private final String HOST = "192.168.1.52";
    private final String PORT = ":3306/";
    private Connection connection = null ;

    public Dba() {
    }

    public boolean conectar(String usuario, String pwd, String dba){
        try {
            connection = DriverManager.getConnection(SQL_DRIVER+HOST+PORT+dba , usuario , pwd);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean desconectar(){
        boolean operationOk = false;
        try{
            this.connection.close();
            operationOk = true;
        }catch (SQLException e){
            System.out.println(e);
        }
        return operationOk;
    }

}
