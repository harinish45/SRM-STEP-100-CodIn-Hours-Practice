public class UC16_Sort_Passenger_Bogies_by_Capacity_Bubble_Sort {

    /**
     * Sorts an integer array in ascending order using Bubble Sort.
     * Repeatedly compares adjacent elements and swaps them if out of order.
     * Time complexity: O(n²)
     *
     * @param capacities the array of bogie capacities to sort (sorted in-place)
     */
    private static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Outer loop: each pass bubbles the largest unsorted element to the end
        for (int i = 0; i < n - 1; i++) {

            // Inner loop: compare adjacent pairs up to the unsorted boundary
            for (int j = 0; j < n - 1 - i; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    // Swap using a temporary variable
                    int temp          = capacities[j];
                    capacities[j]     = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("==================================================\n");

        // Passenger bogie capacities in unsorted order
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order before sorting
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.println(c);
        }

        // Sort in-place using Bubble Sort (no Arrays.sort / Collections.sort)
        bubbleSort(capacities);

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.println(c);
        }

        System.out.println("\nUC16 execution completed...");
    }
}
