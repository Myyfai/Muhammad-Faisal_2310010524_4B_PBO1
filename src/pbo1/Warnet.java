package pbo1;

import java.util.Scanner;

public class Warnet {
    private static final int MAX_KOMPUTER = 10;
    private final Komputer[] daftarKomputer;
    private int jumlahKomputer;

    public Warnet() {
        daftarKomputer = new Komputer[MAX_KOMPUTER];
        jumlahKomputer = 0;
    }

    public void tambahKomputer(String id, String spesifikasi) {
        if (jumlahKomputer < MAX_KOMPUTER) {
            daftarKomputer[jumlahKomputer] = new Komputer(id, spesifikasi);
            jumlahKomputer++;
            System.out.println("Komputer berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas maksimum komputer tercapai!");
        }
    }

    public void tambahKomputerVIP(String id, String spesifikasi, double hargaVIP) {
        if (jumlahKomputer < MAX_KOMPUTER) {
            daftarKomputer[jumlahKomputer] = new KomputerVIP(id, spesifikasi, hargaVIP);
            jumlahKomputer++;
            System.out.println("Komputer VIP berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas maksimum komputer tercapai!");
        }
    }

    public void tampilkanDaftarKomputer() {
        if (jumlahKomputer == 0) {
            System.out.println("Belum ada data komputer.");
        } else {
            System.out.println("\n=== Daftar Komputer ===");
            for (int i = 0; i < jumlahKomputer; i++) {
                System.out.println((i + 1) + ". " + daftarKomputer[i]);
            }
        }
    }

    public void pinjamKomputer(int index) {
        if (index >= 0 && index < jumlahKomputer) {
            Komputer komputer = daftarKomputer[index];
            if (komputer.isTersedia()) {
                komputer.setTersedia(false);
                System.out.println("Komputer " + komputer.getIdKomputer() + " berhasil dipinjam.");
            } else {
                System.out.println("Komputer sedang dipinjam.");
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public void kembalikanKomputer(int index) {
        if (index >= 0 && index < jumlahKomputer) {
            Komputer komputer = daftarKomputer[index];
            if (!komputer.isTersedia()) {
                komputer.setTersedia(true);
                System.out.println("Komputer " + komputer.getIdKomputer() + " berhasil dikembalikan.");
            } else {
                System.out.println("Komputer sudah tersedia.");
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public void hitungBiaya(int index, double jam) {
        if (index >= 0 && index < jumlahKomputer) {
            Komputer komputer = daftarKomputer[index];

            if (komputer instanceof KomputerVIP komputerVIP) {
                double total = komputerVIP.getHargaVIP() * jam;
                System.out.printf("Total biaya rental: Rp%.0f\n", total);
            } else {
                double total = 5000 * jam;
                System.out.printf("Total biaya rental: Rp%.0f\n", total);
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warnet warnet = new Warnet();

        while (true) {
            System.out.println("\n=== Menu Rental Warnet ===");
            System.out.println("1. Tambah Komputer");
            System.out.println("2. Tambah Komputer VIP");
            System.out.println("3. Tampilkan Daftar Komputer");
            System.out.println("4. Pinjam Komputer");
            System.out.println("5. Kembalikan Komputer");
            System.out.println("6. Hitung Biaya Rental");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan ID komputer: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan spesifikasi: ");
                    String spec = scanner.nextLine();
                    warnet.tambahKomputer(id, spec);
                }

                case 2 -> {
                    System.out.print("Masukkan ID komputer VIP: ");
                    String idVip = scanner.nextLine();
                    System.out.print("Masukkan spesifikasi: ");
                    String specVip = scanner.nextLine();
                    System.out.print("Masukkan harga VIP per jam: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine();
                    warnet.tambahKomputerVIP(idVip, specVip, harga);
                }

                case 3 -> warnet.tampilkanDaftarKomputer();

                case 4 -> {
                    System.out.print("Masukkan nomor komputer yang ingin dipinjam: ");
                    int idxPinjam = scanner.nextInt() - 1;
                    scanner.nextLine();
                    warnet.pinjamKomputer(idxPinjam);
                }

                case 5 -> {
                    System.out.print("Masukkan nomor komputer yang dikembalikan: ");
                    int idxKembali = scanner.nextInt() - 1;
                    scanner.nextLine();
                    warnet.kembalikanKomputer(idxKembali);
                }

                case 6 -> {
                    System.out.print("Masukkan nomor komputer: ");
                    int idxHitung = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Masukkan durasi rental (jam): ");
                    double jam = scanner.nextDouble();
                    scanner.nextLine();
                    warnet.hitungBiaya(idxHitung, jam);
                }

                case 7 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}