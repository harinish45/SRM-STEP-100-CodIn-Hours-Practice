import java.util.Scanner;

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

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) if (digits[i] == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int[] digits, int originalNumber) {
        int power = digits.length, sum = 0;
        for (int d : digits) sum += Math.pow(d, power);
        return sum == originalNumber;
    }

    public static int[] findLargestTwo(int[] digits) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) secondLargest = d;
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) secondSmallest = d;
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int digitCount = countDigits(number);
        int[] digits = getDigitsArray(number);

        System.out.println("\n------------ Analysis Report ------------");
        System.out.printf("Original Number      : %d\n", number);
        System.out.printf("Total Digits         : %d\n", digitCount);
        System.out.print("Digits in Number     : ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.printf("Duck Number          : %s\n", isDuckNumber(digits) ? "YES" : "NO");
        System.out.printf("Armstrong Number     : %s\n", isArmstrong(digits, number) ? "YES" : "NO");
        int[] max = findLargestTwo(digits);
        System.out.printf("Largest Digit        : %d\n", max[0]);
        System.out.printf("Second Largest Digit : %d\n", max[1]);
        int[] min = findSmallestTwo(digits);
        System.out.printf("Smallest Digit       : %d\n", min[0]);
        System.out.printf("Second Smallest Digit: %d\n", min[1]);
        System.out.println("-----------------------------------------");
    }
}
