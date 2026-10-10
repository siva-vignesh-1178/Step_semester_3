import java.util.*;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculate();

    String getType() {
        return getClass().getSimpleName().replace("Payment", "")
                .toUpperCase();
    }
}

class CardPayment extends Payment {
    CardPayment(double a) { super(a); }
    double calculate() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double a) { super(a); }
    double calculate() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super(a); }
    double calculate() { return amount; }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD": p = new CardPayment(amount); break;
                case "WALLET": p = new WalletPayment(amount); break;
                default: p = new BankTransferPayment(amount);
            }

            double result = p.calculate();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}