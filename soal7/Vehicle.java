package soal7;

abstract class Vehicle {
    private String licensePlate;
    private int maxSpeed;

    // Constructor
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    // Getter
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    // Setter
    public void setMaxSpeed(int speed) {
        this.maxSpeed = speed;
    }

    // method
    // calculate fuel needed for a trip.
    public abstract double calculateFuelConsumption(int distance);

    // prints the vehicle's license plate and max speed.
    public void displayInfo() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    };

}
