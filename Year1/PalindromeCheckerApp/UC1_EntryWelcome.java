package PalindromeCheckerApp;

/**
 * UC1: Application Entry & Welcome Message
 *
 * Goal: Display a welcome message and app details at startup.
 *
 * Flow:
 * 1. Program starts.
 * 2. JVM invokes the main() method.
 * 3. Application name is displayed.
 * 4. Application version is displayed.
 * 5. Program exits (in this standalone UC).
 *
 * Key Concepts:
 * - Class : Container for logic
 * - Main Method : Entry point (public static void main)
 * - Static Keyword : JVM invokes without object creation
 * - Console Output : System.out.println()
 * - Application Flow Control : Startup behavior
 */
public class UC1_EntryWelcome {

    public static void main(String[] args) {
        // Application Details
        String appName = "Palindrome Checker App";
        String version = "1.0.0";
        String developer = "Harinish"; // Assuming user name based on context

        // Display Welcome Message
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*      WELCOME TO PALINDROME CHECKER     *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println();
        System.out.println("  Application Name : " + appName);
        System.out.println("  Version          : " + version);
        System.out.println("  Developer        : " + developer);
        System.out.println();
        System.out.println("  Initialization complete...");
        System.out.println("  Ready to validate palindromes!");
        System.out.println("******************************************");
    }
}
