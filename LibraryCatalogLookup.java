import java.util.Scanner;

public class LibraryCatalogLookup {

    static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = catalog[mid][0].compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog[mid][1];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] catalog = new String[n][2];

        for (int i = 0; i < n; i++) {
            catalog[i][0] = sc.next();
            catalog[i][1] = sc.next();
        }

        String targetIsbn = sc.next();

        System.out.println(findBook(catalog, targetIsbn));

        sc.close();
    }
}