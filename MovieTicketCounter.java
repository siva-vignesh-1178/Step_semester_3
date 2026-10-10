import java.util.*;

abstract class Ticket {
    static final double FEE = 20;
    int count;

    Ticket(int c) {
        count = c;
    }

    abstract double price();

    double amount() {
        return count * (price() + FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int c) { super(c); }

    double price() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int c) { super(c); }

    double price() { return 250; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int c) { super(c); }

    double price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;

            switch (seat) {
                case "REGULAR":
                    t = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    t = new PremiumTicket(count);
                    break;
                default:
                    t = new ReclinerTicket(count);
            }

            double amount = t.amount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}