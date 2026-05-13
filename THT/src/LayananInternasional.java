public class LayananInternasional extends LayananEkspedisi {
    // Atribut tambahan negaraTujuan untuk menyimpan negara pengiriman internasional
    protected String negaraTujuan;

    // Atribut tambahan nilaiBarangUSD untuk menyimpan nilai barang dalam mata uang USD
    protected double nilaiBarangUSD;

    // Konstruktor untuk menginisialisasi atribut warisan dan atribut tambahan
    public LayananInternasional(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi, String negaraTujuan, double nilaiBarangUSD) {
        // Memanggil konstruktor superclass untuk menginisialisasi atribut yang diwarisi
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        // Mengisi atribut negaraTujuan dengan nilai parameter yang diterima
        this.negaraTujuan = negaraTujuan;
        // Mengisi atribut nilaiBarangUSD dengan nilai parameter yang diterima
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // Override metode hitungOngkir() dari superclass untuk tarif internasional
    @Override
    public double hitungOngkir() {
        // Menghitung ongkir dasar dengan tarif Rp 200.000 dikali berat efektif
        double ongkirDasar = hitungBeratEfektif() * 200000;

        // Mengecek apakah nilai barang dalam USD lebih dari 50 untuk pajak bea cukai
        if (nilaiBarangUSD > 50) {
            // Jika nilai barang lebih dari 50 USD, kenakan pajak bea cukai 20% dari ongkir dasar
            double pajak = ongkirDasar * 0.2;
            // Mengembalikan total ongkir dasar ditambah pajak bea cukai
            return ongkirDasar + pajak;
        }

        // Jika nilai barang 50 USD atau kurang, tidak ada pajak, kembalikan ongkir dasar saja
        return ongkirDasar;
    }

    // Metode spesifik untuk mencetak manifest pengiriman internasional
    public void cetakManifest() {
        // Mencetak informasi manifest internasional ke layar
        System.out.println("Manifest Internasional ke " + negaraTujuan + " - Deklarasi Nilai: $" + nilaiBarangUSD);
    }
}
