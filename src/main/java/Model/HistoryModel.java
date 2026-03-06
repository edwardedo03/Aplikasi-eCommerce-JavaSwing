package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HistoryModel {
    
    private Timestamp tanggal;
    private double totalHargaCart;
    private String alamat;
    
    private String nama;
    private int jumlah;
    private int harga;
    private double totalHargaItem;
    private String promo;
    private String kurir;
    private String metodePembayaran;
    private Timestamp tanggal_detail;

    public HistoryModel(Timestamp tanggal, double totalHargaCart, String alamat) {
        this.tanggal = tanggal;
        this.totalHargaCart = totalHargaCart;
        this.alamat = alamat;
    }
    
    public HistoryModel(String nama, int jumlah, int harga, double totalHargaItem, String promo, String kurir, String metodePembayaran) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.totalHargaItem = totalHargaItem;
        this.promo = promo;
        this.kurir = kurir;
        this.metodePembayaran = metodePembayaran;
    }
    
    public List<HistoryModel> listHistory = new ArrayList<>();
    public List<HistoryModel> listDetailHistory = new ArrayList<>();

    public Timestamp getTanggal() {
        return tanggal;
    }

    public double getTotalHargaCart() {
        return totalHargaCart;
    }

    public String getAlamat() {
        return alamat;
    }

    
    
    
    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public double getTotalHargaItem() {
        return totalHargaItem;
    }

    public String getPromo() {
        return promo;
    }

    public String getKurir() {
        return kurir;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public Timestamp getTanggal_detail() {
        return tanggal_detail;
    }

    public void setTanggal_detail(Timestamp tanggal_detail) {
        this.tanggal_detail = tanggal_detail;
    }
    
    
    
}
