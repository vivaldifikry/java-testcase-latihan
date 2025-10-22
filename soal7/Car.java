package soal7;

class Car extends Vehicle {
    // Atribut Car
    private int fuelEfficiency;

    // Getter
    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    // Setter
    public void setFuelEfficiency(int fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    // Constructor dari Vehicle
    public Car(String licensePlate, int fuelEfficiency) {
        super(licensePlate);
        this.fuelEfficiency = fuelEfficiency;
    }

    // Implementasi abstract method parent
    // Method fuel consumption car : distance / fuelEfficiency.
    @Override
    public double calculateFuelConsumption(int distance) {
        return (double) distance / fuelEfficiency;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n--- Car Info ---");
        super.displayInfo();
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/l");
    }

}
