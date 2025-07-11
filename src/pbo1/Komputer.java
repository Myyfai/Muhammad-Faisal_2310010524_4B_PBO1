package pbo1;

public class Komputer {
    private String idKomputer;
    private String spesifikasi;
    private boolean tersedia;

    public Komputer(String idKomputer, String spesifikasi) {
        this.idKomputer = idKomputer;
        this.spesifikasi = spesifikasi;
        this.tersedia = true;
    }

    public void setIdKomputer(String idKomputer) {
        this.idKomputer = idKomputer;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public String getIdKomputer() {
        return idKomputer;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    @Override
    public String toString() {
        return "ID: " + idKomputer + ", Spesifikasi: " + spesifikasi + ", Status: " + (tersedia ? "Tersedia" : "Dipinjam");
    }
}