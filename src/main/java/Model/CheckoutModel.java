package Model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutModel {
    private String alamat;
    private String metodePembayaran;
    private String promo;
    private String kurir;
    private double hargaKurir;
    private double potonganPromo;
    private double totalHargaPesanan;
    
    public List<String> listAlamat = new ArrayList<>();

    public double getTotalHargaPesanan() {
        return totalHargaPesanan;
    }

    public void setTotalHargaPesanan(double totalHargaPesanan) {
        this.totalHargaPesanan = totalHargaPesanan;
    }
    
    public double getPotonganPromo() {
        return potonganPromo;
    }

    public void setPotonganPromo(double potonganPromo) {
        this.potonganPromo = potonganPromo;
    }
    
    public double getHargaKurir() {
        return hargaKurir;
    }

    public void setHargaKurir(double hargaKurir) {
        this.hargaKurir = hargaKurir;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getKurir() {
        return kurir;
    }

    public void setKurir(String kurir) {
        this.kurir = kurir;
    }
    
    
    
    
}
