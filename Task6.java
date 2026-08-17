import java.util.*;

abstract class Trip {
    protected double distance;

    Trip(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bike extends Trip {
    Bike(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 5;
    }
}

class Auto extends Trip {
    Auto(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 12;
    }
}

class Cab extends Trip {
    Cab(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 12;
    }
}

class Driver {
    private String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    private String name;

    Rider(String name) {
        this.name = name;
    }
}

class Vehicle {
    private String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

public class Task6 {

    static Trip createTrip(String type, double distance) {
        switch (type) {
            case "Bike":
                return new Bike(distance);

            case "Auto":
                return new Auto(distance);

            case "Cab":
                return new Cab(distance);

            default:
                throw new IllegalArgumentException("Invalid ride type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Trip trip = createTrip(type, distance);

                System.out.println((int) trip.calculateFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}