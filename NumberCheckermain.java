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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] digits = getDigitsArray(number);
        int digitCount = countDigits(number);
        int sum = sumOfDigits(digits);
        int squareSum = sumOfSquares(digits);
        boolean harshad = isHarshad(number, digits);
        int[][] frequency = digitFrequency(digits);

        System.out.println("\n------------ Analysis Report ------------");
        System.out.printf("Original Number        : %d\n", number);
        System.out.printf("Digit Count            : %d\n", digitCount);
        System.out.print("Digits                 : ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.printf("Sum of Digits          : %d\n", sum);
        System.out.printf("Sum of Squares         : %d\n", squareSum);
        System.out.printf("Harshad Number         : %s\n", harshad ? "YES" : "NO");
        System.out.println("Digit Frequency        :");
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0)
                System.out.printf("Digit %d -> %d times\n", frequency[i][0], frequency[i][1]);
        }
        System.out.println("-----------------------------------------");
    }
}
