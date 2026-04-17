import java.util.Arrays;

public class UC17_Sort_Bogie_Names_Using_Arrays_Sort {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==================================================\n");

        // Unsorted bogie type names
        String[] bogieNames = {
            "Sleeper",
            "AC Chair",
            "First Class",
            "General",
            "Luxury"
        };

        // Java's built-in dual-pivot quicksort / TimSort — O(n log n)
        // No manual swap logic needed
        Arrays.sort(bogieNames);

        // Display sorted result using Arrays.toString() for clean output
        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 execution completed...");
    }
}
