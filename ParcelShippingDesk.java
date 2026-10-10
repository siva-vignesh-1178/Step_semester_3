import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insuranceAmount() {
        if (this instanceof Insurable) {
            return ((Insurable) this).insurance();
        }
        return 0;
    }

    double total() {
        return charge() + insuranceAmount();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }

    double charge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    p = new ExpressParcel(weight, value);
                    break;
                default:
                    p = new FragileParcel(weight, value);
            }

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, p.charge(), p.insuranceAmount(), p.total());

            grandTotal += p.total();
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}