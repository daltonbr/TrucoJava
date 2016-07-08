package rc.unesp.br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to connect to the DataBase.
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class MySQLConnection {


    /**
     * Returns de Connection to the DataBase
     */
    public static Connection getConnection(){
        Connection connection = null;

        //Username and password for connection at the BD
        String username = "root";
        String password = "123456";

        //For mySQL connection We use the following String connection:
        // jdbc:mysql:<HOST>/<DB_NAME>
        //My host is "localhost" as I'm local
        //My bd_name is "bd_lcp"
        String urlBD = "jdbc:mysql://localhost/bd_truco";

        try {
            //This is used for dinamacally load the Driver (MySQL)
            Class.forName("com.mysql.jdbc.Driver");

            //Try to connect to the BD
            connection = DriverManager.getConnection(urlBD, username, password);
        } catch (ClassNotFoundException e) {
            //It was not possible to find the Driver
            e.printStackTrace();
        } catch (SQLException e) {
            //It was not possible to connect to the BD
            e.printStackTrace();
        }
        finally {
            return connection;
        }
    }
}
