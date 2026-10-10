import java.util.*;

abstract class Customer {
    double amount;

    Customer(double a) {
        amount = a;
    }

    abstract double calculateBill();
}

class Student extends Customer {
    Student(double a) { super(a); }

    double calculateBill() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double a) { super(a); }

    double calculateBill() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double a) { super(a); }

    double calculateBill() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            Customer c;

            switch (type) {
                case "STUDENT": c = new Student(amount); break;
                case "STAFF": c = new Staff(amount); break;
                default: c = new Guest(amount);
            }

            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}