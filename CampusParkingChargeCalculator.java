import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int h) {
        hours = h;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int h) { super(h); }

    double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    Car(int h) { super(h); }

    double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int h) { super(h); }

    double calculateCharge() {
        return Math.max(100, hours * 50.0);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE": v = new Bike(hours); break;
                case "CAR": v = new Car(hours); break;
                default: v = new Truck(hours);
            }

            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}