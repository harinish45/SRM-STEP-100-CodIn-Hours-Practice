import java.util.Scanner;

/**
 * UC3: Palindrome Check Using String Reverse
 *
 * Goal: Check whether a string is a palindrome by reversing it.
 *
 * Flow:
 * 1. Reverse string using a for loop
 * 2. Compare original and reversed using equals()
 * 3. Display result
 *
 * Key Concepts:
 * - Loop (for loop) : Iterate characters in reverse order
 * - String Immutability : Each concatenation creates a new String object
 * - String Concatenation (+) : Builds reversed string character by character
 * - equals() Method : Compares content, not memory reference
 *
 * Data Structure: String
 */
public class UC3_StringReversePalindromeChecker {

    /**
     * Reverses a string using a for loop and string concatenation (+).
     * Note: This demonstrates the concept, but StringBuilder is preferred
     * for performance since String is immutable in Java.
     *
     * @param str the normalized string to reverse
     * @return the reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";

        System.out.println("  [Reverse Loop — String Concatenation]");
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
            System.out.printf("  i=%d -> char='%c' -> reversed so far: \"%s\"%n",
                    i, str.charAt(i), reversed);
        }
        return reversed;
    }

    /**
     * Checks whether the given string is a palindrome using string reversal.
     *
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        // Normalize: lowercase and strip non-alphanumeric characters
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (normalized.isEmpty()) {
            System.out.println("  (Empty or blank input — treated as palindrome)");
            return true;
        }

        System.out.println("  Original (normalized): \"" + normalized + "\"");
        System.out.println();

        // Reverse via loop
        String reversed = reverseString(normalized);

        System.out.println();
        System.out.println("  Original : \"" + normalized + "\"");
        System.out.println("  Reversed : \"" + reversed + "\"");

        // Compare using equals() — compares content, not reference
        return normalized.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  UC3: String Reverse Palindrome Checker      ");
        System.out.println("==============================================");

        while (true) {
            System.out.print("\nEnter a string to check (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            boolean result = isPalindrome(input);

            System.out.println("\n  Result: \"" + input + "\" is "
                    + (result ? "✓ a PALINDROME" : "✗ NOT a palindrome"));
            System.out.println("----------------------------------------------");
        }

        scanner.close();
    }
}
