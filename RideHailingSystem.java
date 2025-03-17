// Abstract class: Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

// Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Subclass: Car
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Subclass: Bike
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Subclass: Auto
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Main class to test Ride-Hailing System
public class RideHailingSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("V001", "Amit Singh", 15);
        Vehicle bike = new Bike("V002", "Ravi Verma", 10);
        Vehicle auto = new Auto("V003", "Suresh Yadav", 12);

        car.getVehicleDetails();
        System.out.println("Fare for 10 km: " + car.calculateFare(10));
        System.out.println();

        bike.getVehicleDetails();
        System.out.println("Fare for 10 km: " + bike.calculateFare(10));
        System.out.println();

        auto.getVehicleDetails();
        System.out.println("Fare for 10 km: " + auto.calculateFare(10));
    }
}
