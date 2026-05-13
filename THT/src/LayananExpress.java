public class LayananExpress extends LayananEkspedisi {
    // Konstruktor yang memanggil konstruktor superclass (LayananEkspedisi)
    public LayananExpress(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        // Memanggil konstruktor superclass untuk menginisialisasi atribut yang diwarisi
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Override metode hitungOngkir() dari superclass untuk tarif express Rp 30.000 per Kg
    @Override
    public double hitungOngkir() {
        // Menghitung ongkir dasar dengan tarif Rp 30.000 dikali berat efektif
        return hitungBeratEfektif() * 30000;
    }

    // Metode spesifik untuk LayananExpress: mengajukan klaim asuransi
    public void klaimAsuransi(double nilaiBarang) {
        // Mengecek apakah nilai barang lebih dari Rp 1.000.000 untuk menentukan jenis klaim
        if (nilaiBarang > 1000000) {
            // Jika nilai barang lebih dari 1 juta, cetak pesan klaim VIP dengan prioritas
            System.out.println("Klaim Asuransi VIP Rp" + nilaiBarang + " untuk resi " + nomorResi + " sedang diproses prioritas.");
        } else {
            // Jika nilai barang 1 juta atau kurang, cetak pesan klaim standar 7 hari
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari untuk resi " + nomorResi + ".");
        }
    }
}
