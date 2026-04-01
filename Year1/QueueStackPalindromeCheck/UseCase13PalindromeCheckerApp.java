package Year1.QueueStackPalindromeCheck;

/**
 * =========================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * =========================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Define the input string to validate
        String input = "level";

        // Capture execution start time
        long startTime = System.nanoTime();

        // Run palindrome check using Stack-based approach
        boolean isPalindrome = checkUsingStack(input);

        // Capture execution end time
        long endTime = System.nanoTime();

        // Calculate total execution duration
        long executionTime = endTime - startTime;

        // Display benchmarking results
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + executionTime + " ns");
    }

    /**
     * Checks palindrome using a Stack (LIFO).
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    private static boolean checkUsingStack(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push all characters onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare popped characters with original
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
