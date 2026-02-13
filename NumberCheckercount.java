import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker {
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String str = String.valueOf(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) digits[i] = Character.getNumericValue(str.charAt(i));
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) reversed[i] = arr[arr.length - 1 - i];
        return reversed;
    }

    public static boolean compareArrays(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) if (digits[i] == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigitsArray(number);
        int digitCount = countDigits(number);
        int[] reversed = reverseArray(digits);
        boolean isPalin = isPalindrome(digits);
        boolean isDuck = isDuckNumber(digits);

        System.out.println("\n------------ Analysis Report ------------");
        System.out.printf("Original Number      : %d\n", number);
        System.out.printf("Total Digits         : %d\n", digitCount);
        System.out.print("Digits in Number     : ");
        for (int d : digits) System.out.print(d + " ");
        System.out.print("\nReversed Digits      : ");
        for (int d : reversed) System.out.print(d + " ");
        System.out.printf("\nPalindrome Number    : %s\n", isPalin ? "YES" : "NO");
        System.out.printf("Duck Number          : %s\n", isDuck ? "YES" : "NO");
        System.out.println("-----------------------------------------");
    }
}
