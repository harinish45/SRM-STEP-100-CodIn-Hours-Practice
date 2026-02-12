import java.util.Scanner;

public class LargestAndSecondLargest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        
        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;
        
        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index++;
            
            if (index == maxDigits) {
                // Increase the size of the array when index reaches maxDigits
                maxDigits += 10;
                
                // Create a new temporary array with the increased size
                int[] temp = new int[maxDigits];
                
                // Copy existing digits to the new array
                System.arraycopy(digits, 0, temp, 0, digits.length);
                
                // Assign the new array to digits
                digits = temp;
            }
        }
        
        int largest = -1;
        int secondLargest = -1;
        
        // Loop through the array and find the largest and second largest digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("The largest digit is: " + largest);
        System.out.println("The second largest digit is: " + secondLargest);
        
        scanner.close();
    }
}
