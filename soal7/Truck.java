package soal7;

class Truck extends Vehicle {
    // Atribut Truck
    private int fuelEfficiency;
    private int cargoWeight;

    // Getter
    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    // Setter
    public void setFuelEfficiency(int fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    // Constructor dari Vehicle
    public Truck(String licensePlate, int fuelEfficiency, int cargoWeight) {
        super(licensePlate);
        this.fuelEfficiency = fuelEfficiency;
        this.cargoWeight = cargoWeight;
    }

    // Implementasi abstract method parent
    // Fuel consumption truck : (distance / fuelEfficiency) + (cargoWeight * 0.05)
    @Override
    public double calculateFuelConsumption(int distance) {
        return (double) ((distance / fuelEfficiency) + (cargoWeight * 0.05));
    }

    @Override
    public void displayInfo() {
        System.out.println("\n--- Truck Info ---");
        super.displayInfo();
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/l");
        System.out.println("Cargo Weight: " + cargoWeight + " kg");
    }

}
