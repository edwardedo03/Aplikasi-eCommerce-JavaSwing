package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserData_db {
    
    private static Connection connection;
    
    public UserData_db() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shoppingcart", "root", "");
        } catch (SQLException ex) {
            System.getLogger(UserData_db.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static Connection getUserConnection() {
        
        if (connection == null) {
            new UserData_db();
        }
        
        return connection;        
    }
    
    
}
