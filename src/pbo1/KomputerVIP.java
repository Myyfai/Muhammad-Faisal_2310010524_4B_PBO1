package pbo1;

public class KomputerVIP extends Komputer {
    private double hargaVIP;

    public KomputerVIP(String idKomputer, String spesifikasi, double hargaVIP) {
        super(idKomputer, spesifikasi);
        this.hargaVIP = hargaVIP;
    }

    public double getHargaVIP() {
        return hargaVIP;
    }

    public void setHargaVIP(double hargaVIP) {
        this.hargaVIP = hargaVIP;
    }
    
    @Override
        public String toString() {
            return super.toString() + ", Harga VIP: Rp" + hargaVIP;
    }
}