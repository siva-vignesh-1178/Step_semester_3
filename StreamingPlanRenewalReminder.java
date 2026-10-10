import java.util.*;
import java.time.*;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String n, String d) {
        name = n;
        startDate = LocalDate.parse(d);
    }

    abstract int validityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Subscription {
    BasicPlan(String n, String d) { super(n, d); }

    int validityDays() { return 30; }
}

class StandardPlan extends Subscription {
    StandardPlan(String n, String d) { super(n, d); }

    int validityDays() { return 90; }
}

class PremiumPlan extends Subscription {
    PremiumPlan(String n, String d) { super(n, d); }

    int validityDays() { return 365; }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            String date = sc.next();
            Subscription s;

            switch (type) {
                case "BASIC":
                    s = new BasicPlan(name, date);
                    break;
                case "STANDARD":
                    s = new StandardPlan(name, date);
                    break;
                default:
                    s = new PremiumPlan(name, date);
            }

            System.out.println(name + ": " + s.getRenewalDate());
        }

        sc.close();
    }
}