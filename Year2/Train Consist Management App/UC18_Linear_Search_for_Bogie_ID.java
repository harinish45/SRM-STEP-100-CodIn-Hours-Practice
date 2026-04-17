public class UC18_Linear_Search_for_Bogie_ID {

    /**
     * Performs a linear search on an unsorted array of bogie IDs.
     * Traverses each element sequentially and stops as soon as a match is found.
     *
     * @param bogieIds array of bogie IDs (may be unsorted)
     * @param searchId the bogie ID to locate
     * @return true if the ID exists in the array, false otherwise
     */
    private static boolean linearSearch(String[] bogieIds, String searchId) {

        for (String id : bogieIds) {
            // Early termination — stop the moment a match is found
            if (id.equals(searchId)) {
                return true;
            }
        }

        // Traversed entire list without a match
        return false;
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==================================================\n");

        // Unsorted bogie ID array — linear search works regardless of order
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key provided by the user / operator
        String searchId = "BG309";

        // Display all available bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform linear search and display result
        System.out.println("\nSearching for: " + searchId);

        boolean found = linearSearch(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie Found.");
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nUC18 execution completed...");
    }
}
