import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        
        int temp = number;
        int digitCount = 0;
        
        // Find the number of digits in the input number
        while (temp != 0) {
            temp /= 10;
            digitCount++;
        }
        
        int[] digits = new int[digitCount];
        int[] reversedDigits = new int[digitCount];
        
        // Extract digits and store them in the digits array
        temp = number;
        for (int i = 0; i < digitCount; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        // Store the digits in reverse order in the reversedDigits array
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        
        scanner.close();
    }
}
