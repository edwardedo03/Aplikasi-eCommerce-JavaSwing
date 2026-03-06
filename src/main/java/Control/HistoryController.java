package Control;

import Model.HistoryModel;
import java.text.DecimalFormat;
import javax.swing.JLabel;

public class HistoryController {

    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    public void hitungTotalHargaItem(HistoryModel historyModel, JLabel jlabelTotal) {
        double total = 0;

        for (HistoryModel harga : historyModel.listDetailHistory) {
            total += harga.getTotalHargaItem();
        }
        System.out.println(total);
        jlabelTotal.setText(df.format(total));
    }

    public void hitungOngkir(JLabel jlabel, JLabel jlabelOngkir) {
        switch (jlabel.getText()) {
            case "JPX":
                    jlabelOngkir.setText("18000");
                break;
            case "J&T":
                    jlabelOngkir.setText("23000");
                break;
            case "JNE":
                    jlabelOngkir.setText("15000");
                break;
            case "Si Cepat":
                    jlabelOngkir.setText("20000");
                break;
            default:
                throw new AssertionError();
        }
    }

}
