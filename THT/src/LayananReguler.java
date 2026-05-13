public class LayananReguler extends LayananEkspedisi {
    // Konstruktor yang memanggil konstruktor superclass (LayananEkspedisi)
    public LayananReguler(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        // Memanggil konstruktor superclass untuk menginisialisasi atribut yang diwarisi
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Override metode hitungOngkir() dari superclass untuk tarif reguler Rp 15.000 per Kg
    @Override
    public double hitungOngkir() {
        // Menghitung ongkir dasar dengan tarif Rp 15.000 dikali berat efektif
        return hitungBeratEfektif() * 15000;
    }

    // Overload metode hitungOngkir dengan parameter tambahan untuk member dan jarak
    public double hitungOngkir(boolean isMember, int jarakKm) {
        // Mengambil tarif dasar dengan memanggil metode hitungOngkir() yang sudah di-override
        double tarifDasar = hitungOngkir();

        // Mengecek apakah pelanggan merupakan member
        if (isMember == true) {
            // Member mendapat diskon 10% dari tarif dasar, jadi bayar 90% dari tarif dasar
            tarifDasar = tarifDasar * 0.9;
        }

        // Menambahkan surcharge jarak jauh sebesar Rp 500 per kilometer
        double surcharge = jarakKm * 500;

        // Mengembalikan total ongkir setelah diskon (jika ada) ditambah surcharge jarak
        return tarifDasar + surcharge;
    }
}
