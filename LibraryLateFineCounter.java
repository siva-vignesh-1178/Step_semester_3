import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String t, int d) {
        title = t;
        daysLate = d;
    }

    abstract double fine();
}

class BookItem extends LibraryItem {
    BookItem(String t, int d) { super(t, d); }

    double fine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String t, int d) { super(t, d); }

    double fine() {
        return Math.min(daysLate * 5.0, 50);
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String t, int d) { super(t, d); }

    double fine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, days);
                    break;
                case "DVD":
                    item = new DVDItem(title, days);
                    break;
                default:
                    item = new MagazineItem(title, days);
            }

            double f = item.fine();
            System.out.printf("%s: %.2f%n", title, f);
            total += f;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}