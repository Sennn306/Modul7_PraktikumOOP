import java.util.ArrayList; // Mengimpor class ArrayList untuk menyimpan koleksi objek

public class Main {
    // Metode main sebagai titik masuk program
    public static void main(String[] args) {
        // Membuat ArrayList dengan tipe LayananEkspedisi untuk upcasting (polymorphism)
        ArrayList<LayananEkspedisi> daftarPengiriman = new ArrayList<>();

        // Membuat objek LayananReguler dengan data: Resi REG-11, Berat 2kg, Dimensi 50x50x50cm
        // Volumetrik = (50*50*50)/6000 = 20.83 Kg, lebih besar dari berat aktual 2kg
        LayananReguler reguler = new LayananReguler("REG-11", 2, 50, 50, 50);

        // Membuat objek LayananExpress dengan data: Resi EXP-22, Berat 5kg, Dimensi 10x10x10cm
        // Volumetrik = (10*10*10)/6000 = 0.17 Kg, berat aktual 5kg lebih besar
        LayananExpress express = new LayananExpress("EXP-22", 5, 10, 10, 10);

        // Membuat objek LayananInternasional dengan data: Resi INT-33, Berat 3kg, Dimensi 20x20x20cm, Tujuan Korea, Nilai USD 100
        // Volumetrik = (20*20*20)/6000 = 1.33 Kg, berat aktual 3kg lebih besar
        LayananInternasional internasional = new LayananInternasional("INT-33", 3, 20, 20, 20, "Korea", 100);

        // Menambahkan objek reguler ke ArrayList (upcasting ke tipe LayananEkspedisi)
        daftarPengiriman.add(reguler);

        // Menambahkan objek express ke ArrayList (upcasting ke tipe LayananEkspedisi)
        daftarPengiriman.add(express);

        // Menambahkan objek internasional ke ArrayList (upcasting ke tipe LayananEkspedisi)
        daftarPengiriman.add(internasional);

        // Inisialisasi variabel untuk menyimpan total pendapatan perusahaan dari ongkir dasar
        double totalPendapatanPerusahaan = 0;

        // Memulai perulangan untuk menelusuri setiap objek dalam koleksi daftarPengiriman
        for (LayananEkspedisi pengiriman : daftarPengiriman) {
            // Memanggil metode cetakResi() untuk mencetak nomor resi dan berat efektif
            pengiriman.cetakResi();

            // Memanggil metode hitungOngkir() tanpa parameter untuk mendapatkan ongkir dasar
            double ongkirDasar = pengiriman.hitungOngkir();

            // Mencetak ongkir dasar ke layar
            System.out.println("Ongkir Dasar: Rp" + ongkirDasar);

            // Menambahkan ongkir dasar ke total pendapatan perusahaan
            totalPendapatanPerusahaan += ongkirDasar;

            // Mengecek apakah objek pengiriman merupakan instance dari LayananReguler (downcasting)
            if (pengiriman instanceof LayananReguler) {
                // Melakukan downcasting dari LayananEkspedisi ke LayananReguler
                LayananReguler r = (LayananReguler) pengiriman;
                // Memanggil metode overload hitungOngkir dengan parameter member=true dan jarak 25km
                double ongkirMember = r.hitungOngkir(true, 25);
                // Mencetak hasil perhitungan ongkir untuk member dengan jarak 25km
                System.out.println("Ongkir Member (25km): Rp" + ongkirMember);
            }

            // Mengecek apakah objek pengiriman merupakan instance dari LayananExpress (downcasting)
            if (pengiriman instanceof LayananExpress) {
                // Melakukan downcasting dari LayananEkspedisi ke LayananExpress
                LayananExpress e = (LayananExpress) pengiriman;
                // Memanggil metode spesifik klaimAsuransi dengan nilai barang Rp 2.500.000 (VIP)
                e.klaimAsuransi(1500000);
            }

            // Mengecek apakah objek pengiriman merupakan instance dari LayananInternasional (downcasting)
            if (pengiriman instanceof LayananInternasional) {
                // Melakukan downcasting dari LayananEkspedisi ke LayananInternasional
                LayananInternasional i = (LayananInternasional) pengiriman;
                // Memanggil metode spesifik cetakManifest untuk menampilkan manifest internasional
                i.cetakManifest();
            }

            System.out.println("----------------------------------------");
        }

        // Mencetak total pendapatan keseluruhan perusahaan dari ongkir dasar (sebelum promo)
        System.out.println("\nTotal Pendapatan Perusahaan (Ongkir Dasar): Rp" + totalPendapatanPerusahaan);
    }
}
