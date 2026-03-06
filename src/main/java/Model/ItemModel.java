package Model;

import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    private String nama;
    private int harga;
    private int jumlah;
    private double totalHargaItem;
    
    public ItemModel(String nama, int harga, int jumlah, double totalHargaItem) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.totalHargaItem = totalHargaItem;
    }

    public List<Integer> listJumlahTerjual = new ArrayList<>();
    
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHargaItem() {
        return totalHargaItem;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotalHargaItem(double totalHargaItem) {
        this.totalHargaItem = totalHargaItem;
    }
    
    
    
}

