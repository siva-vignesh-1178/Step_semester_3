import java.util.*;

interface BusUser {
    double transportFee();
}

abstract class StudentFee {
    String name;
    double tuition;

    StudentFee(String n, double t) {
        name = n;
        tuition = t;
    }

    double totalFee() {
        double transport = 0;

        if (this instanceof BusUser) {
            transport = ((BusUser) this).transportFee();
        }

        return tuition + transport;
    }
}

class DayScholar extends StudentFee implements BusUser {
    DayScholar(String n) {
        super(n, 40000);
    }

    public double transportFee() {
        return 12000;
    }
}

class Hosteller extends StudentFee {
    Hosteller(String n) {
        super(n, 100000);
    }
}

class ScholarStudent extends StudentFee implements BusUser {
    ScholarStudent(String n) {
        super(n, 20000);
    }

    public double transportFee() {
        return 12000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            StudentFee s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                default:
                    s = new ScholarStudent(name);
            }

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}