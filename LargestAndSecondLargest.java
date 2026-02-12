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
                break;
            }
        }
        
        int largest = -1;
        int secondLargest = -1;
        
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
