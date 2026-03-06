package Model;

import java.util.*;

public class ShoppingCartModel {
    
    public List<ItemModel> listItem = new ArrayList<>();
    
    public List<Double> totalHargaItem = new ArrayList<>();
    
    private double totalHargaCart;
    
    public double getTotalHargaCart() {
        return totalHargaCart;
    }

    public void setTotalHargaCart(double totalHargaCart) {
        this.totalHargaCart = totalHargaCart;
    }
    
    
}
