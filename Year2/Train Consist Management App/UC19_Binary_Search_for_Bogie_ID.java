import java.util.Arrays;

public class UC19_Binary_Search_for_Bogie_ID {

    /**
     * Performs binary search on a sorted array of bogie IDs.
     * Uses lexicographic compareTo() for String comparison.
     *
     * @param bogieIds sorted array of bogie IDs
     * @param key      the bogie ID to search for
     * @return index of the key if found, -1 otherwise
     */
    private static int binarySearch(String[] bogieIds, String key) {

        int low  = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;   // avoids integer overflow

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                // Key matches the middle element — found
                return mid;
            } else if (comparison > 0) {
                // Key is lexicographically greater — search right half
                low = mid + 1;
            } else {
                // Key is lexicographically smaller — search left half
                high = mid - 1;
            }
        }

        // Search range exhausted without a match
        return -1;
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==================================================\n");

        // Create array of bogie IDs (may be unsorted from real input)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Precondition: binary search requires sorted data
        Arrays.sort(bogieIds);

        // Search key provided by the user
        String key = "BG309";

        // Display the sorted bogie list
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform binary search
        System.out.println("\nSearching for: " + key);

        int resultIndex = binarySearch(bogieIds, key);

        if (resultIndex != -1) {
            System.out.println("Bogie Found at index: " + resultIndex);
        } else {
            System.out.println("Bogie not found in train.");
        }

        System.out.println("\nUC19 execution completed...");
    }
}
