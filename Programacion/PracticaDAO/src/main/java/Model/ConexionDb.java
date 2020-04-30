
package Model;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionDb {
    private String db = "JavaDAO" ; 
    private String userDb = "JavaDAO"; 
    private String passwd = "JavaDAO_Test_Passwd"; 
    private final String URI = "jdbc:mariadb//sg1jasper.ddns.net:1001/"+ db; 
    

    public Connection getConnection(){
        Connection con = null; 
        
        try {
            con.DriverManager().
        } catch (Exception e) {
        }
        
        
        return con;
    }
}
