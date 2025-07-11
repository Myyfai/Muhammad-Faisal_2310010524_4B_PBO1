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

    // Method tambah komputer biasa
    public void tambahKomputer(String id, String spesifikasi) {
        if (jumlahKomputer < MAX_KOMPUTER) {
            daftarKomputer[jumlahKomputer] = new Komputer(id, spesifikasi);
            jumlahKomputer++;
            System.out.println("Komputer berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas maksimum komputer tercapai!");
        }
    }

    // Method tambah komputer VIP
    public void tambahKomputerVIP(String id, String spesifikasi, double hargaVIP) {
        if (jumlahKomputer < MAX_KOMPUTER) {
            daftarKomputer[jumlahKomputer] = new KomputerVIP(id, spesifikasi, hargaVIP);
            jumlahKomputer++;
            System.out.println("Komputer VIP berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas maksimum komputer tercapai!");
        }
    }

    // Tampilkan daftar komputer
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

    // Pinjam komputer
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

    // Kembalikan komputer
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

    // Hitung biaya rental
    public void hitungBiaya(int index, double jam) {
        if (index >= 0 && index < jumlahKomputer) {
            Komputer komputer = daftarKomputer[index];

            if (komputer instanceof KomputerVIP komputerVIP) {
                double total = komputerVIP.getHargaVIP() * jam;
                System.out.printf("Total biaya rental: Rp%.0f\n", total);
            } else {
                double total = 5000 * jam; // Tarif normal
                System.out.printf("Total biaya rental: Rp%.0f\n", total);
            }
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    // Main method
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

            // Validasi input agar tidak crash jika user input huruf
            String inputMenu = scanner.nextLine();
            int pilihan;

            try {
                pilihan = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka antara 1 sampai 7.");
                continue;
            }

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

                    String inputHarga = scanner.nextLine();
                    double harga;
                    try {
                        harga = Double.parseDouble(inputHarga);
                    } catch (NumberFormatException e) {
                        System.out.println("Harga harus berupa angka!");
                        break;
                    }

                    warnet.tambahKomputerVIP(idVip, specVip, harga);
                }

                case 3 -> warnet.tampilkanDaftarKomputer();

                case 4 -> {
                    if (warnet.jumlahKomputer == 0) {
                        System.out.println("Belum ada komputer yang ditambahkan.");
                        break;
                    }

                    System.out.print("Masukkan nomor komputer yang ingin dipinjam (1-" + warnet.jumlahKomputer + "): ");
                    String inputPinjam = scanner.nextLine();

                    int idxPinjam;
                    try {
                        idxPinjam = Integer.parseInt(inputPinjam);
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                        break;
                    }

                    if (idxPinjam < 1 || idxPinjam > warnet.jumlahKomputer) {
                        System.out.println("Nomor komputer tidak valid.");
                        break;
                    }

                    warnet.pinjamKomputer(idxPinjam - 1);
                }

                case 5 -> {
                    if (warnet.jumlahKomputer == 0) {
                        System.out.println("Belum ada komputer yang ditambahkan.");
                        break;
                    }

                    System.out.print("Masukkan nomor komputer yang dikembalikan (1-" + warnet.jumlahKomputer + "): ");
                    String inputKembali = scanner.nextLine();

                    int idxKembali;
                    try {
                        idxKembali = Integer.parseInt(inputKembali);
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                        break;
                    }

                    if (idxKembali < 1 || idxKembali > warnet.jumlahKomputer) {
                        System.out.println("Nomor komputer tidak valid.");
                        break;
                    }

                    warnet.kembalikanKomputer(idxKembali - 1);
                }

                case 6 -> {
                    if (warnet.jumlahKomputer == 0) {
                        System.out.println("Belum ada komputer yang ditambahkan.");
                        break;
                    }

                    System.out.print("Masukkan nomor komputer (1-" + warnet.jumlahKomputer + "): ");
                    String inputHitung = scanner.nextLine();

                    int idxHitung;
                    try {
                        idxHitung = Integer.parseInt(inputHitung);
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                        break;
                    }

                    if (idxHitung < 1 || idxHitung > warnet.jumlahKomputer) {
                        System.out.println("Nomor komputer tidak valid.");
                        break;
                    }

                    System.out.print("Masukkan durasi rental (jam): ");
                    String inputJam = scanner.nextLine();
                    double jam;
                    try {
                        jam = Double.parseDouble(inputJam);
                        if (jam <= 0) {
                            System.out.println("Durasi harus lebih besar dari nol.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Durasi harus berupa angka.");
                        break;
                    }

                    warnet.hitungBiaya(idxHitung - 1, jam);
                }

                case 7 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Pilihan tidak valid. Silakan pilih antara 1 sampai 7.");
            }
        }
    }
}