public class Main {
    public static void main(String[] args) throws Exception {
        PerangkatPintar[] KoleksiPerangkat = new PerangkatPintar[2];
        
        KoleksiPerangkat[0] = new LampuPintar();
        KoleksiPerangkat[1] = new AcPintar();

        for (int i = 0; i < KoleksiPerangkat.length; i++) {
            KoleksiPerangkat[i].aktifkan(); /*  Pesan bisa tercetak berbeda karena mengikuti konsep polymorpishm
                                                Java memanggil method berdasarkan objek asli (runtime), bukan tipe referensi (compile time). 
                                                Meski referensi bertipe PerangkatPintar, objek yang tersimpan adalah LampuPintar dan AcPintar, 
                                                sehingga method aktifkan() yang dioverride masing-masing subclass yang dieksekusi.   */
        }

        if (KoleksiPerangkat[1] instanceof AcPintar){
            AcPintar ac = (AcPintar) KoleksiPerangkat[1];
            ac.aturSuhu(20);
        }

        /*  Nomor 5
            Compiler bekerja di compile-time, bukan runtime.
            Compiler hanya melihat tipe referensi yakni PerangkatPintar, bukan objek asli yang tersimpan.
            Karena aturKecerahan() tidak dideklarasikan di PerangkatPintar, compiler menolaknya/
            Cara memperbaikinya adalah melakukan downcasting */
    }
}
