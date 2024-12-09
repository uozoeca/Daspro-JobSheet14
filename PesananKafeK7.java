import java.util.Scanner;

public class PesananKafeK7 {
    static String[][] menuKafe = {
        {"Kopi Hitam", "5000"},
        {"Latte", "15000"},
        {"Teh Hangat", "5000"},
        {"Teh Jepang", "12000"},
        {"Susu Hitam", "18000"}
    };
    static String[][] daftarPesanan = new String[10][6];
    static int jumlahPesanan = 0;

    public static void tambahPesanan(Scanner sc) {
        if (jumlahPesanan >= 100) {
            System.out.println("Pesanan Penuh, Tidak Dapat Menambahkan Pesanan");
            return;
        }

        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = sc.nextLine();
        System.out.print("Masukkan Nomor Meja: ");
        int nomorMeja = sc.nextInt();
        sc.nextLine();
    
        System.out.println("\n===== MENU KAFE =====");
        for (int i = 0; i < menuKafe.length; i++) {
            System.out.println((i + 1) + ". " + menuKafe[i][0] + " - Rp " + menuKafe[i][1]);
        }

        double totalHargaPesanan = 0;
        StringBuilder detailPesanan = new StringBuilder();
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
    
            System.out.print("Masukkan Jumlah Pesanan Untuk " + menuKafe[nomorMenu - 1][0] + ": ");
            int jumlahItem = sc.nextInt();
            if (jumlahItem <= 0) {
                System.out.println("Jumlah Pesanan Harus Lebih Dari 0");
                continue;
            }
            
            String namaMenu = menuKafe[nomorMenu - 1][0];
            double hargaMenu = Double.parseDouble(menuKafe[nomorMenu - 1][1]);
            double hargaTotalMenu = hargaMenu * jumlahItem;

            totalHargaPesanan += hargaTotalMenu;
            detailPesanan.append(namaMenu).append(" x ").append(jumlahItem)
                    .append(" = Rp ").append(String.format("%.0f", hargaTotalMenu)).append("\n");
        }

        System.out.println("\nPesanan Berhasil Ditambahkan");
        System.out.println("Total Harga Pesanan: Rp" + String.format("%.0f", totalHargaPesanan));

        daftarPesanan[jumlahPesanan][0] = namaPelanggan;
        daftarPesanan[jumlahPesanan][1] = String.valueOf(nomorMeja);
        daftarPesanan[jumlahPesanan][2] = detailPesanan.toString();
        daftarPesanan[jumlahPesanan][3] = String.format("%.0f", totalHargaPesanan);
        jumlahPesanan++;
    }    

    public static void tampilkanPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("Tidak Ada Pesanan");
            return;
        }
        
        System.out.println("\n=== DAFTAR PESANAN ===");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Nama Pelanggan: " + daftarPesanan[i][0]);
            System.out.println("Nomor Meja: " + daftarPesanan[i][1]);
            System.out.println("Detail Pesanan:");
            System.out.println(daftarPesanan[i][2]);
            System.out.println("Total Harga Pesanan: Rp" + daftarPesanan[i][3]);
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
