package Control;

import Model.ItemModel;
import Model.ShoppingCartModel;
import Model.ShoppingCart_db;
import Model.UserSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JLabel;

public class ShoppingCart_db_Controller {

    Connection connection = ShoppingCart_db.getConnection();

    PreparedStatement ps;

    public void insert_db(ItemModel item) {
        try {
            ps = connection.prepareStatement("" + "INSERT INTO tbl_cart (nama, jumlah, harga, totalHargaItem, user_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, item.getNama());
            ps.setInt(2, item.getJumlah());
            ps.setInt(3, item.getHarga());
            ps.setDouble(4, item.getTotalHargaItem());
            ps.setInt(5, UserSession.getId_session());

            if (ps.executeUpdate() > 0) {
                System.out.println("berhasil");
            } else {
                System.out.println("gagal");
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void updateItem_db(ItemModel item) {
        try {
            ps = connection.prepareStatement("" + "UPDATE tbl_cart SET jumlah = ?, totalHargaItem = ? WHERE user_id = ? AND nama = ?");
            ps.setInt(1, item.getJumlah());
            ps.setDouble(2, item.getTotalHargaItem());
            ps.setInt(3, UserSession.getId_session());
            ps.setString(4, item.getNama());

            int result = ps.executeUpdate();

            if (result == 1) {
                System.out.println("berhasil");
            } else {
                System.out.println("gagal");
            }

        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public ItemModel selectItem_db(String nama) {
        try {
            ps = connection.prepareStatement("" + "SELECT nama, harga, jumlah, totalHargaItem FROM tbl_cart WHERE user_id = ? AND nama = ?");
            ps.setInt(1, UserSession.getId_session());
            ps.setString(2, nama);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new ItemModel(rs.getString("nama"), rs.getInt("harga"), rs.getInt("jumlah"), rs.getDouble("totalHargaItem"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return null;
    }

    public void deleteItem_db(ItemModel item) {
        try {
            ps = connection.prepareStatement("" + "DELETE FROM tbl_cart WHERE user_id = ? AND nama = ?");
            ps.setInt(1, UserSession.getId_session());
            ps.setString(2, item.getNama());

            int result = ps.executeUpdate();

            if (result == 1) {
                System.out.println("berhasil");
            } else {
                System.out.println("gagal");
            }

        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public List<ItemModel> selectAllItem(ShoppingCartModel shoppingCartModel) {
        try {
            ps = connection.prepareStatement("" + "SELECT * FROM tbl_cart WHERE user_id = ?");
            ps.setInt(1, UserSession.getId_session());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                shoppingCartModel.listItem.add(new ItemModel(rs.getString("nama"), rs.getInt("harga"), rs.getInt("jumlah"), rs.getDouble("totalHargaItem")));
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return shoppingCartModel.listItem;
    }
    
    public List<Double> getTotalHargaCart(ShoppingCartModel shoppingCartModel) {
        try {
            ps = connection.prepareStatement("" + "SELECT totalHargaItem FROM tbl_cart WHERE user_id = ?");
            ps.setInt(1, UserSession.getId_session());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                shoppingCartModel.totalHargaItem.add(rs.getDouble("totalHargaItem")); 
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return shoppingCartModel.totalHargaItem;
    }
    
    public int getJumlahItem(String nama) {
        try {
            ps = connection.prepareStatement("" + "SELECT jumlah FROM tbl_cart WHERE nama = ? AND user_id = ?");
            ps.setString(1, nama);
            ps.setInt(2, UserSession.getId_session());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("jumlah");
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    
        return 0;
    
    }
    
    public int getJumlahTerjual(String nama) {
        try {
            ps = connection.prepareStatement("" + "SELECT jumlah FROM tbl_history WHERE nama = ?");
            ps.setString(1, nama);
            
            ResultSet rs = ps.executeQuery();
            
            int total = 0;
            
            while (rs.next()) {
                total += rs.getInt("jumlah");
            }
            
            return total;
            
        } catch (SQLException ex) {
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 100000000;
        }
    }
    
    
}
