public class App {
    public static void main(String[] args) throws Exception {
        Karakter mage1 = new Mage();

        mage1.serang();
        
        ((Mage)mage1).serang("20");
    }
}
