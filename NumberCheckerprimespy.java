import java.util.Scanner;

public class NumberChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= number / 2; i++) if (number % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number, sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpy(int number) {
        int sum = 0, product = 1, temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean prime = isPrime(number);
        boolean neon = isNeon(number);
        boolean spy = isSpy(number);
        boolean auto = isAutomorphic(number);
        boolean buzz = isBuzz(number);

        System.out.println("\n------------ Analysis Report ------------");
        System.out.printf("Original Number        : %d\n", number);
        System.out.printf("Prime Number           : %s\n", prime ? "YES" : "NO");
        System.out.printf("Neon Number            : %s\n", neon ? "YES" : "NO");
        System.out.printf("Spy Number             : %s\n", spy ? "YES" : "NO");
        System.out.printf("Automorphic Number     : %s\n", auto ? "YES" : "NO");
        System.out.printf("Buzz Number            : %s\n", buzz ? "YES" : "NO");
        System.out.println("-----------------------------------------");
    }
}
