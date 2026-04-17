public class UC20_Exception_Handling_During_Search {

    /**
     * Searches for a bogie ID in the given array.
     * Throws IllegalStateException immediately if the array is empty (fail-fast behaviour).
     *
     * @param bogieIds the array of bogie IDs in the current train formation
     * @param searchId the bogie ID to locate
     * @throws IllegalStateException when the train has no bogies loaded
     */
    private static void searchBogie(String[] bogieIds, String searchId) {

        // Defensive validation: fail fast if the train is empty
        if (bogieIds.length == 0) {
            throw new IllegalStateException(
                    "No bogies available in train. Cannot perform search.");
        }

        // Linear search through the bogie collection
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie " + searchId + " found in the train.");
        } else {
            System.out.println("Bogie " + searchId + " not found in the train.");
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("========================================");
        System.out.println();

        // Empty bogie array — no bogies have been added to the train yet
        String[] bogieIds = {};

        String searchId = "BG101";

        // Attempt search; IllegalStateException is expected and propagates up
        searchBogie(bogieIds, searchId);

        System.out.println("\nUC20 execution completed...");
    }
}
