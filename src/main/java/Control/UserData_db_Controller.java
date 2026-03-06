package Control;

import Model.UserData_db;
import Model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserData_db_Controller {

    Connection connection = UserData_db.getUserConnection();

    PreparedStatement ps;

    public void insert_user(UserModel user) throws SQLException {
        ps = connection.prepareStatement("" + "INSERT INTO tbl_user (username, password) VALUES (?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getHashPassword());

        ps.executeUpdate();
    }

    public boolean select_user(UserModel user) throws SQLException {
        ps = connection.prepareStatement("" + "SELECT id_user FROM tbl_user WHERE username = ? AND password = ?");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getHashPassword());

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
    
    public int select_id_user(UserModel user) throws SQLException {
        ps = connection.prepareStatement("" + "SELECT id_user FROM tbl_user WHERE username = ? AND password = ?");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getHashPassword());

        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return rs.getInt("id_user");
        }
        
        return 0;
    }
}
