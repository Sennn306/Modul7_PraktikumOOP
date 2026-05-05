public class AcPintar extends PerangkatPintar {
    @Override
    public void aktifkan() {
        System.out.println("AC menyala dan mulai mendinginkan ruangan");
    }

    public void aturSuhu(int suhu) {
        System.out.println("Suhu ruang diatur menjadi [" + suhu + "] derajat");
    }

    
}
