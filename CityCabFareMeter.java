import java.util.*;

interface NightService {
    double nightFare();
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        return Math.max(100, km * rate());
    }
}

class MiniCab extends Cab {
    MiniCab(double km) { super(km); }

    double rate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }

    double rate() {
        return 14;
    }

    public double nightFare() {
        return fare() * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) { super(km); }

    double rate() {
        return 18;
    }

    public double nightFare() {
        return fare() * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                default:
                    cab = new SUVCab(km);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.fare();

                if (time.equals("NIGHT")) {
                    fare = ((NightService) cab).nightFare();
                }

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}