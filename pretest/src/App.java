class Vehicle {
    void speedUp() {
        System.out.println("Vehicle accelerating");
    }
}

class Car extends Vehicle {
    @Override
    void speedUp() {
        System.out.println("Ca accelerating by 22 units");
    }

    void drift() {
        System.out.println("Performing a drift");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Vehicle myVehicle = new Car(); // Upcasting
        myVehicle.speedUp();
        //myVehicle.drift(); // Menyebabkan error

        // menggunakan instance of
        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle; // Downcasting
            myCar.drift();
        }
    }
}
