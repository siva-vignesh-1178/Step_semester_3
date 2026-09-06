public class WarehouseInventory {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        int max = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {

            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > max) {

                max = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }

            if (sectionB[i] > max) {

                max = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + status);

        System.out.println(
            "Highest Quantity: " + max +
            " (" + maxSection +
            ", Item " + (maxIndex + 1) + ")"
        );
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}