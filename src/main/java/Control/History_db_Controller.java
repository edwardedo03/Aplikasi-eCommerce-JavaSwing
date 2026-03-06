package Control;

import Model.HistoryModel;
import Model.ShoppingCart_db;
import Model.UserSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class History_db_Controller {

    Connection connection = ShoppingCart_db.getConnection();
    
    PreparedStatement ps;
    
    public void selectListHistory(HistoryModel historyModel) {
        try {
            ps = connection.prepareStatement("" + "SELECT tanggal_transaksi, totalHargaCart, alamat FROM tbl_history WHERE user_id = ? GROUP BY tanggal_transaksi");
            ps.setInt(1, UserSession.getId_session());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                historyModel.listHistory.add(new HistoryModel(rs.getTimestamp("tanggal_transaksi"), rs.getDouble("totalHargaCart"), rs.getString("alamat")));
            }
            
        } catch (SQLException ex) {
            System.getLogger(History_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void selectTanggal(Timestamp tanggal, HistoryModel historyModel) {
        try {
            ps = connection.prepareStatement("" + "SELECT nama, jumlah, harga, totalHargaItem, promo, kurir, metodePembayaran FROM tbl_history WHERE tanggal_transaksi = ? AND user_id = ?");
            ps.setTimestamp(1, tanggal);
            ps.setInt(2, UserSession.getId_session());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                historyModel.listDetailHistory.add(new HistoryModel(rs.getString("nama"), rs.getInt("jumlah"), rs.getInt("harga"), rs.getDouble("totalHargaItem"), rs.getString("promo"), rs.getString("kurir"), rs.getString("metodePembayaran")));
            }
            
        } catch (SQLException ex) {
            System.getLogger(History_db_Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
}
