/**
 * UC2: Print a Hardcoded Palindrome Result
 *
 * Goal: Display whether a hardcoded string is a palindrome.
 *
 * Flow:
 * 1. Program starts
 * 2. Hardcoded string is checked
 * 3. Result is printed
 * 4. Program exits
 *
 * Key Concepts:
 * - Class : Container that holds program logic
 * - Main Method : Entry point — public static void main(String[] args)
 * - Static Keyword : Allows JVM to call main() without creating an object
 * - String : Built-in class to store and manipulate textual data
 * - String Literal : Text in double quotes, stored in String constant pool
 * - Conditional (if-else): Evaluates whether the palindrome condition is met
 * - Console Output : System.out.println() to display result
 *
 * Data Structure: String
 */
public class UC2_HardcodedPalindromeChecker {

    public static void main(String[] args) {

        // Hardcoded string stored as a String literal
        String word = "madam";

        // Reverse the string for comparison
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        System.out.println("=========================================");
        System.out.println("  UC2: Hardcoded Palindrome Checker      ");
        System.out.println("=========================================");
        System.out.println("  Input Word : \"" + word + "\"");
        System.out.println("  Reversed   : \"" + reversed + "\"");
        System.out.println();

        // Conditional statement to check palindrome
        if (word.equals(reversed)) {
            System.out.println("  Result: \"" + word + "\" IS a palindrome.");
        } else {
            System.out.println("  Result: \"" + word + "\" is NOT a palindrome.");
        }

        System.out.println("=========================================");
    }
}
