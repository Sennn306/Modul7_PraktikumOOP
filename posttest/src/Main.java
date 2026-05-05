public class Main {
    public static void main(String[] args) throws Exception {
        MetodePembayaran[] metode = new MetodePembayaran[2];
        
        metode[0] = new EWallet();
        metode[1] = new KartuKredit();

        for (int i = 0; i < metode.length; i++) {
            metode[i].metodeBayar(100000);
            if (metode[i] instanceof EWallet){
                ((EWallet)metode[i]).metodeBayar(100000);
            } else if (metode[i] instanceof KartuKredit) {
                ((KartuKredit)metode[i]).verifikasiPin();
            }
        }
        
    }
}
