import java.util.Scanner;
import java.util.Arrays;

public class DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        // Count the occurrences of each dice result.
        for (int roll : rolls) {
            if (roll < 1 || roll > 6) {
                throw new IllegalArgumentException(
                    "Dice results must be between 1 and 6."
                );
            }

            count[roll]++;
        }

        // Print the counts.
        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i]);

            if (i < 6) {
                System.out.print(" ");
            }
        }

        System.out.println();

        // Reconstruct the array in increasing order.
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int j = 0; j < count[value]; j++) {
                rolls[index++] = value;
            }
        }

        return rolls;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }

        diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(rolls));

        sc.close();
    }
}