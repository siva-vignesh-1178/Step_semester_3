import java.util.*;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50;

    Travel(double d) {
        distance = d;
    }

    abstract double fare();

    double total() {
        return fare() + BOOKING_FEE;
    }
}

class BusTravel extends Travel {
    BusTravel(double d) { super(d); }

    double fare() {
        return distance * 2;
    }
}

class TrainTravel extends Travel {
    TrainTravel(double d) { super(d); }

    double fare() {
        return distance * 1.5;
    }
}

class FlightTravel extends Travel {
    FlightTravel(double d) { super(d); }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel t;

            switch (mode) {
                case "BUS":
                    t = new BusTravel(distance);
                    break;
                case "TRAIN":
                    t = new TrainTravel(distance);
                    break;
                default:
                    t = new FlightTravel(distance);
            }

            System.out.printf("%s: %.2f%n", mode, t.total());
        }

        sc.close();
    }
}