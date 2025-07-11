# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengelolaan rental komputer di warnet menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa ID, spesifikasi, dan durasi rental komputer, serta memberikan output berupa informasi status komputer dan biaya rental. Aplikasi ini dirancang untuk memenuhi konsep dasar OOP (Object-Oriented Programming) seperti: 

Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Komputer`, `KomputerVIP`, dan `Warnet` adalah contoh dari class.

```bash
public class Komputer {
    ...
}

public class KomputerVIP extends Mahasiswa {
    ...
}

public class Warnet {
    ...
}
```

2. **Object** Object adalah instance dari class. Pada kode ini, pembuatan objek terjadi saat menambahkan `Komputer` biasa dan `KomputerVIP`.

```bash
new Komputer(id, spesifikasi);
new KomputerVIP(idVip, specVip, harga);
```

3. **Atribut** Atribut adalah variabel yang ada dalam class. Pada kode ini, `idKomputer`, `spesifikasi`, `tersedia`, dan `hargaVIP` adalah contoh atribut.

```bash
private String idKomputer;
private String spesifikasi;
private boolean tersedia;
private double hargaVIP; 
```

4. **Constructor** Constructor adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di class `Komputer` dan `KomputerVIP`.
   
```bash
public Komputer(String idKomputer, String spesifikasi) {
  this.idKomputer = idKomputer;
  this.spesifikasi = spesifikasi;
  this.tersedia = true;
}

public KomputerVIP(String idKomputer, String spesifikasi, double hargaVIP) {
  super(idKomputer, spesifikasi);
  this.hargaVIP = hargaVIP;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini,  `setIdKomputer`, `setSpesifikasi`, dan `setTersedia` adalah contoh method mutator.
   
```bash
public void setIdKomputer(String idKomputer) {
  this.idKomputer = idKomputer;
}

public void setSpesifikasi(String spesifikasi) {
  this.spesifikasi = spesifikasi;
}

public void setTersedia(boolean tersedia) {
  this.tersedia = tersedia;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getIdKomputer`, `getSpesifikasi`, dan `isTersedia` adalah contoh method accessor.

```bash
public String getIdKomputer() {
  return idKomputer;
}

public String getSpesifikasi() {
  return spesifikasi;
    }
    
public boolean isTersedia() {
  return tersedia;
    }
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, semua atribut dideklarasikan sebagai `private` dan hanya bisa diakses melalui method getter dan setter.

```bash
private String nama;
private String npm;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `KomputerVIP` mewarisi `Komputer` dengan sintaks `extends`.

```bash
public class KomputerVIP extends Komputer {
    private double hargaVIP;

    public KomputerVIP(String idKomputer, String spesifikasi, double hargaVIP) {
        super(idKomputer, spesifikasi);
        this.hargaVIP = hargaVIP;
    }
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, polymorphism terlihat dari method override `toString()` di kelas utama/turunan.

```bash
class Komputer
    @Override
    public String toString() {
        return "ID: " + idKomputer + ", Spesifikasi: " + spesifikasi + ", Status: " + (tersedia ? "Tersedia" : "Dipinjam");
    }

class KomputerVIP
@Override
    public String toString() {
        return super.toString() + ", Harga VIP: Rp" + hargaVIP;
    }
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dan `switch case` untuk validasi status komputer dan kapasitas semuanya ada di class `Warnet`.
```bash
salah satu contoh berada pada class Warnet
public void tambahKomputer(String id, String spesifikasi) {
        if (jumlahKomputer < MAX_KOMPUTER) {
            daftarKomputer[jumlahKomputer] = new Komputer(id, spesifikasi);
            jumlahKomputer++;
            System.out.println("Komputer berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas maksimum komputer tercapai!");
        }
    }

untuk switch case pada line 123-246 pada class Warnet
switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan ID komputer: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan spesifikasi: ");
                    String spec = scanner.nextLine();
                    warnet.tambahKomputer(id, spec);
                }
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `while(true)` untuk menu utama dan `for` untuk menampilkan daftar komputer.
```bash
for di line 43-45 di class Warnet
for (int i = 0; i < jumlahKomputer; i++) {
      System.out.println((i + 1) + ". " + daftarKomputer[i]);
}
while(true) di line 101-110 di class Warnet
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
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
        Warnet warnet = new Warnet();

ini salah satu contoh pada bagian System.out.printl
System.out.println("Komputer berhasil ditambahkan.");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, array digunakan untuk menyimpan data pada `daftar komputer` adalah contoh penggunaan array.

```bash
private final Komputer[] daftarKomputer;
public Warnet() {
        daftarKomputer = new Komputer[MAX_KOMPUTER];
        jumlahKomputer = 0;
    }
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
  pilihan = Integer.parseInt(inputMenu);
  } catch (NumberFormatException e) {
  System.out.println("Input tidak valid. Harap masukkan angka antara 1 sampai 7.");
  continue;
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Faisal

NPM: 2310010524
