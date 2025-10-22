package soal7;

public class Soal7 {
    public static void main(String[] args) {

        Car car1 = new Car("CAR-1", 20);
        Truck truck1 = new Truck("TRK-1", 10, 150);

        // car1.setMaxSpeed(120); // warisan dari Vehicle
        // car1.calculateFuelConsumption(200); // implementasi dari Car
        // car1.displayInfo(); // fungsi khusus Car
        // // car1.scratch(); // fungsi khusus Cat

        // System.out.println();

        // truck1.setMaxSpeed(85);
        // truck1.calculateFuelConsumption(200);
        // truck1.displayInfo();

        car1.setMaxSpeed(120);
        truck1.setMaxSpeed(85);

        car1.displayInfo();
        System.out.println("Fuel needed for 200 km: " + car1.calculateFuelConsumption(200) + " liters");

        truck1.displayInfo();
        System.out.println("Fuel needed for 200 km: " + truck1.calculateFuelConsumption(200) + " liters");
    }
}
