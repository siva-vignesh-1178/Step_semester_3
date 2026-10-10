import java.util.*;

abstract class Room {
    int units;

    Room(int u) {
        units = u;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int u) { super(u); }

    double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int u, int o) {
        super(u);
        occupants = o;
    }

    double calculateBill() {
        return units * 6.0 / occupants;
    }
}

class ACRoom extends Room {
    ACRoom(int u) { super(u); }

    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            Room r;

            switch (type) {
                case "SINGLE":
                    r = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new SharedRoom(units, occupants);
                    break;
                default:
                    r = new ACRoom(units);
            }

            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}