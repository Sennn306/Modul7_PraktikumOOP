public class KartuKredit extends MetodePembayaran{
    @Override
    public void metodeBayar(double nominal) {
        System.out.println("Mencetak tagihan Kartu Kredit sebesar Rp[" + nominal + "]");
    }
    
    public void verifikasiPin(){
        System.out.println("Memverifikasi PIN Kartu Kredit... BERHASIL!");
    }
}
