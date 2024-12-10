import java.util.Scanner;

public class PesananKafeK7 {
    static String[] menuKafe = {"Kopi Hitam", "Latte", "Teh Hangat", "Mie Jebew Slebew", "Susu Hitam"};
    static int[] hargaKafe = {5000, 15000, 5000, 12000, 18000};
    static String[] namaPelanggan = new String[10];
    static String[] detailPesanan = new String[10];
    static double[] totalHargaPesanan = new double[10];
    static int[] nomorMeja = new int[10];
    static int jumlahPesanan = 0;
    
    public static void tambahPesanan(Scanner sc) {
        if (jumlahPesanan >= 10) {
            System.out.println("Pesanan Penuh, Tidak Dapat Menambahkan Pesanan");
            return;
        }

        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Nomor Meja: ");
        int meja = sc.nextInt();
        sc.nextLine();

        System.out.println("\n===== MENU KAFE =====");
        for (int i = 0; i < menuKafe.length; i++) {
            System.out.println((i + 1) + ". " + menuKafe[i] + " - Rp " + hargaKafe[i] + "  ");
        }
    
        double totalHarga = 0;
        String detail = "";
        boolean pesanLagi = true;

        while (pesanLagi) {
            System.out.print("\nPilih Menu (Masukkan Nomor Menu, Atau 0 Untuk Selesai): ");
            int nomorMenu = sc.nextInt();
            if (nomorMenu == 0) {
                pesanLagi = false;
                break;
            }
            if (nomorMenu < 1 || nomorMenu > menuKafe.length) {
                System.out.println("Nomor Menu Tidak Valid");
                continue;
            }
    
            System.out.print("Masukkan Jumlah Pesanan Untuk " + menuKafe[nomorMenu - 1] + ": ");
            int jumlahItem = sc.nextInt();
            if (jumlahItem <= 0) {
                System.out.println("Jumlah Pesanan Harus Lebih Dari 0");
                continue;
            }

            String namaMenu = menuKafe[nomorMenu - 1];
            int hargaMenu = hargaKafe[nomorMenu - 1];
            int hargaTotalMenu = hargaMenu * jumlahItem;
            totalHarga += hargaTotalMenu;
            detail += "\n" + namaMenu + " x " + jumlahItem + " = Rp" + hargaTotalMenu + "  ";
        }

        boolean pelangganDitemukan = false;
        for (int i = 0; i < jumlahPesanan; i++) {
            if (namaPelanggan[i].equals(nama) && nomorMeja[i] == meja) {
                detailPesanan[i] += " " + detail;
                totalHargaPesanan[i] += totalHarga;
                pelangganDitemukan = true;
                break;
            }
        }

        if (!pelangganDitemukan) {
            namaPelanggan[jumlahPesanan] = nama;
            nomorMeja[jumlahPesanan] = meja;
            detailPesanan[jumlahPesanan] = detail;
            totalHargaPesanan[jumlahPesanan] = totalHarga;
            jumlahPesanan++;
        }
    
        System.out.println("\nPesanan Berhasil Ditambahkan");
        System.out.println("Total Harga Pesanan: Rp" + totalHarga);
    }    
    
    public static void tampilkanPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("Tidak Ada Pesanan");
            return;
        }
        
        System.out.println("\n=== DAFTAR PESANAN ===");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Nama Pelanggan: " + namaPelanggan[i]);
            System.out.println("Nomor Meja: " + nomorMeja[i]);
            System.out.println("Detail Pesanan: " + detailPesanan[i]);
            System.out.println("Total Harga Pesanan: Rp" + totalHargaPesanan[i]);
            System.out.println("======================");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahPesanan(sc);
                    break;
                case 2:
                    tampilkanPesanan();
                    break;
                case 3:
                    System.out.println("Terima Kasih");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Lagi");
            }
        } while (pilihan != 3);
    }
}
