// Abstract class: Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }
}

// Interface: Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Subclass: Car
class Car extends Vehicle implements Insurable {
    private double insuranceRate;

    public Car(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + insuranceRate + "%";
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Subclass: Truck
class Truck extends Vehicle implements Insurable {
    private double insuranceRate;

    public Truck(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + insuranceRate + "%";
    }
}

// Main class to test Vehicle Rental System
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car1 = new Car("HR26AB1234", 1500, 5);
        Bike bike1 = new Bike("HR05XY5678", 500);
        Truck truck1 = new Truck("HR12TR7890", 2500, 8);

        car1.displayDetails();
        System.out.println(car1.getInsuranceDetails());
        System.out.println("Rental Cost for 5 days: " + car1.calculateRentalCost(5));
        System.out.println("Insurance Cost: " + car1.calculateInsurance());
        System.out.println();

        bike1.displayDetails();
        System.out.println("Rental Cost for 3 days: " + bike1.calculateRentalCost(3));
        System.out.println();

        truck1.displayDetails();
        System.out.println(truck1.getInsuranceDetails());
        System.out.println("Rental Cost for 7 days: " + truck1.calculateRentalCost(7));
        System.out.println("Insurance Cost: " + truck1.calculateInsurance());
    }
}
