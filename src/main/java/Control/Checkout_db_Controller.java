package Control;

import Model.CheckoutModel;
import Model.ItemModel;
import Model.ShoppingCartModel;
import Model.ShoppingCart_db;
import Model.UserSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Checkout_db_Controller {

    Connection connection = ShoppingCart_db.getConnection();

    PreparedStatement ps;

    public void insert_alamat(CheckoutModel checkoutModel) {
        try {
            ps = connection.prepareStatement("" + "INSERT INTO tbl_alamat (alamat, user_id) VALUES (?, ?)");
            ps.setString(1, checkoutModel.getAlamat());
            ps.setInt(2, UserSession.getId_session());

            if (ps.executeUpdate() > 0) {
                System.out.println("berhasil");
            } else {
                System.out.println("gagal");
            }

        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(Checkout_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void select_alamat(CheckoutModel checkoutModel) {
        try {
            ps = connection.prepareStatement("" + "SELECT alamat FROM tbl_alamat WHERE user_id = ?");
            ps.setInt(1, UserSession.getId_session());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                checkoutModel.listAlamat.add(rs.getString("alamat"));
            }

        } catch (SQLException ex) {
            System.getLogger(Checkout_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void deleteCart_db() {
        try {
            ps = connection.prepareStatement("" + "DELETE FROM tbl_cart WHERE user_id = ?");
            ps.setInt(1, UserSession.getId_session());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("berhasil");
            } else {
                System.out.println("gagal delete");
            }

        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(ShoppingCart_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void insertHistory(ShoppingCartModel shoppingCartModel, CheckoutModel checkoutModel) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        try {
            ps = connection.prepareStatement("" + "INSERT INTO tbl_history (nama, jumlah, totalHargaItem, totalHargaCart, alamat, user_id, tanggal_transaksi, promo, kurir, metodePembayaran, harga) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (ItemModel item : shoppingCartModel.listItem) {
                ps.setString(1, item.getNama());
                ps.setInt(2, item.getJumlah());
                ps.setDouble(3, item.getTotalHargaItem());
                ps.setDouble(4, checkoutModel.getTotalHargaPesanan());
                ps.setString(5, checkoutModel.getAlamat());
                ps.setInt(6, UserSession.getId_session());
                ps.setTimestamp(7, now);
                ps.setString(8, checkoutModel.getPromo());
                ps.setString(9, checkoutModel.getKurir());
                ps.setString(10, checkoutModel.getMetodePembayaran());
                ps.setInt(11, item.getHarga());

                if (ps.executeUpdate() > 0) {
                    System.out.println("berhasil");
                } else {
                    System.out.println("gagal insert history");
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Database Error");
            System.getLogger(Checkout_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
