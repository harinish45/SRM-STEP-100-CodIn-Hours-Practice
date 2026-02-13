import java.util.Scanner;

public class DigitFrequencyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Array to store frequency of each digit (0-9)
        int[] frequency = new int[10];

        // Extract digits from the number and calculate frequency
        while (number > 0) {
            int digit = (int)(number % 10); // Get the last digit
            frequency[digit]++;             // Increase the frequency for that digit
            number /= 10;                   // Remove the last digit
        }

        // Display the frequency of each digit
        System.out.println("\nFrequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }

        scanner.close();
    }
}
