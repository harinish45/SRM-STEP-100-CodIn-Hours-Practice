import java.util.Scanner;
import java.util.Stack;

/**
 * UC5: Stack-Based Palindrome Checker
 * 
 * Goal: Use stack to reverse characters and validate palindrome.
 * 
 * Flow:
 * 1. Push characters into stack
 * 2. Pop and compare
 * 3. Print result
 *
 * Key Concepts:
 * - Stack: LIFO (Last In, First Out) data structure
 * - Push Operation: Insert characters into stack
 * - Pop Operation: Remove characters from stack in reverse order
 * - Reversal Logic: Stack naturally reverses element order
 */
public class UC5_StackPalindromeChecker {

    /**
     * Checks whether the given string is a palindrome using a Stack.
     * 
     * Algorithm:
     * 1. Normalize the string (lowercase, remove non-alphanumeric)
     * 2. Push each character onto the stack
     * 3. Pop characters one by one to form the reversed string
     * 4. Compare original and reversed string
     * 
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        // Step 1: Normalize — lowercase and remove spaces/special chars
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (normalized.isEmpty()) {
            System.out.println("  (Empty or blank input — treated as palindrome)");
            return true;
        }

        Stack<Character> stack = new Stack<>();

        // Step 2: Push all characters into the stack
        System.out.println("\n  [Push Phase]");
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
            System.out.print("  Push '" + ch + "' -> Stack: " + stack + "\n");
        }

        // Step 3: Pop characters to build the reversed string
        System.out.println("\n  [Pop Phase]");
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            reversed.append(ch);
            System.out.print("  Pop '" + ch + "'  -> Stack: " + stack + "\n");
        }

        // Step 4: Compare original and reversed
        String reversedStr = reversed.toString();
        System.out.println("\n  Original : " + normalized);
        System.out.println("  Reversed : " + reversedStr);

        return normalized.equals(reversedStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("  UC5: Stack-Based Palindrome Checker   ");
        System.out.println("========================================");

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
            System.out.println("----------------------------------------");
        }

        scanner.close();
    }
}
