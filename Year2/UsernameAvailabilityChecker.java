package Year2;

import java.util.*;

// Problem 1: Social Media Username Availability Checker

public class UsernameAvailabilityChecker {
    private HashMap<String, Integer> usernameDatabase; // username -> userId
    private HashMap<String, Integer> attemptFrequency; // username -> attempt count

    public UsernameAvailabilityChecker() {
        usernameDatabase = new HashMap<>();
        attemptFrequency = new HashMap<>();

        // Add some pre-existing usernames
        usernameDatabase.put("john_doe", 1);
        usernameDatabase.put("admin", 2);
        usernameDatabase.put("root", 3);
        attemptFrequency.put("admin", 10543);
    }

    // Check if username is available - O(1) time
    public boolean checkAvailability(String username) {
        // Track attempt frequency
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);

        return !usernameDatabase.containsKey(username);
    }

    // Suggest alternatives if username is taken
    public ArrayList<String> suggestAlternatives(String username) {
        ArrayList<String> suggestions = new ArrayList<>();

        // Suggest with numbers appended
        for (int i = 1; i <= 5; i++) {
            String suggestion = username + i;
            if (!usernameDatabase.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        // Suggest with dot
        if (!usernameDatabase.containsKey(username.replace("_", "."))) {
            suggestions.add(username.replace("_", "."));
        }

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {
        String mostAttempted = "";
        int maxAttempts = 0;

        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {
            if (entry.getValue() > maxAttempts) {
                maxAttempts = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }

        return mostAttempted + " (" + maxAttempts + " attempts)";
    }

    // Register a new username
    public boolean registerUsername(String username, int userId) {
        if (usernameDatabase.containsKey(username)) {
            return false;
        }
        usernameDatabase.put(username, userId);
        return true;
    }

    public static void main(String[] args) {
        UsernameAvailabilityChecker checker = new UsernameAvailabilityChecker();

        System.out.println("=== Social Media Username Availability Checker ===\n");

        // Test availability checks
        System.out.println("checkAvailability(\"john_doe\") → " +
                (checker.checkAvailability("john_doe") ? "true (available)" : "false (already taken)"));

        System.out.println("checkAvailability(\"jane_smith\") → " +
                (checker.checkAvailability("jane_smith") ? "true (available)" : "false (already taken)"));

        // Test suggestions
        System.out.println("\nsuggestAlternatives(\"john_doe\") → " +
                checker.suggestAlternatives("john_doe"));

        // Test most attempted
        System.out.println("\ngetMostAttempted() → \"" + checker.getMostAttempted() + "\"");

        // Register a new username
        System.out.println("\nregisterUsername(\"jane_smith\", 100) → " +
                (checker.registerUsername("jane_smith", 100) ? "Success" : "Failed"));

        // Check again
        System.out.println("checkAvailability(\"jane_smith\") → " +
                checker.checkAvailability("jane_smith"));
    }
}
