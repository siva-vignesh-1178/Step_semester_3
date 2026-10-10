import java.util.*;

abstract class Staff {
    String name;

    Staff(String n) {
        name = n;
    }

    abstract double pay();
}

class FullTimeStaff extends Staff {
    double salary;

    FullTimeStaff(String n, double s) {
        super(n);
        salary = s;
    }

    double pay() {
        return salary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;

    HourlyStaff(String n, double h, double r) {
        super(n);
        hours = h;
        rate = r;
    }

    double pay() {
        return Math.min(hours, 40) * rate
                + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    double stipend;

    InternStaff(String n, double s) {
        super(n);
        stipend = s;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;

            switch (type) {
                case "FULLTIME":
                    s = new FullTimeStaff(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    s = new HourlyStaff(name,
                            sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    s = new InternStaff(name, sc.nextDouble());
            }

            double amount = s.pay();
            System.out.printf("%s: %.2f%n", name, amount);
            total += amount;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}