package Control;

import Model.CheckoutModel;
import Model.ShoppingCartModel;
import java.text.DecimalFormat;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class CheckoutController {

    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    public void selectRadioButton(JRadioButton jradio, CheckoutModel checkoutModel) {
        checkoutModel.setMetodePembayaran(jradio.getText());
    }

    public void selectKurir(JLabel jlabel, JComboBox<String> comboBox, CheckoutModel checkoutModel, JComboBox<String> comboBox2) {
        String teks = comboBox.getSelectedItem().toString();
        String promo = comboBox2.getSelectedItem().toString();
        switch (teks) {
            case " ":
                if (promo.equals("Gratis Ongkir")) {
                    checkoutModel.setKurir(teks);
                    checkoutModel.setHargaKurir(0);
                    break;
                }
                checkoutModel.setHargaKurir(0);
                jlabel.setText("0");
                checkoutModel.setKurir(teks);
                break;
            case "JPX":
                if (promo.equals("Gratis Ongkir")) {
                    checkoutModel.setKurir(teks);
                    checkoutModel.setHargaKurir(0);
                    break;
                }
                checkoutModel.setHargaKurir(18000);
                jlabel.setText(String.valueOf(checkoutModel.getHargaKurir()));
                checkoutModel.setKurir(teks);
                break;
            case "J&T":
                if (promo.equals("Gratis Ongkir")) {
                    checkoutModel.setKurir(teks);
                    checkoutModel.setHargaKurir(0);
                    break;
                }
                checkoutModel.setHargaKurir(23000);
                jlabel.setText(String.valueOf(checkoutModel.getHargaKurir()));
                checkoutModel.setKurir(teks);
                break;
            case "JNE":
                if (promo.equals("Gratis Ongkir")) {
                    checkoutModel.setKurir(teks);
                    checkoutModel.setHargaKurir(0);
                    break;
                }
                checkoutModel.setHargaKurir(15000);
                jlabel.setText(String.valueOf(checkoutModel.getHargaKurir()));
                checkoutModel.setKurir(teks);
                break;
            case "Si Cepat":
                if (promo.equals("Gratis Ongkir")) {
                    checkoutModel.setKurir(teks);
                    checkoutModel.setHargaKurir(0);
                    break;
                }
                checkoutModel.setHargaKurir(20000);
                jlabel.setText(String.valueOf(checkoutModel.getHargaKurir()));
                checkoutModel.setKurir(teks);
                break;
            default:
                System.out.println("Error");
                throw new AssertionError();
        }
    }

    public void selectPromo(JComboBox<String> comboBox, JComboBox<String> comboBox2, JLabel jlabel, JLabel jlabel_ongkir, CheckoutModel checkoutModel, ShoppingCartModel shoppingCartModel) {
        String value = comboBox.getSelectedItem().toString();
        switch (value) {
            case " ":
                checkoutModel.setPromo(value);
                jlabel.setText("-");
                checkoutModel.setPotonganPromo(0);
                selectKurir(jlabel_ongkir, comboBox2, checkoutModel, comboBox);
                break;
            case "Gratis Ongkir":
                checkoutModel.setPromo(value);
                jlabel.setText("Gratis Ongkir");
                checkoutModel.setHargaKurir(0);
                checkoutModel.setPotonganPromo(0);
                jlabel_ongkir.setText("0");
                break;
            case "Diskon 50%":
                checkoutModel.setPromo(value);
                checkoutModel.setPotonganPromo(shoppingCartModel.getTotalHargaCart() * (50.0 / 100.0));
                jlabel.setText("-" + df.format(checkoutModel.getPotonganPromo()));
                selectKurir(jlabel_ongkir, comboBox2, checkoutModel, comboBox);
                break;
            case "Diskon 10%":
                checkoutModel.setPromo(value);
                checkoutModel.setPotonganPromo(shoppingCartModel.getTotalHargaCart() * (10.0 / 100.0));
                jlabel.setText("-" + df.format(checkoutModel.getPotonganPromo()));
                selectKurir(jlabel_ongkir, comboBox2, checkoutModel, comboBox);
                break;
            default:
                System.out.println("Error");
                throw new AssertionError();
        }
    }

    public void refreshTotalPesanan(JLabel jlabel, CheckoutModel checkoutModel, ShoppingCartModel shoppingCartModel) {
        double total = shoppingCartModel.getTotalHargaCart() + checkoutModel.getHargaKurir() - checkoutModel.getPotonganPromo();
        jlabel.setText(df.format(total));
        checkoutModel.setTotalHargaPesanan(total);
    }

}
