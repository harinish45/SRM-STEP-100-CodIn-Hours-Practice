import java.util.Scanner;

public class NumberChecker {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) factors[index++] = i;
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) if (f > max) max = f;
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    public static double productOfCubes(int[] factors) {
        double product = 1;
        for (int f : factors) product *= Math.pow(f, 3);
        return product;
    }

    public static boolean isPerfect(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) sum += factors[i];
        return sum == number;
    }

    public static boolean isAbundant(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) sum += factors[i];
        return sum > number;
    }

    public static boolean isDeficient(int number, int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length - 1; i++) sum += factors[i];
        return sum < number;
    }

    public static boolean isStrong(int number) {
        int temp = number, sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] factors = findFactors(number);
        int greatest = greatestFactor(factors);
        int sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        double cubeProduct = productOfCubes(factors);
        boolean perfect = isPerfect(number, factors);
        boolean abundant = isAbundant(number, factors);
        boolean deficient = isDeficient(number, factors);
        boolean strong = isStrong(number);

        System.out.println("\n------------ Analysis Report ------------");
        System.out.printf("Original Number            : %d\n", number);
        System.out.print("Factors                    : ");
        for (int f : factors) System.out.print(f + " ");
        System.out.printf("\nGreatest Factor            : %d\n", greatest);
        System.out.printf("Sum of Factors             : %d\n", sum);
        System.out.printf("Product of Factors         : %d\n", product);
        System.out.printf("Product of Cubes           : %.2f\n", cubeProduct);
        System.out.printf("Perfect Number             : %s\n", perfect ? "YES" : "NO");
        System.out.printf("Abundant Number            : %s\n", abundant ? "YES" : "NO");
        System.out.printf("Deficient Number           : %s\n", deficient ? "YES" : "NO");
        System.out.printf("Strong Number              : %s\n", strong ? "YES" : "NO");
        System.out.println("-----------------------------------------");
    }
}
