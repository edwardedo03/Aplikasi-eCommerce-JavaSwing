package Control;

import Model.ItemModel;
import Model.ShoppingCartModel;
import View.ShoppingCart;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ItemController {

    ShoppingCart_db_Controller db = new ShoppingCart_db_Controller();

    public void tambahJumlahItem(String nama, int harga, int jumlah, double totalHargaItem, JLabel jlabel) {
        ItemModel cek = db.selectItem_db(nama);

        if (cek != null) {
            cek.setJumlah(cek.getJumlah() + 1);
            cek.setTotalHargaItem(cek.getTotalHargaItem() + harga);

            db.updateItem_db(cek);

            jlabel.setText(String.valueOf(cek.getJumlah()));

        } else {
            System.out.println("berhasil");
            ItemModel item = new ItemModel(nama, harga, jumlah, totalHargaItem);

            db.insert_db(item);

            jlabel.setText(String.valueOf(item.getJumlah()));
        }
    }

    public void kurangJumlahItem(String nama, int harga, JPanel parentComponent, JLabel jlabel) {
        ItemModel cek = db.selectItem_db(nama);

        if (cek != null) {
            if (cek.getJumlah() == 1) {
                db.deleteItem_db(cek);
                jlabel.setText(String.valueOf(0));

            } else {
                cek.setJumlah(cek.getJumlah() - 1);
                cek.setTotalHargaItem(cek.getTotalHargaItem() - harga);

                db.updateItem_db(cek);

                jlabel.setText(String.valueOf(cek.getJumlah()));
            }
        } else {
            System.out.println("berhasil");

            JOptionPane.showMessageDialog(parentComponent, "Tidak ada produk " + nama + " dalam keranjang", "CART ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showJumlahItem(JLabel jlabel, String nama) {
        jlabel.setText(String.valueOf(db.getJumlahItem(nama)));
    }

    public void tambahSelectItemCart(ShoppingCart shoppingCart, ShoppingCartModel shoppingCartModel, JPanel jpanel) {

        int row = shoppingCart.getCartTable().getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(jpanel, "Select item dalam cart terlebih dahulu!", "SELECT ITEM", JOptionPane.ERROR_MESSAGE);
        }

        ItemModel item = shoppingCartModel.listItem.get(row);

        ItemModel cek = db.selectItem_db(item.getNama());
        cek.setJumlah(cek.getJumlah() + 1);
        cek.setTotalHargaItem(cek.getTotalHargaItem() + cek.getHarga());

        db.updateItem_db(cek);
    }

    public void kurangSelectItemCart(ShoppingCart shoppingCart, ShoppingCartModel shoppingCartModel, JPanel jpanel) {

        int row = shoppingCart.getCartTable().getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(jpanel, "Select item dalam cart terlebih dahulu!", "SELECT ITEM", JOptionPane.ERROR_MESSAGE);
        }

        ItemModel item = shoppingCartModel.listItem.get(row);

        ItemModel cek = db.selectItem_db(item.getNama());

        if (cek.getJumlah() == 1) {
            db.deleteItem_db(cek);
        } else {
            cek.setJumlah(cek.getJumlah() - 1);
            cek.setTotalHargaItem(cek.getTotalHargaItem() - cek.getHarga());

            db.updateItem_db(cek);
        }
    }
    
    public void setLabelJumlahTerjual(String nama, JLabel jlabel) {
        jlabel.setText(String.valueOf(db.getJumlahTerjual(nama)));
    }
    
}
