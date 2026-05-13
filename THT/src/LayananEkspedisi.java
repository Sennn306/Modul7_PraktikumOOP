public class LayananEkspedisi {
    // Atribut nomorResi dengan access modifier protected agar bisa diakses oleh subclass
    protected String nomorResi;
    
    // Atribut beratAktualKg dengan access modifier protected agar bisa diakses oleh subclass
    protected double beratAktualKg;
    
    // Atribut panjang dengan access modifier protected agar bisa diakses oleh subclass
    protected double panjang;
    
    // Atribut lebar dengan access modifier protected agar bisa diakses oleh subclass
    protected double lebar;
    
    // Atribut tinggi dengan access modifier protected agar bisa diakses oleh subclass
    protected double tinggi;

    // Konstruktor untuk menginisialisasi semua atribut saat objek dibuat
    public LayananEkspedisi(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        // Mengisi atribut nomorResi dengan nilai parameter yang diterima
        this.nomorResi = nomorResi;
        // Mengisi atribut beratAktualKg dengan nilai parameter yang diterima
        this.beratAktualKg = beratAktualKg;
        // Mengisi atribut panjang dengan nilai parameter yang diterima
        this.panjang = panjang;
        // Mengisi atribut lebar dengan nilai parameter yang diterima
        this.lebar = lebar;
        // Mengisi atribut tinggi dengan nilai parameter yang diterima
        this.tinggi = tinggi;
    }

    // Metode untuk menghitung berat efektif (nilai tertinggi antara berat aktual dan berat volumetrik)
    public double hitungBeratEfektif() {
        // Menghitung berat volumetrik menggunakan rumus (panjang x lebar x tinggi) / 6000
        double beratVolumetrik = (panjang * lebar * tinggi) / 6000;
        
        // Mengecek apakah berat aktual lebih besar atau sama dengan berat volumetrik
        if (beratAktualKg >= beratVolumetrik) {
            // Jika berat aktual lebih besar atau sama, kembalikan berat aktual sebagai berat efektif
            return beratAktualKg;
        } else {
            // Jika berat volumetrik lebih besar, kembalikan berat volumetrik sebagai berat efektif
            return beratVolumetrik;
        }
    }

    // Metode untuk mencetak nomor resi dan berat efektif yang digunakan
    public void cetakResi() {
        // Mencetak nomor resi ke layar
        System.out.println("Nomor Resi: " + nomorResi);
        // Mencetak berat efektif yang digunakan ke layar
        System.out.println("Berat Efektif: " + hitungBeratEfektif() + " Kg");
    }

    // Metode polymorphic untuk menghitung ongkir dasar (akan di-override oleh subclass)
    public double hitungOngkir() {
        // Mengembalikan 0 sebagai nilai default karena setiap subclass punya tarif sendiri
        return 0;
    }
}