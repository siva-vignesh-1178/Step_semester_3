import java.util.*;
import java.time.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanDays();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getLoanDays());
    }
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int getLoanDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String t) { super(t); }
    int getLoanDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int getLoanDays() { return 3; }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1)
                    .replaceAll("^\"|\"$", "");

            LibraryItem item;

            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                default: item = new Magazine(title);
            }

            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}