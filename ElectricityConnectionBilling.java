import java.util.*;

abstract class Connection {
    int units;

    Connection(int u) {
        units = u;
    }

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(int u) { super(u); }

    double bill() {
        return Math.min(units, 100) * 5.0
                + Math.max(0, units - 100) * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(int u) { super(u); }

    double bill() {
        return units * 8.0 + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int u) { super(u); }

    double bill() {
        return Math.max(units * 6.0, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            switch (type) {
                case "HOME":
                    c = new HomeConnection(units);
                    break;
                case "SHOP":
                    c = new ShopConnection(units);
                    break;
                default:
                    c = new FactoryConnection(units);
            }

            double amount = c.bill();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}