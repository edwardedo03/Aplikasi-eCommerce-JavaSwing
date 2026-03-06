package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShoppingCart_db {

    private static Connection connection;

    public ShoppingCart_db() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shoppingcart", "root", "");
        } catch (SQLException ex) {
            System.getLogger(ShoppingCart_db.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static Connection getConnection() {
        
        if (connection == null) {
            new ShoppingCart_db();
        }
        
        return connection;
    }
    
}
