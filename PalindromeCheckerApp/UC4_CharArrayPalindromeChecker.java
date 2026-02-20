import java.util.Scanner;

/**
 * UC4: Character Array Based Palindrome Checker
 * 
 * Goal: Convert string to character array and compare characters.
 * 
 * Flow:
 * 1. Convert string to char[]
 * 2. Use two-pointer approach
 * 3. Compare start & end characters
 *
 * Key Concepts:
 * - Character Array (char[]) : Primitive array for index-based access
 * - Array Indexing : 0-based index access
 * - Two-Pointer Technique : One pointer at start, one at end
 * - Time Complexity : O(n/2) — efficient, no extra objects created
 */
public class UC4_CharArrayPalindromeChecker {

    /**
     * Checks whether the given string is a palindrome using char[] + Two-Pointer.
     *
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        // Step 1: Normalize — lowercase and remove non-alphanumeric characters
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (normalized.isEmpty()) {
            System.out.println("  (Empty or blank input — treated as palindrome)");
            return true;
        }

        // Step 2: Convert to char[]
        char[] chars = normalized.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        System.out.println("  Char Array : " + new String(chars));
        System.out.println("  Length     : " + chars.length);
        System.out.println();
        System.out.println("  [Two-Pointer Comparison]");

        // Step 3: Use two-pointer to compare from both ends
        boolean palindrome = true;
        while (left < right) {
            System.out.printf("  left[%d]='%c'  vs  right[%d]='%c'  -> %s%n",
                    left, chars[left], right, chars[right],
                    (chars[left] == chars[right]) ? "Match ✓" : "Mismatch ✗");

            if (chars[left] != chars[right]) {
                palindrome = false;
                break;
            }
            left++;
            right--;
        }

        return palindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  UC4: Character Array Palindrome Checker     ");
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
