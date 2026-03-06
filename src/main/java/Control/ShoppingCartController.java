package Control;

import Model.ShoppingCartModel;

public class ShoppingCartController {
    
    public void totalHargaCart(ShoppingCartModel shoppingCartModel) {
        double totalHarga = 0;
        
        for (double harga : shoppingCartModel.totalHargaItem) {
            totalHarga += harga;
        }
        
        shoppingCartModel.setTotalHargaCart(totalHarga);
    }
    
}
